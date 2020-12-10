<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>学生选课页面</title>
    <script src="js/jquery-3.5.0.min.js"></script>
    <script src="js/studentTC.js"></script>
    <link href="css/userManager.css" rel="stylesheet">
    <link href="css/bgstudent.css" rel="stylesheet">
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
				<a class="navbar-brand" href="login.html">Student out Classes</a>
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

<div id="pageBody">
    <div id="search">
        <form id="searchForm">
            <input type="text" id="sCNO" name="CNO" placeholder="输入课程号..."/>
            <input type="text" id="sCName" name="CName" placeholder="输入课程名..."/>
        </form>
        <div id="bt">
            <a href="#" id="btSearch" class="btn btn-primary">查找</a>
        </div>
    </div>

    <table>
        <thead>
        <tr>
            <th width="40"><input type="checkbox" id="ckAll" title="选择"/></th>
            <th width="100" id="sortBYCNO" data="CNO">课程号</th>
            <th width="110">课程名</th>
            <th width="100">学分</th>
            <th width="120">操作</th>
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
            <span id="total">3</span>条数据，
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
</html>