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
import com.ruoyi.religion.domain.ReligionBuildSafeManager;
import com.ruoyi.religion.service.IReligionBuildSafeManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 建筑安全隐患排查Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@RestController
@RequestMapping("/api/religionBuildSafeManager")
public class ApiReligionBuildSafeManagerController extends BaseController
{
    @Autowired
    private IReligionBuildSafeManagerService religionBuildSafeManagerService;

    /**
     * 查询建筑安全隐患排查列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionBuildSafeManager religionBuildSafeManager)
    {
        startPage();
        List<ReligionBuildSafeManager> list = religionBuildSafeManagerService.selectReligionBuildSafeManagerList(religionBuildSafeManager);
        return getDataTable(list);
    }

    /**
     * 导出建筑安全隐患排查列表
     */
    @RequiresLogin
    @Log(title = "建筑安全隐患排查", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionBuildSafeManager religionBuildSafeManager)
    {
        List<ReligionBuildSafeManager> list = religionBuildSafeManagerService.selectReligionBuildSafeManagerList(religionBuildSafeManager);
        ExcelUtil<ReligionBuildSafeManager> util = new ExcelUtil<ReligionBuildSafeManager>(ReligionBuildSafeManager.class);
        util.exportExcel(response, list, "建筑安全隐患排查数据");
    }

    /**
     * 获取建筑安全隐患排查详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionBuildSafeManagerService.selectReligionBuildSafeManagerById(id));
    }

    /**
     * 新增建筑安全隐患排查
     */
    @RequiresLogin
    @Log(title = "建筑安全隐患排查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionBuildSafeManager religionBuildSafeManager)
    {
        return toAjax(religionBuildSafeManagerService.insertReligionBuildSafeManager(religionBuildSafeManager));
    }

    /**
     * 修改建筑安全隐患排查
     */
    @RequiresLogin
    @Log(title = "建筑安全隐患排查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionBuildSafeManager religionBuildSafeManager)
    {
        return toAjax(religionBuildSafeManagerService.updateReligionBuildSafeManager(religionBuildSafeManager));
    }

    /**
     * 删除建筑安全隐患排查
     */
    @RequiresLogin
    @Log(title = "建筑安全隐患排查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionBuildSafeManagerService.deleteReligionBuildSafeManagerByIds(ids));
    }
}
