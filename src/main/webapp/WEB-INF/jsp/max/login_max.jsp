<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/18
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/loginMax.css">
</head>

<body>
<div id="main">
    <div id="content">
        <form action="${pageContext.request.contextPath}/log/login" method="post">
            <h4 id="theam">"Game live"登录</h4>
            <input type="text" name="uname" placeholder="姓名"
                   style="border-bottom: 1px solid darkgray;"/><br/> <input
                type="password" name="upwd" placeholder="密码"
                style="border-bottom: 1px solid darkgray;"/><br/> <input
                type="text" name="code" placeholder="验证码"><br> <img
                id="verify" alt="不能正常显示" src="${pageContext.request.contextPath}/user/getVerifyCode">
            <input type="checkbox" name="checkbox"
                   style="width: 16px; height: 16px">自动登录<br>
            <div id="btn_div" style="text-align: center;">
                <button class="btn" style="width: 100px; height: 40px;"
                        type="submit">登录
                </button>
                <button id="regist" class="btn" style="width: 100px; height: 40px;" id="btn_zc"
                        type="button" onclick="fn()">注册
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">

    //jquery的页面加载函数
    $(function () {
        //获取验证码 刷新
        $("#verify").click(function () {
            $("#verify").attr("src", "${pageContext.request.contextPath}/user/getVerifyCode?" + (new Date()).valueOf());
        });

        //失去焦点发送异步请求查询邮箱是否已经被占用
        $("#email").blur(function () {
            var val = $("#email").val();
            //发送异步请求
            $.post(
                "${pageContext.request.contextPath}/log/getVerifyEmail",
                {email: val},
                function (data) {
                    // console.log(data.valueOf());
                    // alert(data.f);
                    $("#sp1").html(data.msg);
                },
                "json"
            );
        });
        //监听注册按钮
        $("#regist").click(function () {
            location.href = "${pageContext.request.contextPath}/log/registMax";
        });


    });
</script>
</html>
