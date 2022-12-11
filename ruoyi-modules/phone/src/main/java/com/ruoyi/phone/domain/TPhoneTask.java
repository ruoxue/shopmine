package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.*;

/**
 * 生产任务对象 t_phone_task
 * 
 * @author ruoyi
 * @date 2022-12-07 16:44:29
 */
public class TPhoneTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    /** 租户号 */
    @Excel(name = "租户号")
    private String tenantId;

    /** 删除 */
    private Long deleted;

    /** 状态 */
    @Excel(name = "状态",readConverterExp = "1=正常,0=暂停")
    private Long status;

    /** 保存路径 */
    private String path;

    /** 范围 */
    @Excel(name = "范围")
    @NotBlank(message = "范围不能为空")
    @Size(min = 1,max = 26,message = "长度在1～26")
    private String scope;

    /** 下载 */
    @Excel(name = "下载")
    private String url;

    /** 内容 */
    private String content;

    /** 仅系统内生成 */
    @Excel(name = "仅系统内生成")
    @NotBlank(message = "请选择是否仅系统内生成")
    private Long inSystem;

    /** 模版 */
    @Excel(name = "模版")
    @Min(value = 1,message = "请选择模版")
    @NotBlank(message = "请选择模版")
    private Long templateId;
    @Excel(name = "模版名")
    private  String templateName;

    /** 数量 */
    @Excel(name = "数量")
    @Min(value = 1,message = "最小为1")
    @Max(value = 10000,message = "最大为10000")
    private Long num;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

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
    public void setTenantId(String tenantId) 
    {
        this.tenantId = tenantId;
    }

    public String getTenantId() 
    {
        return tenantId;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setScope(String scope) 
    {
        this.scope = scope;
    }

    public String getScope() 
    {
        return scope;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setInSystem(Long inSystem) 
    {
        this.inSystem = inSystem;
    }

    public Long getInSystem() 
    {
        return inSystem;
    }
    public void setTemplateId(Long templateId) 
    {
        this.templateId = templateId;
    }

    public Long getTemplateId() 
    {
        return templateId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("tenantId", getTenantId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("deleted", getDeleted())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("path", getPath())
            .append("scope", getScope())
            .append("url", getUrl())
            .append("content", getContent())
            .append("inSystem", getInSystem())
            .append("templateId", getTemplateId())
            .append("num", getNum())
            .toString();
    }
}
