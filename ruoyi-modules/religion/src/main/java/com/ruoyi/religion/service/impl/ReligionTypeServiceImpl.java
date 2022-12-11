package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionTypeMapper;
import com.ruoyi.religion.domain.ReligionType;
import com.ruoyi.religion.service.IReligionTypeService;

/**
 * 宗教类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
@Service
public class ReligionTypeServiceImpl implements IReligionTypeService 
{
    @Autowired
    private ReligionTypeMapper religionTypeMapper;

    /**
     * 查询宗教类型
     * 
     * @param id 宗教类型主键
     * @return 宗教类型
     */
    @Override
    public ReligionType selectReligionTypeById(Long id)
    {
        return religionTypeMapper.selectReligionTypeById(id);
    }

    /**
     * 查询宗教类型列表
     * 
     * @param religionType 宗教类型
     * @return 宗教类型
     */
    @Override
    public List<ReligionType> selectReligionTypeList(ReligionType religionType)
    {
        return religionTypeMapper.selectReligionTypeList(religionType);
    }

    /**
     * 新增宗教类型
     * 
     * @param religionType 宗教类型
     * @return 结果
     */
    @Override
    public int insertReligionType(ReligionType religionType)
    {
        religionType.setCreateTime(DateUtils.getNowDate());
        return religionTypeMapper.insertReligionType(religionType);
    }

    /**
     * 修改宗教类型
     * 
     * @param religionType 宗教类型
     * @return 结果
     */
    @Override
    public int updateReligionType(ReligionType religionType)
    {
        religionType.setUpdateTime(DateUtils.getNowDate());
        return religionTypeMapper.updateReligionType(religionType);
    }

    /**
     * 批量删除宗教类型
     * 
     * @param ids 需要删除的宗教类型主键
     * @return 结果
     */
    @Override
    public int deleteReligionTypeByIds(Long[] ids)
    {
        return religionTypeMapper.deleteReligionTypeByIds(ids);
    }

    /**
     * 删除宗教类型信息
     * 
     * @param id 宗教类型主键
     * @return 结果
     */
    @Override
    public int deleteReligionTypeById(Long id)
    {
        return religionTypeMapper.deleteReligionTypeById(id);
    }
}
