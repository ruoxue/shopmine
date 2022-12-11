package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionActivtyManager;

/**
 * 活动备案Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
public interface IReligionActivtyManagerService 
{
    /**
     * 查询活动备案
     * 
     * @param id 活动备案主键
     * @return 活动备案
     */
    public ReligionActivtyManager selectReligionActivtyManagerById(Long id);

    /**
     * 查询活动备案列表
     * 
     * @param religionActivtyManager 活动备案
     * @return 活动备案集合
     */
    public List<ReligionActivtyManager> selectReligionActivtyManagerList(ReligionActivtyManager religionActivtyManager);

    /**
     * 新增活动备案
     * 
     * @param religionActivtyManager 活动备案
     * @return 结果
     */
    public int insertReligionActivtyManager(ReligionActivtyManager religionActivtyManager);

    /**
     * 修改活动备案
     * 
     * @param religionActivtyManager 活动备案
     * @return 结果
     */
    public int updateReligionActivtyManager(ReligionActivtyManager religionActivtyManager);

    /**
     * 批量删除活动备案
     * 
     * @param ids 需要删除的活动备案主键集合
     * @return 结果
     */
    public int deleteReligionActivtyManagerByIds(Long[] ids);

    /**
     * 删除活动备案信息
     * 
     * @param id 活动备案主键
     * @return 结果
     */
    public int deleteReligionActivtyManagerById(Long id);
}
