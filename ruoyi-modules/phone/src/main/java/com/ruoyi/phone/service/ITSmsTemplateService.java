package com.ruoyi.phone.service;

import java.util.List;
import com.ruoyi.phone.domain.TSmsTemplate;

/**
 * 短信模版Service接口
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
public interface ITSmsTemplateService 
{
    /**
     * 查询短信模版
     * 
     * @param id 短信模版主键
     * @return 短信模版
     */
    public TSmsTemplate selectTSmsTemplateById(Long id);

    /**
     * 查询短信模版列表
     * 
     * @param tSmsTemplate 短信模版
     * @return 短信模版集合
     */
    public List<TSmsTemplate> selectTSmsTemplateList(TSmsTemplate tSmsTemplate);

    /**
     * 新增短信模版
     * 
     * @param tSmsTemplate 短信模版
     * @return 结果
     */
    public int insertTSmsTemplate(TSmsTemplate tSmsTemplate);

    /**
     * 修改短信模版
     * 
     * @param tSmsTemplate 短信模版
     * @return 结果
     */
    public int updateTSmsTemplate(TSmsTemplate tSmsTemplate);

    /**
     * 批量删除短信模版
     * 
     * @param ids 需要删除的短信模版主键集合
     * @return 结果
     */
    public int deleteTSmsTemplateByIds(Long[] ids);

    /**
     * 删除短信模版信息
     * 
     * @param id 短信模版主键
     * @return 结果
     */
    public int deleteTSmsTemplateById(Long id);
}
