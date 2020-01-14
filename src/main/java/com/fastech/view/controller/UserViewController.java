package com.fastech.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/adminview")
public class UserViewController {

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//
//		return "login";
//	}
//
//	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
//	public String loginout() {
//		return "loginout";
//	}

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "blog/index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String person() {
        return "blog/person";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMain() {
        return "include/main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/register";
    }

//	@RequestMapping(value = "/writeBlog", method = RequestMethod.GET)
//    public String writeBlog() {
//        return "blog/include/detail";
//    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(ModelMap model) {
        return "blog/include/detail";
    }

    @RequestMapping(value = "/remark", method = RequestMethod.GET)
    public String remark(ModelMap model) {
        return "blog/include/remark";
    }

    @RequestMapping(value = "/user/user/{uid}", method = RequestMethod.GET)
    public String showUserPage(@PathVariable String uid, ModelMap model) {
        model.addAttribute("uid",uid);
        return "user/user";
    }

}
