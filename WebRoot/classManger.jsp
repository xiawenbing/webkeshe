<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>学生选课页面</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/classManger.js"></script>
    <link href="css/userManager.css" rel="stylesheet">
    <link href="css/bgmanger.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
            .download{
		font-weight:bolder;
	}
	.user{
		margin-top:12px;
		margin-right:80px;
	}
	a{
		cursor:pointer;
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

<div id="pageBody">
    <div id="search">
        <form id="searchForm">
            <input type="text" id="sCNO" name="CNO" placeholder="输入课程号..."/>
             <input type="text" id="sCName" name="CName" placeholder="输入课程名..."/>
        </form>
        <div id="bt">
            <a href="#" id="btSearch" class="btn btn-primary">查找</a>
            <a href="#" id="btAdd" class="btn btn-info">新增课程</a>
        </div>
    </div>

    <table>
        <thead>
        <tr>
            <th width="40"><input type="checkbox" id="ckAll" title="选择"/></th>
            <th width="100" id="sortByUserName" data="CNO">课程号</th>
            <th width="110">课程名</th>
            <th width="100">学分</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>

    <div id="paging">
        <div class="pageSize">每页
            <select id="pageSize">
                <option selected>5</option>
                <option>10</option>
                <option>20</option>
            </select>条数据，共
            <span id="total"></span>条数据，
              <span id="pageNumber">1</span>页/<span id="pageCount"></span>页
        </div>
        <div id="pageNav">
            <a id="first" href="#">首页</a>
            <a id="back" href="#">上一页</a>
            <a id="next" href="#">下一页</a>
            <a id="last" href="#">尾页</a>
        </div>
    </div>
</div>
</body>
<!-- 遮罩层 -->
	<div id="fade" class="black_overlay" onclick="CloseDiv()"></div>
	<!-- 新增界面 -->
	<div id="MyDiv" class="white_content">
		<!-- 关闭按钮x -->
		<div style="text-align: right; margin-left: 5px; height: 20px;">
			<span id="xBtn" title="点击关闭" onclick="CloseDiv('MyDiv','fade')">x</span>
		</div>
		<!-- 内部新增界面 -->
		   <div id="loginForm">
			 <div class="title">
				<span class="titleSignUp"></span>
			</div>
			<form id="registerForm">
			    <p>
					<input id="CNO" type="text" name="CNO"
						placeholder="Enter CNO..." /> <span class="errSpan"
						id="CNOError"></span>
				</p>
				<p>
					<input id="CName" type="text" name="CName"
						placeholder="Enter CName..." /> <span class="errSpan"
						id="CNameError"></span>
				</p>
				<p>
					<input type="text" id="Point" name="Point"
						placeholder="Enter Point..." /> <span class="errSpan"
						id="chrNameError"></span>
				</p>
				<p>
                <input id="btLogin" type="button" value="提&nbsp;&nbsp;交 " />
                 <span class="auth_err" id="checkError"></span>
                </p>	
			</form>
		</div><!--  #loginForm -->
	</div>	
</html>