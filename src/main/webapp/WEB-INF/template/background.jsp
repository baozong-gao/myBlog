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
	width: 100%;
	height: 100%;
	background-repeat: no-repeat; /*图片不重复，即不会填充div*/
	margin: auto auto; /*居中*/
	background-size: cover;
	-moz-background-size: cover; /*图片填充整个区域 */
	position: relative;
}
</style>
<sitemesh:write property='head' />
</head>
<body>
	<div class='background_div'>
		<div class='top_div'>
			<dir class="logo_div"></dir>
		</div>
		<div class='gps_div'></div>
		<div class='central_div'>
			<sitemesh:write property='body' />
		</div>
		<div class='disclaimer_div'>Site disclaimer. This is an example.</div>
	</div>

</body>
</html>
