package com.fastech.service.impl;

import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.dao.BlogDAO;
import com.fastech.dao.RemarkDAO;
import com.fastech.entity.Blog;
import com.fastech.entity.Remark;
import com.fastech.entity.vo.*;
import com.fastech.service.BlogService;
import com.fastech.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAO blogDAO;
	@Autowired
	private RemarkDAO remarkDAO;

	@Override
	public Return getBolgByUid(String uid) {
		List<Blog> blogs = blogDAO.getBolgByUid(uid);
		return new Return(true, blogs, "success");
	}

	@Override
	public Return writeBlog(Blog blog, String id) {
		// TODO Auto-generated method stub
		blog.setId(UUID.randomUUID().toString());
		blog.setUid(id);
		Timestamp time = TimeUtils.getTime();
		blog.setCreatetime(time);
		blog.setUpdatetime(time);
		blogDAO.insertBlog(blog);
		return new Return(true, "success");
	}
	
	@Override
	public Return writeRemark(RemarkViewVO remarkViewVO) {
		Remark remark=new Remark(remarkViewVO);
		remark.setId(UUID.randomUUID().toString());
		Timestamp time = TimeUtils.getTime();
		remark.setCreatetime(time);
		remarkDAO.insertRemark(remark);
		return new Return(true, "success");
	}

	private Blog getBlogMap(Map<String, Object> inputMap) {
		Blog b = new Blog();
//		blogtheme
		b.setBlogname(inputMap.get("blogname").toString());
		b.setBlogtheme(Integer.valueOf(inputMap.get("blogtheme").toString()));
		b.setBlogcontent(inputMap.get("blogcontent").toString());
		b.setBlogsign(Integer.valueOf(inputMap.get("blogsign").toString()));
		return b;
	}

	@Override
	public NewReturn getBlogs(BlogViewVO blogViewVO) {
		int page = blogViewVO.getPage();
		int pagesize = blogViewVO.getRows();
		int pageNo = (page - 1) * pagesize;
		int sign=blogViewVO.getSign();
		Blog bselect=new Blog(blogViewVO);
		PageVO pagevo = new PageVO(pageNo, pagesize, bselect);
		List<BlogVO> blogs =new ArrayList<BlogVO>();
		Integer total;
		if(sign==1) {
			blogs = blogDAO.getPersonBlogs(pagevo);
			total =blogDAO.queryPersonCounts(pagevo);
		}else {
			blogs = blogDAO.getBlogs(pagevo);
			total =blogDAO.queryCounts(pagevo);
		}
		
		 
		return new NewReturn(total,blogs);
	}

	@Override
	public Return getBlogById(String bid) {
		List<BlogVO> blog = blogDAO.getBolgById(bid);
		return new Return(true,blog,"success");
	}
	
	@Override
	public Return getRemarkById(String bid) {
		List<RemarkVO> remark = remarkDAO.getRemarkById(bid);
		return new Return(true,remark,"success");
	}


}
