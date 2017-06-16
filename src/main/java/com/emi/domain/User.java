package com.emi.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emi on 2016/10/27.
 */
@Entity(name = "user_")
public class User extends BaseDomain {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String nickName;

    private int state;

    private long integral;

    //CascadeType.PERSIST（级联新建）、CascadeType.REMOVE（级联删除）、CascadeType.REFRESH（级联刷新）、CascadeType.MERGE（级联更新）
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL) //mappedBy:该属性的值是“多”方class里的“一”方的变量名。
    @OrderBy(value = "id ASC")
    private Set<OrderImport> orderImports;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    private Set<OrderExport> exports;


    public User() {
        this.state = 1;
        this.integral = 10;
    }

    public User(String name, String password, String nickName) {
        this();
        this.name = name;
        this.password = password;
        this.nickName = nickName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public Set<OrderImport> getOrderImports() {
        return orderImports;
    }

    public void setOrderImports(Set<OrderImport> orderImports) {
        this.orderImports = orderImports;
    }

//    public Set<OrderExport> getExports() {
//        return exports;
//    }
//
//    public void setExports(Set<OrderExport> exports) {
//        this.exports = exports;
//    }


}
