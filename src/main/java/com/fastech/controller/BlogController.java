package com.fastech.controller;


import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.service.BlogService;
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
@RequestMapping(value = "/admin/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

   
    @RequestMapping(value = "/writeBlog")
    public Return writeBlog(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null) {
        	return new Return(false,"session过期!");
        }
        
        return blogService.writeBlog(inputMap,user) ;
    }
    
    @RequestMapping(value = "/writeRemark")
    public Return writeRemark(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null) {
        	return new Return(false,"session过期!");
        }
        
        return blogService.writeRemark(inputMap,user) ;
    }
    
    @RequestMapping(value = "/getBlogs")
    public NewReturn getBlogs(HttpServletRequest httpServletRequest,
    		@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null) {
        	return new NewReturn(false,"session过期!");
        }
        inputMap.put("id", user.getId());
        return blogService.getBlogs(inputMap) ;
    }
    
    
    @RequestMapping(value = "/getBlogById")
    public Return getBlog(HttpServletRequest httpServletRequest,
    		@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null) {
        	return new Return(false,"session过期!");
        }
        return blogService.getBlogById(inputMap) ;
    }
    
    @RequestMapping(value = "/getRemarkById")
    public Return getRemark(HttpServletRequest httpServletRequest,
    		@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null) {
        	return new Return(false,"session过期!");
        }
        return blogService.getRemarkById(inputMap) ;
    }

    /**
     *
     * @param httpServletRequest
     * @param inputMap
     * @return
     */
    public Return getRemark1(HttpServletRequest httpServletRequest,
                            @RequestParam(required = false) Map<String, Object> inputMap) {
        return new Return();
    }
}
