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
	body {
    background-image: url(../images/bgmain.jpg);
    font-size: 14px;
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
					<li><a href="main.jsp">首页</a></li>
					<li><a href="StudentCC.jsp" class="download" >学生选课</a></li>
					<li><a href="StudentTC.jsp" class="download" >学生退课</a></li>
					<li><a href="AllClass.jsp" class="download">课表查询</a></li>
					<li><a href="Score.jsp" class="download">成绩统计</a></li>
					<li><a href="register.jsp"class="download">修改密码</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mainJPG">
   		<div class="jumbotron">
	        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600940536860&di=0571eab7f15ba71ee2054fae5477f8e3&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F00%2F09%2F87%2F315630832fad803.jpg" title="主页面图片">
   		</div>
	</div>

</body>
</html>