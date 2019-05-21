package webec

class QuestionController {

    static scaffold = Question

    def springSecurityService
    def QuestionService



    //Diese Methode prüft, welche Fragen noch nicht beantwortet wurden und übergibt diese mit einer ArrayList ans openQuestions.gsp
    def openQuestions() {

        //angemeldeten User auslesen
        def user = springSecurityService.currentUser;
        def user_id = user.id;

        //Liste aller Fragen und Liste aller Antworten dieses Users
        List<Question> allQuestions = Question.list();
        List<Answer> allAnswersByUser = Answer.findAllByUser(user);
        List openQuest = new ArrayList();

        boolean found;

        //Prüfen, welche Fragen noch nicht beantwortet wurden von diesem User und diese der openQuest-ArrayList hinzufügen
        for(Question question : allQuestions) {
            found = false;
            for(Answer answer : allAnswersByUser) {
                if(answer.question == question) {
                    found = true;
                }
            }
            if(!found) {
                openQuest.add(question);
            }
        }

        [openQuest: openQuest, user_id: user_id]
    }



    //Diese Methode prüft, wleche Fragen bereits beantwortet wurden und übergibt diese als ArrayList ans answeredQuestions.gsp
    def answeredQuestions() {

        //angemeldeten User auslesen
        def user = springSecurityService.currentUser;

        //alle Antworten des Users in eine ArrayList speichern
        List<Answer> answers = Answer.findAllByUser(user);
        List answeredQuest = new ArrayList();

        for(Answer answer : answers) {
            //in einem String-Array die Frage und die gegebene Antwort speichern
            String[] arr = new String[2];
            Question question = Question.find(answer.question);
            boolean answerOfThisQuestion = answer.answer;
            String questionType = question.questionType;

            String answerQuestion = QuestionService.answerBooleanToString(answerOfThisQuestion, questionType)

            arr[0] = question.getQuestionTitle();
            arr[1] = answerQuestion;

            answeredQuest.add(arr);
        }

        [answeredQuest: answeredQuest]
    }



    //Diese Methode gibt eine Liste aller Fragen ans evaluation.gsp
    def evaluation() {
        List<Question> allQuest = Question.list();
        [allQuest: allQuest]
    }



    //Diese Methode speichert die Antwort, welche bei dem OpenQuestion.gsp gegeben werden
    def saveAnswerOfUser() {
        try {
            //Antworten auslesen und ids auf Objekete matchen
            def question_id = params.question;
            def givenAnswer = Boolean.parseBoolean(params.answer);
            def user_id = params.user_id;
            Question question = Question.findById(question_id);
            SecUser user = SecUser.findById(user_id);

            //Antwort abspeichern
            Answer answer = new Answer();
            answer.question = question;
            answer.user = user;
            answer.answer = givenAnswer
            answer.save(flush: true)

            //je nachdem, ob positiv oder negativ geantwortet wurde, das entsprechende Feld der Frage um 1 inkrementieren
            if (givenAnswer) {
                def answersPositive = question.getAnswersPositive();
                question.setAnswersPositive(answersPositive + 1);

            } else {
                def answersNegative = question.getAnswersNegative();
                question.setAnswersNegative(answersNegative + 1);
            }
            question.save(flush: true);

            flash.message= "Sie haben die Frage «${question.questionTitle}» erfolgreich beantwortet."

        } catch (RuntimeException re) {
            flash.error = re.message
        }

        redirect(controller: "question", action: "openQuestions")
    }



    //Diese Methode löscht eine Frage
    //Scaffold wird überschrieben, damit vor dem Löschen, die Abhängigkeiten (Einträge in Answers) gelöscht werden können
    def delete(Long id) {
        def questionToDelete = Question.findById(id)
        try{
            //Abhängigkeiten / Einträge in Answers mit dieser Frage löschen
            questionService.deleteQuestionDependencies(questionToDelete)

            //Frage löschen
            questionToDelete.delete(flush: true)

            flash.message= "Die Frage «${questionToDelete.questionTitle}» wurde erfolgreich gelöscht."
        } catch (RuntimeException re) {
            flash.error = re.message
        }
        redirect(controller:"question")
    }


}