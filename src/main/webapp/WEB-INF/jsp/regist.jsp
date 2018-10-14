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
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册"> <input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
