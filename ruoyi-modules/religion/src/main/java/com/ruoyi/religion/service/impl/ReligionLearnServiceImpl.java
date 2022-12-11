package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionLearnMapper;
import com.ruoyi.religion.domain.ReligionLearn;
import com.ruoyi.religion.service.IReligionLearnService;

/**
 * 学习Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@Service
public class ReligionLearnServiceImpl implements IReligionLearnService 
{
    @Autowired
    private ReligionLearnMapper religionLearnMapper;

    /**
     * 查询学习
     * 
     * @param id 学习主键
     * @return 学习
     */
    @Override
    public ReligionLearn selectReligionLearnById(Long id)
    {
        return religionLearnMapper.selectReligionLearnById(id);
    }

    /**
     * 查询学习列表
     * 
     * @param religionLearn 学习
     * @return 学习
     */
    @Override
    public List<ReligionLearn> selectReligionLearnList(ReligionLearn religionLearn)
    {
        return religionLearnMapper.selectReligionLearnList(religionLearn);
    }

    /**
     * 新增学习
     * 
     * @param religionLearn 学习
     * @return 结果
     */
    @Override
    public int insertReligionLearn(ReligionLearn religionLearn)
    {
        religionLearn.setCreateTime(DateUtils.getNowDate());
        return religionLearnMapper.insertReligionLearn(religionLearn);
    }

    /**
     * 修改学习
     * 
     * @param religionLearn 学习
     * @return 结果
     */
    @Override
    public int updateReligionLearn(ReligionLearn religionLearn)
    {
        religionLearn.setUpdateTime(DateUtils.getNowDate());
        return religionLearnMapper.updateReligionLearn(religionLearn);
    }

    /**
     * 批量删除学习
     * 
     * @param ids 需要删除的学习主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnByIds(Long[] ids)
    {
        return religionLearnMapper.deleteReligionLearnByIds(ids);
    }

    /**
     * 删除学习信息
     * 
     * @param id 学习主键
     * @return 结果
     */
    @Override
    public int deleteReligionLearnById(Long id)
    {
        return religionLearnMapper.deleteReligionLearnById(id);
    }
}
