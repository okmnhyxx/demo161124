package com.emi.domain;

import javax.persistence.*;

/**
 * Created by emi on 2016/10/27.
 */
@MappedSuperclass
public abstract class BaseOrder extends BaseDomain {

    private String orderNo;

    private int orderType;

    private int orderState;

    @ManyToOne(cascade= CascadeType.REFRESH)//optional=false 时join 查询关系为inner join, optional=true 时join 查询关系为left join,默认true。
    @JoinColumn(name = "user_id")
    private User user;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
