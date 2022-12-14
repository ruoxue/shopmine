package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionDrillManager;

/**
 * 消防演练管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:46
 */
public interface ReligionDrillManagerMapper 
{
    /**
     * 查询消防演练管理
     * 
     * @param id 消防演练管理主键
     * @return 消防演练管理
     */
    public ReligionDrillManager selectReligionDrillManagerById(Long id);

    /**
     * 查询消防演练管理列表
     * 
     * @param religionDrillManager 消防演练管理
     * @return 消防演练管理集合
     */
    public List<ReligionDrillManager> selectReligionDrillManagerList(ReligionDrillManager religionDrillManager);

    /**
     * 新增消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    public int insertReligionDrillManager(ReligionDrillManager religionDrillManager);

    /**
     * 修改消防演练管理
     * 
     * @param religionDrillManager 消防演练管理
     * @return 结果
     */
    public int updateReligionDrillManager(ReligionDrillManager religionDrillManager);

    /**
     * 删除消防演练管理
     * 
     * @param id 消防演练管理主键
     * @return 结果
     */
    public int deleteReligionDrillManagerById(Long id);

    /**
     * 批量删除消防演练管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionDrillManagerByIds(Long[] ids);
}
