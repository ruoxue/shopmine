package com.ruoyi.religion.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.religion.mapper.ReligionErrorManagerMapper;
import com.ruoyi.religion.domain.ReligionErrorManager;
import com.ruoyi.religion.service.IReligionErrorManagerService;

/**
 * 违规登记Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03 07:39:47
 */
@Service
public class ReligionErrorManagerServiceImpl implements IReligionErrorManagerService 
{
    @Autowired
    private ReligionErrorManagerMapper religionErrorManagerMapper;

    /**
     * 查询违规登记
     * 
     * @param id 违规登记主键
     * @return 违规登记
     */
    @Override
    public ReligionErrorManager selectReligionErrorManagerById(Long id)
    {
        return religionErrorManagerMapper.selectReligionErrorManagerById(id);
    }

    /**
     * 查询违规登记列表
     * 
     * @param religionErrorManager 违规登记
     * @return 违规登记
     */
    @Override
    public List<ReligionErrorManager> selectReligionErrorManagerList(ReligionErrorManager religionErrorManager)
    {
        return religionErrorManagerMapper.selectReligionErrorManagerList(religionErrorManager);
    }

    /**
     * 新增违规登记
     * 
     * @param religionErrorManager 违规登记
     * @return 结果
     */
    @Override
    public int insertReligionErrorManager(ReligionErrorManager religionErrorManager)
    {
        religionErrorManager.setCreateTime(DateUtils.getNowDate());
        return religionErrorManagerMapper.insertReligionErrorManager(religionErrorManager);
    }

    /**
     * 修改违规登记
     * 
     * @param religionErrorManager 违规登记
     * @return 结果
     */
    @Override
    public int updateReligionErrorManager(ReligionErrorManager religionErrorManager)
    {
        religionErrorManager.setUpdateTime(DateUtils.getNowDate());
        return religionErrorManagerMapper.updateReligionErrorManager(religionErrorManager);
    }

    /**
     * 批量删除违规登记
     * 
     * @param ids 需要删除的违规登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionErrorManagerByIds(Long[] ids)
    {
        return religionErrorManagerMapper.deleteReligionErrorManagerByIds(ids);
    }

    /**
     * 删除违规登记信息
     * 
     * @param id 违规登记主键
     * @return 结果
     */
    @Override
    public int deleteReligionErrorManagerById(Long id)
    {
        return religionErrorManagerMapper.deleteReligionErrorManagerById(id);
    }
}
