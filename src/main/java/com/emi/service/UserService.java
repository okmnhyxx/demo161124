package com.emi.service;

import com.emi.config.SystemConfigs;
import com.emi.config.SystemProperties;
import com.emi.domain.User;
import com.emi.dto.UserRegisterRequest;
import com.emi.dto.UserRegisterResponse;
import com.emi.dto.UserSearchRequest;
import com.emi.dto.UserSearchResponse;
import com.emi.dto.comon.PageRespVo;
import com.emi.dto.comon.PagedRequest;
import com.emi.dto.vo.UserRespVo;
import com.emi.repository.Specification.UserSpecification;
import com.emi.repository.UserRepository;
import com.emi.repository.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by emi on 2016/10/27.
 */
@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    SystemProperties properties;

    @Autowired
    SystemConfigs configs;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserRegisterResponse register(UserRegisterRequest registerRequest) {
        User users = new User(registerRequest.getName(), registerRequest.getPassword(), registerRequest.getNickName());
        userRepository.save(users);
        return new UserRegisterResponse();
    }


    public UserSearchResponse all(PagedRequest pagedRequest) {
        PageRequest pageRequest = new PageRequest(pagedRequest.getCurrentPage(), pagedRequest.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
        Page<User> userPage = userRepository.findAll(pageRequest);
        UserRespVo[] userArr = this.userDomain2Vo(userPage.getContent());
        return new UserSearchResponse(userArr, new PageRespVo(pagedRequest.getPageSize(), pagedRequest.getCurrentPage(), userPage.getTotalElements()));
    }


    public UserSearchResponse search(UserSearchRequest searchRequest) {

        PageRequest pageRequest = new PageRequest(searchRequest.getCurrentPage(), searchRequest.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
        Page<User> userPage = userRepository.findAll(UserSpecification.findUserBy(searchRequest), pageRequest);
        UserRespVo[] userArr = this.userDomain2Vo(userPage.getContent());
        return new UserSearchResponse(userArr, new PageRespVo(searchRequest.getPageSize(), searchRequest.getCurrentPage(), userPage.getTotalElements()));
    }


    public UserSearchResponse search2(UserSearchRequest searchRequest) {

        PageHelper.startPage(searchRequest.getCurrentPage(), searchRequest.getPageSize());
        List<User> userList = userMapper.searchUser(searchRequest.fetchParameter());
        UserRespVo[] userArr = this.userDomain2Vo(userList);
        PageInfo pageInfo = new PageInfo<>(userList);
        return new UserSearchResponse(userArr, new PageRespVo(pageInfo));
    }


    private UserRespVo[] userDomain2Vo(List<User> userList) {
        User u;
        UserRespVo[] userArr = new UserRespVo[userList.size()];
        for (int i = 0; i< userList.size(); i ++) {
            u = userList.get(i);
            userArr[i] = new UserRespVo(u.getName(), u.getNickName(), u.getState(), u.getIntegral());
        }
        return userArr;
    }

}
