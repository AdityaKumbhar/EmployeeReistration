<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #272D2A;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #46A5C7;}



#customers th {
  padding-top: 10px;
  padding-bottom: 10px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}

#customers tr {
  padding-top: 10px;
  padding-bottom: 10px;
  text-align: center;
  
  color: black;
}
</style>
</head>
<body>
<input type="button" onclick="location.href='form';" value="Register Student" ></input>
<h1 style="color:#556AA2" text-align:center>All Employees Details</h1>
<form >
<table   id="customers">

 		<tr >
 			<th>Employee ID</th>
 			<th>Employee First Name</th>
 			<th>Employee Last Name</th>
 			<th>Employee DOB</th>
 			<th>Employee Email</th>
 			<th>Employee Contact</th>
 			<th>Employee City</th>
 			<th>Employee Address</th>
 			<th>Employee DOJ</th>
 			<th>Employee  Designation-id</th>
 			<th>Employee Department_id</th>
 			<th colspan="4">Action</th>
 			
 		</tr>
 		
 		<c:forEach  var= "listemployee"  items="${listEmployee}">
 			<tr >
 			<td >${listemployee.id}</td>
 			<td >${listemployee.firstName}</td>
 			<td >${listemployee.lastName}</td>
 			<td >${listemployee.DOB}</td>
 			<td >${listemployee.email}</td>
 			<td>${listemployee.contact}</td>
 			<td  >${listemployee.city}</td>
 			<td  >${listemployee.address}</td>
 			<td >${listemployee.DOJ}</td>
 			<td >${listemployee.designation_id}</td>
 			<td >${listemployee.department_id}</td>
 			
 	<%-- 	<td> <a href="update?id=${listemployee.id }">Edit</a></td>
 			   <td>     <a href="view?id=${listemployee.id }">View</a></td>
 			      <td>  <a href="delete?id=${listemployee.id }">Delete</a>
 			</td>
 		--%>	
 		<td>
 		<select name="form" onchange="location = this.value;" >
 		<option value="">--Choose--</option>
<option value="update?id=${listemployee.id }">Edit</option>
<option value="view?id=${listemployee.id }">View</option>
<option value="delete?id=${listemployee.id }">Delete</option>
</select>
       </td>

 			</tr>
 		</c:forEach>
 	</table>
 
</form>
</body>
</html>

  <td><form:select path="designation_id"  items="${ Designation}"  itemValue="Designationid" itemLabel="title" > 
				       </form:select>  </td>