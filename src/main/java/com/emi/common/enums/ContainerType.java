package com.emi.common.enums;

/**
 * Created by emi on 2016/11/1.
 */
public enum ContainerType {

    Type1(1,"AA"),
    Type2(2, "BB"),
    Type3(3, "CC");

    private int value;

    private String desc;

    ContainerType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
