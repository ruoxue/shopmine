package com.ruoyi.order.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayFundTransCommonQueryResponse;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.utils.ip.IpUtils;
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.order.domain.BuyerOrder;
import com.ruoyi.order.service.IBuyerOrderService;
import com.ruoyi.pay.core.client.PayCommonResult;
import com.ruoyi.shop.domain.OrderPO;
import com.ruoyi.system.api.RemoteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.order.domain.BuyerPayment;
import com.ruoyi.order.service.IBuyerPaymentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 支付Controller
 *
 * @author xiaoming
 * @date 2022-08-19
 */
@RestController
@RequestMapping("/buyerPayment")
public class BuyerPaymentController extends BaseController {
    @Autowired
    private IBuyerPaymentService buyerPaymentService;
    @Autowired
    private IBuyerOrderService iBuyerOrderService;

    @Autowired
    private RemoteOrderService remoteOrderService;


    /**
     * 查询支付列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(BuyerPayment buyerPayment) {
        startPage();
        List<BuyerPayment> list = buyerPaymentService.selectBuyerPaymentList(buyerPayment);
        return getDataTable(list);
    }

    /**
     * 导出支付列表
     */
    @RequiresLogin
    @Log(title = "支付", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BuyerPayment buyerPayment) {
        List<BuyerPayment> list = buyerPaymentService.selectBuyerPaymentList(buyerPayment);
        ExcelUtil<BuyerPayment> util = new ExcelUtil<BuyerPayment>(BuyerPayment.class);
        util.exportExcel(response, list, "支付数据");
    }


    @RequiresLogin
    @PostMapping("/payment")
    public AjaxResult payment(HttpServletResponse response, @RequestBody BuyerPayment buyerPayment) {
        String orderId = buyerPayment.getOrderId();
        AlipayFundTransUniTransferResponse payment = buyerPaymentService.payment(orderId, buyerPayment.getPayMethod());

        if (payment.isSuccess()) {
            return AjaxResult.success(payment.getMsg());
        }
        return AjaxResult.error(payment.getSubMsg());
    }

    @RequiresLogin
    @PostMapping("/paymentQuery")
    public AjaxResult paymentQuery(HttpServletResponse response, @RequestBody BuyerPayment buyerPayment) {
        Long id = buyerPayment.getId();
        AlipayResponse alipayResponse = buyerPaymentService.paymentQuery(id);

        if (alipayResponse.isSuccess()) {
            return AjaxResult.success(alipayResponse.getMsg(),"");
        }
        return AjaxResult.error(alipayResponse.getSubMsg());
    }

    /**
     * 获取支付详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long revision) {
        return AjaxResult.success(buyerPaymentService.selectBuyerPaymentById(revision));
    }

    /**
     * 新增支付
     */
    @RequiresLogin
    @Log(title = "支付", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BuyerPayment buyerPayment, HttpServletRequest request) {
        BuyerOrder orderPO = iBuyerOrderService.selectBuyerOrderByOrderId(buyerPayment.getOrderId());

        if (orderPO.getType() == 4) {
            return AjaxResult.success("",
                    buyerPaymentService.insertBuyerPaymentVirtual(
                            buyerPayment.getOrderId(),
                            buyerPayment.getRemark(),

                            buyerPayment.getAddressId(),
                            buyerPayment.getPayMethod())
            );
        } else {
            String ip = IpUtils.getIpAddr(request);
            PayCommonResult<?> payCommonResult = buyerPaymentService.insertBuyerPayment(buyerPayment, ip);
            if (payCommonResult.isSuccess())
                return AjaxResult.success("", payCommonResult.getData());
            return AjaxResult.error(payCommonResult.getMsg());

        }
    }

    /**
     * 修改支付
     */
    @RequiresLogin
    @Log(title = "支付", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BuyerPayment buyerPayment) {
        return toAjax(buyerPaymentService.updateBuyerPayment(buyerPayment));
    }

    /**
     * 删除支付
     */
    @RequiresLogin
    @Log(title = "支付", businessType = BusinessType.DELETE)
    @DeleteMapping("/{revisions}")
    public AjaxResult remove(@PathVariable Long[] revisions) {
        return toAjax(buyerPaymentService.deleteBuyerPaymentByRevisions(revisions));
    }
}
