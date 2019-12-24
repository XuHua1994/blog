package com.fastech.entity.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BlogVO {
	private String id;
	private String uid;
	private String username;
	private String blogname;
	private Integer blogtheme;
	private String blogthemevo;
	private String blogcontent;
	private Integer blogsign;
	private String blogsignvo;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getUpdatetime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(updatetime);
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getBlogthemevo() {
		return blogthemevo;
	}

	public void setBlogthemevo(String blogthemevo) {
		this.blogthemevo = blogthemevo;
	}

	public String getBlogsignvo() {
		return blogsignvo;
	}

	public void setBlogsignvo(String blogsignvo) {
		this.blogsignvo = blogsignvo;
	}

}
