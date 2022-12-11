package com.ruoyi.phone.api.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.security.annotation.InnerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.security.annotation.RequiresLogin;
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
@RequestMapping("/api/tPhoneTask")
public class ApiTPhoneTaskController extends BaseController {
    @Autowired
    private ITPhoneTaskService tPhoneTaskService;

    /**
     * 查询生产任务列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(TPhoneTask tPhoneTask) {
        startPage();
        List<TPhoneTask> list = tPhoneTaskService.selectTPhoneTaskList(tPhoneTask);
        return getDataTable(list);
    }

    /**
     * 导出生产任务列表
     */
    @RequiresLogin
    @Log(title = "生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPhoneTask tPhoneTask) {
        List<TPhoneTask> list = tPhoneTaskService.selectTPhoneTaskList(tPhoneTask);
        ExcelUtil<TPhoneTask> util = new ExcelUtil<TPhoneTask>(TPhoneTask.class);
        util.exportExcel(response, list, "生产任务数据");
    }

    /**
     * 获取生产任务详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tPhoneTaskService.selectTPhoneTaskById(id));
    }

    /**
     * 新增生产任务
     */
    @RequiresLogin
    @Log(title = "生产任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPhoneTask tPhoneTask) {
        return toAjax(tPhoneTaskService.insertTPhoneTask(tPhoneTask));
    }

    /**
     * 修改生产任务
     */
    @RequiresLogin
    @Log(title = "生产任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPhoneTask tPhoneTask) {
        return toAjax(tPhoneTaskService.updateTPhoneTask(tPhoneTask));
    }

    /**
     * 删除生产任务
     */
    @RequiresLogin
    @Log(title = "生产任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tPhoneTaskService.deleteTPhoneTaskByIds(ids));
    }
//    @InnerAuth
    @GetMapping("/genPhone/{type}")
    public int  genPhone(@PathVariable("type") Integer type
                            ,
                               @RequestHeader(SecurityConstants.FROM_SOURCE) String inner
    ) {

       return tPhoneTaskService.getPhone(type);


    }

}
