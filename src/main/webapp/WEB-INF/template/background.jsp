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
<script type="text/javascript">
function faster_login() {
	var user_id = document.getElementById("user_id").value;
	var pass = document.getElementById("passwd").value;
	var url = getRootPath()+"/login";
	ajax(url,user_id,pass);
	
}
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}
function ajax(url, user_id, pass){
    //1.创建对象
    var oAjax = null;
    if(window.XMLHttpRequest){
        oAjax = new XMLHttpRequest();
    }else{
        oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }
      
    //2.连接服务器  
    oAjax.open('post', url, true);   //open(方法, url, 是否异步)
      
    // 使用post提交时必须加上下面这行代码
    oAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    
    // 向服务器发出一个请求
    oAjax.send("user_id=" + user_id + "&pass=" + pass);  
      
    //4.接收返回
    oAjax.onreadystatechange = function(){  //OnReadyStateChange事件
        if(oAjax.readyState == 4){  //4为完成
            if(oAjax.status == 200){    //200为成功
            	alert(oAjax.responseText);
                alert("成功");
            }else{
                alert("失败");
            }
        }
    };
}
</script>

<sitemesh:write property='head' />
</head>
<body>
	<div class='background_div'>
		<div class='top_div'>
			<dir class="logo_div"></dir>
			<div class="user_div">
				<div>
					<div style="display:inline;">
						<input type="text" value="用户名" id="user_id"/>
					</div>
					<div style="display:inline;">
						<input type="checkbox">记住我
					</div>
				</div>
				<div >
					<div style="display:inline;">
						<input type="text" value="密码"  id="passwd"/>
					</div>
					<div style="display:inline;">
						<input type="button" value="登入" onclick="faster_login()">
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
