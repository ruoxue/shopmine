package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TSuplier;

/**
 * 供应商Service接口
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:04
 */
public interface ITSuplierService 
{
    /**
     * 查询供应商
     * 
     * @param supId 供应商主键
     * @return 供应商
     */
    public TSuplier selectTSuplierBySupId(Long supId);

    /**
     * 查询供应商列表
     * 
     * @param tSuplier 供应商
     * @return 供应商集合
     */
    public List<TSuplier> selectTSuplierList(TSuplier tSuplier);

    /**
     * 新增供应商
     * 
     * @param tSuplier 供应商
     * @return 结果
     */
    public int insertTSuplier(TSuplier tSuplier);

    /**
     * 修改供应商
     * 
     * @param tSuplier 供应商
     * @return 结果
     */
    public int updateTSuplier(TSuplier tSuplier);

    /**
     * 批量删除供应商
     * 
     * @param supIds 需要删除的供应商主键集合
     * @return 结果
     */
    public int deleteTSuplierBySupIds(Long[] supIds);

    /**
     * 删除供应商信息
     * 
     * @param supId 供应商主键
     * @return 结果
     */
    public int deleteTSuplierBySupId(Long supId);

    int editAmount(TSuplier tSuplier);
}
