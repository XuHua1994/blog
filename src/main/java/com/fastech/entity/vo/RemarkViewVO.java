package com.fastech.entity.vo;

public class RemarkViewVO {
	private String blogid;//评论博客id
	private String remarkid;//评论人id
	private String remark;//评论内容

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public void setRemarkid(String remarkid) {
		this.remarkid = remarkid;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBlogid() {
		return blogid;
	}

	public String getRemarkid() {
		return remarkid;
	}

	public String getRemark() {
		return remark;
	}
}
