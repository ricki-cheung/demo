package com.example.demo.model.sys;

import java.io.Serializable;

public class Resource implements Serializable  {
	private Integer id;
    private String parentId;
    private String code;
    private String resourceName;
    private String uri;
    private Boolean isMenu;
    private int resourceOrder;
    private String description;
    private boolean enable;
    
    // ui fields
    private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}

	public int getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(int resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Resource{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", code='" + code + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", uri='" + uri + '\'' +
                ", isMenu=" + isMenu +
                ", resourceOrder=" + resourceOrder +
                ", description='" + description + '\'' +
                ", enable=" + enable +
                '}';
	}
    
    
}
