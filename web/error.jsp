<%--
  Created by IntelliJ IDEA.
  User: yecheng
  Date: 2020/10/8
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="refresh"  content="10;url=index.html">
    <title>出错啦</title>
    <link href="css/error.css" rel="stylesheet"/>
    <script  src="js/error.js"></script>

</head>
<body onload="onTime()">
<div id="errorDiv">
    <div id="errorHint">
        <p id="errorInfo">${info}</p>
        <p ><span id="leaveTime">10</span>秒后自动返回到登录页面</p>
        <p>不能跳转，请<a href="index.html">点击这儿</a></p>
    </div>
</div>
</body>
</html>
