<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/13
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
<div align="center">
    <h3>用户登录页面</h3>
    <hr>
    <form action="${pageContext.request.contextPath}/log/login" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uname"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="upwd"></td>
            </tr>
            <tr style="height: 30px">
                <td>验证码：</td>
                <td >
                    <input type="text" name="code" id="verification">
                </td>
                <td >
                    <img id="verify"  src="${pageContext.request.contextPath}/user/getVerifyCode" />
                    <a href="javascript:getver()">看不清</a>
                </td>
            </tr>
            <tr >
                <td colspan="2" align="center" ><input type="submit" value="登录"> <input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>

</div>

</body>
<%--引入jquery插件--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
    //获取验证码 刷新
    function getver(){
        $("#verify").attr("src", "${pageContext.request.contextPath}/user/getVerifyCode?" + (new Date()).valueOf());
    }
</script>
</html>
