package com.ruoyi.phone.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.phone.mapper.TSmsTemplateMapper;
import com.ruoyi.phone.domain.TSmsTemplate;
import com.ruoyi.phone.service.ITSmsTemplateService;

/**
 * 短信模版Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-12-06 14:58:03
 */
@Service
public class TSmsTemplateServiceImpl implements ITSmsTemplateService 
{
    @Autowired
    private TSmsTemplateMapper tSmsTemplateMapper;

    /**
     * 查询短信模版
     * 
     * @param id 短信模版主键
     * @return 短信模版
     */
    @Override
    public TSmsTemplate selectTSmsTemplateById(Long id)
    {
        return tSmsTemplateMapper.selectTSmsTemplateById(id);
    }

    /**
     * 查询短信模版列表
     * 
     * @param tSmsTemplate 短信模版
     * @return 短信模版
     */
    @Override
    public List<TSmsTemplate> selectTSmsTemplateList(TSmsTemplate tSmsTemplate)
    {
        return tSmsTemplateMapper.selectTSmsTemplateList(tSmsTemplate);
    }

    /**
     * 新增短信模版
     * 
     * @param tSmsTemplate 短信模版
     * @return 结果
     */
    @Override
    public int insertTSmsTemplate(TSmsTemplate tSmsTemplate)
    {
        return tSmsTemplateMapper.insertTSmsTemplate(tSmsTemplate);
    }

    /**
     * 修改短信模版
     * 
     * @param tSmsTemplate 短信模版
     * @return 结果
     */
    @Override
    public int updateTSmsTemplate(TSmsTemplate tSmsTemplate)
    {
        return tSmsTemplateMapper.updateTSmsTemplate(tSmsTemplate);
    }

    /**
     * 批量删除短信模版
     * 
     * @param ids 需要删除的短信模版主键
     * @return 结果
     */
    @Override
    public int deleteTSmsTemplateByIds(Long[] ids)
    {
        return tSmsTemplateMapper.deleteTSmsTemplateByIds(ids);
    }

    /**
     * 删除短信模版信息
     * 
     * @param id 短信模版主键
     * @return 结果
     */
    @Override
    public int deleteTSmsTemplateById(Long id)
    {
        return tSmsTemplateMapper.deleteTSmsTemplateById(id);
    }
}
