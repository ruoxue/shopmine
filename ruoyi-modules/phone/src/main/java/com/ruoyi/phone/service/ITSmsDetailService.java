package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TSmsDetail;

/**
 * 短信内容Service接口
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
public interface ITSmsDetailService 
{
    /**
     * 查询短信内容
     * 
     * @param id 短信内容主键
     * @return 短信内容
     */
    public TSmsDetail selectTSmsDetailById(Long id);

    /**
     * 查询短信内容列表
     * 
     * @param tSmsDetail 短信内容
     * @return 短信内容集合
     */
    public List<TSmsDetail> selectTSmsDetailList(TSmsDetail tSmsDetail);

    /**
     * 新增短信内容
     * 
     * @param tSmsDetail 短信内容
     * @return 结果
     */
    public int insertTSmsDetail(TSmsDetail tSmsDetail);

    /**
     * 修改短信内容
     * 
     * @param tSmsDetail 短信内容
     * @return 结果
     */
    public int updateTSmsDetail(TSmsDetail tSmsDetail);

    /**
     * 批量删除短信内容
     * 
     * @param ids 需要删除的短信内容主键集合
     * @return 结果
     */
    public int deleteTSmsDetailByIds(Long[] ids);

    /**
     * 删除短信内容信息
     * 
     * @param id 短信内容主键
     * @return 结果
     */
    public int deleteTSmsDetailById(Long id);
}
