<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="js/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="js/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="User" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>Admin</b></span>	
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">      
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- search form -->
      <form action="UserSearch" method="post" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="search" class="form-control" placeholder="Search by email...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <ul class="sidebar-menu">
        <li class="treeview active">
          <a href="#">
            <i class="fa fa-book"></i> <span>Department</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu menu-open" style="display: block;">
          <c:forEach items="${departments}" var="department">
          	<li><a href="DepartmentSearch?id=${department.id}"><i class="fa fa-circle-o"></i>${department.name}</a></li>
           </c:forEach>
            
          </ul>
        </li>
      </ul>
      
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
		<table class="table table-condensed">
			  <thead>
			      <tr>
			      	<th></th>
			        <th>firstnameua</th>
			        <th>surnameua</th>
			        <th>patronymicua</th>
			        <th>email</th>
			        <th><input type="button" value="Disable" class="disable btn btn-info btn-xs"></th>  
			        <th><input type="button" value="remove" class="remove btn btn-danger btn-xs"></th>
			      </tr>
			    </thead>
			    <tbody>
			    <form method="post" action="#" id="form">
			    <c:forEach items="${users}" var="user">
			      <tr class="${user.user_id}">
			       	<td><input type="checkbox" name="user_check"  ${user.status ? "checked" : ""} value="${user.user_id}"/></td>
			        <td>${user.firstnameua}</td>
			        <td>${user.surnameua}</td>
			        <td>${user.patronymicua}</td>
			        <td>${user.email}</td>
			        <td><a href="EditUser?&id=${user.user_id}"><i class="fa fa-edit"></i></a></td>
			        <td><a href="#" onclick="remove(${user.user_id})"><i class="fa fa-fw fa-remove"></i></a></td>        
			      </tr>
			     </c:forEach>
			    </form>
			    </tbody>
			</table>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">

  </footer>
  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
   </ul>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="js/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="js/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="js/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/dist/js/demo.js"></script>
<script>
	$(function () {
		$(".disable").on('click', function() {
	
			$.ajax({
				url: 'DisableUser',
				type: 'post',
				data: $("#form").serialize(),
				dataType: 'json',
				success: function() {
				}
			});
		});
		
		$(".remove").on('click', function() {
			
			$.ajax({
				url: 'DeleteUser',
				type: 'post',
				data: $("#form").serialize(),
				dataType: 'json',
				complete: function() {
					location.reload();
				},
				success: function(result) {
					
				}
			});
		});	
	});
	function remove(user_id) {
		$('.'+user_id).css('display', 'none');
		$.ajax({
			url: 'DeleteUser',
			type: 'get',
			data: 'user_id='+user_id,
			dataType: 'json',
			complete: function() {
				location.reload();
			},
			success: function() {
				
			}
		});
	}
</script>
</body>
</html>
