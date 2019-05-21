package webec

import grails.gorm.transactions.Transactional

@Transactional
class QuestionService {

    def answerBooleanToString(boolean answer, String questionType) {

        if (questionType == "Mag ich / Mag ich nicht") {
            if (answer) {
                return "Mag ich";
            } else {
                return "Mag ich nicht"
            }
        } else if (questionType == "Ja / Nein") {
            if (answer) {
                return "Ja";
            } else {
                return "Nein"
            }
        } else {
            if (answer) {
                return "Ich stimme zu";
            } else {
                return "Ich lehene ab"
            }
        }
    }

    def deleteQuestionDependencies(Question question) {
        def answerList = Answer.findAllByQuestion(question)
        answerList.each { answer -> answer.delete(flush: true)}
    }

    def calculatePercentagesForEvaluation(int answersPositive, int answersNegative, boolean answerType) {
        double percentPositive;
        double percentNegative;

        if(answersPositive==0 && answersNegative==0) {
            percentPositive=0;
            percentNegative=0;
        } else if(answersPositive>0 && answersNegative==0) {
            percentPositive=100;
            percentNegative=0;
        } else if(answersPositive==0 && answersNegative>0) {
            percentPositive=0;
            percentNegative=100;
        } else {
            percentPositive = Math.round((100/(answersPositive+answersNegative)*answersPositive)*100)/100.0
            percentNegative = 100-percentPositive;
        }

        if(answerType) {
            return percentPositive;
        } else {
            return percentNegative
        }

    }

    def calculatePercentagesForEvaluationChart(int answersPositive, int answersNegative, boolean answerType) {
        return (int)(calculatePercentagesForEvaluation(answersPositive, answersNegative, answerType));
    }

}