package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.shop.domain.BuyerOrder;
import com.ruoyi.shop.domain.OrderBasicVO;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.system.api.factory.RemoteOrderFallbackFactory;
import com.ruoyi.system.api.factory.RemotePhoneFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remotePhoneService", value = ServiceNameConstants.PHONE_SERVICE,
        fallbackFactory = RemotePhoneFallbackFactory.class)
public interface RemotePhoneService
{

    @GetMapping(value ="/api/tPhoneTask/genPhone/{type}")
    int  genPhone(@PathVariable("type") Integer type, @RequestHeader(SecurityConstants.FROM_SOURCE) String inner);
}
