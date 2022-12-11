package com.ruoyi.order.service;

import com.ruoyi.order.domain.BuyerOrder;


/**
 * 订单Service接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface IBuyerOrderService 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public BuyerOrder selectBuyerOrderByOrderId(String orderId);




    /**
     * 修改订单
     * 
     * @param buyerOrder 订单
     * @return 结果
     */
    public int updateBuyerOrder(BuyerOrder buyerOrder);


}
