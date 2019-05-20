<%--
  Created by IntelliJ IDEA.
  User: sever
  Date: 01.05.2019
  Time: 17:55
--%>

<%@ page contentType="text/html;charset=UTF-8" import="webec.QuestionService" %>
<%
    def QuestionService = grailsApplication.classLoader.loadClass('webec.QuestionService').newInstance()
%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Swipinion - offene Fragen</title>
</head>

<body>

    <main>
        <h1>Liste aller offenen Fragen</h1>
        <table>
            <tr>
                <th>Frage</th>
                <th>Frage beantworten</th>
            </tr>
            <g:each in="${openQuest}" var="quest">
                <tr>
                    <td>${quest.questionTitle}</td>
                    <td>
                        <g:form controller="question" >
                            <g:hiddenField  name="question" value="${quest.id}"/><br/>

                            <g:hiddenField  name="user_id" value="${user_id}"/><br/>

                            <g:radio name="answer" value="true"/>
                            ${QuestionService.answerBooleanToString(true, quest.questionType)}

                            <g:radio name="answer" value="false"/>
                            ${QuestionService.answerBooleanToString(false, quest.questionType)}

                            <g:actionSubmit value="Speichern" action="saveAnswerOfUser" />
                        </g:form>
                    </td>
                </tr>
            </g:each>


        </table>
    </main>
</body>
</html>