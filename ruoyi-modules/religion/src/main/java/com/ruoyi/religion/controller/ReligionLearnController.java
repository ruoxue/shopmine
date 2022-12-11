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
import com.ruoyi.religion.domain.ReligionLearn;
import com.ruoyi.religion.service.IReligionLearnService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 学习Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/religionLearn")
public class ReligionLearnController extends BaseController
{
    @Autowired
    private IReligionLearnService religionLearnService;

    /**
     * 查询学习列表
     */
    @RequiresPermissions("religion:religionLearn:list")
    @GetMapping("/list")
    public TableDataInfo list(ReligionLearn religionLearn)
    {
        startPage();
        List<ReligionLearn> list = religionLearnService.selectReligionLearnList(religionLearn);
        return getDataTable(list);
    }

    /**
     * 导出学习列表
     */
    @RequiresPermissions("religion:religionLearn:export")
    @Log(title = "学习", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionLearn religionLearn)
    {
        List<ReligionLearn> list = religionLearnService.selectReligionLearnList(religionLearn);
        ExcelUtil<ReligionLearn> util = new ExcelUtil<ReligionLearn>(ReligionLearn.class);
        util.exportExcel(response, list, "学习数据");
    }

    /**
     * 获取学习详细信息
     */
    @RequiresPermissions("religion:religionLearn:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionLearnService.selectReligionLearnById(id));
    }

    /**
     * 新增学习
     */
    @RequiresPermissions("religion:religionLearn:add")
    @Log(title = "学习", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionLearn religionLearn)
    {
        return toAjax(religionLearnService.insertReligionLearn(religionLearn));
    }

    /**
     * 修改学习
     */
    @RequiresPermissions("religion:religionLearn:edit")
    @Log(title = "学习", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionLearn religionLearn)
    {
        return toAjax(religionLearnService.updateReligionLearn(religionLearn));
    }

    /**
     * 删除学习
     */
    @RequiresPermissions("religion:religionLearn:remove")
    @Log(title = "学习", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionLearnService.deleteReligionLearnByIds(ids));
    }
}
