<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
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
</style>
<sitemesh:write property='head' />
</head>
<body>
	<div class='background_div'>
		<div>
			<sitemesh:write property='body' />
		</div>
		<div class='disclaimer'>Site disclaimer. This is an example.</div>
	</div>

</body>
</html>
