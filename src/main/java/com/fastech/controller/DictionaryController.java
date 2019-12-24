package com.fastech.controller;

import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.service.BlogService;
import com.fastech.service.DictionaryService;
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
@RequestMapping(value = "/admin/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

   
    @RequestMapping(value = "/getDictionaryByType")
    public Return writeBlog(HttpServletRequest httpServletRequest,@RequestParam(required = true) String type) {
//        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new Return(false,"session过期!");
//        }
        
        return dictionaryService.getDictionaryByType(type) ;
    }
    
   
   
}
