package com.ruoyi.order.service.impl;

import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayFundTransCommonQueryResponse;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.order.domain.BuyerItem;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.order.mapper.BuyerItemMapper;
import com.ruoyi.order.mapper.BuyerPaymentMapper;
import com.ruoyi.order.service.IBuyerOrderService;
import com.ruoyi.order.service.IBuyerPaymentService;
import com.ruoyi.order.service.IPayChannelService;
import com.ruoyi.pay.core.client.PayClient;
import com.ruoyi.pay.core.client.PayClientFactory;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import com.ruoyi.pay.core.client.dto.PayOrderNotifyRespDTO;
import com.ruoyi.pay.core.client.dto.PayOrderUnifiedReqDTO;
import com.ruoyi.pay.core.client.impl.alipay.AlipayPayClientConfig;
import com.ruoyi.pay.core.enums.PayNotifyRefundStatusEnum;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.order.domain.BuyerOrder;

import com.ruoyi.shop.domain.ProductSku;
import com.ruoyi.system.api.RemoteOrderService;
import com.ruoyi.system.api.RemoteProductSkuService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-28
 */
@Service
public class BuyerPaymentServiceImpl implements IBuyerPaymentService {

    @Autowired
    private BuyerPaymentMapper buyerPaymentMapper;
    @Autowired
    BuyerItemMapper buyerItemMapper;
    @Autowired
    IPayChannelService payChannelService;

    @Autowired
    PayClientFactory payClientFactory;


    @Autowired
   private RemoteProductSkuService skuService;


    @Autowired
    private IBuyerOrderService orderService;

    @Autowired
    private RemoteOrderService remoteOrderService;

    /**
     * 查询支付
     *
     * @param revision 支付主键
     * @return 支付
     */
    @Override
    public BuyerPayment selectBuyerPaymentById(Long revision) {
        return buyerPaymentMapper.selectBuyerPaymentById(revision);
    }

    /**
     * 查询支付列表
     *
     * @param buyerPayment 支付
     * @return 支付
     */
    @Override
    public List<BuyerPayment> selectBuyerPaymentList(BuyerPayment buyerPayment) {
        return buyerPaymentMapper.selectBuyerPaymentList(buyerPayment);
    }

    /**
     * 新增支付
     *
     * @param query 支付
     * @return 结果
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PayCommonResult<?> insertBuyerPayment(BuyerPayment query, String ip) {
        BuyerOrder orderPO = orderService.selectBuyerOrderByOrderId(query.getOrderId());

        orderPO.setUpdatedTime(new Date());
        orderPO.setAddressId(query.getAddressId());
        orderPO.setOrderStatus(0);
        orderPO.setPayMethod(query.getPayMethod());
        orderService.updateBuyerOrder(orderPO);
        BigDecimal totalPrice = orderPO.getTotalPrice();
        BuyerPayment buyerPayment = new BuyerPayment();
        buyerPayment.setCreatedTime(new Date());
        buyerPayment.setPayAmount(totalPrice);
        buyerPayment.setOrderAmount(totalPrice);
        buyerPayment.setOrderId(orderPO.getOrderId());
        buyerPayment.setRevision(1L);
        buyerPaymentMapper.insertBuyerPayment(buyerPayment);
        PayChannel payChannel = payChannelService.selectPayChannelById(query.getPayMethod());

        AlipayPayClientConfig config = new AlipayPayClientConfig();
        BeanUtils.copyProperties(payChannel, config);
        config.setServerUrl(payChannel.getGateWay());


        payClientFactory.createOrUpdatePayClient(payChannel.getId(), payChannel.getCode()
                , config);
        PayClient payClient = payClientFactory.getPayClient(payChannel.getId());

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();

        payOrderUnifiedReqDTO.setAmount(totalPrice.multiply(BigDecimal.valueOf(100L)).longValue());
        Date date = new Date();
        date.setTime(date.getTime() + 600 * 1000 * 60 * 24);
        payOrderUnifiedReqDTO.setExpireTime(date);
        payOrderUnifiedReqDTO.setUserIp(ip);

        payOrderUnifiedReqDTO.setMerchantOrderId(buyerPayment.getId() + "");
        payOrderUnifiedReqDTO.setAmount(orderPO.getPayablePrice().multiply(BigDecimal.valueOf(100)).longValue());
        payOrderUnifiedReqDTO.setSubject(orderPO.getSubject());
        payOrderUnifiedReqDTO.setNotifyUrl(payChannel.getNotifyUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());
        payOrderUnifiedReqDTO.setReturnUrl(payChannel.getReturnUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());

        PayCommonResult<?> payCommonResult = payClient.unifiedOrder(payOrderUnifiedReqDTO);
        AlipayResponse response = ((AlipayResponse) payCommonResult.getData());

        if (response.isSuccess()) {

            buyerPayment.setPayDesc((response.getMsg()));
            buyerPayment.setIp(ip);
            buyerPaymentMapper.updateBuyerPayment(buyerPayment);
            return payCommonResult;
        } else {
            buyerPayment.setPayDesc((response.getMsg()));
            buyerPayment.setIp(ip);
            buyerPaymentMapper.updateBuyerPayment(buyerPayment);
            return payCommonResult;
        }
    }

    /**
     * 修改支付
     *
     * @param buyerPayment 支付
     * @return 结果
     */
    @Override
    public int updateBuyerPayment(BuyerPayment buyerPayment) {
        return buyerPaymentMapper.updateBuyerPayment(buyerPayment);
    }

    /**
     * 批量删除支付
     *
     * @param revisions 需要删除的支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevisions(Long[] revisions) {
        return buyerPaymentMapper.deleteBuyerPaymentById(revisions);
    }

    /**
     * 删除支付信息
     *
     * @param id 支付主键
     * @return 结果
     */
    @Override
    public int deleteBuyerPaymentByRevision(Long id) {
        return buyerPaymentMapper.deleteBuyerPaymentById(id);
    }

    @Override
    public BuyerOrder insertBuyerPaymentVirtual(String orderId, String info, Long addressId, Long payMethod) {
        BuyerOrder orderPO = orderService.selectBuyerOrderByOrderId(orderId);

        orderPO.setInfo(info);
        orderPO.setOrderStatus(10);
        orderPO.setPayMethod(payMethod);
        orderPO.setAddressId(addressId);
        orderService.updateBuyerOrder(orderPO);

        return orderPO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int payNotify(PayNotifyDataDTO payNotifyDataDTO, PayChannel payChannel) {


        AlipayPayClientConfig config = new AlipayPayClientConfig();
        BeanUtils.copyProperties(payChannel, config);
        config.setServerUrl(payChannel.getGateWay());


        payClientFactory.createOrUpdatePayClient(payChannel.getId(),
                payChannel.getCode()
                , config);
        PayClient client = payClientFactory.getPayClient(payChannel.getId());
        boolean b = client.verifyNotifyData(payNotifyDataDTO);
        if (b) {

            try {
                PayOrderNotifyRespDTO payOrderNotifyRespDTO = client.parseOrderNotify(payNotifyDataDTO);

                String orderExtensionNo = payOrderNotifyRespDTO.getOrderExtensionNo();

                long paySeq = Long.parseLong(orderExtensionNo);
                BuyerPayment buyerPayment = buyerPaymentMapper.selectBuyerPaymentById(paySeq);

                if (buyerPayment.getStatus() >= 10) {
                    return 0;
                }

                if (!PayNotifyRefundStatusEnum.TRADE_SUCCESS.toString().equals(payOrderNotifyRespDTO.getTradeStatus())) {
                    return 0;
                }
                ((BuyerPaymentServiceImpl) AopContext.currentProxy()).paySuccess(payOrderNotifyRespDTO.getChannelOrderNo(), buyerPayment);
                return 1;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
        return 0;
    }

    public void paySuccess(String channelOrderNo, BuyerPayment buyerPayment) {
        buyerPayment.setStatus(10L);
        buyerPayment.setUpdatedTime(new Date());
        buyerPayment.setThirdSn(channelOrderNo);
        buyerPayment.setThirdId(channelOrderNo);

        BuyerOrder info = orderService.selectBuyerOrderByOrderId(buyerPayment.getOrderId());
        if (info.getOrderStatus() >= 10)
            return;

        info.setOrderStatus(10);

        info.setUpdatedTime(new Date());
        orderService.updateBuyerOrder(info);
        buyerPaymentMapper.updateBuyerPayment(buyerPayment);
        BuyerItem buyerItemQuery = new BuyerItem();
        buyerItemQuery.setOrderId(buyerPayment.getOrderId());
        List<BuyerItem> buyerItems = buyerItemMapper.selectBuyerItemList(buyerItemQuery);
        for (int i = 0; i < buyerItems.size(); i++) {
            BuyerItem buyerItem = buyerItems.get(i);
            BigDecimal price = buyerItem.getPrice();
            ProductSku sku = skuService.getInfo(buyerItem.getSkuId(), SecurityConstants.INNER);
            Long shopId = sku.getShopId();
            Map<String, String> param = new HashMap<>();
            param.put("amount", String.valueOf(price));
            param.put("shopId", String.valueOf(shopId));

            int i1 = buyerPaymentMapper.updateShopAmount(param);

        }
    }

    @Override
    @Transactional
    public AlipayResponse paymentQuery(Long payId) {
        BuyerPayment buyerPayment = buyerPaymentMapper.selectBuyerPaymentById(payId);

        BuyerOrder buyerOrder = orderService.selectBuyerOrderByOrderId(buyerPayment.getOrderId());

        PayChannel payChannel = payChannelService.selectAllPayChannelParamById(buyerOrder.getPayMethod());


        AlipayPayClientConfig config = new AlipayPayClientConfig();


        BeanUtils.copyProperties(payChannel, config);

        config.setServerUrl(payChannel.getGateWay());
        payClientFactory.createOrUpdatePayClient(payChannel.getId(),
                payChannel.getCode()
                , config);
        PayClient client = payClientFactory.getPayClient(payChannel.getId());

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();
        payOrderUnifiedReqDTO.setMerchantOrderId(String.valueOf(buyerPayment.getId()));

        try {
            if (buyerOrder.getType() == 4) {

                PayCommonResult<AlipayFundTransCommonQueryResponse> result = client.paymentQuery(payOrderUnifiedReqDTO);

                if (result.isSuccess()) {
                    AlipayFundTransCommonQueryResponse data = result.getData();
                    buyerPayment.setThirdSn(data.getOrderId());
                    buyerPayment.setStatus(10L);
                    buyerPayment.setPayDesc(data.getMsg());
                    BuyerOrder order = new BuyerOrder();
                    order.setOrderId(buyerPayment.getOrderId());
                    order.setOrderStatus(1000);
                    order.setUpdatedTime(new Date());
                    buyerPayment.setUpdatedTime(new Date());

                    buyerPaymentMapper.updateBuyerPayment(buyerPayment);
                    orderService.updateBuyerOrder(order);

                } else {
                    buyerPayment.setPayDesc(result.getMsg());
                    buyerPayment.setUpdatedTime(new Date());
                    buyerPaymentMapper.updateBuyerPayment(buyerPayment);

                }
                return result.getData();

            } else {

                PayCommonResult<AlipayTradeQueryResponse> query = client.query(payOrderUnifiedReqDTO);

                if (query.isSuccess()&&query.getData().isSuccess()) {
                    ((BuyerPaymentServiceImpl) AopContext.currentProxy()).paySuccess(query.getData().getTradeNo(), buyerPayment);
                }
                return query.getData();


            }


        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }


    }

    @Transactional
    @Override
    public AlipayFundTransUniTransferResponse payment(String orderId, Long cid) {


        BuyerOrder order = orderService.selectBuyerOrderByOrderId(orderId);

        BuyerPayment buyerPayment = new BuyerPayment();
        buyerPayment.setCreatedTime(new Date());
        BigDecimal totalPrice = order.getTotalPrice();
        buyerPayment.setPayAmount(totalPrice);
        buyerPayment.setPayMethod(cid);
        buyerPayment.setOrderAmount(totalPrice);
        buyerPayment.setOrderId(order.getOrderId());
        buyerPayment.setRevision(1L);

        buyerPaymentMapper.insertBuyerPayment(buyerPayment);


        Long addressId = order.getAddressId();

        BuyerAddress address = remoteOrderService.getAddress(addressId, SecurityConstants.INNER);

        PayChannel payChannel = payChannelService.selectAllPayChannelParamById(cid);


        AlipayPayClientConfig config = new AlipayPayClientConfig();


        BeanUtils.copyProperties(payChannel, config);


        config.setServerUrl(payChannel.getGateWay());

        payClientFactory.createOrUpdatePayClient(payChannel.getId(),
                payChannel.getCode()
                , config);
        PayClient client = payClientFactory.getPayClient(payChannel.getId());

        PayOrderUnifiedReqDTO payOrderUnifiedReqDTO = new PayOrderUnifiedReqDTO();

        Date date = new Date();
        date.setTime(date.getTime() + 600 * 1000 * 60 * 24);
        payOrderUnifiedReqDTO.setExpireTime(date);
        payOrderUnifiedReqDTO.setUserIp(null);


        payOrderUnifiedReqDTO.setMerchantOrderId(buyerPayment.getId() + "");

        payOrderUnifiedReqDTO.setAmount(order.getPayablePrice().multiply(BigDecimal.valueOf(100)).longValue());
        payOrderUnifiedReqDTO.setSubject(order.getSubject());
        payOrderUnifiedReqDTO.setUserName(address.getAddressName());
        payOrderUnifiedReqDTO.setLogin(address.getPhone());
        payOrderUnifiedReqDTO.setNotifyUrl(payChannel.getNotifyUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());
        payOrderUnifiedReqDTO.setReturnUrl(payChannel.getReturnUrl() + "/" + payChannel.getId() + "/" + buyerPayment.getId());


        try {
            PayCommonResult<AlipayFundTransUniTransferResponse> payment = client.payment(payOrderUnifiedReqDTO);
            if (payment.isSuccess()) {
                AlipayFundTransUniTransferResponse data = payment.getData();
                buyerPayment.setThirdSn(data.getOrderId());
                buyerPayment.setStatus(10L);
                buyerPayment.setPayDesc(data.getMsg());
                order.setOrderStatus(1000);
                order.setUpdatedTime(new Date());
                buyerPayment.setUpdatedTime(new Date());

                buyerPaymentMapper.updateBuyerPayment(buyerPayment);
                orderService.updateBuyerOrder(order);

            } else {
                buyerPayment.setPayDesc(payment.getMsg());
                buyerPayment.setUpdatedTime(new Date());
                buyerPaymentMapper.updateBuyerPayment(buyerPayment);

            }

            return payment.getData();

        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

    }
}
