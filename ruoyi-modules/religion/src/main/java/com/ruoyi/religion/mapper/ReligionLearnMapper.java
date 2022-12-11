package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionLearn;

/**
 * 学习Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
public interface ReligionLearnMapper 
{
    /**
     * 查询学习
     * 
     * @param id 学习主键
     * @return 学习
     */
    public ReligionLearn selectReligionLearnById(Long id);

    /**
     * 查询学习列表
     * 
     * @param religionLearn 学习
     * @return 学习集合
     */
    public List<ReligionLearn> selectReligionLearnList(ReligionLearn religionLearn);

    /**
     * 新增学习
     * 
     * @param religionLearn 学习
     * @return 结果
     */
    public int insertReligionLearn(ReligionLearn religionLearn);

    /**
     * 修改学习
     * 
     * @param religionLearn 学习
     * @return 结果
     */
    public int updateReligionLearn(ReligionLearn religionLearn);

    /**
     * 删除学习
     * 
     * @param id 学习主键
     * @return 结果
     */
    public int deleteReligionLearnById(Long id);

    /**
     * 批量删除学习
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionLearnByIds(Long[] ids);
}
