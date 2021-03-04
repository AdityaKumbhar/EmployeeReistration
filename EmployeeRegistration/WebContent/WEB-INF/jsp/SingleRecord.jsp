<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
  height: 20%;
}

#customers td, #customers th {
  border: 1px solid #272D2A;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #46A5C7;}



#customers th {
  padding-top: 10px;
  padding-bottom: 10px;
  width:20%
  text-align: center;
  background-color: #F2B0B0;
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
<form >
<table   id="customers">

 		<c:forEach  var= "listemployee"  items="${listemployee}">
 			
          <tr ><th> ID</th><td >${listemployee.id}</td></tr>
          <tr>	<th> firstName</th><td >${listemployee.firstName}</td></tr>
      <tr><th> lastName</th><td >${listemployee.lastName}</td></tr>
 	  <tr>	<th> DOB</th>	<td >${listemployee.DOB}</td></tr>
 	  <tr><th> email</th>	<td >${listemployee.email}</td></tr>
 	  <tr><th> contact</th><td>${listemployee.contact}</td></tr>
 	  <tr><th> city</th>	<td  >${listemployee.city}</td></tr>
 	   <tr>	<th> address</th><td  >${listemployee.address}</td></tr>
 		<tr><th> DOJ</th><td >${listemployee.DOJ}</td></tr>
 		<tr><th> department_id</th><td >${listemployee.department_id}</td></tr>
 			
 		
 		</c:forEach>
 	</table>
 
</form>
</body>
</html>