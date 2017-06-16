package com.emi.repository.mapper;

import com.emi.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by emi on 2016/11/4.
 */
@Mapper
public interface UserMapper {

    List<User> searchUser(String name2);
    List<User> searchUser(Map<String,String> map);
}
