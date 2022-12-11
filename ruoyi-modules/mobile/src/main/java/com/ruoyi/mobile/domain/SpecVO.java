package com.ruoyi.mobile.domain;

import com.ruoyi.shop.domain.ProductSpecTitle;

import java.util.List;

public class SpecVO {
    private String name;
    private List<ProductSpecTitle> list;
    private List<String> conName;

    public List<String> getConName() {
        return conName;
    }

    public void setConName(List<String> conName) {
        this.conName = conName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductSpecTitle> getList() {
        return list;
    }

    public void setList(List<ProductSpecTitle> list) {
        this.list = list;
    }
}
