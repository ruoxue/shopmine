package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionActivtyManagerMapper;
import com.ruoyi.religion.domain.ReligionActivtyManager;
import com.ruoyi.religion.service.IReligionActivtyManagerService;

/**
 * 活动备案Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
@Service
public class ReligionActivtyManagerServiceImpl implements IReligionActivtyManagerService 
{
    @Autowired
    private ReligionActivtyManagerMapper religionActivtyManagerMapper;

    /**
     * 查询活动备案
     * 
     * @param id 活动备案主键
     * @return 活动备案
     */
    @Override
    public ReligionActivtyManager selectReligionActivtyManagerById(Long id)
    {
        return religionActivtyManagerMapper.selectReligionActivtyManagerById(id);
    }

    /**
     * 查询活动备案列表
     * 
     * @param religionActivtyManager 活动备案
     * @return 活动备案
     */
    @Override
    public List<ReligionActivtyManager> selectReligionActivtyManagerList(ReligionActivtyManager religionActivtyManager)
    {
        return religionActivtyManagerMapper.selectReligionActivtyManagerList(religionActivtyManager);
    }

    /**
     * 新增活动备案
     * 
     * @param religionActivtyManager 活动备案
     * @return 结果
     */
    @Override
    public int insertReligionActivtyManager(ReligionActivtyManager religionActivtyManager)
    {
        religionActivtyManager.setCreateTime(DateUtils.getNowDate());
        return religionActivtyManagerMapper.insertReligionActivtyManager(religionActivtyManager);
    }

    /**
     * 修改活动备案
     * 
     * @param religionActivtyManager 活动备案
     * @return 结果
     */
    @Override
    public int updateReligionActivtyManager(ReligionActivtyManager religionActivtyManager)
    {
        religionActivtyManager.setUpdateTime(DateUtils.getNowDate());
        return religionActivtyManagerMapper.updateReligionActivtyManager(religionActivtyManager);
    }

    /**
     * 批量删除活动备案
     * 
     * @param ids 需要删除的活动备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionActivtyManagerByIds(Long[] ids)
    {
        return religionActivtyManagerMapper.deleteReligionActivtyManagerByIds(ids);
    }

    /**
     * 删除活动备案信息
     * 
     * @param id 活动备案主键
     * @return 结果
     */
    @Override
    public int deleteReligionActivtyManagerById(Long id)
    {
        return religionActivtyManagerMapper.deleteReligionActivtyManagerById(id);
    }
}
