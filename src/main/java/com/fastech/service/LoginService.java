package com.fastech.service;

import com.fastech.base.Return;
import com.fastech.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

    Return loginUser(Map<String, String> inputMap, HttpServletRequest request);

    void registerUser(User user, HttpServletRequest request);
}
