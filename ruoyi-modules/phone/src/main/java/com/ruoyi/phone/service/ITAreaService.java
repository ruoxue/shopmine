package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TArea;

/**
 * 地区码Service接口
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
public interface ITAreaService 
{
    /**
     * 查询地区码
     * 
     * @param areaId 地区码主键
     * @return 地区码
     */
    public TArea selectTAreaByAreaId(Long areaId);

    /**
     * 查询地区码列表
     * 
     * @param tArea 地区码
     * @return 地区码集合
     */
    public List<TArea> selectTAreaList(TArea tArea);

    /**
     * 新增地区码
     * 
     * @param tArea 地区码
     * @return 结果
     */
    public int insertTArea(TArea tArea);

    /**
     * 修改地区码
     * 
     * @param tArea 地区码
     * @return 结果
     */
    public int updateTArea(TArea tArea);

    /**
     * 批量删除地区码
     * 
     * @param areaIds 需要删除的地区码主键集合
     * @return 结果
     */
    public int deleteTAreaByAreaIds(Long[] areaIds);

    /**
     * 删除地区码信息
     * 
     * @param areaId 地区码主键
     * @return 结果
     */
    public int deleteTAreaByAreaId(Long areaId);
}
