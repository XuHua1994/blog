package com.fastech.entity;

import com.fastech.entity.vo.BlogViewVO;

import java.sql.Timestamp;

public class Blog {
	private String id;
	private String uid;
	private String blogname;
	private Integer blogtheme;
	private String blogcontent;
	private Integer blogsign;
	private Timestamp createtime;
	private Timestamp updatetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBlogname() {
		return blogname;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}

	public Integer getBlogtheme() {
		return blogtheme;
	}

	public void setBlogtheme(Integer blogtheme) {
		this.blogtheme = blogtheme;
	}

	public String getBlogcontent() {
		return blogcontent;
	}

	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}

	public Integer getBlogsign() {
		return blogsign;
	}

	public void setBlogsign(Integer blogsign) {
		this.blogsign = blogsign;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Blog(){

	}

	public Blog(BlogViewVO blogViewVO){
		this.uid = blogViewVO.getUid();
		this.blogname = blogViewVO.getBlogname();
		this.blogtheme = blogViewVO.getBlogtheme();
	}

}
