package webec

import org.springframework.web.bind.annotation.PostMapping

import javax.persistence.PostLoad

class QuestionController {

    static scaffold = Question

    def springSecurityService

    def listOfQuestions() {
        List<Question> allQuest = Question.list();
        [allQuest: allQuest]
    }

    def openQuestions() {

        def user = springSecurityService.currentUser;
        def userId = user.id;

        List<Question> allQuestions = Question.list();
        List<Answer> allAnswersByUser = Answer.findAllByUser_id(userId);
        List openQuest = new ArrayList();

        boolean found;

        for(Question question : allQuestions) {
            found = false;
            for(Answer answer : allAnswersByUser) {
                if(answer.question_id == question.id) {
                    found = true;
                }
            }
            if(!found) {
                openQuest.add(question);
            }
        }

        [openQuest: openQuest, userId: userId]
    }



    def answeredQuestions() {

        def user = springSecurityService.currentUser;
        def userId = user.id;

        List<Answer> answers = Answer.findAllByUser_id(userId);
        List answeredQuest = new ArrayList();

        for(Answer answer : answers) {
            String[] arr = new String[2];
            Question question = Question.findById(answer.question_id);
            boolean answerOfThisQuestion = answer.answer;
            String questionType = question.questionType;
            String answerQuestion;

            System.out.println(questionType)

            if(questionType == "Mag ich / Mag ich nicht") {
                if(answerOfThisQuestion) {
                    answerQuestion = "Mag ich";
                } else {
                    answerQuestion = "Mag ich nicht"
                }
            } else if(questionType == "Ja / Nein") {
                if(answerOfThisQuestion) {
                    answerQuestion = "Ja";
                } else {
                    answerQuestion = "Nein"
                }
            } else {
                if(answerOfThisQuestion) {
                    answerQuestion = "Ich stimme zu";
                } else {
                    answerQuestion = "Ich lehene ab"
                }
            }

            arr[0] = question.getQuestionTitle();
            arr[1] = answerQuestion;

            answeredQuest.add(arr);
        }

        [answeredQuest: answeredQuest]

    }

    def evaluation() {
        List<Question> allQuest = Question.list();
        [allQuest: allQuest]
    }

    //@PostMapping("/saveAnswersOfUser")
    def saveAnswersOfUser() {

        System.out.println("hallo");

        def answer = new Answer(params)
        answer.save(flush:true)

        def question_id = params.question_id;
        def givenAnswer = params.answer;

        Question question = Question.findById(question_id);
        System.out.println(question)

        if(givenAnswer) {
            def answersPositive = Question.findById(question_id).getAnswersPositive();
            question.setAnswersPositive(answersPositive+1);

        } else {
            def answersNegative = Question.findById(question_id).getAnswersNegative();
            question.setAnswersNegative(answersNegative+1);
        }

        question.save(flush: true);

        render text: "success!";
    }

}
