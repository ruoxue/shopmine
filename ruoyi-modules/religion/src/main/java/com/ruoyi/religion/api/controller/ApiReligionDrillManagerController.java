package com.ruoyi.religion.api.controller;

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
import com.ruoyi.religion.domain.ReligionDrillManager;
import com.ruoyi.religion.service.IReligionDrillManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 消防演练管理Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@RestController
@RequestMapping("/api/religionDrillManager")
public class ApiReligionDrillManagerController extends BaseController
{
    @Autowired
    private IReligionDrillManagerService religionDrillManagerService;

    /**
     * 查询消防演练管理列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionDrillManager religionDrillManager)
    {
        startPage();
        List<ReligionDrillManager> list = religionDrillManagerService.selectReligionDrillManagerList(religionDrillManager);
        return getDataTable(list);
    }

    /**
     * 导出消防演练管理列表
     */
    @RequiresLogin
    @Log(title = "消防演练管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionDrillManager religionDrillManager)
    {
        List<ReligionDrillManager> list = religionDrillManagerService.selectReligionDrillManagerList(religionDrillManager);
        ExcelUtil<ReligionDrillManager> util = new ExcelUtil<ReligionDrillManager>(ReligionDrillManager.class);
        util.exportExcel(response, list, "消防演练管理数据");
    }

    /**
     * 获取消防演练管理详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionDrillManagerService.selectReligionDrillManagerById(id));
    }

    /**
     * 新增消防演练管理
     */
    @RequiresLogin
    @Log(title = "消防演练管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionDrillManager religionDrillManager)
    {
        return toAjax(religionDrillManagerService.insertReligionDrillManager(religionDrillManager));
    }

    /**
     * 修改消防演练管理
     */
    @RequiresLogin
    @Log(title = "消防演练管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionDrillManager religionDrillManager)
    {
        return toAjax(religionDrillManagerService.updateReligionDrillManager(religionDrillManager));
    }

    /**
     * 删除消防演练管理
     */
    @RequiresLogin
    @Log(title = "消防演练管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionDrillManagerService.deleteReligionDrillManagerByIds(ids));
    }
}
