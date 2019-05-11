package webec

import grails.util.Environment
import webec.SecRole
import webec.SecUser
import webec.SecUserSecRole

import javax.security.auth.login.FailedLoginException

class BootStrap {

    def init = { servletContext ->

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))


        SecUser guest  = save(new SecUser(username: 'guest', password: 'guest'))
        SecUserSecRole.create(guest, guestRole, true)

        if (Environment.current == Environment.PRODUCTION) return; // guard clause

        SecUser testUser  = save(new SecUser(username: 'me', password: 'toobad'))
        SecUserSecRole.create(testUser, adminRole, true) //flush

        // plausibility check
        assert SecRole.count()          == 2
        assert SecUser.count()          == 2
        assert SecUserSecRole.count()   == 2

        save(new Question(questionTitle: "Ist WebeC dein Lieblingsmodul?", questionType: "Ja / Nein", answersNegative: 0, answersPositive: 0))
        save(new Question(questionTitle: "Hast du heute Pasta gegessen?", questionType: "Ja / Nein", answersNegative: 2, answersPositive: 0))
        save(new Question(questionTitle: "Kantine der FHNW", questionType: "Mag ich / Mag ich nicht", answersNegative: 3, answersPositive: 5))
        save(new Question(questionTitle: "Herr König ist der beste Dozent der FHNW", questionType: "Ich stimme zu / Ich lehene ab", answersNegative: 0, answersPositive: 3))

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