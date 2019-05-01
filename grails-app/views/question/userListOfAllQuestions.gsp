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

<a href="/">Home</a>

<h2>alle Fragen</h2>
<table>
    <g:each in="${userListOfAllQuestions}" var="quest">
        <tr><td>${quest.questionTitle}</td><td>${quest.questionType}</td><td>${quest.answersPositive}</td><td>${quest.answersNegative}</td></tr>
    </g:each>
</table>

<!--<h2>Ja / Nein Fragen</h2>
<table>
    <g:each in="${listOfAllYesNoQuestions}" var="bla">
        <tr><td>${bla.questionTitle}</td><td>${bla.questionType}</td><td>${bla.answersPositive}</td><td>${bla.answersNegative}</td></tr>
    </g:each>
</table>-->
</body>
</html>