package com.fastech.service;

import com.fastech.base.Return;
import com.fastech.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    Return getUserById(HttpServletRequest request);

    List<User> queryAll();

    Return findUserById(String id);

    int updateUser(User user);

    int deleteUserById(String id);

    Return loginUser(Map<String, String> inputMap, HttpServletRequest request);

    Return registerUser(Map<String, String> inputMap, HttpServletRequest request);
}
