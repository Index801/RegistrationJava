<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Registration Page</title>
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
  <!-- iCheck -->
  <link rel="stylesheet" href="js/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>
  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>
    <form action="Registration" method="post" id="registr-form">
      <div class="form-group has-feedback">
        <input type="text" class="form-control translit" placeholder="firstname" name="firstname">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control translit" placeholder="surname" name="surname">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control translit" placeholder="patronymic" name="patronymic">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="firstnamelatin" name="firstnamelatin">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="surnamelatin" name="surnamelatin">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="patronymiclatin" name="patronymiclatin">
      </div>
      <div class="row form-group">
      	<div class="col-xs-6">
        <input type="text" class="form-control" placeholder="Email" name="email">

         </div>
        <div class="col-xs-6">
        <div class="form-group">
                  <select class="form-control" name="domain">
                    <option value="@student.khai.edu">@student.khai.edu</option>
					<option value="@khai.edu">@khai.edu</option>
                  </select>
                </div>
        </div>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="phone" name="phone">
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" name="password">
      </div>
      <div class="form-group has-feedback">
        <select class="form-control" name="department">
        			<c:forEach items="${departments}" var="department">
                    	<option value="${department.id}">${department.name}</option>
                     </c:forEach>
        </select>
      </div>
      <div class="row">
        <div class="col-xs-8">
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="js/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="js/iCheck/icheck.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/common.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>






