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
    <title>Swipinion - beantwortete Frage</title>
</head>

<body>
    <main>
        <h1>Liste aller beantworteten Fragen</h1>
        <table>

            <tr>
                <th>Frage</th>
                <th>Meine Antwort</th>
            </tr>

            <g:each in="${answeredQuest}" var="quest">
                <tr>
                    <td>${quest[0]}</td>
                    <td>${quest[1]}</td>
                </tr>
            </g:each>

        </table>
    </main>
</body>
</html>