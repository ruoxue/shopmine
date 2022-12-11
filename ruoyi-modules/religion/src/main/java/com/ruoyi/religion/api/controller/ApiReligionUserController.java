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
import com.ruoyi.religion.domain.ReligionUser;
import com.ruoyi.religion.service.IReligionUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 宗教人员Controller
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@RestController
@RequestMapping("/api/religionUser")
public class ApiReligionUserController extends BaseController
{
    @Autowired
    private IReligionUserService religionUserService;

    /**
     * 查询宗教人员列表
     */
    @RequiresLogin
    @GetMapping("/list")
    public TableDataInfo list(ReligionUser religionUser)
    {
        startPage();
        List<ReligionUser> list = religionUserService.selectReligionUserList(religionUser);
        return getDataTable(list);
    }

    /**
     * 导出宗教人员列表
     */
    @RequiresLogin
    @Log(title = "宗教人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReligionUser religionUser)
    {
        List<ReligionUser> list = religionUserService.selectReligionUserList(religionUser);
        ExcelUtil<ReligionUser> util = new ExcelUtil<ReligionUser>(ReligionUser.class);
        util.exportExcel(response, list, "宗教人员数据");
    }

    /**
     * 获取宗教人员详细信息
     */
    @RequiresLogin
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(religionUserService.selectReligionUserById(id));
    }

    /**
     * 新增宗教人员
     */
    @RequiresLogin
    @Log(title = "宗教人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReligionUser religionUser)
    {
        return toAjax(religionUserService.insertReligionUser(religionUser));
    }

    /**
     * 修改宗教人员
     */
    @RequiresLogin
    @Log(title = "宗教人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReligionUser religionUser)
    {
        return toAjax(religionUserService.updateReligionUser(religionUser));
    }

    /**
     * 删除宗教人员
     */
    @RequiresLogin
    @Log(title = "宗教人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(religionUserService.deleteReligionUserByIds(ids));
    }
}
