package com.ruoyi.phone.mapper;

import java.util.List;
import com.ruoyi.phone.domain.TSmsDetail;

/**
 * 短信内容Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
public interface TSmsDetailMapper 
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
     * 删除短信内容
     * 
     * @param id 短信内容主键
     * @return 结果
     */
    public int deleteTSmsDetailById(Long id);

    /**
     * 批量删除短信内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSmsDetailByIds(Long[] ids);
}
