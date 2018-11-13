package com.rbac.common.pojo;

import java.util.List;

/**
 * 分页组件
* <p>Title: Page.java</p>  
* <p>Description: </p>  
* @author 朱光和 
* @date 2018年11月13日
 */
public class Page<T> {

	//分页列表
	private List<T> datas;
	
	//页码
	private int pageNum;
	
	//总页数
	private int totalPage;
	
	//总记录数
	private int totalRecord;

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
