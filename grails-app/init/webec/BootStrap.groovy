package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        if (Environment.current == Environment.PRODUCTION) return; // guard clause

        SecUser me = new SecUser(username: "me", password: "1234").save(flush:true);
        SecRole admin = new SecRole(authority: SecRole.ROLE_ADMIN).save(flush:true);
        new SecUserSecRole(secUser: me, secRole: admin).save(flush:true);


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