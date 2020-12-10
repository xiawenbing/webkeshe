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
				<a class="navbar-brand" href="login.html">SummerTeacherMain</a>
			</div>			
			<div>
				<ul class="nav navbar-nav">
					<li><a href="TeacherMain.jsp">首页</a></li>
					<li><a href="TeacherClass.jsp" class="download" >教师担任课程信息</a></li>
					<li><a href="Teacherclsaanum.jsp" class="download" >学生选课名单</a></li>	
					<li><a href="TeacherScore.jsp" class="download" >学生成绩管理</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mainJPG">
   		<div class="jumbotron">
	        <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607511171050&di=77a3b2e2012259fa90266603769433c0&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fbackgd%2Fcover%2F00%2F46%2F71%2F5bff37485b1d7.jpg%2521%2Ffw%2F780%2Fquality%2F90%2Funsharp%2Ftrue%2Fcompress%2Ftrue" title="主页面图片">
   		</div>
	</div>

</body>
</html>