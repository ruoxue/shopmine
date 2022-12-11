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
import com.ruoyi.religion.domain.ReligionActivityComplain;
import com.ruoyi.religion.service.IReligionActivityComplainService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 活动管理Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:45
 */
@RestController
@RequestMapping("/religionActivityComplain")
public class ReligionActivityComplainController extends BaseController
{
    @Autowired
    private IReligionActivityComplainService religionActivityComplainService;

    /**
     * 查询活动管理列表
     */
    @RequiresPermissions("religion:religionActivityComplain:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionActivityComplain religionActivityComplain)
    {
        startPage();
        List<ReligionActivityComplain> list = religionActivityComplainService.selectReligionActivityComplainList(religionActivityComplain);
        return getDataTable(list);
    }

    /**
     * 导出活动管理列表
     */
    @RequiresPermissions("religion:religionActivityComplain:export")
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionActivityComplain religionActivityComplain)
    {
        List<ReligionActivityComplain> list = religionActivityComplainService.selectReligionActivityComplainList(religionActivityComplain);
        ExcelUtil<ReligionActivityComplain> util = new ExcelUtil<ReligionActivityComplain>(ReligionActivityComplain.class);
        util.exportExcel(response, list, "活动管理数据");
    }

    /**
     * 获取活动管理详细信息
     */
    @RequiresPermissions("religion:religionActivityComplain:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionActivityComplainService.selectReligionActivityComplainById(id));
    }

    /**
     * 新增活动管理
     */
    @RequiresPermissions("religion:religionActivityComplain:add")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionActivityComplain religionActivityComplain)
    {
        return toAjax(religionActivityComplainService.insertReligionActivityComplain(religionActivityComplain));
    }

    /**
     * 修改活动管理
     */
    @RequiresPermissions("religion:religionActivityComplain:edit")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionActivityComplain religionActivityComplain)
    {
        return toAjax(religionActivityComplainService.updateReligionActivityComplain(religionActivityComplain));
    }

    /**
     * 删除活动管理
     */
    @RequiresPermissions("religion:religionActivityComplain:remove")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionActivityComplainService.deleteReligionActivityComplainByIds(ids));
    }
}
