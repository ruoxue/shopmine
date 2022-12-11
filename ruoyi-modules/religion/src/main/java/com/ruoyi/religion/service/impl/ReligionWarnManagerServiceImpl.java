package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionWarnManagerMapper;
import com.ruoyi.religion.domain.ReligionWarnManager;
import com.ruoyi.religion.service.IReligionWarnManagerService;

/**
 * 消防预警接入Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@Service
public class ReligionWarnManagerServiceImpl implements IReligionWarnManagerService 
{
    @Autowired
    private ReligionWarnManagerMapper religionWarnManagerMapper;

    /**
     * 查询消防预警接入
     * 
     * @param id 消防预警接入主键
     * @return 消防预警接入
     */
    @Override
    public ReligionWarnManager selectReligionWarnManagerById(Long id)
    {
        return religionWarnManagerMapper.selectReligionWarnManagerById(id);
    }

    /**
     * 查询消防预警接入列表
     * 
     * @param religionWarnManager 消防预警接入
     * @return 消防预警接入
     */
    @Override
    public List<ReligionWarnManager> selectReligionWarnManagerList(ReligionWarnManager religionWarnManager)
    {
        return religionWarnManagerMapper.selectReligionWarnManagerList(religionWarnManager);
    }

    /**
     * 新增消防预警接入
     * 
     * @param religionWarnManager 消防预警接入
     * @return 结果
     */
    @Override
    public int insertReligionWarnManager(ReligionWarnManager religionWarnManager)
    {
        religionWarnManager.setCreateTime(DateUtils.getNowDate());
        return religionWarnManagerMapper.insertReligionWarnManager(religionWarnManager);
    }

    /**
     * 修改消防预警接入
     * 
     * @param religionWarnManager 消防预警接入
     * @return 结果
     */
    @Override
    public int updateReligionWarnManager(ReligionWarnManager religionWarnManager)
    {
        religionWarnManager.setUpdateTime(DateUtils.getNowDate());
        return religionWarnManagerMapper.updateReligionWarnManager(religionWarnManager);
    }

    /**
     * 批量删除消防预警接入
     * 
     * @param ids 需要删除的消防预警接入主键
     * @return 结果
     */
    @Override
    public int deleteReligionWarnManagerByIds(Long[] ids)
    {
        return religionWarnManagerMapper.deleteReligionWarnManagerByIds(ids);
    }

    /**
     * 删除消防预警接入信息
     * 
     * @param id 消防预警接入主键
     * @return 结果
     */
    @Override
    public int deleteReligionWarnManagerById(Long id)
    {
        return religionWarnManagerMapper.deleteReligionWarnManagerById(id);
    }
}
