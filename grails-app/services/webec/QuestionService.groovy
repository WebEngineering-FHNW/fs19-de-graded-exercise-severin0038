package webec

import grails.gorm.transactions.Transactional

@Transactional
class QuestionService {

    def serviceMethod() {

    }

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
}