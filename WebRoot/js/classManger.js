//初始化填充table
function firstFill(){
	  /* 分页参数 */
    var pageSize = $("#pageSize").val();
    var pageNumber = document.getElementById("pageNumber").innerText;
    var sort = "CNO";
    var sortOrder = "asc";
    /* 查询参数 */
    var CNO = $("#sCNO").val();
    var CName = $("#sCName").val();
     
    $.ajax({
        type: "post",
        url: "findall.do",
        data: {
        	 queryParams: '{"CNO":"'+CNO+'","CName":"'+CName+'"}',
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
                 str = str+ '<td><input type="checkbox" value='+ row.CNO +' /></td>';
                 str = str+ '<td>'+ row.CNO +'</td>';
                 str = str+ '<td>'+ row.CName +'</td>';
                 str = str+ '<td>'+ row.Point +'</td>';
                 str = str+ '<td><a href="#" id="btdel" value='+row.CNO+'>删除</a> '
                 str = str+ '<td><a href="#" id="btupdate" value='+row.CNO+'>修改</a> ';
                 str = str+ '</tr>';
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
    
    $("#btAdd").click(function () { 
        $("#titleSignUp").text("创建新的课程");
        $("#CName").attr("readonly", false);
        $("#CNO").attr("readonly", false);
        ShowDiv('MyDiv', 'fade');
    })
    
    //绑定动态生成的表格中每行的选课按钮事件
     $('table').on('click', '#btupdate', function() { 
    	 var rowData = $(this).parents("tr").attr("data");
         openEditDiv(rowData);
    });
    
     //绑定动态生成的表格中每行的选课按钮事件
    $('table').on('click', '#btdel', function() {
        var cno = $(this).attr("value");
        var  data = {CNO:cno}
        $.ajax({
            type: "post",
            url: "delcalss.do",
            data: data,
            dataType: "json",
            success: function(response) {
                alert(response.info);
                if (response.code == 0) {
                	 firstFill();
                }
            }
        });
    });
    $("#btLogin").click(function(e) { 
        $.ajax({
            type: "post",
            url: "Insertclass.do",
            data: $("#registerForm").serialize(), //将表单内容序列化成一个URL 编码字符串
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    alert(response.info);
                    window.location.href = "classManger.jsp";
                }
            }
        });
    });  
});

var FormUtils = {
	    fillForm: function(formid, data) {
	        $('#' + formid).find(':input').each(function() {
	            $(this).val(data[$(this).attr('id')]);
	        });
	    },
	    emptyForm: function(formid) {
	        $('#' + formid).find(':input').each(function() {
	            $(this).val("");
	        });
	        $('#' + formid).find('span').each(function() {
	            $(this).html("");
	        });
	    }
	};

function openEditDiv(rowData) {
    var data = JSON.parse(rowData);
    FormUtils.emptyForm("registerForm");
    FormUtils.fillForm("registerForm", data);
    $("#CName").attr("readonly", true);
    $("#CNO").attr("readonly", true);
    ShowDiv('MyDiv', 'fade');
}
