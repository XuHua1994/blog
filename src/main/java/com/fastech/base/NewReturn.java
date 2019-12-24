package com.fastech.base;

import java.io.Serializable;
import java.util.List;

public class NewReturn implements Serializable {

	private static final long serialVersionUID = -5158708077742187883L;
	
	/* 状态 */
	private boolean state;
	/* 数据 */
	private Object result;
	
	/* 表格数据 */
	private Object rows;
	/* 数据量 */
	private Integer total;
	
	private String msg;
	public NewReturn() {
	}
	
	public NewReturn(Boolean state, String msg) {
		super();
		this.state = state;
		this.msg = msg;
	}
	
	public NewReturn(Boolean state, Object result) {
		super();
		this.state = state;
		this.result = result;
	}
	
	public NewReturn(Boolean state, Object result, String msg) {
		super();
		this.state = state;
		this.result = result;
		this.msg = msg;
	}
	
	public NewReturn(Integer total,Object rows) {
		super();
		this.rows = rows;
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "NewReturn [state=" + state + ", result=" + result + ", rows=" + rows + ", total=" + total + ", msg="
				+ msg + "]";
	}

	
	
}
