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

    <main>

        <h1>Auswertung aller Fragen</h1>

        <g:each in="${allQuest}" var="quest">

            <div class="answer_container">
                <h2>${quest.questionTitle}</h2>
                <p class="answer--positive">
                    <span class="answer__label">
                        <%
                            if ( quest.questionType == "Ja / Nein" ) {
                                out << "Ja"
                            } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                                out << "Mag ich"
                            } else {
                                out << "Ich stimme zu"
                            }
                        %>:
                    </span>
                    <span class="answer__count">
                        ${quest.answersPositive}
                    </span>
                </p>
                <p class="answer answer--negative">
                    <span class="answer__label">
                    <%
                        if ( quest.questionType == "Ja / Nein" ) {
                            out << "Nein"
                        } else if ( quest.questionType == "Mag ich / Mag ich nicht" ) {
                            out << "Mag ich nicht"
                        } else {
                            out << "Ich lehne ab"
                        }
                    %>:
                </span>
                    <span class="answer__count">
                        ${quest.answersNegative}
                    </span>
                </p>
            </div>

        </g:each>
    </main
</body>
</html>