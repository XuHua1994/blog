package com.fastech.controller;

import com.fastech.base.CommonResult;
import com.fastech.entity.User;
import com.fastech.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Api(description = "用户接口")
@RestController
@RequestMapping(value = "/admin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/getUserById")
    public CommonResult  getUserById(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
        System.out.print("1");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        return new CommonResult("ok", user);
    }

}
