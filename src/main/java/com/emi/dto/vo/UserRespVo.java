package com.emi.dto.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by emi on 2016/11/1.
 */
@ApiModel
public class UserRespVo {

    @ApiModelProperty(value = "登录名")
    private String name;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "状态")
    private int state;

    private long integral;

    public UserRespVo() {
    }

    public UserRespVo(String name, String nickName, int state, long integral) {
        this();
        this.name = name;
        this.nickName = nickName;
        this.state = state;
        this.integral = integral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
