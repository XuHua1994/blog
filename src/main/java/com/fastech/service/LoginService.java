package com.fastech.service;

import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.entity.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    Return loginUser(UserVO userVO, HttpServletRequest request);

    void registerUser(User user, HttpServletRequest request);
}
