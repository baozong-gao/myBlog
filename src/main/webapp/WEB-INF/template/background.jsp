<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高保宗的博客<sitemesh:write property='title' />
</title>
<style type='text/css'>
/* Some CSS */
body {
	font-family: 微软雅黑, 宋体;
	font-size: 62.5%;
	color: #000000;
	background-color: #FFFFFF;
}

* {
	margin: 0;
	padding: 0;
}

.background_div {
	margin: auto;
	width: 70%;
	border-style: solid;
	border-width: 0px 1px;
	border-color: #6AC25E;
}

.top_div {
	height: 56px;
}

.gps_div {
	height: 24px;
}

.disclaimer_div {
	height: 24px;
}

.central_div {
	height: 87%;
}

.logo_div {
	background-image: url(resources/image/logo.jpg); /*背景图片*/
	width: 180px;
	height: 100%;
	background-repeat: no-repeat; /*图片不重复，即不会填充div*/
	float: left;
	margin-top: 2px;
	margin-left: 2px;
	background-size: cover;
	-moz-background-size: cover; /*图片填充整个区域 */
	position: relative;
	background-size: cover;
}

.user_div {
	float: right;
	margin-bottom: 2px;
	margin-right: 5px;
}

</style>
<sitemesh:write property='head' />
</head>
<body>
	<div class='background_div'>
		<div class='top_div'>
			<dir class="logo_div"></dir>
			<div class="user_div">
				<div>
					<div style="display:inline;">
						<input type="text" value="用户名" />
					</div>
					<div style="display:inline;">
						<input type="checkbox">记住我
					</div>
				</div>
				<div >
					<div style="display:inline;">
						<input type="text" value="密码" />
					</div>
					<div style="display:inline;">
						<input type="button" value="登入">
					</div>
				</div>
			</div>
		</div>
		<div class='gps_div'></div>
		<div class='central_div'>
			<sitemesh:write property='body' />
		</div>
		<div class='disclaimer_div'>Site disclaimer. This is an example.</div>
	</div>

</body>
</html>
