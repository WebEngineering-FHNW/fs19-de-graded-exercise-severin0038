package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        // in production or test, this might already be in the DB

        //rollen erstellen
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole normalRole = save(SecRole.findOrCreateWhere(authority: SecRole.NORMAL))

        if (Environment.current == Environment.PRODUCTION) return; // guard clause

        SecUser severin  = save(new SecUser(username: 'severin', password: 'severin'))
        SecUserSecRole.create(severin, normalRole, true)

        SecUser dani  = save(new SecUser(username: 'dani', password: 'dani'))
        SecUserSecRole.create(dani, normalRole, true)

        SecUser noemi  = save(new SecUser(username: 'noemi', password: 'noemi'))
        SecUserSecRole.create(noemi, normalRole, true)

        SecUser debby  = save(new SecUser(username: 'debby', password: 'debby'))
        SecUserSecRole.create(debby, normalRole, true)

        SecUser nati  = save(new SecUser(username: 'nati', password: 'nati'))
        SecUserSecRole.create(nati, normalRole, true)

        SecUser chris  = save(new SecUser(username: 'chris', password: 'chris'))
        SecUserSecRole.create(chris, normalRole, true)

        SecUser admin  = save(new SecUser(username: 'admin', password: 'admin'))
        SecUserSecRole.create(admin, adminRole, true)

        //Fragen erstellen
        Question question1 = save(new Question(questionTitle: "Ist WebeC dein Lieblingsmodul?", questionType: "Ja / Nein", answersNegative: 1, answersPositive: 4))
        Question question2 = save(new Question(questionTitle: "Hast du heute Pasta gegessen?", questionType: "Ja / Nein", answersNegative: 3, answersPositive: 0))
        Question question3 = save(new Question(questionTitle: "Kantine der FHNW", questionType: "Mag ich / Mag ich nicht", answersNegative: 2, answersPositive: 3))
        save(new Question(questionTitle: "Herr König ist der beste Dozent der FHNW", questionType: "Ich stimme zu / Ich lehene ab", answersNegative: 0, answersPositive: 0))

        //Antworten erstellen
        save(new Answer(user: severin, question: question1, answer: true))
        save(new Answer(user: dani, question: question1, answer: true))
        save(new Answer(user: dani, question: question2, answer: false))
        save(new Answer(user: dani, question: question3, answer: false))
        save(new Answer(user: noemi, question: question1, answer: false))
        save(new Answer(user: noemi, question: question2, answer: false))
        save(new Answer(user: noemi, question: question3, answer: true))
        save(new Answer(user: debby, question: question1, answer: true))
        save(new Answer(user: debby, question: question3, answer: true))
        save(new Answer(user: nati, question: question3, answer: false))
        save(new Answer(user: chris, question: question1, answer: true))
        save(new Answer(user: chris, question: question2, answer: false))
        save(new Answer(user: chris, question: question3, answer: true))
        save(new Answer(user: admin, question: question3, answer: true))


    }

    static <D> D save(D domainObject) {
        domainObject.save(failOnError: true, flush:true)
    }

    def destroy = {
    }
}

/*
package webec

class BootStrap {

    def init = { servletContext ->
    }
    def destroy = {
    }
}
*/