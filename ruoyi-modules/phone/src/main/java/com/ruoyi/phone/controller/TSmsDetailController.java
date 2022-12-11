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
import com.ruoyi.phone.domain.TSmsDetail;
import com.ruoyi.phone.service.ITSmsDetailService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 短信内容Controller
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
@RestController
@RequestMapping("/tSmsDetail")
public class TSmsDetailController extends BaseController
{
    @Autowired
    private ITSmsDetailService tSmsDetailService;

    /**
     * 查询短信内容列表
     */
    @RequiresPermissions("phone:tSmsDetail:list")
    @GetMapping("/list")
    public TableDataInfo list(TSmsDetail tSmsDetail)
    {
        startPage();
        List<TSmsDetail> list = tSmsDetailService.selectTSmsDetailList(tSmsDetail);
        return getDataTable(list);
    }

    /**
     * 导出短信内容列表
     */
    @RequiresPermissions("phone:tSmsDetail:export")
    @Log(title = "短信内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSmsDetail tSmsDetail)
    {
        List<TSmsDetail> list = tSmsDetailService.selectTSmsDetailList(tSmsDetail);
        ExcelUtil<TSmsDetail> util = new ExcelUtil<TSmsDetail>(TSmsDetail.class);
        util.exportExcel(response, list, "短信内容数据");
    }

    /**
     * 获取短信内容详细信息
     */
    @RequiresPermissions("phone:tSmsDetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSmsDetailService.selectTSmsDetailById(id));
    }

    /**
     * 新增短信内容
     */
    @RequiresPermissions("phone:tSmsDetail:add")
    @Log(title = "短信内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSmsDetail tSmsDetail)
    {
        return toAjax(tSmsDetailService.insertTSmsDetail(tSmsDetail));
    }

    /**
     * 修改短信内容
     */
    @RequiresPermissions("phone:tSmsDetail:edit")
    @Log(title = "短信内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSmsDetail tSmsDetail)
    {
        return toAjax(tSmsDetailService.updateTSmsDetail(tSmsDetail));
    }

    /**
     * 删除短信内容
     */
    @RequiresPermissions("phone:tSmsDetail:remove")
    @Log(title = "短信内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSmsDetailService.deleteTSmsDetailByIds(ids));
    }
}
