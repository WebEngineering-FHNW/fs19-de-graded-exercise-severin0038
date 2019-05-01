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
<table>
    <g:each in="${userListOfAllQuestions}" var="quest">
        <tr><td>${quest.questionTitle}</td><td>${quest.questionType}</td></tr>
    </g:each>
</table>
</body>
</html>