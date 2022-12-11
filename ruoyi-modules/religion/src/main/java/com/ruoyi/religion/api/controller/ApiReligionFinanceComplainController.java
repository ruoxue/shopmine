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
import com.ruoyi.religion.domain.ReligionFinanceComplain;
import com.ruoyi.religion.service.IReligionFinanceComplainService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 财务投诉Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/api/religionFinanceComplain")
public class ApiReligionFinanceComplainController extends BaseController
{
    @Autowired
    private IReligionFinanceComplainService religionFinanceComplainService;

    /**
     * 查询财务投诉列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionFinanceComplain religionFinanceComplain)
    {
        startPage();
        List<ReligionFinanceComplain> list = religionFinanceComplainService.selectReligionFinanceComplainList(religionFinanceComplain);
        return getDataTable(list);
    }

    /**
     * 导出财务投诉列表
     */
    @RequiresLogin
    @Log(title = "财务投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionFinanceComplain religionFinanceComplain)
    {
        List<ReligionFinanceComplain> list = religionFinanceComplainService.selectReligionFinanceComplainList(religionFinanceComplain);
        ExcelUtil<ReligionFinanceComplain> util = new ExcelUtil<ReligionFinanceComplain>(ReligionFinanceComplain.class);
        util.exportExcel(response, list, "财务投诉数据");
    }

    /**
     * 获取财务投诉详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionFinanceComplainService.selectReligionFinanceComplainById(id));
    }

    /**
     * 新增财务投诉
     */
    @RequiresLogin
    @Log(title = "财务投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionFinanceComplain religionFinanceComplain)
    {
        return toAjax(religionFinanceComplainService.insertReligionFinanceComplain(religionFinanceComplain));
    }

    /**
     * 修改财务投诉
     */
    @RequiresLogin
    @Log(title = "财务投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionFinanceComplain religionFinanceComplain)
    {
        return toAjax(religionFinanceComplainService.updateReligionFinanceComplain(religionFinanceComplain));
    }

    /**
     * 删除财务投诉
     */
    @RequiresLogin
    @Log(title = "财务投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionFinanceComplainService.deleteReligionFinanceComplainByIds(ids));
    }
}
