<%@ include file="../include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
</head>
<body>
<h1>Add group</h1>
<c:url var="indexUrl" value="/user/index.htm" />
<c:url var="saveUrl" value="/group/save.htm" />
<form:form modelAttribute="groupAttribute" method="POST" action="${saveUrl}">
    Title:
    <form:input path="title"></form:input><form:errors path="title" cssClass="error" />
    <input type="submit" value="Save" />
</form:form>
<p>Return to <a href="${indexUrl}">Index Page</a></p>
</body>
</html>