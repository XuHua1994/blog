package com.fastech.controller;

import com.fastech.base.CommonResult;
import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.entity.vo.UserVO;
import com.fastech.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "登入接口")
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Return login(@ModelAttribute UserVO userVO, HttpServletRequest request) {

        return loginService.loginUser(userVO, request);
    }


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name="password",value="密码",required=true)
    })
    @RequestMapping(value = "getRegister", method = RequestMethod.POST)
    public CommonResult getRegister(@RequestParam String username,@RequestParam String password, HttpServletRequest request) {
        CommonResult commonResult=new CommonResult();
        try {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            loginService.registerUser(user,request);
            commonResult.setResult("注册成功!");
            commonResult.setStatus("ok");
        } catch (Exception e) {
            commonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
            commonResult.setStatus("error");
            e.printStackTrace();
        }

        return commonResult;
    }
}
