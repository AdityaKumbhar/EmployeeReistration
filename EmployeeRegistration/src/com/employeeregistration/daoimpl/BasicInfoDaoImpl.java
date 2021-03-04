package com.employeeregistration.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employeeregistration.dao.EmployeeRegistrationDao;
import com.employeeregistration.model.Attachment;
import com.employeeregistration.model.BasicInfo;
import com.employeeregistration.model.Department;
import com.employeeregistration.model.Designation;
import com.mysql.cj.xdevapi.Statement;



@Repository("dao")
@Transactional
public class BasicInfoDaoImpl implements EmployeeRegistrationDao {

	
	static 	int result=0;
	private static final String SELECT_QUERY_ALL_RECORD="SELECT  * FROM BASICINFO ";
    private static final String INSERT_QUERY="INSERT INTO BASICINFO(FirstName,LastName,DOB,Email,Contact,City,Address,DOJ,designation_id,department_id)values(?,?,  ?,?, ?,?,  ?,?  ,?,?)";
    private static final String  ATTACHMENT_INSERT_QUERY="INSERT INTO ATTACHMENT values(?,?,?,?)";
	private static final String DESG_SELECT_QUERY="SELECT * FROM DESIGNATION";
	private static final String DEPT_SELECT_QUERY="SELECT * FROM DEPARTMENT";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//------------------------------------------------LIST-----------------------------------------------------------------
	@Override
	public List<BasicInfo> listEmployees() {
		System.out.println("list emp method");
		
		List<BasicInfo> listContact = jdbcTemplate.query(SELECT_QUERY_ALL_RECORD, new RowMapper<BasicInfo>() 
				{
			
				public BasicInfo mapRow(ResultSet rs, int rowNum)throws SQLException {
					
					BasicInfo basic= new BasicInfo();
					basic.setId(rs.getInt("id"));
					basic.setFirstName(rs.getString("firstName"));
					basic.setLastName(rs.getString("LastName"));
					basic.setDOB(rs.getString("DOB"));
					basic.setEmail(rs.getString("email"));
					basic.setContact(rs.getString("contact"));
					basic.setCity(rs.getString("city"));
					basic.setAddress(rs.getString("address"));
					basic.setDOJ(rs.getString("DOJ"));
					
					basic.setDesignation_id(rs.getInt("designation_id"));
					basic.setDepartment_id(rs.getInt("department_id"));
				
					return basic;
				}
			});
		
		return listContact;
		
	}//listStudents() 
	
	//---------------------------------------------Insert-----------------------------------------------------------------------
	@Override
	public void InsertBasicInfo(BasicInfo basicinfo){
		System.out.println("enter in basicinfo method dao");
		if( basicinfo.getId()>0)
		{
			System.out.println("updatew query"+basicinfo.getId());
			/////////////UPDATEStudentName
			String UPDATE_QUERY="Update basicinfo set firstName=?,lastName=?,DOB=?,email=?,contact=?,city=?,address=?,DOJ=?,Designation_id=?,Department_id=? where id=?;";
			 jdbcTemplate.update(UPDATE_QUERY, basicinfo.getFirstName(),basicinfo.getLastName(),basicinfo.getDOB(),basicinfo.getEmail(),basicinfo.getContact(),basicinfo.getCity(),basicinfo.getAddress(),basicinfo.getDOJ(),basicinfo.getDesignation_id(),basicinfo.getDepartment_id(),basicinfo.getId());
	System.out.println("record updated");
		}
		
		else if(basicinfo.getId()==0){
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        int row= this.jdbcTemplate.update(new PreparedStatementCreator(){
	            public PreparedStatement createPreparedStatement(Connection connection)
	                throws SQLException {
	                PreparedStatement ps =connection.prepareStatement(INSERT_QUERY,java.sql.Statement.RETURN_GENERATED_KEYS);
	                ps.setString(1, basicinfo.getFirstName());
	                ps.setString(2, basicinfo.getLastName());
	                ps.setString(3, basicinfo.getDOB());
	                ps.setString(4,   basicinfo.getEmail());
	                ps.setString(5,basicinfo.getContact ());
	                ps.setString(6,basicinfo.getCity ());
	                ps.setString(7,basicinfo.getAddress ());
	                ps.setString(8,basicinfo.getDOJ());
	                ps.setInt(9,basicinfo.getDepartment_id ());
	                ps.setInt(10, basicinfo.getDesignation_id());
	                
	                return ps;
	            }
	        },keyHolder);

	        if (row > 0)
	            result = keyHolder.getKey().intValue();
		System.out.println("key=="+result);
		}
	}//InsertBasicInfo()
	
	
	//--------------------------------------------------------insertAttachment------------------------------
	@Override
	public void insertAttachment(Attachment attachment) {
		System.out.println("enter in insert attachment() dao");
		/*
		jdbcTemplate.update(ATTACHMENT_INSERT_QUERY,result,attachment.getName(),attachment.getPath());
		*/
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection)
			            throws SQLException {

			            PreparedStatement ps = connection.prepareStatement(ATTACHMENT_INSERT_QUERY);
			          
			            ps.setInt(1, 0);
			            ps.setInt(2, result);
			            ps.setString(3, attachment.getName());
			           ps.setString(4, attachment.getPath());
			          
			            return ps;
			        }
			    });
  	}
	
	//----------------------------------------Designation for drop box--------------------------------------------------
	@Override
	  public List<Designation> desglist() {
		System.out.println("enter in desglist() dao");
		List<Designation> listDesignation = jdbcTemplate.query(DESG_SELECT_QUERY, new RowMapper<Designation>() 
				{
			
				public Designation mapRow(ResultSet rs, int rowNum)throws SQLException {
					Designation designation= new Designation();
					designation.setId(rs.getInt("id"));
		             designation.setTitle(rs.getString("Title"));
		             
		             return designation;
				}//maprow
			});
		
		return listDesignation;
		  
	  }//desglist()
	     
	//--------------------------------------------Department-------------------------------------------------------
	@Override
	  public List<Department> departmentlist() {
		System.out.println("enter in deptlist() dao");
		List<Department> listDepartment = jdbcTemplate.query(DEPT_SELECT_QUERY, new RowMapper<Department>() 
				{
				public Department mapRow(ResultSet rs, int rowNum)throws SQLException {
					Department department= new Department();
					department.setId(rs.getInt("id"));
					department.setTitle(rs.getString("Title"));
		             
		             return department;
				}//maprow
			});
		
		return listDepartment;
	  }//desglist()

	//-----------------------------------------------------------Edit-----------------------------------
@Override
	public BasicInfo findEmployeeById(int id){
	String SELECT_QUERY="Select * from basicinfo where id="+id;
	System.out.println(" findEmployeeById start"+id);
	return(BasicInfo)jdbcTemplate.query(SELECT_QUERY, new ResultSetExtractor<BasicInfo>(){
		
		@Override
        public BasicInfo extractData(ResultSet rs) throws SQLException,DataAccessException {
			System.out.println(" extractData start");
            if (rs.next()) {
            	BasicInfo basicInfo = new BasicInfo();
            	basicInfo.setId(rs.getInt(1));
            	basicInfo.setFirstName(rs.getString(2));
            	basicInfo.setLastName(rs.getString(3));
            	basicInfo.setDOB(rs.getString(4));
            	basicInfo.setEmail(rs.getString(5));
            	basicInfo.setContact(rs.getString(6));
            	basicInfo.setCity(rs.getString(7));
            	basicInfo.setAddress(rs.getString(8));
            	basicInfo.setDOJ(rs.getString(9));
            	basicInfo.setDesignation_id(rs.getInt(10));
            	basicInfo.setDepartment_id(rs.getInt(11));
            	
            	
                return basicInfo;
            }//if
                return null;
        }// extractData()
 });//ResultSetExtractor()
}// findStudentById()
	

//---------------------------------------------------VIEW-----------------------------------------------------------------
@Override
public BasicInfo getEmployeeById(int id) {
	
	String SELECT_QUERY="Select * from basicinfo where id="+id;
	System.out.println(" findEmployeeById start"+id);
	return(BasicInfo)jdbcTemplate.query(SELECT_QUERY, new ResultSetExtractor<BasicInfo>(){
		
		@Override
        public BasicInfo extractData(ResultSet rs) throws SQLException,DataAccessException {
			System.out.println(" extractData start");
            if (rs.next()) {
            	BasicInfo basicInfo = new BasicInfo();
            	basicInfo.setId(rs.getInt(1));
            	basicInfo.setFirstName(rs.getString(2));
            	basicInfo.setLastName(rs.getString(3));
            	basicInfo.setDOB(rs.getString(4));
            	basicInfo.setEmail(rs.getString(5));
            	basicInfo.setContact(rs.getString(6));
            	basicInfo.setCity(rs.getString(7));
            	basicInfo.setAddress(rs.getString(8));
            	basicInfo.setDOJ(rs.getString(9));
            	basicInfo.setDesignation_id(rs.getInt(10));
            	basicInfo.setDepartment_id(rs.getInt(11));
            	
            	
                return basicInfo;
            }//if
                return null;
        }// extractData()
 });//ResultSetExtractor()  
	
	
}

//----------------------------------------DELETE----------------------------------------------
	 public void deleteEmployee(int id){
			String DELETE_QUERY="Delete from basicinfo  where id="+id;
			System.out.println(" deleteEmployee start"+id);
		 jdbcTemplate.update(DELETE_QUERY);
	 }//delete method



	

}//class
/*
//--------------------------------------UPDATE-------------------------------------
	@Override
	 public void updateEmployee(BasicInfo basicinfo){
		String UPDATE_QUERY="Update basicinfo set firstName=?,lastName=?,DOB=?,email=?,contact=?,city=?,address=?,DOJ=?,DesignationId=?,DepartmentId=? where id=?;";
	 jdbcTemplate.update(UPDATE_QUERY, basicinfo.getFirstName(),basicinfo.getLastName(),basicinfo.getDOB(),basicinfo.getEmail(),basicinfo.getContact(),basicinfo.getCity(),basicinfo.getAddress(),basicinfo.getDOJ(),basicinfo.getDesignation_id(),basicinfo.getDepartment_id());
	System.out.println(" updateEmployee start"+basicinfo);
	
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection)
			            throws SQLException {
			        	System.out.println(" createPreparedStatement start");
			            PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			          
			            ps.setString(1,  basicinfo.getFirstName());
			            ps.setString(2,basicinfo.getLastName());
			            ps.setString(3,basicinfo.getDOB());
			           ps.setString(4, basicinfo.getEmail());
			           ps.setString(5, basicinfo.getContact());
			           ps.setString(6, basicinfo.getCity());
			           ps.setString(7, basicinfo.getAddress());
			           ps.setString(8, basicinfo.getDOJ());
			           ps.setInt(9, basicinfo.getDesignation_id());
			           ps.setInt(10,basicinfo.getDepartment_id());
			          
			            return ps;
			        }
			    });
	*/
	
//	}//update
		
