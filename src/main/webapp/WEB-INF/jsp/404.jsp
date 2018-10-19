<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" href="${pageContext.request.contextPath}/static/layui/layui.all.js"></script>
</head>
<body>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>404页面</legend>
    </fieldset>
    <div class="layui-card">
        <div class="layui-card-header">卡片面板</div>
        <div class="layui-card-body">
            卡片式面板面板通常用于非白色背景色的主体内<br>
            从而映衬出边框投影
        </div>
    </div>
</div>
</body>
</html>
