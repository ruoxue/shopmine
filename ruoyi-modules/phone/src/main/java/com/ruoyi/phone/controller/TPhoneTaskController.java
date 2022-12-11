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
import com.ruoyi.phone.domain.TPhoneTask;
import com.ruoyi.phone.service.ITPhoneTaskService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 生产任务Controller
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
@RestController
@RequestMapping("/tPhoneTask")
public class TPhoneTaskController extends BaseController
{
    @Autowired
    private ITPhoneTaskService tPhoneTaskService;

    /**
     * 查询生产任务列表
     */
    @RequiresPermissions("phone:tPhoneTask:list")
    @GetMapping("/list")
    public TableDataInfo list(TPhoneTask tPhoneTask)
    {
        startPage();
        List<TPhoneTask> list = tPhoneTaskService.selectTPhoneTaskList(tPhoneTask);
        return getDataTable(list);
    }

    /**
     * 导出生产任务列表
     */
    @RequiresPermissions("phone:tPhoneTask:export")
    @Log(title = "生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPhoneTask tPhoneTask)
    {
        List<TPhoneTask> list = tPhoneTaskService.selectTPhoneTaskList(tPhoneTask);
        ExcelUtil<TPhoneTask> util = new ExcelUtil<TPhoneTask>(TPhoneTask.class);
        util.exportExcel(response, list, "生产任务数据");
    }

    /**
     * 获取生产任务详细信息
     */
    @RequiresPermissions("phone:tPhoneTask:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tPhoneTaskService.selectTPhoneTaskById(id));
    }

    /**
     * 新增生产任务
     */
    @RequiresPermissions("phone:tPhoneTask:add")
    @Log(title = "生产任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPhoneTask tPhoneTask)
    {
        return toAjax(tPhoneTaskService.insertTPhoneTask(tPhoneTask));
    }

    /**
     * 修改生产任务
     */
    @RequiresPermissions("phone:tPhoneTask:edit")
    @Log(title = "生产任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPhoneTask tPhoneTask)
    {
        return toAjax(tPhoneTaskService.updateTPhoneTask(tPhoneTask));
    }

    /**
     * 删除生产任务
     */
    @RequiresPermissions("phone:tPhoneTask:remove")
    @Log(title = "生产任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tPhoneTaskService.deleteTPhoneTaskByIds(ids));
    }
}
