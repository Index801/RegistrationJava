
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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
			<a href="User" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>Admin</b></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Admin</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top"></nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- search form -->
				<form action="UserSearch" method="post" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="search" class="form-control"
							placeholder="Search by email..."> <span
							class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<ul class="sidebar-menu">
					<li class="treeview active"><a href="#"> <i
							class="fa fa-book"></i> <span>Department</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu menu-open" style="display: block;">
							<c:forEach items="${departments}" var="department">
								<li><a href="DepartmentSearch?id=${department.id}"><i
										class="fa fa-circle-o"></i>${department.name}</a></li>
							</c:forEach>

						</ul></li>
				</ul>

			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">
				<divclass"row">
					<div class="col-md-12">
			<form action="EditUser" method="POST" class="form-horizontal" id="update-form">
				<div class="form-group">
					<label class="control-label col-xs-3">Имя:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control translit" name="firstname" value="${firstname}">
						<input type="hidden" name="user_id" value="${user_id}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Фамлия:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control translit" name="surname" value="${surname}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Отчество:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control translit" name="patronymic" value="${patronymic}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">ИмяLatin:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" name="firstnamelatin" value="${firstnamelatin}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">ФамлияLatin:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" name="surnamelatin" value="${surnamelatin}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">ОтчествоLatin:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" name="patronymiclatin" value="${patronymiclatin}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Password:</label>
					<div class="col-xs-9">
						<input type="password" class="form-control" name="password" value="${password}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Telephone:</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" name="phone" value="${phone}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Department:</label>
					<div class="col-xs-9">
						<select name="department" class="form-control">
							 <c:forEach items="${departments}" var="department">
					          	<option value="${department.id}">${department.name}</option>
					          </c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-3">Status:</label>
					<div class="col-xs-9">
						<select name="status" class="form-control">
							<option value="0">Выключен</option>
							<option value="1" ${status ? "selected" : ""}>Включен</option>
						</select>
					</div>
				</div>
				<div class="form-group reason">
					<label class="control-label col-xs-3">Причина:</label>
					<div class="col-xs-9">
						<select name="reason" class="form-control">
							<option value="Причина2">Причина2</option>
							<option value="Причина1" <c:if test="${user.reason eq Причина1}">selected</c:if>>Причина1</option>
						</select>
					</div>
				</div>
				<div class="form-group">
			    	<div class="col-xs-offset-3 col-xs-9">
			     		<input type="submit" class="btn btn-primary edit" value="Сохранить">
			     	</div>
			     </div>
			</form>
		</div>
			
		</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<footer class="main-footer"> </footer>
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
			<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
					class="fa fa-home"></i></a></li>
			<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
					class="fa fa-gears"></i></a></li>
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
		$(function() {
			$(".edit").on('click', function() {
				$.ajax({
					url : 'EditUser',
					type : 'post',
					data : $("#update-form").serialize(),
					dataType : 'json',
					success : function(json) {
						console.log(json);
					}
				});
			});
		});
		$(document).ready(function() {
			if ($("[name='status']").val() == '0') {
				$('.reason').css('display', 'block');
			} else {
				$('.reason').css('display', 'none');
			}
		});
		$(function() {
			$("[name='status']").on('change', function() {
				if ($(this).val() == '0') {
					$('.reason').css('display', 'block');
				} else {
					$('.reason').css('display', 'none');
				}
			});
		});
	</script>
</body>
</html>
