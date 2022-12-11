package com.ruoyi.order.mapper;

import com.ruoyi.order.domain.BuyerOrder;

import java.util.List;

/**
 * 订单Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface BuyerOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public BuyerOrder selectBuyerOrderByOrderId(String orderId);

    /**
     * 查询订单列表
     * 
     * @param buyerOrder 订单
     * @return 订单集合
     */
    public List<BuyerOrder> selectBuyerOrderList(BuyerOrder buyerOrder);

    /**
     * 新增订单
     * 
     * @param buyerOrder 订单
     * @return 结果
     */
    public int insertBuyerOrder(BuyerOrder buyerOrder);

    /**
     * 修改订单
     * 
     * @param buyerOrder 订单
     * @return 结果
     */
    public int updateBuyerOrder(BuyerOrder buyerOrder);




}
