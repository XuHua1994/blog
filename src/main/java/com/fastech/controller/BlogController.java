package com.fastech.controller;


import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.entity.Blog;
import com.fastech.entity.vo.BlogViewVO;
import com.fastech.entity.vo.RemarkViewVO;
import com.fastech.service.impl.BlogServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

   
    @ApiOperation(value = "写博客", notes = "根据用户id,创建个人博客")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Return writeBlog(@ModelAttribute Blog blog,@PathVariable String id) {

        return blogService.writeBlog(blog,id);
    }
    
    @ApiOperation(value = "写评论", notes = "根据评论人uid,评论博客bid,编写评论")
    @RequestMapping(value = "/remark", method = RequestMethod.POST)
    public Return writeRemark(@ModelAttribute RemarkViewVO remarkViewVO) {

        return blogService.writeRemark(remarkViewVO) ;
    }
    @ApiOperation(value = "获取博客", notes = "根据博客名称模糊查询")
    @ApiImplicitParams ({
            @ApiImplicitParam(name = "blogname", value = "博客名称模糊查询", required = false, dataType = "String"),
            @ApiImplicitParam(name = "blogtheme", value = "博客类型查询", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sign", value = "0:所有博客/1:本人博客", required = true, dataType = "String")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public NewReturn getBlogs(@ModelAttribute BlogViewVO blogViewVO) {
        return blogService.getBlogs(blogViewVO) ;
    }

    @ApiOperation(value = "获取博客内容", notes = "根据博客id,获取该博客信息")
    @RequestMapping(value = "/{bid}", method = RequestMethod.GET)
    public Return getBlog(@PathVariable String bid) {
        return blogService.getBlogById(bid) ;
    }

    @ApiOperation(value = "获取博客评论", notes = "根据博客id,获取该博客评论信息")
    @RequestMapping(value = "/remark/{bid}", method = RequestMethod.GET)
    public Return getRemark(@PathVariable String bid) {
        return blogService.getRemarkById(bid) ;
    }


//    public Return getRemark1(@RequestParam(required = false) Map<String, Object> inputMap) {
//        return new Return();
//    }
}
