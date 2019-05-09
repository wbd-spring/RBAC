package com.rbac.common.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限model
 * @author zgh
 *
 */
public class Permission implements Serializable{
	
	private Integer id;
	
	private String name;
	
	private String url;
	
	private Integer pid;
	
	private boolean open;
	private boolean checked;
	private List<Permission> children =new ArrayList<Permission>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}
