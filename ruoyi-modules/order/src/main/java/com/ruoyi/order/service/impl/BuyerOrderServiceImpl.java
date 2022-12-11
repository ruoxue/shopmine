package com.ruoyi.order.service.impl;

import com.ruoyi.common.redis.compent.OrderIdUtil;
import com.ruoyi.order.mapper.BuyerOrderMapper;
import com.ruoyi.order.service.IBuyerOrderService;
import com.ruoyi.order.domain.BuyerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单Service业务层处理
 *
 * @author xiaoming
 * @date 2022-08-07
 */
@Service
public class BuyerOrderServiceImpl implements IBuyerOrderService {
    @Autowired
    private BuyerOrderMapper buyerOrderMapper;


    @Autowired
    private OrderIdUtil orderIdUtil;


    /**
     * 查询订单
     *
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public BuyerOrder selectBuyerOrderByOrderId(String orderId) {
        return buyerOrderMapper.selectBuyerOrderByOrderId(orderId);
    }






    /**
     * 修改订单
     *
     * @param buyerOrder 订单
     * @return 结果
     */
    @Override
    public int updateBuyerOrder(BuyerOrder buyerOrder) {
        return buyerOrderMapper.updateBuyerOrder(buyerOrder);
    }


}
