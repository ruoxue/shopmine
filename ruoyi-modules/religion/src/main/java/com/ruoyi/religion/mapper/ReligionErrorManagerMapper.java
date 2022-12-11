package com.ruoyi.religion.mapper;

import java.util.List;
import com.ruoyi.religion.domain.ReligionErrorManager;

/**
 * 违规登记Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
public interface ReligionErrorManagerMapper 
{
    /**
     * 查询违规登记
     * 
     * @param id 违规登记主键
     * @return 违规登记
     */
    public ReligionErrorManager selectReligionErrorManagerById(Long id);

    /**
     * 查询违规登记列表
     * 
     * @param religionErrorManager 违规登记
     * @return 违规登记集合
     */
    public List<ReligionErrorManager> selectReligionErrorManagerList(ReligionErrorManager religionErrorManager);

    /**
     * 新增违规登记
     * 
     * @param religionErrorManager 违规登记
     * @return 结果
     */
    public int insertReligionErrorManager(ReligionErrorManager religionErrorManager);

    /**
     * 修改违规登记
     * 
     * @param religionErrorManager 违规登记
     * @return 结果
     */
    public int updateReligionErrorManager(ReligionErrorManager religionErrorManager);

    /**
     * 删除违规登记
     * 
     * @param id 违规登记主键
     * @return 结果
     */
    public int deleteReligionErrorManagerById(Long id);

    /**
     * 批量删除违规登记
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReligionErrorManagerByIds(Long[] ids);
}
