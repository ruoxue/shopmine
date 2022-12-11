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
import com.ruoyi.religion.domain.ReligionType;
import com.ruoyi.religion.service.IReligionTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 宗教类型Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@RestController
@RequestMapping("/religionType")
public class ReligionTypeController extends BaseController
{
    @Autowired
    private IReligionTypeService religionTypeService;

    /**
     * 查询宗教类型列表
     */
    @RequiresPermissions("religion:religionType:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionType religionType)
    {
        startPage();
        List<ReligionType> list = religionTypeService.selectReligionTypeList(religionType);
        return getDataTable(list);
    }

    /**
     * 导出宗教类型列表
     */
    @RequiresPermissions("religion:religionType:export")
    @Log(title = "宗教类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionType religionType)
    {
        List<ReligionType> list = religionTypeService.selectReligionTypeList(religionType);
        ExcelUtil<ReligionType> util = new ExcelUtil<ReligionType>(ReligionType.class);
        util.exportExcel(response, list, "宗教类型数据");
    }

    /**
     * 获取宗教类型详细信息
     */
    @RequiresPermissions("religion:religionType:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionTypeService.selectReligionTypeById(id));
    }

    /**
     * 新增宗教类型
     */
    @RequiresPermissions("religion:religionType:add")
    @Log(title = "宗教类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionType religionType)
    {
        return toAjax(religionTypeService.insertReligionType(religionType));
    }

    /**
     * 修改宗教类型
     */
    @RequiresPermissions("religion:religionType:edit")
    @Log(title = "宗教类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionType religionType)
    {
        return toAjax(religionTypeService.updateReligionType(religionType));
    }

    /**
     * 删除宗教类型
     */
    @RequiresPermissions("religion:religionType:remove")
    @Log(title = "宗教类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionTypeService.deleteReligionTypeByIds(ids));
    }
}
