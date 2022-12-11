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
import com.ruoyi.religion.domain.ReligionVideo;
import com.ruoyi.religion.service.IReligionVideoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 视频数据Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@RestController
@RequestMapping("/api/religionVideo")
public class ApiReligionVideoController extends BaseController
{
    @Autowired
    private IReligionVideoService religionVideoService;

    /**
     * 查询视频数据列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionVideo religionVideo)
    {
        startPage();
        List<ReligionVideo> list = religionVideoService.selectReligionVideoList(religionVideo);
        return getDataTable(list);
    }

    /**
     * 导出视频数据列表
     */
    @RequiresLogin
    @Log(title = "视频数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionVideo religionVideo)
    {
        List<ReligionVideo> list = religionVideoService.selectReligionVideoList(religionVideo);
        ExcelUtil<ReligionVideo> util = new ExcelUtil<ReligionVideo>(ReligionVideo.class);
        util.exportExcel(response, list, "视频数据数据");
    }

    /**
     * 获取视频数据详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionVideoService.selectReligionVideoById(id));
    }

    /**
     * 新增视频数据
     */
    @RequiresLogin
    @Log(title = "视频数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionVideo religionVideo)
    {
        return toAjax(religionVideoService.insertReligionVideo(religionVideo));
    }

    /**
     * 修改视频数据
     */
    @RequiresLogin
    @Log(title = "视频数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionVideo religionVideo)
    {
        return toAjax(religionVideoService.updateReligionVideo(religionVideo));
    }

    /**
     * 删除视频数据
     */
    @RequiresLogin
    @Log(title = "视频数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionVideoService.deleteReligionVideoByIds(ids));
    }
}
