package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 访问记录对象 t_phone_visitor
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:12
 */
public class TPhoneVisitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 租户号 */
    @Excel(name = "租户号")
    private String tenantId;

    /** 删除 */
    private Long deleted;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 来源 */
    @Excel(name = "来源")
    private String origin;

    /** 联系方式 */
    @Excel(name = "联系方式")
    @NotBlank(message = "请输入联系方式")
    private String connection;

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
    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getOrigin() 
    {
        return origin;
    }
    public void setConnection(String connection) 
    {
        this.connection = connection;
    }

    public String getConnection() 
    {
        return connection;
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
            .append("origin", getOrigin())
            .append("remark", getRemark())
            .append("connection", getConnection())
            .toString();
    }
}
