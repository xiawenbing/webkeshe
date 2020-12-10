<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>学生选课页面</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/userManger.js"></script>
    <script src="js/register.js"></script>
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
				<a class="navbar-brand" href="login.html">SummerStudentMain</a>
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
             <input type="text" id="sSNO" name="SNO" placeholder="输入学籍号..."/>
             <input type="text" id="suserName" name="userName" placeholder="输入用户名..."/>  
        </form>
        <div id="bt">
            <a href="#" id="btSearch" class="btn btn-primary">查找</a>
        </div>
    </div>

    <table>
        <thead>
        <tr>
            <th width="40"><input type="checkbox" id="ckAll" title="选择"/></th>
            <th width="100" id="sortByUserName" data="SNO">学籍号</th>
            <th width="110">用户名</th>
            <th width="100">密码</th>
            <th width="100">权限</th>
            <th width="150">操作</th>
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
        <span class="titleRegister">更改用户信息</span>
        <span class="titleLogin"><a href="login.html">重新登录</a></span>
    </div>
    <form id="registerForm">
        <p><input id="usepassword" name="usepassword" type="password" placeholder="原密码" />
            <span class="auth_err" id="usepasswordError"></span>
        
        <p><input id="password" name="password" type="password" placeholder="密码" />
            <span class="auth_err" id="passwordError"></span>
        </p>
        <p><input id="password1" name="password1" type="password" placeholder="确认密码" />
            <span class="auth_err" id="password1Error"></span>
        </p>
        <p>
            <input id="btLogin" type="button" value="提&nbsp;&nbsp;交" />
            <span class="auth_err" id="checkError"></span>
        </p>
    </form>
		</div><!--  #loginForm -->

</body>
</html>