<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>学生成绩查询页面</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/TeacherScore.js"></script>
     <link href="css/userManager.css" rel="stylesheet">
     <link href="css/bgteacher.css" rel="stylesheet">
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
				<a class="navbar-brand" href="login.html">Performance Analysis</a>
			</div>			
			<div>
				<ul class="nav navbar-nav">
					<li><a href="TeacherMain.jsp">首页</a></li>
					<li><a href="TeacherClass.jsp" class="download" >教师担任课程信息</a></li>
					<li><a href="#" class="download" >学生选课名单</a></li>	
					<li><a href="TeacherScore.jsp" class="download" >学生成绩管理</a></li>
				</ul>
			</div>
		</div>
	</nav>

<div id="pageBody">
    <div id="search">
        <form id="searchForm">
            <input type="text" id="sSNO" name="SNO" placeholder="输入学号..."/>
            <input type="text" id="suserName" name="userName" placeholder="输入姓名..."/>
        </form>
        <div id="bt">
            <a href="#" id="btSearch" class="btn btn-primary">查找</a>
              <a href="#" id="btinsert" class="btn btn-info">添加学生成绩</a>
        </div>
    </div>

    <table>
        <thead>
        <tr>
            <th width="40"><input type="checkbox" id="ckAll" title="选择"/></th>
            <th width="100" id="sortByUserName" data="SNO">学号</th>
            <th width="110">姓名</th>
            <th width="100">课程号</th>
            <th width="100">课程名</th>
            <th width="100">成绩</th>
            <th width="100">操作</th>
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
			<h2 style="text-align: center;" id="formTitle">修改</h2>
                    <form id="registerForm">
                        <input id="action" name="action" type="text" hidden />
                         <p><input id="SNO" name="SNO" type="text" placeholder="学号" />
                            <span class="auth_err" id="SNOError"></span>
                        </p>
                        <p><input id="userName" name="userName" type="text" placeholder="用户名" />
                            <span class="auth_err" id="userNameError"></span>
                        </p>
                       
                        <p><input id="CNO" name="CNO" type="text" placeholder="课程号" />
                            <span class="auth_err" id="CNOError"></span>
                        </p>
                       <p><input id="CName" name="CName" type="text" placeholder="课程名" />
                            <span class="auth_err" id="CNameError"></span>
                        </p>
                    
                        <p><input id="Score" name="Score" type="text" placeholder="成绩" />
                            <span class="auth_err" id="password1Error"></span>
                        </p>
                        <p>
                            <a href="#" id="btLogin">确定</a>
                            <span class="auth_err" id="checkError"></span>
                        </p>
                    </form>
		</div><!--  #loginForm -->
	</div>	
</body>
</html>