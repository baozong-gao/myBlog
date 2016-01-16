<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/resources/image/icon.png">
<title>登入</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
      <form class="form-signin" action="login">
        <h2 class="form-signin-heading">登入系统</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="user_id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="passwd" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
      </form>
    </div>
  </body>
</html>