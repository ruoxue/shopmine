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
import com.ruoyi.phone.domain.TSmsTemplate;
import com.ruoyi.phone.service.ITSmsTemplateService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 短信模版Controller
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
@RestController
@RequestMapping("/tSmsTemplate")
public class TSmsTemplateController extends BaseController
{
    @Autowired
    private ITSmsTemplateService tSmsTemplateService;

    /**
     * 查询短信模版列表
     */
    @RequiresPermissions("phone:tSmsTemplate:list")
    @GetMapping("/list")
    public TableDataInfo list(TSmsTemplate tSmsTemplate)
    {
        startPage();
        List<TSmsTemplate> list = tSmsTemplateService.selectTSmsTemplateList(tSmsTemplate);
        return getDataTable(list);
    }

    /**
     * 导出短信模版列表
     */
    @RequiresPermissions("phone:tSmsTemplate:export")
    @Log(title = "短信模版", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSmsTemplate tSmsTemplate)
    {
        List<TSmsTemplate> list = tSmsTemplateService.selectTSmsTemplateList(tSmsTemplate);
        ExcelUtil<TSmsTemplate> util = new ExcelUtil<TSmsTemplate>(TSmsTemplate.class);
        util.exportExcel(response, list, "短信模版数据");
    }

    /**
     * 获取短信模版详细信息
     */
    @RequiresPermissions("phone:tSmsTemplate:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tSmsTemplateService.selectTSmsTemplateById(id));
    }

    /**
     * 新增短信模版
     */
    @RequiresPermissions("phone:tSmsTemplate:add")
    @Log(title = "短信模版", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSmsTemplate tSmsTemplate)
    {
        return toAjax(tSmsTemplateService.insertTSmsTemplate(tSmsTemplate));
    }

    /**
     * 修改短信模版
     */
    @RequiresPermissions("phone:tSmsTemplate:edit")
    @Log(title = "短信模版", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSmsTemplate tSmsTemplate)
    {
        return toAjax(tSmsTemplateService.updateTSmsTemplate(tSmsTemplate));
    }

    /**
     * 删除短信模版
     */
    @RequiresPermissions("phone:tSmsTemplate:remove")
    @Log(title = "短信模版", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tSmsTemplateService.deleteTSmsTemplateByIds(ids));
    }
}
