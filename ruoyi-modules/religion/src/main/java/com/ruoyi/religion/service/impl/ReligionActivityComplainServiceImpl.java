package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionActivityComplainMapper;
import com.ruoyi.religion.domain.ReligionActivityComplain;
import com.ruoyi.religion.service.IReligionActivityComplainService;

/**
 * 活动管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:45
 */
@Service
public class ReligionActivityComplainServiceImpl implements IReligionActivityComplainService 
{
    @Autowired
    private ReligionActivityComplainMapper religionActivityComplainMapper;

    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    @Override
    public ReligionActivityComplain selectReligionActivityComplainById(Long id)
    {
        return religionActivityComplainMapper.selectReligionActivityComplainById(id);
    }

    /**
     * 查询活动管理列表
     * 
     * @param religionActivityComplain 活动管理
     * @return 活动管理
     */
    @Override
    public List<ReligionActivityComplain> selectReligionActivityComplainList(ReligionActivityComplain religionActivityComplain)
    {
        return religionActivityComplainMapper.selectReligionActivityComplainList(religionActivityComplain);
    }

    /**
     * 新增活动管理
     * 
     * @param religionActivityComplain 活动管理
     * @return 结果
     */
    @Override
    public int insertReligionActivityComplain(ReligionActivityComplain religionActivityComplain)
    {
        religionActivityComplain.setCreateTime(DateUtils.getNowDate());
        return religionActivityComplainMapper.insertReligionActivityComplain(religionActivityComplain);
    }

    /**
     * 修改活动管理
     * 
     * @param religionActivityComplain 活动管理
     * @return 结果
     */
    @Override
    public int updateReligionActivityComplain(ReligionActivityComplain religionActivityComplain)
    {
        religionActivityComplain.setUpdateTime(DateUtils.getNowDate());
        return religionActivityComplainMapper.updateReligionActivityComplain(religionActivityComplain);
    }

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的活动管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionActivityComplainByIds(Long[] ids)
    {
        return religionActivityComplainMapper.deleteReligionActivityComplainByIds(ids);
    }

    /**
     * 删除活动管理信息
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    @Override
    public int deleteReligionActivityComplainById(Long id)
    {
        return religionActivityComplainMapper.deleteReligionActivityComplainById(id);
    }
}
