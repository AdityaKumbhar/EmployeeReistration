package com.employeeregistration.model;

//import java.sql.Date;

public class BasicInfo {
	

	 private int  id;

	 private  String firstName;

	 private  String lastName;

	 private  String DOB;

	 private String email;

	 private  String contact;

	 private  String city;

	 private  String address;

	 private  String DOJ;

	 private int designation_id;

	 private int department_id;
	 
	 static{
		 System.out.println("Basic info class");
	 }
		public void setId(int  id) {
		
			this.id = id;
		}
	 
	public int getId() {
	
		return id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String string) {
		this.email = string;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public int getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public int getDepartment_id() {
	
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

}

/*
 * 
 * 
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddItem() {
        ModelAndView model = new ModelAndView();
        List<Map<String, Object>> listCat = categoryRepository.viewCategoryList();
        model.addObject("listCat", listCat);
        return new ModelAndView("addItem", "command", new Item());
        */
