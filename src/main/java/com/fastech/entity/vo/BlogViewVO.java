package com.fastech.entity.vo;

public class BlogViewVO {
	private String uid;
	private String blogname;
	private Integer blogtheme;
	private Integer sign;
	private Integer page;
	private Integer rows;

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}

	public void setBlogtheme(Integer blogtheme) {
		this.blogtheme = blogtheme;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getUid() {
		return uid;
	}

	public String getBlogname() {
		return blogname;
	}

	public Integer getBlogtheme() {
		return blogtheme;
	}

	public Integer getSign() {
		return sign;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getRows() {
		return rows;
	}
}
