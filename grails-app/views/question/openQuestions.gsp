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
<a href="/question/answeredQuestions">bereits beantwortete Fragen</a>

<h2>alle Fragen</h2>
<table>
    <tr>
        <th>Frage</th>
        <th>Frage beantworten</th>
    </tr>
    <g:each in="${openQuest}" var="quest">
        <tr>
            <td>${quest.questionTitle}</td>
            <td>
                <g:form controller="question" action="save">
                    <g:hiddenField  name="question_id" value="${quest.id}"/><br/>

                    <g:hiddenField  name="user_id" value="1"/><br/>

                    <g:radio name="answer" value="true"/>Ja
                    <g:radio name="answer" value="false"/>Nein

                    <g:actionSubmit value="Save"/>
                </g:form>
            </td>
        </tr>
    </g:each>
</table>
</body>
</html>