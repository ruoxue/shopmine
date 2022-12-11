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
import com.ruoyi.religion.domain.ReligionDisinfectionControl;
import com.ruoyi.religion.service.IReligionDisinfectionControlService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 场所消杀管理Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@RestController
@RequestMapping("/api/religionDisinfectionControl")
public class ApiReligionDisinfectionControlController extends BaseController
{
    @Autowired
    private IReligionDisinfectionControlService religionDisinfectionControlService;

    /**
     * 查询场所消杀管理列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionDisinfectionControl religionDisinfectionControl)
    {
        startPage();
        List<ReligionDisinfectionControl> list = religionDisinfectionControlService.selectReligionDisinfectionControlList(religionDisinfectionControl);
        return getDataTable(list);
    }

    /**
     * 导出场所消杀管理列表
     */
    @RequiresLogin
    @Log(title = "场所消杀管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionDisinfectionControl religionDisinfectionControl)
    {
        List<ReligionDisinfectionControl> list = religionDisinfectionControlService.selectReligionDisinfectionControlList(religionDisinfectionControl);
        ExcelUtil<ReligionDisinfectionControl> util = new ExcelUtil<ReligionDisinfectionControl>(ReligionDisinfectionControl.class);
        util.exportExcel(response, list, "场所消杀管理数据");
    }

    /**
     * 获取场所消杀管理详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionDisinfectionControlService.selectReligionDisinfectionControlById(id));
    }

    /**
     * 新增场所消杀管理
     */
    @RequiresLogin
    @Log(title = "场所消杀管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionDisinfectionControl religionDisinfectionControl)
    {
        return toAjax(religionDisinfectionControlService.insertReligionDisinfectionControl(religionDisinfectionControl));
    }

    /**
     * 修改场所消杀管理
     */
    @RequiresLogin
    @Log(title = "场所消杀管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionDisinfectionControl religionDisinfectionControl)
    {
        return toAjax(religionDisinfectionControlService.updateReligionDisinfectionControl(religionDisinfectionControl));
    }

    /**
     * 删除场所消杀管理
     */
    @RequiresLogin
    @Log(title = "场所消杀管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionDisinfectionControlService.deleteReligionDisinfectionControlByIds(ids));
    }
}
