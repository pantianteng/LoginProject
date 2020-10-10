<%--
  Created by IntelliJ IDEA.
  User: yecheng
  Date: 2020/10/8
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
    <style type="text/css">@import "css/main.css";</style>
    <script  src="js/main.js"></script>
    <title>login WebSite</title>

    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
<body>
<div class="div1">
    <img src="Images/mainhead.png" alt="login Website" class="styleImgMain">
</div>
<div class="div5">
    <p>
        <font size="4%" color="#a9a9a9">
            Design From
        </font>
    </p>
    <p>
        <font size="%6" color="black">
            <span>&nbsp;YeCheng.com</span>
        </font>
    </p>
</div>
<div>
    <div class="div2" style="text-align:right" >
        <br>
        <p>
            <label>
                <font color="black" size="4%">欢迎您&nbsp;${User.chrName}</font>
            </label>
            <label onclick="returnBack()" class="pointer">
                <font color="blue" size="4%">&nbsp;;【安全退出】</font>
            </label>
        </p>
    </div>
    <div class="div3" style="text-align: right;margin-top: 20px;" >
        <form method="post" name="CheckPage">
            <label onClick="" class="pointer" >
                <font>&nbsp;首页&nbsp;</font>
            </label>
            <label onclick="goToDownload()" class="pointer" >
                <font>|&nbsp;下载&nbsp;</font>
            </label>
            <label onClick="goUserManage()" class="pointer" >
                <font>|&nbsp;用户管理&nbsp;</font>
            </label>
            <label onClick="goResManage()" class="pointer" >
                <font>|&nbsp;资源管理&nbsp;</font>
            </label>
            <label onClick="goPersonCenter()" class="pointer" >
                <font>|&nbsp;个人中心&nbsp;</font>
            </label>
            <label onClick="" class="pointer" >
                <font>|&nbsp;关于&nbsp;</font>
            </label>
        </form>
    </div>

    <div class="div4">
        <div class="divLine">
        </div>
        <img src="Images/main.jpg" alt="主页" style="position: absolute;left: 50%;margin-left: -540px;margin-top: 20px">
    </div>

</body>
</html>



</body>
</html>















