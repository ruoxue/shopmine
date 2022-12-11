package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 手机管理对象 t_phone_number
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
public class TPhoneNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 手机号前7位 */
    @Excel(name = "手机号前7位")
    @NotBlank(message = "手机号不能为空")
    @Size(min = 7, max = 7, message = "请输入7位数字")
    private Long number;

    /** 省份 */
    @Excel(name = "省份")
    @NotBlank(message = "省份不能为空")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 状态 */
    @Excel(name = "状态",readConverterExp = "0=禁用,1=启用")
    private Long status;

    /** $column.columnComment */
    private Long id;

    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("number", getNumber())
            .append("province", getProvince())
            .append("city", getCity())
            .append("status", getStatus())
            .append("id", getId())
            .toString();
    }
}
