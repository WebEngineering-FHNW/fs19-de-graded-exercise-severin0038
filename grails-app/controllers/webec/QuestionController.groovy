package webec

class QuestionController {

    static scaffold = Question

    def openQuestions() {
        def openQuestions = Question.list()
        [openQuestions: openQuestions]
    }

    def answeredQuestions() {
        def answeredQuestions = Question.list()
        [answeredQuestions: answeredQuestions]
    }

    def save() {
        def answer = new Answer(params)
        answer.save()
        render "Success!"
    }
}
