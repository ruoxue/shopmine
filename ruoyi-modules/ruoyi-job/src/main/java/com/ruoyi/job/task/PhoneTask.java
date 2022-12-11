package com.ruoyi.job.task;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.shop.domain.BuyerAddress;
import com.ruoyi.system.api.RemotePhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 *
 * @author ruoyi
 */
@Component("phoneTask")
public class PhoneTask {
    @Autowired
    private RemotePhoneService remotePhoneService;

    public void genPhoneNum(Integer type) {
        System.out.println(StringUtils.format("执行多参方法： Integer类型{}", type));

        int ajaxResult = remotePhoneService.genPhone(type, SecurityConstants.INNER);
        System.out.println(StringUtils.format("执行多参方法返回： Integer类型{}", ajaxResult));


    }


}
