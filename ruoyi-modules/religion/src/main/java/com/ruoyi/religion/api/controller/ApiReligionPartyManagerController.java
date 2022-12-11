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
import com.ruoyi.religion.domain.ReligionPartyManager;
import com.ruoyi.religion.service.IReligionPartyManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 集会登记Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/api/religionPartyManager")
public class ApiReligionPartyManagerController extends BaseController
{
    @Autowired
    private IReligionPartyManagerService religionPartyManagerService;

    /**
     * 查询集会登记列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionPartyManager religionPartyManager)
    {
        startPage();
        List<ReligionPartyManager> list = religionPartyManagerService.selectReligionPartyManagerList(religionPartyManager);
        return getDataTable(list);
    }

    /**
     * 导出集会登记列表
     */
    @RequiresLogin
    @Log(title = "集会登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionPartyManager religionPartyManager)
    {
        List<ReligionPartyManager> list = religionPartyManagerService.selectReligionPartyManagerList(religionPartyManager);
        ExcelUtil<ReligionPartyManager> util = new ExcelUtil<ReligionPartyManager>(ReligionPartyManager.class);
        util.exportExcel(response, list, "集会登记数据");
    }

    /**
     * 获取集会登记详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionPartyManagerService.selectReligionPartyManagerById(id));
    }

    /**
     * 新增集会登记
     */
    @RequiresLogin
    @Log(title = "集会登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionPartyManager religionPartyManager)
    {
        return toAjax(religionPartyManagerService.insertReligionPartyManager(religionPartyManager));
    }

    /**
     * 修改集会登记
     */
    @RequiresLogin
    @Log(title = "集会登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionPartyManager religionPartyManager)
    {
        return toAjax(religionPartyManagerService.updateReligionPartyManager(religionPartyManager));
    }

    /**
     * 删除集会登记
     */
    @RequiresLogin
    @Log(title = "集会登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionPartyManagerService.deleteReligionPartyManagerByIds(ids));
    }
}
