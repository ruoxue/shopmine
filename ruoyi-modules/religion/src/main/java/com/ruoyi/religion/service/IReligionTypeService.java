package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionType;

/**
 * 宗教类型Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
public interface IReligionTypeService 
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
     * 批量删除宗教类型
     * 
     * @param ids 需要删除的宗教类型主键集合
     * @return 结果
     */
    public int deleteReligionTypeByIds(Long[] ids);

    /**
     * 删除宗教类型信息
     * 
     * @param id 宗教类型主键
     * @return 结果
     */
    public int deleteReligionTypeById(Long id);
}
