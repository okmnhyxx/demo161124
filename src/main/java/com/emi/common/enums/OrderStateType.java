package com.emi.common.enums;

/**
 * Created by emi on 2016/10/26.
 */
public enum OrderStateType {

    Create(1,"已创建"),
    Send(2, "已支付"),
    Check(3, "已审核"),
    Run(4, "已执行"),
    Finish(5, "完成");

    private int value;

    private String desc;

    OrderStateType(int value, String desc) {
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
