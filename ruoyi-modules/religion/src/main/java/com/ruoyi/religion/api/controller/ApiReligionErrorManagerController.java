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
import com.ruoyi.religion.domain.ReligionErrorManager;
import com.ruoyi.religion.service.IReligionErrorManagerService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 违规登记Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@RestController
@RequestMapping("/api/religionErrorManager")
public class ApiReligionErrorManagerController extends BaseController
{
    @Autowired
    private IReligionErrorManagerService religionErrorManagerService;

    /**
     * 查询违规登记列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionErrorManager religionErrorManager)
    {
        startPage();
        List<ReligionErrorManager> list = religionErrorManagerService.selectReligionErrorManagerList(religionErrorManager);
        return getDataTable(list);
    }

    /**
     * 导出违规登记列表
     */
    @RequiresLogin
    @Log(title = "违规登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionErrorManager religionErrorManager)
    {
        List<ReligionErrorManager> list = religionErrorManagerService.selectReligionErrorManagerList(religionErrorManager);
        ExcelUtil<ReligionErrorManager> util = new ExcelUtil<ReligionErrorManager>(ReligionErrorManager.class);
        util.exportExcel(response, list, "违规登记数据");
    }

    /**
     * 获取违规登记详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionErrorManagerService.selectReligionErrorManagerById(id));
    }

    /**
     * 新增违规登记
     */
    @RequiresLogin
    @Log(title = "违规登记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionErrorManager religionErrorManager)
    {
        return toAjax(religionErrorManagerService.insertReligionErrorManager(religionErrorManager));
    }

    /**
     * 修改违规登记
     */
    @RequiresLogin
    @Log(title = "违规登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionErrorManager religionErrorManager)
    {
        return toAjax(religionErrorManagerService.updateReligionErrorManager(religionErrorManager));
    }

    /**
     * 删除违规登记
     */
    @RequiresLogin
    @Log(title = "违规登记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionErrorManagerService.deleteReligionErrorManagerByIds(ids));
    }
}
