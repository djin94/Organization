<%@ include file="../include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>List groups</h1>
<c:url var="indexUrl" value="/user/index.htm" />
<a href="add.htm">create</a><br/>
<c:if test="${empty groups}">
    List is empty.<br/>
</c:if>
<ul>
    <c:forEach items="${groups}" var="group">
    <li>Title : <c:out value="${group.title}" />;
        </c:forEach>
</ul>
<p>Return to <a href="${indexUrl}">Index Page</a></p>

</body>
</html>