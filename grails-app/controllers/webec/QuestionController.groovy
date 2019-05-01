package webec

class QuestionController {

    static scaffold = Question

    def userListOfAllQuestions() {
        def userListOfAllQuestions = Question.list()
        [list:userListOfAllQuestions]
    }
}
