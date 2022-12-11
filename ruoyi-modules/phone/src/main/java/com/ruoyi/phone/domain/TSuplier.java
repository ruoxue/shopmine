package com.ruoyi.phone.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供应商对象 t_suplier
 *
 * @author ruoyi
 * @date 2022-12-07 16:53:45
 */
public class TSuplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商id */
    private Long supId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String pwd;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 信息 */
    @Excel(name = "信息")
    private String info;

    /**  */
    @Excel(name = "")
    private String url;

    /** 归属号 */
    @Excel(name = "归属号")
    private String extno;

    /** 最多 */
    @Excel(name = "最多")
    private Long max;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 余额 */
    @Excel(name = "余额")
    private Long balance;

    public void setSupId(Long supId)
    {
        this.supId = supId;
    }

    public Long getSupId()
    {
        return supId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public String getPwd()
    {
        return pwd;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setExtno(String extno)
    {
        this.extno = extno;
    }

    public String getExtno()
    {
        return extno;
    }
    public void setMax(Long max)
    {
        this.max = max;
    }

    public Long getMax()
    {
        return max;
    }
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setBalance(Long balance)
    {
        this.balance = balance;
    }

    public Long getBalance()
    {
        return balance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("supId", getSupId())
                .append("name", getName())
                .append("pwd", getPwd())
                .append("status", getStatus())
                .append("remark", getRemark())
                .append("info", getInfo())
                .append("url", getUrl())
                .append("extno", getExtno())
                .append("max", getMax())
                .append("account", getAccount())
                .append("balance", getBalance())
                .toString();
    }
}
