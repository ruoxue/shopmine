package com.ruoyi.phone.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class SuplierRetModel {


    @JsonProperty("status")
    private String status;
    @JsonProperty("balance")
    private Long balance;
    @JsonProperty("list")
    private List<ListDTO> list;


    public static class ListDTO {
        @JsonProperty("mid")
        private String mid;
        @JsonProperty("mobile")
        private String mobile;
        @JsonProperty("result")
        private Integer result;

        private  Long flag;
        private  String spid;
        private  String accessCode;
        private  String stat;
        private  String time;

        public Long getFlag() {
            return flag;
        }

        public void setFlag(Long flag) {
            this.flag = flag;
        }

        public String getSpid() {
            return spid;
        }

        public void setSpid(String spid) {
            this.spid = spid;
        }

        public String getAccessCode() {
            return accessCode;
        }

        public void setAccessCode(String accessCode) {
            this.accessCode = accessCode;
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public List<ListDTO> getList() {
        return list;
    }

    public void setList(List<ListDTO> list) {
        this.list = list;
    }
}
