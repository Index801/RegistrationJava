<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="stylesheet/bootstrap.min.css">
 <script src="js/jquery-1.9.1.js"></script>
 <script src="js/jquery.validate.min.js"></script>
 <script src="js/common.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
${error}
<div class="container">
<h3 class="form-title">Registration</h3>
<form action="Registration" method="POST" class="form-horizontal" id="registr-form">
	<div class="form-group">
		<label class="control-label col-xs-3">Имя:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control translit" name="firstname">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Фамлия:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control translit" name="surname">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Отчество:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control translit" name="patronymic">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">ИмяLatin:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control" name="firstnamelatin">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">ФамлияLatin:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control" name="surnamelatin">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">ОтчествоLatin:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control" name="patronymiclatin">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Email:</label>
		<div class="col-xs-6">
			<input type="text" class="form-control"  name="email">
		</div>
		<div class="col-xs-3">
			<select name="domain" class="form-control">
				<option value="@student.khai.edu">@student.khai.edu</option>
				<option value="@khai.edu">@khai.edu</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Password:</label>
		<div class="col-xs-9">
			<input type="password" class="form-control" name="password">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Telephone:</label>
		<div class="col-xs-9">
			<input type="text" class="form-control" name="phone">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-xs-3">Department:</label>
		<div class="col-xs-9">
			<select name="department" class="form-control">
				<option value="Department1">Department1</option>
				<option value="Department2">Department2</option>
			</select>
		</div>
	</div>
	<div class="form-group">
    	<div class="col-xs-offset-3 col-xs-9">
     		<input type="submit" class="btn btn-primary" value="Регистрация">
     	</div>
     </div>
</form>
</div>
</body>
</html>