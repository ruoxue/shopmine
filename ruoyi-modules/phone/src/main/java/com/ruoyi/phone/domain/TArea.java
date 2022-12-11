package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 地区码对象 t_area
 * 
 * @author ruoyi
 * @date 2022-11-12 03:52:11
 */
public class TArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地区Id */
    private Long areaId;

    /** 地区编码 */
    @Excel(name = "地区编码")
    private String areaCode;

    /** 地区名 */
    @Excel(name = "地区名")
    private String areaName;

    /** 地区级别（1:省份province,2:市city,3:区县district,4:街道street） */
    @Excel(name = "地区级别", readConverterExp = "1=:省份province,2:市city,3:区县district,4:街道street")
    private Long level;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityCode;

    /** 城市中心点（即：经纬度坐标） */
    @Excel(name = "城市中心点", readConverterExp = "即=：经纬度坐标")
    private String center;

    /** 地区父节点 */
    @Excel(name = "地区父节点")
    private Long parentId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setCityCode(String cityCode) 
    {
        this.cityCode = cityCode;
    }

    public String getCityCode() 
    {
        return cityCode;
    }
    public void setCenter(String center) 
    {
        this.center = center;
    }

    public String getCenter() 
    {
        return center;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
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
            .append("areaId", getAreaId())
            .append("areaCode", getAreaCode())
            .append("areaName", getAreaName())
            .append("level", getLevel())
            .append("cityCode", getCityCode())
            .append("center", getCenter())
            .append("parentId", getParentId())
            .append("status", getStatus())
            .toString();
    }
}
