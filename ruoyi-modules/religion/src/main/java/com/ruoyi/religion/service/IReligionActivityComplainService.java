package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionActivityComplain;

/**
 * 活动管理Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:45
 */
public interface IReligionActivityComplainService 
{
    /**
     * 查询活动管理
     * 
     * @param id 活动管理主键
     * @return 活动管理
     */
    public ReligionActivityComplain selectReligionActivityComplainById(Long id);

    /**
     * 查询活动管理列表
     * 
     * @param religionActivityComplain 活动管理
     * @return 活动管理集合
     */
    public List<ReligionActivityComplain> selectReligionActivityComplainList(ReligionActivityComplain religionActivityComplain);

    /**
     * 新增活动管理
     * 
     * @param religionActivityComplain 活动管理
     * @return 结果
     */
    public int insertReligionActivityComplain(ReligionActivityComplain religionActivityComplain);

    /**
     * 修改活动管理
     * 
     * @param religionActivityComplain 活动管理
     * @return 结果
     */
    public int updateReligionActivityComplain(ReligionActivityComplain religionActivityComplain);

    /**
     * 批量删除活动管理
     * 
     * @param ids 需要删除的活动管理主键集合
     * @return 结果
     */
    public int deleteReligionActivityComplainByIds(Long[] ids);

    /**
     * 删除活动管理信息
     * 
     * @param id 活动管理主键
     * @return 结果
     */
    public int deleteReligionActivityComplainById(Long id);
}
