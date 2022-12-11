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
import com.ruoyi.religion.domain.ReligionHarmoniousBuild;
import com.ruoyi.religion.service.IReligionHarmoniousBuildService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 和谐建设Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/api/religionHarmoniousBuild")
public class ApiReligionHarmoniousBuildController extends BaseController
{
    @Autowired
    private IReligionHarmoniousBuildService religionHarmoniousBuildService;

    /**
     * 查询和谐建设列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        startPage();
        List<ReligionHarmoniousBuild> list = religionHarmoniousBuildService.selectReligionHarmoniousBuildList(religionHarmoniousBuild);
        return getDataTable(list);
    }

    /**
     * 导出和谐建设列表
     */
    @RequiresLogin
    @Log(title = "和谐建设", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        List<ReligionHarmoniousBuild> list = religionHarmoniousBuildService.selectReligionHarmoniousBuildList(religionHarmoniousBuild);
        ExcelUtil<ReligionHarmoniousBuild> util = new ExcelUtil<ReligionHarmoniousBuild>(ReligionHarmoniousBuild.class);
        util.exportExcel(response, list, "和谐建设数据");
    }

    /**
     * 获取和谐建设详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionHarmoniousBuildService.selectReligionHarmoniousBuildById(id));
    }

    /**
     * 新增和谐建设
     */
    @RequiresLogin
    @Log(title = "和谐建设", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        return toAjax(religionHarmoniousBuildService.insertReligionHarmoniousBuild(religionHarmoniousBuild));
    }

    /**
     * 修改和谐建设
     */
    @RequiresLogin
    @Log(title = "和谐建设", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionHarmoniousBuild religionHarmoniousBuild)
    {
        return toAjax(religionHarmoniousBuildService.updateReligionHarmoniousBuild(religionHarmoniousBuild));
    }

    /**
     * 删除和谐建设
     */
    @RequiresLogin
    @Log(title = "和谐建设", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionHarmoniousBuildService.deleteReligionHarmoniousBuildByIds(ids));
    }
}
