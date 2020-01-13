package com.fastech.controller;


import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.entity.User;
import com.fastech.service.impl.BlogServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

   
    @RequestMapping(value = "/writeBlog")
    public Return writeBlog(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new Return(false,"session过期!");
//        }
        
        return blogService.writeBlog(inputMap,user) ;
    }
    
    @RequestMapping(value = "/writeRemark")
    public Return writeRemark(HttpServletRequest httpServletRequest,@RequestParam(required = false) Map<String, Object> inputMap) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new Return(false,"session过期!");
//        }
        
        return blogService.writeRemark(inputMap,user) ;
    }
    @ApiOperation(value = "获取博客", notes = "根据博客名称模糊查询")
    @ApiImplicitParams ({
            @ApiImplicitParam(name = "blogname", value = "博客名称模糊查询", required = false, dataType = "String"),
            @ApiImplicitParam(name = "blogtheme", value = "博客类型查询", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sign", value = "0:所有博客/1:本人博客", required = true, dataType = "String")
    })
    @RequestMapping(value = "/getBlogs", method = RequestMethod.GET)
    public NewReturn getBlogs(HttpServletRequest httpServletRequest,
    		@RequestParam int page,@RequestParam int rows,@RequestParam(required = false) String blogname
            ,@RequestParam(required = false) String blogtheme,@RequestParam String sign) {
        System.out.println("111111111111");
        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new NewReturn(false,"session过期!");
//        }
        Map<String,Object> inputMap=new HashMap<>();
        inputMap.put("id", user.getId());
        inputMap.put("blogtheme", blogtheme);
        inputMap.put("blogname", blogname);
        inputMap.put("sign", sign);
        inputMap.put("page",page);
        inputMap.put("rows",rows);
        return blogService.getBlogs(inputMap) ;
    }
    
    
    @RequestMapping(value = "/getBlogById")
    public Return getBlog(HttpServletRequest httpServletRequest,
    		@RequestParam(required = false) Map<String, Object> inputMap) {
//        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new Return(false,"session过期!");
//        }
        return blogService.getBlogById(inputMap) ;
    }
    
    @RequestMapping(value = "/getRemarkById")
    public Return getRemark(HttpServletRequest httpServletRequest,
    		@RequestParam(required = false) Map<String, Object> inputMap) {
//        User user = (User) httpServletRequest.getSession().getAttribute("user");
//        if(user==null) {
//        	return new Return(false,"session过期!");
//        }
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
