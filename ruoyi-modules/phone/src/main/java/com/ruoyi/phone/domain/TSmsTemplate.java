package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 短信模版对象 t_sms_template
 * 
 * @author ruoyi
 * @date 2022-12-07 16:44:28
 */
public class TSmsTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 短信模版id */
    @Excel(name = "短信模版id")
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    /** 内容 */
    @Excel(name = "内容")
    @NotBlank(message = "内容不能为空")

    private String content;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("content", getContent())
            .append("status", getStatus())
            .toString();
    }
}
