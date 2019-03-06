package com.springmvc.pojo;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageResultInfo{
	
	private Long total;
	
	private List rows = new ArrayList<>();

	public PageResultInfo() {
		super();
	}

	public PageResultInfo(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
