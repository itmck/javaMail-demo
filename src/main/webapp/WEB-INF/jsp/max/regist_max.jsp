<%--
  Created by IntelliJ IDEA.
  User: 34745
  Date: 2018/10/18
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
    <style type="text/css">
        body {
            background-color: rgb(238, 238, 238);
            padding-top: 5%;
        }

        #content {
            text-align: center;
        }

        input {
            height: 40px;
            width: 300px;
            border-radius: 4px;
            border-color: #FFFFFF;
            border: 1px;
            font-size: 16px;
            padding-left: 20px;
            margin: 5px;
        }

        #btn_div {
            margin: 10px;
        }

        .btn {
            background-color: rgb(51, 122, 183);
            border-radius: 10px;
            border: 0px;
        }

        #cls {
            height: 40px;
            width: 320px;
            border-radius: 4px;
            border-color: #FFFFFF;
            border: 0px;
            font-size: 15px;
            padding-left: 20px;
            margin: 5px;
        }

        .clean {
            clean: both;
        }
    </style>

</head>

<body>
<div id="content">
    <form id="myform" action="${pageContext.request.contextPath }/regist" method="post" onsubmit="return fn()">
        <h4>用户注册</h4>
        <span id="sp1"></span>
        <table cellpadding="0px" cellspacing="0px" align="center"
               border="0px">
            <tr>
                <th>用户名:</th>
                <td><input id="username" type="text" name="uname" /></td>
            </tr>
            <tr>
                <th>密 码</th>
                <td><input id="password" type="password" name="upwd" /></td>
            </tr>
            <tr>
                <th>确认密码</th>
                <td><input id="re_pass" type="password" name="re_pass" /></td>
            </tr>
            <tr>
                <th>邮  箱:</th>
                <td><input id="email" type="text" name="email" /></td>
            </tr>
        </table>
        <div id="btn_div" style="text-align: center;">
            <button class="btn" style="width: 100px; height: 40px;"
                    type="submit">注册</button>
        </div>
        <label for="re_pass" ></label>

    </form>
</div>
</body>
<script type="text/javascript"
        src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js" ></script>
<script>
   //页面加载函数
    $(function () {
        var flg=false;
        function fn() {
            return flg;
        }

        $("#username").blur(function() {
            $.ajax({
                url : "${pageContext.request.contextPath}/log/getVerifyUName",
                data : {
                    //username : this.value
                    uname: $("#username").val()
                },
                dataType : "json",
                success : function(d) {
                    if (d.msg==1) {
                        $("#sp1").html("用户名已经存在");
                    } else {
                        $("#sp1").html("用户名可以使用");
                        flg=true;
                    }
                },
                type : "post",
                async : true
            });
        });

        $(".btn").click(function() {

            $.ajax({
                url : "${pageContext.request.contextPath }/log/regist",
                data : {
                    uname: $("#username").val(),
                    upwd:$("#password").val(),
                    email:$("#email").val(),
                },
                dataType : "json",
                success : function(data) {
                    alert(data.msg);
                },
                type : "post",
                async : true
            });
        });

        //表单验证
        $("#myform").validate(
            {rules:{

                    //表单元素二
                    "upwd":{
                        required:true,
                        minlength:6
                    },
                    "re_pass":{
                        required:true,
                        equalTo:"input[name='upwd']"
                    },

                },
                /* messages:{
                    "username":{
                        required:"请一定要留下你的名字！",
                        minlength:"你输入的名字太短了不太好！长一点！"
                    }
                } */
            }
        );

    });
</script>
</html>