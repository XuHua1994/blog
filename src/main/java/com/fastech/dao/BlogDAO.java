package com.fastech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fastech.entity.Blog;
import com.fastech.entity.vo.BlogVO;
import com.fastech.entity.vo.PageVO;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface BlogDAO {
	List<Blog> getBolgByUid(@Param(value = "uid") String uid);
	
	List<BlogVO> getBolgById(@Param(value = "id") String id);

	void insertBlog(Blog blog);

	List<BlogVO> getBlogs(PageVO pagevo);

	Integer queryCounts(PageVO pagevo);

	List<BlogVO> getPersonBlogs(PageVO pagevo);

	Integer queryPersonCounts(PageVO pagevo);
}
