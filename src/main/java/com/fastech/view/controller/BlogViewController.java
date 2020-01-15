package com.fastech.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/adminview")
public class BlogViewController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "blog/index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String person() {
        return "blog/person";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(ModelMap model) {
        return "blog/include/detail";
    }

    @RequestMapping(value = "/remark", method = RequestMethod.GET)
    public String remark(ModelMap model) {
        return "blog/include/remark";
    }



}
