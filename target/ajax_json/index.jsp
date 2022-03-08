<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
</head>
<body>

<%--onblur：失去焦点事件--%>
用户名：
<input type="text" id="txtName"/>


</body>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>


<script type="text/javascript">
    $("input").blur(function(){
        // 所有参数:
        // url:待载入页面的URL地址.Json
        // data:待发送Key /value参数
        // success:载入成功时回调函数
        // data :封装了服务器返回的数据
        // status :状态
        $.ajax({
            url:"${pageContext.request.contextPath}/ajax/a1",
            data:{"name":$("#txtName").val()},
            success:function (data,status){
                alert(data);
                alert(status);
            }
        });

    })
</script>
</html>
