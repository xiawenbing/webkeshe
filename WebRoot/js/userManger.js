//初始化填充table
function firstFill(){
	  /* 分页参数 */
    var pageSize = $("#pageSize").val();
    var pageNumber = document.getElementById("pageNumber").innerText;
    var sort = "SNO";
    var sortOrder = "ASC";
    /* 查询参数 */
    var SNO = $("#sSNO").val();
    var userName = $("#suserName").val();
     
    $.ajax({
        type: "post",
        url: "userManger.do",
        data: {
        	 queryParams: '{"SNO":"'+SNO+'","userName":"'+userName+'"}',
            pageParams: '{"pageSize":"'+pageSize+'","pageNumber":"'+pageNumber+'","sort":'+sort+',"sortOrder":'+sortOrder+'}'
        },
        dataType: "json",
        success: function (response) {
            var rows = response.rows;
            var total = response.total;  //总记录的条数
            var pageCount = Math.ceil(total/pageSize); //总页数
            $("#total").text(total);
            $("#pageCount").text(pageCount);
            $("tbody").empty();
            $.each(rows, function (index, row) { 
                 var s = JSON.stringify(row);
                 var str = "<tr data='"+ s +"'>";
                 str = str+ '<td><input type="checkbox" value='+ row.SNO +' /></td>';
                 str = str+ '<td>'+ row.SNO +'</td>';
                 str = str+ '<td>'+ row.userName +'</td>';
                 str = str+ '<td>'+ row.password +'</td>';
                 str = str+ '<td>'+ row.role +'</td>';
                 str = str + ' <td><a href = "#" id="btnDel" value=' + row.SNO + '>删除</a> ';
                 str = str + '<a href="#" id="btnUpdate">修改</a></td>';;
                 $("tbody").append(str);
            });
            // 奇数偶数行颜色不一样
            $('tbody tr:even').addClass('tr_even'); //偶数行
            $('tbody tr:odd').addClass('tr_odd'); //奇数行
        }
    });
}

/* 弹出框和遮罩层 的显示 */
function ShowDiv(show_div, bg_div){
    document.getElementById(show_div).style.display = "block";
    document.getElementById(bg_div).style.display = "block";
    //弹出框的居中设置
    var winHeight = $(window).height(); //获取当前窗口高度
    var winWidth = $(window).width(); //获取当前窗口宽度
    var popupHeight = $("#" + show_div).height(); //获取弹出层高度
    var popupWeight = $("#" + show_div).width(); //获取弹出层宽度
    var posiTop = (winHeight - popupHeight) / 2;
    var posiLeft = (winWidth - popupWeight) / 2;
    $("#" + show_div).css({ "left": posiLeft + "px", "top": posiTop + "px", "display": "block" }); //设置position
}
function CloseDiv(show_div, bg_div){
    document.getElementById(show_div).style.display = "none";
    document.getElementById(bg_div).style.display = "none"; 
}

$(document).ready(function () {
    // 刚加载页面时，第一次填充table
	firstFill();

    /* table部分的事件绑定 */
    $("tbody").on("mouseover", "tr", function() {
        $(this).addClass('tr_hover'); //通过jQuery控制实现鼠标悬停上的背景色
    });
   
    $("tbody").on("mouseout", "tr", function() {
        $(this).removeClass('tr_hover'); //通过jQuery控制实现鼠标悬停上的背景色
    });
    $("tbody").on("click", " tr input:checkbox",function () {
        if(this.checked == true){
            $(this).parents("tr").addClass('tr_select');
        }else{
            $(this).parents("tr").removeClass('tr_select');
        }
    });
    /* 按钮组的功能 */
    $("#btSearch").click(function(){
    	firstFill();
    });
    /* 分页导航的功能 */
    $("#pageSize").on("change",function(){
    	firstFill();
    });
    $("#first").click(function(){
        $("#pageNumber").text( 1 );
        firstFill();
    });
    $("#back").click(function(){
        var newPageNumber = parseInt($("#pageNumber").text())-1;
        if(newPageNumber <= 0){
            alert("已经是第一页了，不能往前翻了！");
        }else{
            $("#pageNumber").text(newPageNumber);
            firstFill();
        }
    });
    $("#next").click(function(){
        var newPageNumber = parseInt($("#pageNumber").text()) + 1;
        if(newPageNumber > parseInt($("#pageCount").text()) ){
            alert("已经是最后一页了，不能往后翻了！");
        }else{
            $("#pageNumber").text(newPageNumber);
            firstFill();
        }
    });
    $("#last").click(function(){
        $("#pageNumber").text($("#pageCount").text());
        firstFill();
    });
    
    $('tbody').on('click', '#btnUpdate', function(){
        ShowDiv('MyDiv', 'fade');
    });
    
    $("#tbody").on("click", "#btnUpdate", function(){
        $("#titleSignUp").text("修改用户信息");
        $("#userName").attr("readonly", true);
        userName_flag = false;
        password_flag = false;
        usepassword_flag = false;
        ShowDiv('MyDiv', 'fade');
    });
    
    //绑定动态生成的表格中每行的删除按钮事件
    $('table').on('click', '#btnDel', function() {
        var sno = $(this).attr("value");
        $.ajax({
            type: "post",
            url: "deleteUser.do",
            data: {SNO: sno },
            dataType: "json",
            success: function(response) {
                alert(response.info);
                if (response.code == 0) {
                	firstFill();
                }
            }
        });
    });
});