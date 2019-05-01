package webec

class QuestionController {

    static scaffold = Question

    def userListOfAllQuestions() {
        def userListOfAllQuestions = Question.list()
        [userListOfAllQuestions: userListOfAllQuestions]

        /*def listOfAllYesNoQuestions = Question.findAllByQuestionType("Ja / Nein")
        [listOfAllYesNoQuestions:listOfAllYesNoQuestions]*/
    }

    def answerQuestion() {
        [answerInstance: new Answer(params)]
    }
}
