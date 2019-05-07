package webec

class QuestionController {

    static scaffold = Question

    def userListOfAllQuestions() {
        def userListOfAllQuestions = Question.list()
        [userListOfAllQuestions: userListOfAllQuestions]

    }

    def save() {
        def answer = new Answer(params)
        answer.save()
        render "Success!"
    }
}
