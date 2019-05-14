package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.NORMAL))


        SecUser guest  = save(new SecUser(username: 'guest', password: 'guest'))
        SecUserSecRole.create(guest, guestRole, true)

        SecUser guest2  = save(new SecUser(username: 'guest2', password: 'guest2'))
        SecUserSecRole.create(guest2, guestRole, true)

        if (Environment.current == Environment.PRODUCTION) return; // guard clause

        SecUser testUser  = save(new SecUser(username: 'me', password: 'toobad'))
        SecUserSecRole.create(testUser, adminRole, true) //flush

        // plausibility check
//        assert SecRole.count()          == 2
//        assert SecUser.count()          == 2
//        assert SecUserSecRole.count()   == 2

        save(new Question(questionTitle: "Ist WebeC dein Lieblingsmodul?", questionType: "Ja / Nein", answersNegative: 0, answersPositive: 0))
        save(new Question(questionTitle: "Hast du heute Pasta gegessen?", questionType: "Ja / Nein", answersNegative: 2, answersPositive: 0))
        save(new Question(questionTitle: "Kantine der FHNW", questionType: "Mag ich / Mag ich nicht", answersNegative: 3, answersPositive: 5))
        save(new Question(questionTitle: "Herr König ist der beste Dozent der FHNW", questionType: "Ich stimme zu / Ich lehene ab", answersNegative: 0, answersPositive: 3))
        save(new Answer(user_id: 1, question_id: 2, answer: true))
        save(new Answer(user_id: 1, question_id: 1, answer: false))
        save(new Answer(user_id: 2, question_id: 3, answer: true))
        save(new Answer(user_id: 1, question_id: 4, answer: true))

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