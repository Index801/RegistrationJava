<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="stylesheet/bootstrap.min.css">
 <script src="js/jquery-1.9.1.js"></script>
<title>User-List</title>
</head>
<body>
<div class="container">
	<div id="form">      
  <table class="table table-condensed">
	  <thead>
	      <tr>
	      	<th>status</th>
	        <th>firstnameua</th>
	        <th>surnameua</th>
	        <th>patronymicua</th>
	        <th>email</th>
	        <th></th>     
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach items="${users}" var="user">
	      <tr>
	       	<td><input type="checkbox" name="status" ${user.status ? "checked" : ""}/></td>
	        <td>${user.firstnameua}</td>
	        <td>${user.surnameua}</td>
	        <td>${user.patronymicua}</td>
	        <td>${user.email}</td>
	        <td><button><a href="EditUser?&id=${user.user_id}">Edit</a></button></td>
	       
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
  </div>
</div>
</body>
</html>