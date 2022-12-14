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
import com.ruoyi.religion.domain.ReligionLaw;
import com.ruoyi.religion.service.IReligionLawService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 政策法规Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/api/religionLaw")
public class ApiReligionLawController extends BaseController
{
    @Autowired
    private IReligionLawService religionLawService;

    /**
     * 查询政策法规列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionLaw religionLaw)
    {
        startPage();
        List<ReligionLaw> list = religionLawService.selectReligionLawList(religionLaw);
        return getDataTable(list);
    }

    /**
     * 导出政策法规列表
     */
    @RequiresLogin
    @Log(title = "政策法规", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionLaw religionLaw)
    {
        List<ReligionLaw> list = religionLawService.selectReligionLawList(religionLaw);
        ExcelUtil<ReligionLaw> util = new ExcelUtil<ReligionLaw>(ReligionLaw.class);
        util.exportExcel(response, list, "政策法规数据");
    }

    /**
     * 获取政策法规详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionLawService.selectReligionLawById(id));
    }

    /**
     * 新增政策法规
     */
    @RequiresLogin
    @Log(title = "政策法规", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionLaw religionLaw)
    {
        return toAjax(religionLawService.insertReligionLaw(religionLaw));
    }

    /**
     * 修改政策法规
     */
    @RequiresLogin
    @Log(title = "政策法规", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionLaw religionLaw)
    {
        return toAjax(religionLawService.updateReligionLaw(religionLaw));
    }

    /**
     * 删除政策法规
     */
    @RequiresLogin
    @Log(title = "政策法规", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionLawService.deleteReligionLawByIds(ids));
    }
}
