<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<spring:url value="save" var="saveURL"></spring:url>
	<form:form  modelAttribute="BasicInfo" 
	  method="POST"  enctype="multipart/form-data"
	                         action="save"    >
     	<form :errors path="*"/>
	<form:input path="id" />
		<table  >
			<tr>
				   <td>firstName</td>
			        <td><form:input path="firstName"/></td>
			</tr>
			<tr>
			      	<td>lastName</td>
				   <td><form:input path="lastName"/></td>
			</tr>
			<tr>
				    <td>DOB</td>
				    <td><form:input  path="DOB" /></td>
			</tr>
				<tr>
				      <td>email</td>
			      	<td><form:input path="email"/></td>
			</tr>
			 	<tr>
				    <td>contact</td>
				     <td><form:input path="contact"/></td>
			</tr>
			<tr>
				    <td>city</td>
				     <td><form:input path="city"/></td>
			</tr>
			<tr>
				     <td>address</td>
				     <td><form:input path="address"/></td>
			</tr>
			<tr>
				    <td>DOJ</td>
				     <td><form:input path="DOJ"/></td>
			</tr>
			<tr>
			           <td>Designation :</td>
				       <td><form:select path="designation_id"  items="${ Designation}"  itemValue="Designationid" itemLabel="title" > 
				       </form:select>  </td>
          </tr>
			
			<tr>
			           <td>Department :</td>
				       <td><form:select path="department_id"  items="${ Department}"  itemValue= "departmentId"  itemLabel="title" >
				       </form:select>   </td>
           	</tr>
           	
           	  	
           	<tr>
           	<td><h4>Upload Documents</h4></td>
			<tr>
           	
           	<tr>
            <td>Upload Addhar</td>
            <td><input type="file" name="files"  path="path"/></td>
        </tr>
           	
           	<tr>
            <td>Upload Marksheet</td>
            <td><input type="file" name="files"  path="path" /></td>
        </tr>
        
        <td><input type="submit" value=Save></td>
      
		</table>
		
	</form:form>
	
</body>
</html>