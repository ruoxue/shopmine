package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionType;

/**
 * 宗教类型Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
public interface ReligionTypeMapper 
{
    /**
     * 查询宗教类型
     * 
     * @param id 宗教类型主键
     * @return 宗教类型
     */
    public ReligionType selectReligionTypeById(Long id);

    /**
     * 查询宗教类型列表
     * 
     * @param religionType 宗教类型
     * @return 宗教类型集合
     */
    public List<ReligionType> selectReligionTypeList(ReligionType religionType);

    /**
     * 新增宗教类型
     * 
     * @param religionType 宗教类型
     * @return 结果
     */
    public int insertReligionType(ReligionType religionType);

    /**
     * 修改宗教类型
     * 
     * @param religionType 宗教类型
     * @return 结果
     */
    public int updateReligionType(ReligionType religionType);

    /**
     * 删除宗教类型
     * 
     * @param id 宗教类型主键
     * @return 结果
     */
    public int deleteReligionTypeById(Long id);

    /**
     * 批量删除宗教类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionTypeByIds(Long[] ids);
}
