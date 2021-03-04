package com.employeeregistration.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.employeeregistration.dao.EmployeeRegistrationDao;
import com.employeeregistration.model.Attachment;
import com.employeeregistration.model.BasicInfo;
import com.employeeregistration.model.Department;
import com.employeeregistration.model.Designation;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

@Controller
public class EmployeeRegistrationController {
static{
	System.out.println("Enter In Controller");
}
	@Autowired
	private EmployeeRegistrationDao dao;
	///
	  private final static Logger log = LoggerFactory.getLogger(EmployeeRegistrationController.class);

	   @Autowired
	    private HttpServletRequest request;

//-----------------------------------------------------FORM------------------------------
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView addnewStudent (ModelAndView model)
	{
		System.out.println("enter in addnewEmp()");
		BasicInfo basic=new BasicInfo();
		Attachment attachment=new Attachment();
       	model.addObject("BasicInfo", basic);
       		model.setViewName("Form");
		
		return model;
	}
	
//================================Save========================
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveContact(@RequestParam("files")  MultipartFile  file,   Model map, @ModelAttribute  BasicInfo basicinfo)
	{
		 Attachment attachment=new Attachment();
		 if (!file.isEmpty()) {
			 try {
                 String uploadsDir = "/uploads/";
                 String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                 System.out.println("realPathtoUploads= "+realPathtoUploads);
                 if(! new File(realPathtoUploads).exists())
                	 System.out.println(file);
                 {
                     new File(realPathtoUploads).mkdir();
                 }
                log.info("realPathtoUploads = {}"+realPathtoUploads);
                 String orgName = file.getOriginalFilename();
                 String filePath = realPathtoUploads + orgName;
                 File dest = new File(filePath);
                 file.transferTo(dest);
                 attachment.setPath(filePath);
                 attachment.setName(orgName);
       }
              catch (Exception e) {
	                return "You failed to upload " ;
	            }
 		}
   	dao.InsertBasicInfo(basicinfo);
 	   	dao.insertAttachment(attachment);
 	  
 	  	return "view";
       }//method

	//---------------------------------------------List---------------------------------------------------
@RequestMapping(value="/list1" ,method = RequestMethod.GET)
	public String List1(Model model ){
		System.out.println("In list ()");
		System.out.println(dao);
		List<BasicInfo> list = dao.listEmployees();
		System.out.println(list.size());
		model.addAttribute("listEmployee", list);

		return "Display";                                             
	}//list()

//-------------------------------------Designation drop box---------------------------------------------------------------
	@ModelAttribute("Designation")
	private List<Designation> getDesignation(){
		System.out.println("enter in designation()");
		List<Designation> listDesignation=dao.desglist();
		return  listDesignation;
	}
	
	//-------------------------------Department drop box-------------------------------------------------------------------
	@ModelAttribute("Department")
	private List<Department> getDepartments(){
		System.out.println("enter in department");
		List<Department> listDepartment=dao.departmentlist();
		return  listDepartment;
	}//department
	
//----------------------------------------------Update--------------------------------------------------------
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String editEmployee(Model model){

		   int id=Integer.parseInt(request.getParameter("id"));
	        BasicInfo basicInfo=dao.findEmployeeById(id);
	        
	        System.out.println("Edit Controller ");
	        System.out.println(basicInfo.getId());
	        System.out.println(basicInfo.getFirstName());
	        System.out.println(basicInfo.getLastName());
	        System.out.println(basicInfo.getDOB());
	        System.out.println(basicInfo.getCity());
	        System.out.println(basicInfo.getEmail());
	        System.out.println(basicInfo.getContact());
	        System.out.println(basicInfo.getAddress());
	        System.out.println(basicInfo.getDOJ());
	        System.out.println(basicInfo.getDesignation_id());
	        System.out.println(basicInfo.getDepartment_id());
		//	ModelAndView model = new ModelAndView("Display");
	        model.addAttribute("BasicInfo",basicInfo);
		//    model.addObject("BasicInfo", basicInfo);
		 request.setAttribute("BasicInformation", basicInfo);
		//	model.setViewName("EditForm");
		    return "Form";
       }//method
	
	//-----------------------------------------VIEW----------------------------------------------
	@RequestMapping(value="/view"  ,method=RequestMethod.GET)
	public String viewEmployee(Model model){

		  int id=Integer.parseInt(request.getParameter("id"));
	       BasicInfo basicInfo=dao.getEmployeeById(id);
	       System.out.println(basicInfo.getId());
	       System.out.println(basicInfo.getFirstName());
	       System.out.println(basicInfo.getLastName());
	       System.out.println(basicInfo.getDOB());
	       System.out.println(basicInfo.getEmail());
	       System.out.println(basicInfo.getContact());
	       System.out.println(basicInfo.getCity());
	       System.out.println(basicInfo.getAddress());
	       System.out.println(basicInfo.getDOJ());
	       System.out.println(basicInfo.getDesignation_id());
	       System.out.println(basicInfo.getDepartment_id());
           model.addAttribute("listemployee", basicInfo);
           
           return "SingleRecord";  
    }//editemployee

	//-------------------------------------delete------------------------------------------------
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(){
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("delete id="+id);
		dao.deleteEmployee(id);
			return "redirect:/list1";
	}//delete
	
}//class
