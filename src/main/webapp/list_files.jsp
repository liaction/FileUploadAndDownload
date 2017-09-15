<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>下载文件显示页面</title>
</head>

<body>
<!-- 遍历Map集合 -->
<c:forEach var="file" items="${fileNames}">
    <c:url value="/FileDownloadServlet" var="downloadUrl">
        <c:param name="filename" value="${file.key}"/>
    </c:url>
    ${file.value}<a href="${downloadUrl}">下载</a>
    <br/>
</c:forEach>
</body>
</html>