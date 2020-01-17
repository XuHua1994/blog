package com.fastech.entity.vo;
public class PageVO {
	
	private int pageNo;//第几页
	
	private int pageSize;//显示几个
	
	private Object obj;
	
	public PageVO(int page,int pageSize,Object obj){
		this.pageNo=page;
		this.pageSize=pageSize;
		this.obj=obj;
	}
 
	public int getPageNo() {
		return pageNo;
	}
 
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
 
	
	public int getPageSize() {
		return pageSize;
	}
 
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
 
	public Object getObj() {
		return obj;
	}
 
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
