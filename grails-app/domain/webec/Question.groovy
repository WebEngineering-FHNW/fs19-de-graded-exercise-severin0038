package webec

import grails.plugin.springsecurity.annotation.Secured

class Question {

    String questionTitle
    String questionType
    int answersPositive
    int answersNegative

    static constraints = {
        questionTitle blank:false
        questionType inList: ["Mag ich / Mag ich nicht", "Ja / Nein", "Ich stimme zu / Ich lehene ab"]
        answersNegative display: false
        answersPositive display: false
    }
}