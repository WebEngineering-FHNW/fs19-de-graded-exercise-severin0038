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

<a href="/">Home</a><br>
<a href="/question/openQuestions">offene Fragen</a>

<h2>alle Fragen</h2>
<table>
    <tr>
        <th>Frage</th>
        <th>Meine Antwort</th>
    </tr>
    <g:each in="${answeredQuestions}" var="quest">
        <tr>
            <td>${quest.questionTitle}</td>
            <td>Antwort</td>
        </tr>
    </g:each>
</table>
</body>
</html>