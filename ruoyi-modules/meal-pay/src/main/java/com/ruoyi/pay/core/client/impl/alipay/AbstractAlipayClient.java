package com.ruoyi.pay.core.client.impl.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.*;
import com.alipay.api.domain.AlipayFundTransCommonQueryModel;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.domain.Participant;
import com.alipay.api.request.AlipayFundTransCommonQueryRequest;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayFundTransCommonQueryResponse;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.pay.core.client.AbstractPayCodeMapping;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.impl.AbstractPayClient;
import com.ruoyi.pay.core.enums.PayNotifyRefundStatusEnum;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.ruoyi.common.core.utils.bean.BeanUtils;
import com.ruoyi.pay.core.client.dto.*;
import org.apache.poi.ss.usermodel.DateUtil;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


/**
 * 支付宝抽象类， 实现支付宝统一的接口。如退款
 *
 * @author jason
 */

public abstract class AbstractAlipayClient extends AbstractPayClient<AlipayPayClientConfig> {

    protected DefaultAlipayClient client;

    public AbstractAlipayClient(Long channelId, String channelCode,
                                AlipayPayClientConfig config, AbstractPayCodeMapping codeMapping) {
        super(channelId, channelCode, config, codeMapping);
    }

    @Override

    protected void doInit() throws AlipayApiException {
        AlipayConfig alipayConfig=new AlipayConfig();
        alipayConfig.setAlipayPublicCertPath(config.getPublicCertPath());
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        alipayConfig.setFormat("json");
        alipayConfig.setServerUrl(config.getServerUrl());

        alipayConfig.setAppId(config.getAppId());
        alipayConfig.setPrivateKey(config.getPrivateKey());
        alipayConfig.setAppCertPath(config.getCertPath());
        alipayConfig.setRootCertPath(config.getRootCertPath());
        alipayConfig.setAlipayPublicCertPath(config.getPublicCertPath());
        this.client = new DefaultAlipayClient(alipayConfig); //获得初始化的AlipayClient

    }

    /**
     * 从支付宝通知返回参数中解析 PayOrderNotifyRespDTO, 通知具体参数参考
     * //https://opendocs.alipay.com/open/203/105286
     *
     * @param data 通知结果
     * @return 解析结果 PayOrderNotifyRespDTO
     * @throws Exception 解析失败，抛出异常
     */
    @Override
    public PayOrderNotifyRespDTO parseOrderNotify(PayNotifyDataDTO data) throws Exception {
        Map<String, String> params = data.getParams();


        return PayOrderNotifyRespDTO.builder().setOrderExtensionNo(params.get("out_trade_no"))
                .setChannelOrderNo(params.get("trade_no")).setChannelUserId(params.get("seller_id"))
                .setTradeStatus(params.get("trade_status"))
                .setSuccessTime(DateUtils.parseDate(params.get("notify_time")))
                .build();
    }

    @Override
    public PayRefundNotifyDTO parseRefundNotify(PayNotifyDataDTO notifyData) {
        Map<String, String> params = notifyData.getParams();
        PayRefundNotifyDTO notifyDTO = PayRefundNotifyDTO.builder().setChannelOrderNo(params.get("trade_no"))
                .setTradeNo(params.get("out_trade_no"))
                .setReqNo(params.get("out_biz_no"))
                .setStatus(PayNotifyRefundStatusEnum.SUCCESS)
                .setRefundSuccessTime(DateUtil.parseYYYYMMDDDate(params.get("gmt_refund")))
                .build();
        return notifyDTO;
    }

    @Override
    public boolean isRefundNotify(PayNotifyDataDTO notifyData) {
        if (notifyData.getParams().containsKey("refund_fee")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean verifyNotifyData(PayNotifyDataDTO notifyData) {
        boolean verifyResult = false;
        try {
            verifyResult = AlipaySignature.rsaCheckV1(notifyData.getParams(),
                    config.getAlipayPublicKey(),
                    StandardCharsets.UTF_8.name(), "RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
            //  log.error("[AlipayClient verifyNotifyData][(notify param is :{}) 验证失败]", toJsonString(notifyData.getParams()), e);
        }
        return verifyResult;
    }

    /**
     * 支付宝统一的退款接口 alipay.trade.refund
     *
     * @param reqDTO 退款请求 request DTO
     * @return 退款请求 Response
     */
    @Override
    protected PayCommonResult<PayRefundUnifiedRespDTO> doUnifiedRefund(PayRefundUnifiedReqDTO reqDTO) {
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setTradeNo(reqDTO.getChannelOrderNo());
        model.setOutTradeNo(reqDTO.getPayTradeNo());
        model.setOutRequestNo(reqDTO.getMerchantRefundId());
        model.setRefundAmount(calculateAmount(reqDTO.getAmount()).toString());
        model.setRefundReason(reqDTO.getReason());
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        refundRequest.setBizModel(model);
        try {
            AlipayTradeRefundResponse response = client.execute(refundRequest);
            // log.info("[doUnifiedRefund][response({}) 发起退款 渠道返回", toJsonString(response));
            if (response.isSuccess()) {
                //退款导致触发的异步通知是发送到支付接口中设置的notify_url
                //支付宝不返回退款单号，设置为空
                PayRefundUnifiedRespDTO respDTO = new PayRefundUnifiedRespDTO();
                respDTO.setChannelRefundId("");
                return PayCommonResult.build(response.getCode(), response.getMsg(), respDTO, codeMapping);
            }
            // 失败。需要抛出异常
            return PayCommonResult.build(response.getCode(), response.getMsg(), null, codeMapping);
        } catch (AlipayApiException e) {
            // TODO 记录异常日志
            //   log.error("[doUnifiedRefund][request({}) 发起退款失败,网络读超时，退款状态未知]", toJsonString(reqDTO), e);
            return PayCommonResult.build(e.getErrCode(), e.getErrMsg(), null, codeMapping);
        }
    }


    @Override
    public PayCommonResult<AlipayFundTransUniTransferResponse> payment(PayOrderUnifiedReqDTO payOrderUnifiedReqDTO) throws AlipayApiException {
        String privateKey = config.getPrivateKey();
        CertAlipayRequest alipayConfig = new CertAlipayRequest();
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setServerUrl(config.getServerUrl());
        alipayConfig.setAppId(config.getAppId());
        alipayConfig.setCharset("UTF8");
        alipayConfig.setSignType("RSA2");
        alipayConfig.setFormat("json");
        alipayConfig.setCertPath(config.getCertPath());
        alipayConfig.setRootCertPath(config.getRootCertPath());
        alipayConfig.setAlipayPublicCertPath(config.getPublicCertPath());
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();
        model.setOutBizNo(payOrderUnifiedReqDTO.getMerchantOrderId());
        model.setRemark(payOrderUnifiedReqDTO.getBody());
        model.setBizScene("DIRECT_TRANSFER");
        Participant payeeInfo = new Participant();
        payeeInfo.setIdentity(payOrderUnifiedReqDTO.getLogin());
        payeeInfo.setIdentityType("ALIPAY_LOGON_ID");
        payeeInfo.setName(payOrderUnifiedReqDTO.getUserName());
        model.setPayeeInfo(payeeInfo);
        model.setTransAmount(String.format("%.2f", calculateAmount(payOrderUnifiedReqDTO.getAmount())));
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");
        model.setOrderTitle(payOrderUnifiedReqDTO.getSubject());
        request.setBizModel(model);
        AlipayFundTransUniTransferResponse response = alipayClient.certificateExecute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            return PayCommonResult.build("-9999", "Success", response, codeMapping);


        } else {
            return PayCommonResult.build(response.getCode(), response.getSubMsg(), response, codeMapping);

        }
    }



    public PayCommonResult<AlipayFundTransCommonQueryResponse> paymentQuery(PayOrderUnifiedReqDTO payOrderUnifiedReqDTO) throws AlipayApiException {
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        // 设置网关地址
        certAlipayRequest.setServerUrl(config.getServerUrl());
        // 设置应用Id
        certAlipayRequest.setAppId(config.getAppId());
        // 设置应用私钥
        certAlipayRequest.setPrivateKey(config.getPrivateKey());
        // 设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        // 设置字符集
        certAlipayRequest.setCharset("utf-8");
        // 设置签名类型
        certAlipayRequest.setSignType("RSA2");
        // 设置应用公钥证书路径
        certAlipayRequest.setCertPath(config.getCertPath());
        // 设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(config.getPublicCertPath());
        // 设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(config.getRootCertPath());
        // 构造client
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        AlipayFundTransCommonQueryRequest request;
        request = new AlipayFundTransCommonQueryRequest();
        AlipayFundTransCommonQueryModel model = new AlipayFundTransCommonQueryModel();
        model.setOutBizNo(payOrderUnifiedReqDTO.getMerchantOrderId());
        model.setBizScene("DIRECT_TRANSFER");
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");
        request.setBizModel(model);
        AlipayFundTransCommonQueryResponse response = alipayClient.certificateExecute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            return PayCommonResult.build("-9999", "Success", response, codeMapping);


        } else {
            return PayCommonResult.build(response.getCode(), response.getSubMsg(), response, codeMapping);

        }
    }





    public PayCommonResult<AlipayTradeQueryResponse> query(PayOrderUnifiedReqDTO payOrderUnifiedReqDTO) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", payOrderUnifiedReqDTO.getMerchantOrderId());
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response = client.certificateExecute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            return PayCommonResult.build("-9999", "Success", response, codeMapping);

        } else {
            System.out.println("调用失败");
            return PayCommonResult.build(response.getCode(), response.getSubMsg(), response, codeMapping);

        }
    }





}



