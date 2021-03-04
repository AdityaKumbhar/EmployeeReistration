package com.employeeregistration.dao;

import java.sql.SQLException;
import java.util.List;




import com.employeeregistration.model.Attachment;
import com.employeeregistration.model.BasicInfo;
import com.employeeregistration.model.Department;
import com.employeeregistration.model.Designation;


public interface EmployeeRegistrationDao {

	
	  public List<BasicInfo> listEmployees();
	  public void InsertBasicInfo(BasicInfo basicinfo);
	  public List<Designation> desglist() ;
	  public List<Department> departmentlist() ;
	  public void insertAttachment(Attachment attachment);
    
	  public BasicInfo findEmployeeById(int id);
      public void deleteEmployee(int id);
      public BasicInfo getEmployeeById(int id);

	
}
