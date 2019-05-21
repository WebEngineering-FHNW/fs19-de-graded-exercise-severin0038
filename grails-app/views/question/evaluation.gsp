<%--
  Created by IntelliJ IDEA.
  User: sever
  Date: 14.05.2019
  Time: 13:56
--%>

<%@ page contentType="text/html;charset=UTF-8" import="webec.QuestionService" %>
<%
    def QuestionService = grailsApplication.classLoader.loadClass('webec.QuestionService').newInstance()
%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Swipinion - Auswertung</title>
    <asset:stylesheet src="chart.css"/>
</head>

<body>

    <main>

        <h1>Auswertung aller Fragen</h1>

        <g:each in="${allQuest}" var="quest">

            <div class="answer">

                <h2>${quest.questionTitle}</h2>

                <div class="chart">
                    <div class="chartlabel">

                        <span class="positive">
                            ${QuestionService.answerBooleanToString(true, quest.questionType)}
                        </span>

                        <span class="negative">
                            ${QuestionService.answerBooleanToString(false, quest.questionType)}
                        </span>
                    </div>

                    <div class="chartgraphic">

                        <!-- percentage-bar-positive -->
                        <div class="percentage-bar percentage-bar-${(int)QuestionService.calculatePercentagesForEvaluation(quest.answersPositive, quest.answersNegative, true)}">
                            <span>
                                ${quest.answersPositive} (${QuestionService.calculatePercentagesForEvaluation(quest.answersPositive, quest.answersNegative, true)}%)
                            </span>
                        </div>

                        <!-- percentage-bar-negative -->
                        <div class="percentage-bar percentage-bar-${(int)QuestionService.calculatePercentagesForEvaluation(quest.answersPositive, quest.answersNegative, false)}">
                            <span>
                                ${quest.answersNegative} (${QuestionService.calculatePercentagesForEvaluation(quest.answersPositive, quest.answersNegative, false)}%)
                            </span>
                        </div>

                    </div>

                </div>
            </div>

        </g:each>

    </main

</body>
</html>