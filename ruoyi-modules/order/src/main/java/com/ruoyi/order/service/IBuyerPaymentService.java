package com.ruoyi.order.service;

import java.util.List;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayFundTransCommonQueryResponse;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.domain.PayChannel;
import com.ruoyi.pay.core.client.dto.PayNotifyDataDTO;
import com.ruoyi.order.domain.BuyerOrder;

import com.ruoyi.pay.core.client.PayCommonResult;

/**
 * 支付Service接口
 * 
 * @author xiaoming
 * @date 2022-08-28
 */
public interface IBuyerPaymentService 
{
    /**
     * 查询支付
     * 
     * @param revision 支付主键
     * @return 支付
     */
    public BuyerPayment selectBuyerPaymentById(Long revision);

    /**
     * 查询支付列表
     * 
     * @param buyerPayment 支付
     * @return 支付集合
     */
    public List<BuyerPayment> selectBuyerPaymentList(BuyerPayment buyerPayment);

    /**
     * 新增支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    public PayCommonResult<?> insertBuyerPayment(BuyerPayment buyerPayment,String ip);

    /**
     * 修改支付
     * 
     * @param buyerPayment 支付
     * @return 结果
     */
    public int updateBuyerPayment(BuyerPayment buyerPayment);

    /**
     * 批量删除支付
     * 
     * @param revisions 需要删除的支付主键集合
     * @return 结果
     */
    public int deleteBuyerPaymentByRevisions(Long[] revisions);

    /**
     * 删除支付信息
     * 
     * @param revision 支付主键
     * @return 结果
     */
    public int deleteBuyerPaymentByRevision(Long revision);

    BuyerOrder insertBuyerPaymentVirtual(String orderId, String info, Long addressId, Long payMethod);

    int payNotify(PayNotifyDataDTO payNotifyDataDTO, PayChannel payChannel);

    public AlipayFundTransUniTransferResponse payment(String orderId, Long cid) ;
    public AlipayResponse paymentQuery(Long payId) ;

}
