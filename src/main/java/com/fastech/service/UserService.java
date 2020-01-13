package com.fastech.service;

import com.fastech.base.Return;
import com.fastech.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    Return getUserById(HttpServletRequest request);

    List<User> queryAll();

    Return findUserById(String id);

    int updateUser(User user);

    int deleteUserById(String id);

}
