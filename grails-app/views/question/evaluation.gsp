<%--
  Created by IntelliJ IDEA.
  User: sever
  Date: 14.05.2019
  Time: 13:56
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Swipinion - Auswertung</title>
</head>

<body>

<a href="/">Home</a>

<h1>Auswertung aller Fragen</h1>

<g:each in="${allQuest}" var="quest">

    <div>
        <h2>${quest.questionTitle}</h2>
        <p>
            <%
                if ( quest.questionType == "Ja / Nein" ) {
                    out << "Ja"
                } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                    out << "Mag ich"
                } else {
                    out << "Ich stimme zu"
                }
            %>
            : ${quest.answersPositive}
        </p>
        <p>
            <%
                if ( quest.questionType == "Ja / Nein" ) {
                    out << "Nein"
                } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                    out << "Mag ich nicht"
                } else {
                    out << "Ich lehne ab"
                }
            %>
            : ${quest.answersNegative}
        </p>
    </div>

</g:each>


</body>
</html>