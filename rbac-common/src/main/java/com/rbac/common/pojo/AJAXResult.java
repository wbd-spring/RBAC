package com.rbac.common.pojo;

import java.io.Serializable;

/**
 * Ajax请求返回的数据
* <p>Title: AJAXResult.java</p>  
* <p>Description: </p>  
* @author 朱光和 
* @date 2018年11月13日
 */
public class AJAXResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success;
	
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
