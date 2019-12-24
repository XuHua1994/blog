package com.fastech.controller;

import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getLogin",method = RequestMethod.POST)
    public Return login(@RequestParam(required = false) Map<String, String> inputMap, HttpServletRequest request) {

        return userService.loginUser(inputMap, request);
    }

    @RequestMapping(value = "/getUserById")
    public Return getUserById(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
//        if (CommonUtil.isNullOrEmpty(sessionid)) {
//            return new Return("-1");
//        }
        System.out.print("1");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        String username = (String) httpServletRequest.getSession().getAttribute("username");
//        HttpSession session = SessionUtils.getSession(sessionid);
        // 判断session是否为空 空返回code=-1
//        if (CommonUtil.isNullOrEmpty(session)) {
//            return new Return("-1");
//        }
        // 从session中获取username
//        String username = "";
//        try {
//            username = session.getAttribute("username").toString();
//        } catch (Exception e) {
////            log.error("username为空", e);
//        }
        return new Return(true,user,"success") ;
    }
    //getRegister
    @RequestMapping(value = "/getRegister",method = RequestMethod.POST)
    public Return getRegister(@RequestParam(required = false) Map<String, String> inputMap, HttpServletRequest request) {

        return userService.registerUser(inputMap, request);
    }
}
