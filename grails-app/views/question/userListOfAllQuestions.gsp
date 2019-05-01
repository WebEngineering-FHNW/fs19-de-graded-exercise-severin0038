<%--
  Created by IntelliJ IDEA.
  User: sever
  Date: 01.05.2019
  Time: 17:55
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:each in="${userListOfAllQuestions}" var="quest">
        <h3>${quest.questionTitle}</h3>
    </g:each>
</body>
</html>