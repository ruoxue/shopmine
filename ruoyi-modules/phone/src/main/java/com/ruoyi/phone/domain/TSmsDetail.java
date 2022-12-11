package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * 短信内容对象 t_sms_detail
 * 
 * @author ruoyi
 * @date 2022-12-07 16:44:27
 */
public class TSmsDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 短信编号 */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    @NotBlank(message = "请输入手机号")
    private String phoneNum;

    /** 归属地 */
    @Excel(name = "归属地")
    private String city;

    /** 模版 */
    @Excel(name = "模版")
    @NotBlank(message = "请选择模版")
    private Long templateId;
    @Excel(name = "模版名")
    private String templateName;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 任务 */
    @Excel(name = "任务")
    private Long taskId;
    @Excel(name = "任务名")
    private String taskName;
    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 结果 */
    @Excel(name = "结果")
    private String result;

    /** 重发 */
    @Excel(name = "重发")
    private Long cycle;

    /** 已发送次数 */
    @Excel(name = "已发送次数")
    private Long hadCycle;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long suplierId;
    @Excel(name = "供应商名")
    private String suplierName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPhoneNum(String phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() 
    {
        return phoneNum;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setTemplateId(Long templateId) 
    {
        this.templateId = templateId;
    }

    public Long getTemplateId() 
    {
        return templateId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setCycle(Long cycle) 
    {
        this.cycle = cycle;
    }

    public Long getCycle() 
    {
        return cycle;
    }
    public void setHadCycle(Long hadCycle) 
    {
        this.hadCycle = hadCycle;
    }

    public Long getHadCycle() 
    {
        return hadCycle;
    }
    public void setSuplierId(Long suplierId) 
    {
        this.suplierId = suplierId;
    }

    public Long getSuplierId() 
    {
        return suplierId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phoneNum", getPhoneNum())
            .append("city", getCity())
            .append("createTime", getCreateTime())
            .append("templateId", getTemplateId())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("taskId", getTaskId())
            .append("province", getProvince())
            .append("result", getResult())
            .append("cycle", getCycle())
            .append("hadCycle", getHadCycle())
            .append("suplierId", getSuplierId())
            .toString();
    }
}
