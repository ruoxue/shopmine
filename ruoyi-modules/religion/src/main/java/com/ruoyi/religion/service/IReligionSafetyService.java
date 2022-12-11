package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionSafety;

/**
 * 消防场所Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
public interface IReligionSafetyService 
{
    /**
     * 查询消防场所
     * 
     * @param id 消防场所主键
     * @return 消防场所
     */
    public ReligionSafety selectReligionSafetyById(Long id);

    /**
     * 查询消防场所列表
     * 
     * @param religionSafety 消防场所
     * @return 消防场所集合
     */
    public List<ReligionSafety> selectReligionSafetyList(ReligionSafety religionSafety);

    /**
     * 新增消防场所
     * 
     * @param religionSafety 消防场所
     * @return 结果
     */
    public int insertReligionSafety(ReligionSafety religionSafety);

    /**
     * 修改消防场所
     * 
     * @param religionSafety 消防场所
     * @return 结果
     */
    public int updateReligionSafety(ReligionSafety religionSafety);

    /**
     * 批量删除消防场所
     * 
     * @param ids 需要删除的消防场所主键集合
     * @return 结果
     */
    public int deleteReligionSafetyByIds(Long[] ids);

    /**
     * 删除消防场所信息
     * 
     * @param id 消防场所主键
     * @return 结果
     */
    public int deleteReligionSafetyById(Long id);
}
