package webec

import grails.plugin.springsecurity.annotation.Secured

class Question {

    String questionTitle
    String questionType
    int answersPositive
    int answersNegative

    static constraints = {

        //max. 200 Zeichen, damit es keine ewig langen Fragen gibt
        questionTitle(blank:false, size: 3..200, nullable: false)

        //wenn ein Fragetyp ergänzt wird, muss dieser im QuestionController ebenfalls ergänzt werden
        questionType inList: ["Mag ich / Mag ich nicht", "Ja / Nein", "Ich stimme zu / Ich lehene ab"]

        //Die gegeben Antworten sollen bei einer neuen Frage immer 0 sein und werden deswegen nicht angezeigt.
        answersNegative display: false
        answersPositive display: false
    }
}