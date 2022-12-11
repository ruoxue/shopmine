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
import com.ruoyi.religion.domain.ReligionArea;
import com.ruoyi.religion.service.IReligionAreaService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 宗教场所Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@RestController
@RequestMapping("/api/religionArea")
public class ApiReligionAreaController extends BaseController
{
    @Autowired
    private IReligionAreaService religionAreaService;

    /**
     * 查询宗教场所列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionArea religionArea)
    {
        startPage();
        List<ReligionArea> list = religionAreaService.selectReligionAreaList(religionArea);
        return getDataTable(list);
    }

    /**
     * 导出宗教场所列表
     */
    @RequiresLogin
    @Log(title = "宗教场所", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionArea religionArea)
    {
        List<ReligionArea> list = religionAreaService.selectReligionAreaList(religionArea);
        ExcelUtil<ReligionArea> util = new ExcelUtil<ReligionArea>(ReligionArea.class);
        util.exportExcel(response, list, "宗教场所数据");
    }

    /**
     * 获取宗教场所详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionAreaService.selectReligionAreaById(id));
    }

    /**
     * 新增宗教场所
     */
    @RequiresLogin
    @Log(title = "宗教场所", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionArea religionArea)
    {
        return toAjax(religionAreaService.insertReligionArea(religionArea));
    }

    /**
     * 修改宗教场所
     */
    @RequiresLogin
    @Log(title = "宗教场所", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionArea religionArea)
    {
        return toAjax(religionAreaService.updateReligionArea(religionArea));
    }

    /**
     * 删除宗教场所
     */
    @RequiresLogin
    @Log(title = "宗教场所", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionAreaService.deleteReligionAreaByIds(ids));
    }
}
