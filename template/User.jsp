<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="stylesheet/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheet/userlist.css">
 <script src="js/jquery-1.9.1.js"></script>
 <script src="js/bootstrap.js"></script>
 
<title>User-List</title>
</head>
<body>
	<div class="row affix-row">
		<div class="col-sm-3 col-md-2 affix-sidebar">
				<div class="sidebar-nav">
		  <div class="navbar navbar-default" role="navigation">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
		      <span class="sr-only">Toggle navigation</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      </button>
		      <span class="visible-xs navbar-brand">Sidebar menu</span>
		    </div>
		    <div class="navbar-collapse collapse sidebar-navbar-collapse">
		      <ul class="nav navbar-nav" id="sidenav01">
		        <li class="active">
		          <a href="#" data-toggle="collapse" data-target="#toggleDemo0" data-parent="#sidenav01" class="collapsed">
		          <h4>
		          Control Panel
		          <br>
		          <small>IOSDSV <span class="caret"></span></small>
		          </h4>
		          </a>
		          <div class="collapse" id="toggleDemo0" style="height: 0px;">
		            <ul class="nav nav-list">
		              <li><a href="#">ProfileSubMenu1</a></li>
		              <li><a href="#">ProfileSubMenu2</a></li>
		              <li><a href="#">ProfileSubMenu3</a></li>
		            </ul>
		          </div>
		        </li>
		        <li>
		          <a href="#" data-toggle="collapse" data-target="#toggleDemo" data-parent="#sidenav01" class="collapsed">
		          <span class="glyphicon glyphicon-cloud"></span> Submenu 1 <span class="caret pull-right"></span>
		          </a>
		          <div class="collapse" id="toggleDemo" style="height: 0px;">
		            <ul class="nav nav-list">
		              <li><a href="#">Submenu1.1</a></li>
		              <li><a href="#">Submenu1.2</a></li>
		              <li><a href="#">Submenu1.3</a></li>
		            </ul>
		          </div>
		        </li>
		        <li class="active">
		          <a href="#" data-toggle="collapse" data-target="#toggleDemo2" data-parent="#sidenav01" class="collapsed">
		          <span class="glyphicon glyphicon-inbox"></span> Submenu 2 <span class="caret pull-right"></span>
		          </a>
		          <div class="collapse" id="toggleDemo2" style="height: 0px;">
		            <ul class="nav nav-list">
		              <li><a href="#">Submenu2.1</a></li>
		              <li><a href="#">Submenu2.2</a></li>
		              <li><a href="#">Submenu2.3</a></li>
		            </ul>
		          </div>
		        </li>
		        <li><a href=""><span class="glyphicon glyphicon-cog"></span> PreferencesMenu</a></li>
		      </ul>
		      </div><!--/.nav-collapse -->
		    </div>
		  </div>
		</div>
		<div class="col-sm-9 col-md-10 affix-content">
			<div class="container-fluid">
	  		<table class="table table-condensed">
			  <thead>
			      <tr>
			      	<th>status</th>
			        <th>firstnameua</th>
			        <th>surnameua</th>
			        <th>patronymicua</th>
			        <th>email</th>
			        <th></th>  
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach items="${users}" var="user">
			      <tr class="${user.user_id}">
			       	<td><input type="checkbox" name="status" value="${user.status ? "1" : "0"}" ${user.status ? "checked" : ""} data-id="${user.user_id}"/></td>
			        <td>${user.firstnameua}</td>
			        <td>${user.surnameua}</td>
			        <td>${user.patronymicua}</td>
			        <td>${user.email}</td>
			        <td><a href="#" onclick="remove(${user.user_id})">Remove</a></td>
			        <td><a href="EditUser?&id=${user.user_id}">Edit</a></td>
			       
			      </tr>
			      </c:forEach>
			    </tbody>
			</table>
			</div>
	  </div>
  </div>
<script>
	$(function () {
		$("[name='status']").on('click', function() {
			$.ajax({
				url: 'User',
				type: 'post',
				data: 'user_id='+$(this).data('id')+'&status='+$(this).val(),
				dataType: 'json',
				success: function() {
				}
			});
			if($(this).val() == '1') {
				$(this).val('0');
			} else {
				$(this).val('1');
			}
		});
		
	});
	function remove(user_id) {
		$('.'+user_id).css('display', 'none');
		$.ajax({
			url: 'User',
			type: 'post',
			data: 'user_id='+user_id+'&remove=1',
			dataType: 'json',
			success: function() {
				
			}
		});
	}
</script>
</body>
</html>