package com.ruoyi.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 支付类型对象 pay_channel
 *
 * @author xiaoming
 * @date 2022-09-12
 */
public class PayChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** code */

    @Excel(name = "code")
    private String code;

    /** 名称 */
    @Excel(name = "名称")
    private String name;
    @JsonIgnore
    /** 配置 */
    private String config;
    @JsonIgnore
    /** 私钥 */
    private String privateKey;
    @JsonIgnore
    /** 公钥 */
    private String alipayPublicKey;
    @JsonIgnore
    /** 证书 */
    private String appCertContent;
    @JsonIgnore
    /**  */
    private String alipayPublicCertContent;


    @JsonIgnore
    private String certPath;
    @JsonIgnore
    private String rootCertPath;
    @JsonIgnore
    private String publicCertPath;

    /** appID */
    @JsonIgnore
    @Excel(name = "appID")
    private String appId;

    /** 参数 */
    @JsonIgnore
    private String param;

    /** 图标 */
    @Excel(name = "图标")
    private String img;
    @JsonIgnore
    /** 网关 */
    @Excel(name = "网关")
    private String gateWay;
    @JsonIgnore
    /** 回调地址 */
    @Excel(name = "回调地址")
    private String notifyUrl;
    @JsonIgnore
    /** 同步回调地址 */
    @Excel(name = "同步回调地址")
    private String returnUrl;
    @JsonIgnore
    private  String showUrl;

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setConfig(String config)
    {
        this.config = config;
    }

    public String getConfig()
    {
        return config;
    }
    public void setPrivateKey(String privateKey)
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey()
    {
        return privateKey;
    }
    public void setAlipayPublicKey(String alipayPublicKey)
    {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getAlipayPublicKey()
    {
        return alipayPublicKey;
    }
    public void setAppCertContent(String appCertContent)
    {
        this.appCertContent = appCertContent;
    }

    public String getAppCertContent()
    {
        return appCertContent;
    }
    public void setAlipayPublicCertContent(String alipayPublicCertContent)
    {
        this.alipayPublicCertContent = alipayPublicCertContent;
    }

    public String getAlipayPublicCertContent()
    {
        return alipayPublicCertContent;
    }
    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getAppId()
    {
        return appId;
    }
    public void setParam(String param)
    {
        this.param = param;
    }

    public String getParam()
    {
        return param;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }
    public void setGateWay(String gateWay)
    {
        this.gateWay = gateWay;
    }

    public String getGateWay()
    {
        return gateWay;
    }
    public void setNotifyUrl(String notifyUrl)
    {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl()
    {
        return notifyUrl;
    }
    public void setReturnUrl(String returnUrl)
    {
        this.returnUrl = returnUrl;
    }

    public String getReturnUrl()
    {
        return returnUrl;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getRootCertPath() {
        return rootCertPath;
    }

    public void setRootCertPath(String rootCertPath) {
        this.rootCertPath = rootCertPath;
    }

    public String getPublicCertPath() {
        return publicCertPath;
    }

    public void setPublicCertPath(String publicCertPath) {
        this.publicCertPath = publicCertPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .append("config", getConfig())
                .append("privateKey", getPrivateKey())
                .append("alipayPublicKey", getAlipayPublicKey())
                .append("appCertContent", getAppCertContent())
                .append("alipayPublicCertContent", getAlipayPublicCertContent())
                .append("appId", getAppId())
                .append("param", getParam())
                .append("img", getImg())
                .append("gateWay", getGateWay())
                .append("notifyUrl", getNotifyUrl())
                .append("returnUrl", getReturnUrl())
                .toString();
    }
}
