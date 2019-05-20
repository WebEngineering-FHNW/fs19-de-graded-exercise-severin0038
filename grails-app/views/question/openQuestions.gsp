<%--
  Created by IntelliJ IDEA.
  User: sever
  Date: 01.05.2019
  Time: 17:55
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
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
                        <g:form controller="question" action="saveAnswerOfUser">
                            <g:hiddenField  name="question" value="${quest.id}"/><br/>

                            <g:hiddenField  name="user_id" value="${user_id}"/><br/>

                            <g:radio name="answer" value="true"/>
                                <%
                                    if ( quest.questionType == "Ja / Nein" ) {
                                        out << "Ja"
                                    } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                                        out << "Mag ich"
                                    } else {
                                        out << "Ich stimme zu"
                                    }
                                %>

                            <g:radio name="answer" value="false"/>
                                <%
                                    if ( quest.questionType == "Ja / Nein" ) {
                                        out << "Nein"
                                    } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                                        out << "Mag ich nicht"
                                    } else {
                                        out << "Ich lehne ab"
                                    }
                                %>

                            <g:actionSubmit value="Save"/>
                        </g:form>
                    </td>
                </tr>
            </g:each>


        </table>
    </main>
</body>
</html>