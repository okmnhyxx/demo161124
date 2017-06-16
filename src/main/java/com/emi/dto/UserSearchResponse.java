package com.emi.dto;

import com.emi.dto.comon.PageRespVo;
import com.emi.dto.comon.RestResponse;
import com.emi.dto.vo.UserRespVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by emi on 2016/11/2.
 */
@ApiModel
public class UserSearchResponse extends RestResponse {

    @ApiModelProperty
    private UserRespVo[] userVoArr;

    @ApiModelProperty
    private PageRespVo pageInfo;

    public UserSearchResponse() {
    }

    public UserSearchResponse(UserRespVo[] userVoArr, PageRespVo pageInfo) {
        this.userVoArr = userVoArr;
        this.pageInfo = pageInfo;
    }

    public UserRespVo[] getUserVoArr() {
        return userVoArr;
    }

    public void setUserVoArr(UserRespVo[] userVoArr) {
        this.userVoArr = userVoArr;
    }

    public PageRespVo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageRespVo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
