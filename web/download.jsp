<%--
  Created by IntelliJ IDEA.
  User: yecheng
  Date: 2020/10/8
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download</title>
    <style type="text/css">@import "css/download.css";</style>
    <style type="text/css">@import "css/main.css";</style>
    <link href="css/download.css" rel="stylesheet" type="text/css">

</head>
<body>
<!-- 头部-->
<div class="headDiv">
    <b>
        <font color="#000000" size=10>
            Download List
        </font>
    </b>
</div>
<!-- 下部-->
<div class="bodyDiv">
    <div class="divLine"></div>
    <div class="downloadDiv">
        <c:forEach items="${DownloadList}" var="download" varStatus="downloadvst">
            <table align="center" border="1" style="align-self: center" class="tableStyle">
                <tr>
                    <th  rowspan="2" align="center" width="26.6%">
                        <img src="${download.image}" class="imageIcon">
                    </th>

                    <th width="40%" colspan="2" align="left" >
                            ${download.name}
                    </th>
                    <th  rowspan="4" width="33.4%">

                        <a href="download.do?id=${download.id}" class="pointer">
                            <input value="立即下载" type="button" class="buttonStyle">
                        </a>
                    </th>
                </tr>
                <tr>
                    <td align="left">
                        大小：${download.size}&nbsp;&nbsp;星级：${download.star}
                    </td>
                </tr>
                <tr>
                    <th rowspan="2" colspan="3" align="left">
                            ${download.description}
                    </th>
                </tr>
            </table>
            </form>
        </c:forEach>


    </div>
</div>
</body>
</html>
