package com.ruoyi.system.api.factory;

import com.ruoyi.system.api.RemoteOrderService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RemotePhoneFallbackFactory implements FallbackFactory<RemoteOrderService> {
    @Override
    public RemoteOrderService create(Throwable cause) {
        return null;
    }
}
