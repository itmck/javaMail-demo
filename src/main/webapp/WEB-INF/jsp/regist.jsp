<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h3>用户注册页面</h3>
    <hr>
    <form action="${pageContext.request.contextPath}/log/regist" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="upwd"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" id="email"></td>
                <td><span id="sp1"></span></td>
            </tr>
            <tr style="height: 30px">
                <td>验证码：</td>
                <td>
                    <input type="text" name="code" id="verification">
                </td>
                <td>
                    <img id="verify" src="${pageContext.request.contextPath}/user/getVerifyCode"/>
                    <a href="javascript:getver()">看不清</a>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册"> <input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>

</div>
</body>
<%--引入jquery插件--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
    //获取验证码 刷新
    function getver() {
        $("#verify").attr("src", "${pageContext.request.contextPath}/user/getVerifyCode?" + (new Date()).valueOf());
    }

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

</script>
</html>
