package com.ruoyi.phone.controller;

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
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.phone.domain.TPhoneVisitor;
import com.ruoyi.phone.service.ITPhoneVisitorService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 访问记录Controller
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
@RestController
@RequestMapping("/tPhoneVisitor")
public class TPhoneVisitorController extends BaseController
{
    @Autowired
    private ITPhoneVisitorService tPhoneVisitorService;

    /**
     * 查询访问记录列表
     */
    @RequiresPermissions("phone:tPhoneVisitor:list")
    @GetMapping("/list")
    public TableDataInfo list(TPhoneVisitor tPhoneVisitor)
    {
        startPage();
        List<TPhoneVisitor> list = tPhoneVisitorService.selectTPhoneVisitorList(tPhoneVisitor);
        return getDataTable(list);
    }

    /**
     * 导出访问记录列表
     */
    @RequiresPermissions("phone:tPhoneVisitor:export")
    @Log(title = "访问记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPhoneVisitor tPhoneVisitor)
    {
        List<TPhoneVisitor> list = tPhoneVisitorService.selectTPhoneVisitorList(tPhoneVisitor);
        ExcelUtil<TPhoneVisitor> util = new ExcelUtil<TPhoneVisitor>(TPhoneVisitor.class);
        util.exportExcel(response, list, "访问记录数据");
    }

    /**
     * 获取访问记录详细信息
     */
    @RequiresPermissions("phone:tPhoneVisitor:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tPhoneVisitorService.selectTPhoneVisitorById(id));
    }

    /**
     * 新增访问记录
     */
    @RequiresPermissions("phone:tPhoneVisitor:add")
    @Log(title = "访问记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPhoneVisitor tPhoneVisitor)
    {
        return toAjax(tPhoneVisitorService.insertTPhoneVisitor(tPhoneVisitor));
    }

    /**
     * 修改访问记录
     */
    @RequiresPermissions("phone:tPhoneVisitor:edit")
    @Log(title = "访问记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPhoneVisitor tPhoneVisitor)
    {
        return toAjax(tPhoneVisitorService.updateTPhoneVisitor(tPhoneVisitor));
    }

    /**
     * 删除访问记录
     */
    @RequiresPermissions("phone:tPhoneVisitor:remove")
    @Log(title = "访问记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPhoneVisitorService.deleteTPhoneVisitorByIds(ids));
    }
}
