<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>欢迎进入主页面</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	img{
		width:100%;
		height:100%;
		cursor:pointer;
	}
	.download{
		font-weight:bolder;
	}
	.mainJPG{
		margin:80px auto;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="login.html">SummerMain</a>
			</div>			
			<div>
				<ul class="nav navbar-nav">
					<li><a href="Mangermain.jsp">首页</a></li>
					<li><a href="userManger.jsp" class="download" >用户管理</a></li>
					<li><a href="classManger.jsp" class="download" >课程管理</a></li>	
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mainJPG">
   		<div class="jumbotron">
	        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607421092395&di=75b78d788279d53ab89143384f5f7c0f&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-11-24%2F5a17812a08ef0.jpg" title="主页面图片">
   		</div>
	</div>

</body>
</html>