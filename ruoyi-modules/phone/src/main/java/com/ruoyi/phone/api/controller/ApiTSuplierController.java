package com.ruoyi.phone.api.controller;

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
import com.ruoyi.phone.domain.TSuplier;
import com.ruoyi.phone.service.ITSuplierService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:04
 */
@RestController
@RequestMapping("/api/tSuplier")
public class ApiTSuplierController extends BaseController
{
    @Autowired
    private ITSuplierService tSuplierService;

    /**
     * 查询供应商列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(TSuplier tSuplier)
    {
        startPage();
        List<TSuplier> list = tSuplierService.selectTSuplierList(tSuplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresLogin
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TSuplier tSuplier)
    {
        List<TSuplier> list = tSuplierService.selectTSuplierList(tSuplier);
        ExcelUtil<TSuplier> util = new ExcelUtil<TSuplier>(TSuplier.class);
        util.exportExcel(response, list, "供应商数据");
    }

    /**
     * 获取供应商详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{supId}")
    public AjaxResult getInfo(@PathVariable("supId") Long supId)
    {
        return AjaxResult.success(tSuplierService.selectTSuplierBySupId(supId));
    }

    /**
     * 新增供应商
     */
    @RequiresLogin
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TSuplier tSuplier)
    {
        return toAjax(tSuplierService.insertTSuplier(tSuplier));
    }

    /**
     * 修改供应商
     */
    @RequiresLogin
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TSuplier tSuplier)
    {
        return toAjax(tSuplierService.updateTSuplier(tSuplier));
    }

    /**
     * 删除供应商
     */
    @RequiresLogin
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{supIds}")
    public AjaxResult remove(@PathVariable Long[] supIds)
    {
        return toAjax(tSuplierService.deleteTSuplierBySupIds(supIds));
    }
}
