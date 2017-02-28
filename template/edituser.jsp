<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="stylesheet/bootstrap.min.css">
<script src="js/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				<option value="1">Department1</option>
				<option value="2">Department2</option>
			</select>
		</div>
	</div>
	<div class="form-group">
    	<div class="col-xs-offset-3 col-xs-9">
     		<input type="submit" class="btn btn-primary edit" value="Регистрация">
     	</div>
     </div>
</form>
</div>
<script>
	$(function () {
		$(".edit").on('click', function() {
			$.ajax({
				url: 'EditUser',
				type: 'post',
				data: $("#update-form").serialize(),
				dataType: 'json',
				success: function(json) {
					console.log(json);
				}
			});
		});
		
	});
</script>
</body>
</html>