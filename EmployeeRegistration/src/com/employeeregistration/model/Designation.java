package com.employeeregistration.model;

public class Designation {
	
	private int id;
	private int Designationid;
	private String title;
	
	
	public int getDesignationid() {
		return Designationid;
 	}
	public void setDesignationid(int designationid) {
		Designationid = designationid;
	}
	public int getId() {
		return Designationid; 
	}
	public void setId(int id) {
		this.Designationid = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
