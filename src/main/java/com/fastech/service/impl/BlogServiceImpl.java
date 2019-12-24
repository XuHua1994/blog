package com.fastech.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastech.base.NewReturn;
import com.fastech.base.Return;
import com.fastech.dao.BlogDAO;
import com.fastech.dao.RemarkDAO;
import com.fastech.entity.Blog;
import com.fastech.entity.Remark;
import com.fastech.entity.User;
import com.fastech.entity.vo.BlogVO;
import com.fastech.entity.vo.PageVO;
import com.fastech.entity.vo.RemarkVO;
import com.fastech.service.BlogService;
import com.fastech.utils.TimeUtils;

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
	public Return writeBlog(Map<String, Object> inputMap, User user) {
		// TODO Auto-generated method stub
		Blog blog = getBlogMap(inputMap);
		blog.setId(UUID.randomUUID().toString());
		blog.setUid(user.getId());
		Timestamp time = TimeUtils.getTime();
		blog.setCreatetime(time);
		blog.setUpdatetime(time);
		blogDAO.insertBlog(blog);
		return new Return(true, "success");
	}
	
	@Override
	public Return writeRemark(Map<String, Object> inputMap, User user) {
		Remark r=new Remark();
		r.setId(UUID.randomUUID().toString());
		r.setBlogid(inputMap.get("blogid").toString());
		r.setRemarkid(user.getId());
		r.setRemark(inputMap.get("remark").toString());
		Timestamp time = TimeUtils.getTime();
		r.setCreatetime(time);
		remarkDAO.insertRemark(r);
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
	public NewReturn getBlogs(Map<String, Object> inputMap) {
		int page = Integer.valueOf(inputMap.get("page").toString());
		int pagesize = Integer.valueOf(inputMap.get("rows").toString());
		int pageNo = (page - 1) * pagesize;
		int sign=Integer.valueOf(inputMap.get("sign").toString());
		Blog bselect=new Blog();
		bselect.setBlogname(inputMap.get("blogname").toString());
		String bt=inputMap.get("blogtheme").toString();
		if(!"".equals(bt)) {
			bselect.setBlogtheme(Integer.valueOf(bt));
		}
		bselect.setUid(inputMap.get("id").toString());
		PageVO pagevo = new PageVO(pageNo, pagesize, bselect);
		List<BlogVO> blogs =new ArrayList<BlogVO>();
		Integer total =0;
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
	public Return getBlogById(Map<String, Object> inputMap) {
		String id=inputMap.get("id").toString();
		List<BlogVO> blog = blogDAO.getBolgById(id);
		return new Return(true,blog,"success");
	}
	
	@Override
	public Return getRemarkById(Map<String, Object> inputMap) {
		String blogid=inputMap.get("blogid").toString();
		List<RemarkVO> remark = remarkDAO.getRemarkById(blogid);
		return new Return(true,remark,"success");
	}


}
