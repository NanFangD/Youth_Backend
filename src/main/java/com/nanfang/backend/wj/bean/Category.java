package com.nanfang.backend.wj.bean;

/**
 * @author nanfang
 * @create 2020/02/06/23:17
 */
public class Category {
    private String cid;
    private String name;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
