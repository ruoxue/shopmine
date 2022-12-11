package com.ruoyi.phone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TAreaMapper;
import com.ruoyi.phone.domain.TArea;
import com.ruoyi.phone.service.ITAreaService;

/**
 * 地区码Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
@Service
public class TAreaServiceImpl implements ITAreaService 
{
    @Autowired
    private TAreaMapper tAreaMapper;

    /**
     * 查询地区码
     * 
     * @param areaId 地区码主键
     * @return 地区码
     */
    @Override
    public TArea selectTAreaByAreaId(Long areaId)
    {
        return tAreaMapper.selectTAreaByAreaId(areaId);
    }

    /**
     * 查询地区码列表
     * 
     * @param tArea 地区码
     * @return 地区码
     */
    @Override
    public List<TArea> selectTAreaList(TArea tArea)
    {
        return tAreaMapper.selectTAreaList(tArea);
    }

    /**
     * 新增地区码
     * 
     * @param tArea 地区码
     * @return 结果
     */
    @Override
    public int insertTArea(TArea tArea)
    {
        return tAreaMapper.insertTArea(tArea);
    }

    /**
     * 修改地区码
     * 
     * @param tArea 地区码
     * @return 结果
     */
    @Override
    public int updateTArea(TArea tArea)
    {
        return tAreaMapper.updateTArea(tArea);
    }

    /**
     * 批量删除地区码
     * 
     * @param areaIds 需要删除的地区码主键
     * @return 结果
     */
    @Override
    public int deleteTAreaByAreaIds(Long[] areaIds)
    {
        return tAreaMapper.deleteTAreaByAreaIds(areaIds);
    }

    /**
     * 删除地区码信息
     * 
     * @param areaId 地区码主键
     * @return 结果
     */
    @Override
    public int deleteTAreaByAreaId(Long areaId)
    {
        return tAreaMapper.deleteTAreaByAreaId(areaId);
    }
}
