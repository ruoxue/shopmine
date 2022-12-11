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
import com.ruoyi.phone.domain.TArea;
import com.ruoyi.phone.service.ITAreaService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 地区码Controller
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
@RestController
@RequestMapping("/api/tArea")
public class ApiTAreaController extends BaseController
{
    @Autowired
    private ITAreaService tAreaService;

    /**
     * 查询地区码列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(TArea tArea)
    {
        startPage();
        List<TArea> list = tAreaService.selectTAreaList(tArea);
        return getDataTable(list);
    }

    /**
     * 导出地区码列表
     */
    @RequiresLogin
    @Log(title = "地区码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TArea tArea)
    {
        List<TArea> list = tAreaService.selectTAreaList(tArea);
        ExcelUtil<TArea> util = new ExcelUtil<TArea>(TArea.class);
        util.exportExcel(response, list, "地区码数据");
    }

    /**
     * 获取地区码详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{areaId}")
    public AjaxResult getInfo(@PathVariable("areaId") Long areaId)
    {
        return AjaxResult.success(tAreaService.selectTAreaByAreaId(areaId));
    }

    /**
     * 新增地区码
     */
    @RequiresLogin
    @Log(title = "地区码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TArea tArea)
    {
        return toAjax(tAreaService.insertTArea(tArea));
    }

    /**
     * 修改地区码
     */
    @RequiresLogin
    @Log(title = "地区码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TArea tArea)
    {
        return toAjax(tAreaService.updateTArea(tArea));
    }

    /**
     * 删除地区码
     */
    @RequiresLogin
    @Log(title = "地区码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaIds}")
    public AjaxResult remove(@PathVariable Long[] areaIds)
    {
        return toAjax(tAreaService.deleteTAreaByAreaIds(areaIds));
    }
}
