package com.emi.dto;

import com.emi.common.exception.DateFormatException;
import com.emi.dto.comon.PagedRequest;
import com.emi.dto.comon.PagedRequest2;
import com.emi.service.ServiceUtils;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emi on 2016/11/1.
 */
public class UserSearchRequest extends PagedRequest {

    private String name;

    private String nickName;

    private String state;

    private String createTimeFrom;

    private String createTimeTo;

    public UserSearchRequest() {
    }

    public UserSearchRequest(String name, String nickName, String state, String createTimeFrom, String createTimeTo) {
        this.name = name;
        this.nickName = nickName;
        this.state = state;
        this.createTimeFrom = createTimeFrom;
        this.createTimeTo = createTimeTo;
    }
    public UserSearchRequest(String name, String nickName, String state, String createTimeFrom, String createTimeTo, int pageSize, int currentPage) {
        super(pageSize, currentPage);
        this.name = name;
        this.nickName = nickName;
        this.state = state;
        this.createTimeFrom = createTimeFrom;
        this.createTimeTo = createTimeTo;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(String createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public String getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(String createTimeTo) {
        this.createTimeTo = createTimeTo;
    }

    public Date fetchCreateTimeToDate() {
        try {
            return null == createTimeTo ? null : ServiceUtils.sdf.parse(createTimeTo);
        } catch (ParseException e) {
            throw new DateFormatException(ServiceUtils.sdf, createTimeTo, LoggerFactory.getLogger(UserSearchRequest.class));
        }
    }

    public Date fetchCreateTimeFromDate() {
        try {
            return null == createTimeFrom ? null : ServiceUtils.sdf.parse(createTimeFrom);
        } catch (ParseException e) {
            throw new DateFormatException(ServiceUtils.sdf, createTimeFrom, LoggerFactory.getLogger(UserSearchRequest.class));
        }
    }

    @Override
    public Map<String, String> fetchParameter() {
        Map<String, String> map = new HashMap<>(7);
        map.put("name", name);
        map.put("nickName", nickName);
        map.put("state", state);
        map.put("createTimeFrom", createTimeFrom);
        map.put("createTimeTo", createTimeTo);
        map.put("pageSize", getPageSize() + "");
        map.put("currentPage", getCurrentPage() + "");
        return map;
    }
}
