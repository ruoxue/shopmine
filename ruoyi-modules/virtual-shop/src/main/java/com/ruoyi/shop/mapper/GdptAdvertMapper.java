package com.ruoyi.shop.mapper;

import java.util.List;
import com.ruoyi.shop.domain.GdptAdvert;

/**
 * 广告Mapper接口
 * 
 * @author xiaoming
 * @date 2022-08-07
 */
public interface GdptAdvertMapper 
{
    /**
     * 查询广告
     * 
     * @param id 广告主键
     * @return 广告
     */
    public GdptAdvert selectGdptAdvertById(String id);

    /**
     * 查询广告列表
     * 
     * @param gdptAdvert 广告
     * @return 广告集合
     */
    public List<GdptAdvert> selectGdptAdvertList(GdptAdvert gdptAdvert);

    /**
     * 新增广告
     * 
     * @param gdptAdvert 广告
     * @return 结果
     */
    public int insertGdptAdvert(GdptAdvert gdptAdvert);

    /**
     * 修改广告
     * 
     * @param gdptAdvert 广告
     * @return 结果
     */
    public int updateGdptAdvert(GdptAdvert gdptAdvert);

    /**
     * 删除广告
     * 
     * @param id 广告主键
     * @return 结果
     */
    public int deleteGdptAdvertById(String id);

    /**
     * 批量删除广告
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGdptAdvertByIds(String[] ids);
}
