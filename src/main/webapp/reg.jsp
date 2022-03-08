<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    用户名：
    <input type="text" id="name" onblur="a1()">
    <span id="userinfo"></span>
</p>
<p>
    密码：
    <input type="text" id="pwd" onblur="a2()">
    <span id="pwdinfo"></span>

</p>
</body>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
<script>
    function a1(){

        $.post({
            url:"${pageContext.request.contextPath}/ajax/a3",
            data:{"name":$("#name").val()},
            success:function (data){
                if (data.toString()=="ok"){
                        $("#userinfo").css("color","green");
                }else{
                    $("#userinfo").css("color","red");
                }
                $("#userinfo").html(data);
            }
        })
    }
    function a2(){

        $.post("${pageContext.request.contextPath}/ajax/a3",{"pwd":$("#pwd").val()},function (data){
            if (data.toString()=="ok"){
                $("#pwdinfo").css("color","green");
            }else{
                $("#pwdinfo").css("color","red");
            }
            $("#pwdinfo").html(data);
        })
    }
</script>
</html>
