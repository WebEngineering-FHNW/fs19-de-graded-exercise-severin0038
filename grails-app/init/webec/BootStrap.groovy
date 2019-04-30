package webec

class BootStrap {

    def init = { servletContext ->
    }
    def destroy = {
    }
}

/*
package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        if (Environment.current == Environment.PRODUCTION) return; // guard clause

        save(new Question(questionTitle: "WebeC ist mein Lieblingsmodul", questionType: "Ja / Nein").save(flush:true))

    }

    static <D> D save(D domainObject) {
        domainObject.save(failOnError: true, flush:true)
    }

    def destroy = {
    }
}

 */