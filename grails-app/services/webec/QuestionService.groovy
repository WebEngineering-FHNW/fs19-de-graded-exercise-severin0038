package webec

import grails.gorm.transactions.Transactional

@Transactional
class QuestionService {

    //Diese Methode wandelt eine Antwort (true oder fals) aufgrund des Fragetyps einem String zu
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


    //Diese Methode löscht die Abhängigkeiten einer Frage (also alle Einträge in der Antworten-Tabelle mit dieser Frage)
    def deleteQuestionDependencies(Question question) {
        def answerList = Answer.findAllByQuestion(question)
        answerList.each { answer -> answer.delete(flush: true)}
    }


    //Diese Methode berechnet die Prozentzahlen der positiven und negativen Antworten
    def calculatePercentagesForEvaluation(int answersPositive, int answersNegative, boolean answerType) {

        //Sonderfall wenn noch keine Antworten gegeben wurden (damit nicht durch 0 geteilt wird)
        if(answersPositive==0 && answersNegative==0) {
            return 0;

        } else {
            double percentPositive = Math.round((100 / (answersPositive + answersNegative) * answersPositive) * 100) / 100.0
            if(answerType) {
                return percentPositive
            } else {
                return 100-percentPositive
            }
        }

    }


}