package com.employeeregistration.model;

public class Attachment {
	 private Integer id;
     private Integer  basicinfo_id;
	 private String name;
	 private String path;
	 
	 
	 
	 public int getBasicinfo_id() {
		return basicinfo_id;
	}
	public void setBasicinfo_id(int basicinfo_id) {
		this.basicinfo_id = basicinfo_id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String type) {
		this.name = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	 

}
