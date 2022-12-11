package com.ruoyi.religion.controller;

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
import com.ruoyi.religion.domain.ReligionActivtyManager;
import com.ruoyi.religion.service.IReligionActivtyManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 活动备案Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@RestController
@RequestMapping("/religionActivtyManager")
public class ReligionActivtyManagerController extends BaseController
{
    @Autowired
    private IReligionActivtyManagerService religionActivtyManagerService;

    /**
     * 查询活动备案列表
     */
    @RequiresPermissions("religion:religionActivtyManager:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionActivtyManager religionActivtyManager)
    {
        startPage();
        List<ReligionActivtyManager> list = religionActivtyManagerService.selectReligionActivtyManagerList(religionActivtyManager);
        return getDataTable(list);
    }

    /**
     * 导出活动备案列表
     */
    @RequiresPermissions("religion:religionActivtyManager:export")
    @Log(title = "活动备案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionActivtyManager religionActivtyManager)
    {
        List<ReligionActivtyManager> list = religionActivtyManagerService.selectReligionActivtyManagerList(religionActivtyManager);
        ExcelUtil<ReligionActivtyManager> util = new ExcelUtil<ReligionActivtyManager>(ReligionActivtyManager.class);
        util.exportExcel(response, list, "活动备案数据");
    }

    /**
     * 获取活动备案详细信息
     */
    @RequiresPermissions("religion:religionActivtyManager:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionActivtyManagerService.selectReligionActivtyManagerById(id));
    }

    /**
     * 新增活动备案
     */
    @RequiresPermissions("religion:religionActivtyManager:add")
    @Log(title = "活动备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionActivtyManager religionActivtyManager)
    {
        return toAjax(religionActivtyManagerService.insertReligionActivtyManager(religionActivtyManager));
    }

    /**
     * 修改活动备案
     */
    @RequiresPermissions("religion:religionActivtyManager:edit")
    @Log(title = "活动备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionActivtyManager religionActivtyManager)
    {
        return toAjax(religionActivtyManagerService.updateReligionActivtyManager(religionActivtyManager));
    }

    /**
     * 删除活动备案
     */
    @RequiresPermissions("religion:religionActivtyManager:remove")
    @Log(title = "活动备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionActivtyManagerService.deleteReligionActivtyManagerByIds(ids));
    }
}
