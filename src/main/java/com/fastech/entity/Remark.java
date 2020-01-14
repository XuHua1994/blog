package com.fastech.entity;

import com.fastech.entity.vo.RemarkViewVO;

import java.sql.Timestamp;

public class Remark {
	private String id;
	private String blogid;
	private String remarkid;
	private String remark;
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
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Remark(){

	}

	public Remark(RemarkViewVO remarkViewVO){
		this.blogid = remarkViewVO.getBlogid();
		this.remarkid = remarkViewVO.getRemarkid();
		this.remark = remarkViewVO.getRemark();
	}
}
