package com.fastech.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/adminview")
public class UserViewController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMain() {
        return "include/main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "/user/user/{uid}", method = RequestMethod.GET)
    public String showUserPage(@PathVariable String uid, ModelMap model) {
        model.addAttribute("uid",uid);
        return "user/user";
    }

}
