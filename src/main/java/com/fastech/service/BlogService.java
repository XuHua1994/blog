package com.fastech.service;


import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.entity.Blog;
import com.fastech.entity.vo.BlogViewVO;
import com.fastech.entity.vo.RemarkViewVO;

public interface BlogService {

	Return getBolgByUid(String uid);

	Return writeBlog(Blog blog, String id);
	
	NewReturn getBlogs(BlogViewVO blogViewVO);

	Return getBlogById(String bid);

	Return writeRemark(RemarkViewVO remarkViewVO);

	Return getRemarkById(String bid);
}
