package com.emi.common.enums;

/**
 * Created by emi on 2016/10/26.
 */
public enum OrderType  {

    Import(1, "进口"),
    Export(2, "出口");

    private int value;

    private String desc;

    OrderType(int value, String desc) {
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
