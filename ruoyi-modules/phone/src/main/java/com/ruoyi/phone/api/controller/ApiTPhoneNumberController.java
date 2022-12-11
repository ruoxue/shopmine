package com.ruoyi.phone.api.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.common.security.annotation.RequiresLogin;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.phone.domain.TPhoneNumber;
import com.ruoyi.phone.service.ITPhoneNumberService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 手机管理Controller
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
@RestController
@RequestMapping("/api/tPhoneNumber")
public class ApiTPhoneNumberController extends BaseController
{
    @Autowired
    private ITPhoneNumberService tPhoneNumberService;

    /**
     * 查询手机管理列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(TPhoneNumber tPhoneNumber)
    {
        startPage();
        List<TPhoneNumber> list = tPhoneNumberService.selectTPhoneNumberList(tPhoneNumber);
        return getDataTable(list);
    }

    /**
     * 导出手机管理列表
     */
    @RequiresLogin
    @Log(title = "手机管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPhoneNumber tPhoneNumber)
    {
        List<TPhoneNumber> list = tPhoneNumberService.selectTPhoneNumberList(tPhoneNumber);
        ExcelUtil<TPhoneNumber> util = new ExcelUtil<TPhoneNumber>(TPhoneNumber.class);
        util.exportExcel(response, list, "手机管理数据");
    }

    /**
     * 获取手机管理详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tPhoneNumberService.selectTPhoneNumberById(id));
    }

    /**
     * 新增手机管理
     */
    @RequiresLogin
    @Log(title = "手机管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPhoneNumber tPhoneNumber)
    {
        return toAjax(tPhoneNumberService.insertTPhoneNumber(tPhoneNumber));
    }

    /**
     * 修改手机管理
     */
    @RequiresLogin
    @Log(title = "手机管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPhoneNumber tPhoneNumber)
    {
        return toAjax(tPhoneNumberService.updateTPhoneNumber(tPhoneNumber));
    }

    /**
     * 删除手机管理
     */
    @RequiresLogin
    @Log(title = "手机管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPhoneNumberService.deleteTPhoneNumberByIds(ids));
    }
}
