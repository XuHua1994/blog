package com.fastech.entity.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class RemarkVO {
	private String id;
	private String blogid;//评论博客id
	private String remarkid;//评论人id
	private String remarkname;//评论人名字
	private String remark;//评论内容
	private Timestamp createtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	public String getRemarkid() {
		return remarkid;
	}
	public void setRemarkid(String remarkid) {
		this.remarkid = remarkid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatetime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(createtime);
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getRemarkname() {
		return remarkname;
	}
	public void setRemarkname(String remarkname) {
		this.remarkname = remarkname;
	}
	
}
