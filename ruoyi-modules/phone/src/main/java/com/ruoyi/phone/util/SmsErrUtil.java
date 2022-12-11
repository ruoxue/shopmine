package com.ruoyi.phone.util;

import java.util.HashMap;
import java.util.Map;

public class SmsErrUtil {
    static Map<String, String> map = new HashMap<>();

    static {
        map.put("DELIVRD", "短信投递成功");
        map.put("MA:0011", "未知系统内部错误");
        map.put("MA:0009", "未定义错误");
        map.put("MA:0006", "系统拒绝");
        map.put("MA:0005", "目的号码格式错误");
        map.put("MA:0004", "未知");
        map.put("MA:0003", "无法找到下级路由");
        map.put("MA:0002", "内容非法");
        map.put("MA:0001", "全局黑名单号码");
        map.put("REJECTED", "Message is  in a   rejected state");
        map.put("DELETED", "Message has   been deleted.");
        map.put("EXPIRED", "Message validity period has expired");
        map.put("MA:0012", "防钓鱼");
        map.put("MA:0013", "非法错误的包时序");
        map.put("MO:NNNNN", "NNNN为对外提交过程中，上级网关的返回值，具体含义需上级网关解释");
        map.put("MA:0014", "非法的OP_ISD号段");
        map.put("MA:0021", "号码格式错误");
        map.put("MA:0022", "号码超过半小时下发次数限制");
        map.put("MA:0023", "客户黑名单号码");
        map.put("MA:0024", "内容未报备");
        map.put("MA:0025", "不支持该短信");
        map.put("MA:0026", "分条发送，组包超时");
        map.put("MA:0027", "通道黑名单");
        map.put("MA:0028", "全局黑名单号段");
        map.put("MA:0029", "通道黑名单号段");
        map.put("MA:0030", "直接产生拒绝报告");
        map.put("MO:200", "不支持分条短信");
        map.put("MO:0254", "转发提交超时");
        map.put("MO:0255", "转发提交过程中，连接断开");
        map.put("0","提交成功");
        map.put("10","原号码错误，即extno错误");
        map.put("15","余额不足");
        map.put("17","账号签名无效");

    }

    public static String getResult(String key) {
        return  key+":"+map.get(key);
    }


}
