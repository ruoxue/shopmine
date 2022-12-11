package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.shop.domain.*;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteOrderService", value = ServiceNameConstants.SHOP_SERVICE,
        fallbackFactory = RemoteOrderFallbackFactory.class)
public interface RemoteOrderService
{
    @GetMapping(value = "/buyerOrder/commit")
    String commitOrderPay( @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping(value = "/buyerOrder/fegin")
    String insertBuyerOrder(OrderPO buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping(value = "/buyerOrder/list/fegin")
    List<OrderPO> selectBuyerOrderList(@RequestBody BuyerOrder buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping(value = "/buyerOrder/fegin")
    OrderPO updateBuyerPayment(@RequestBody OrderPO orderPO, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/buyerOrder/saleList/fegin")
    List<OrderPO> selectSaleOrderList(@RequestBody BuyerOrder buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/buyerOrder/order/fegin")
    List<OrderPO> selectOrderList(@RequestBody BuyerOrder buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
    @PutMapping("/buyerOrder/order/fegin")
    int update(BuyerOrder buyerOrder, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping(value ="/buyerOrder/order/basic/fegin/{uid}")
    public List<OrderBasicVO>  basicInfo(@PathVariable("uid") String uid, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner) ;

    @GetMapping(value ="/buyerOrder/address/{addressId}")
    BuyerAddress getAddress(@PathVariable("addressId") Long addressId, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);
}
