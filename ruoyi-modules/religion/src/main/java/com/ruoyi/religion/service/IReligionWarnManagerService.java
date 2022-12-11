package com.ruoyi.religion.service;

import java.util.List;
import com.ruoyi.religion.domain.ReligionWarnManager;

/**
 * 消防预警接入Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:48
 */
public interface IReligionWarnManagerService 
{
    /**
     * 查询消防预警接入
     * 
     * @param id 消防预警接入主键
     * @return 消防预警接入
     */
    public ReligionWarnManager selectReligionWarnManagerById(Long id);

    /**
     * 查询消防预警接入列表
     * 
     * @param religionWarnManager 消防预警接入
     * @return 消防预警接入集合
     */
    public List<ReligionWarnManager> selectReligionWarnManagerList(ReligionWarnManager religionWarnManager);

    /**
     * 新增消防预警接入
     * 
     * @param religionWarnManager 消防预警接入
     * @return 结果
     */
    public int insertReligionWarnManager(ReligionWarnManager religionWarnManager);

    /**
     * 修改消防预警接入
     * 
     * @param religionWarnManager 消防预警接入
     * @return 结果
     */
    public int updateReligionWarnManager(ReligionWarnManager religionWarnManager);

    /**
     * 批量删除消防预警接入
     * 
     * @param ids 需要删除的消防预警接入主键集合
     * @return 结果
     */
    public int deleteReligionWarnManagerByIds(Long[] ids);

    /**
     * 删除消防预警接入信息
     * 
     * @param id 消防预警接入主键
     * @return 结果
     */
    public int deleteReligionWarnManagerById(Long id);
}
