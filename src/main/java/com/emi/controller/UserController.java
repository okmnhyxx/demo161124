package com.emi.controller;

import com.emi.dto.UserRegisterRequest;
import com.emi.dto.UserRegisterResponse;
import com.emi.dto.UserSearchRequest;
import com.emi.dto.UserSearchResponse;
import com.emi.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.spi.PersistenceUnitInfo;


/**
 * Created by emi on 2016/10/27.
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册接口1", notes = "json post 方式")
    @ApiImplicitParam(name = "registerRequest", value = "用户注册信息DTO", required = true, dataType = "UserRegisterRequest")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public UserRegisterResponse create(@RequestBody UserRegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }


    @ApiOperation(value = "用户注册接口2", notes = "common post 方式")
    @ApiImplicitParam(name = "registerRequest", value = "用户注册信息DTO", required = true, dataType = "UserRegisterRequest")
    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    @ResponseBody
    public UserRegisterResponse create2(UserRegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }

    @ApiOperation(value = "条件查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchRequest", value = "查询参数,见类 UserSearchRequest", required = false, dataType = "UserSearchRequest", paramType = "query"),
    })
    @RequestMapping(value = "/search1", method = RequestMethod.GET)
    @ResponseBody
    public UserSearchResponse search(UserSearchRequest searchRequest) {
//        PersistenceUnitInfoDescriptor
//        PersistenceUnitInfo
//                HibernateJpaAutoConfiguration
            return userService.search(searchRequest);
    }

    @ApiOperation(value = "条件查询用户")
    @RequestMapping(value = "/search2", method = RequestMethod.GET)
    @ResponseBody
    public UserSearchResponse search2(@ApiParam(value = "查询参数,见类 UserSearchRequest")UserSearchRequest searchRequest) {
        int a = 10/0;
        return userService.search2(searchRequest);
    }


}
