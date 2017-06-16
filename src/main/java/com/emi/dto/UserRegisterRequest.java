package com.emi.dto;

import com.emi.dto.comon.RestRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2016/10/27.
 */
public class UserRegisterRequest extends RestRequest {

    private String name;

    private String password;

    private String nickName;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String name, String password, String nickName) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
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

    @Override
    public Map<String, String> fetchParameter() {
        Map<String, String> map = new HashMap<>(3);
        map.put("name",name);
        map.put("password", password);
        map.put("nickName", nickName);
        return map;
    }
}
