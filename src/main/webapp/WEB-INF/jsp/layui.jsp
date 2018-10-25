<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/23
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>layui测试</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.all.js"></script>
</head>
<body>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">网站设置</li>
        <li value="1">用户管理</li>
        <li value="2">权限分配</li>
        <li value="3">商品管理</li>
        <li value="4">订单管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            name:${requestScope.name}<br>password:${requestScope.password}
        </div>
        <div class="layui-tab-item">
            将需要显示的内容放在这里面即可
        </div>
        <div class="layui-tab-item">
            哈哈哈${requestScope.s}<br>${requestScope.sv}
        </div>
        <div class="layui-tab-item">
            ${requestScope.s}<br>${requestScope.sv}
        </div>
        <div class="layui-tab-item">
            ${requestScope.s}<br>${requestScope.sv}
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">

    var s;
    var url1;
    var url2;
    //一般直接写在一个js文件中
    layui.use(['layer', 'form', 'jquery'], function () {
        var layer = layui.layer
            , $ = layui.jquery
            , form = layui.form;


        $("ul").on("click", "li", function () {//只需要找到你点击的是哪个ul里面的就行
            s = $(this).val();
           // url1 = "mck@aaa?s=" + s;
           // url2 = "wxp@bbb?s=" + s;
           // layer.msg(url1 + " " + url2);
            ss(s);
            ss2(s);

        });

        var ss = function (s) {
            $.post(
                "${pageContext.request.contextPath}/xx/get",
                {"s": s},
                "json"
            );
        }
        var ss2 = function (s) {
            $.post(
                "${pageContext.request.contextPath}/xx/getV",
                {"s": s},
                "json"
            );
        }


    });
</script>
</html>
