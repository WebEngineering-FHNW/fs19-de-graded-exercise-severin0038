package webec

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TestklasseController {

    TestklasseService testklasseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testklasseService.list(params), model:[testklasseCount: testklasseService.count()]
    }

    def show(Long id) {
        respond testklasseService.get(id)
    }

    def create() {
        respond new Testklasse(params)
    }

    def save(Testklasse testklasse) {
        if (testklasse == null) {
            notFound()
            return
        }

        try {
            testklasseService.save(testklasse)
        } catch (ValidationException e) {
            respond testklasse.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testklasse.label', default: 'Testklasse'), testklasse.id])
                redirect testklasse
            }
            '*' { respond testklasse, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testklasseService.get(id)
    }

    def update(Testklasse testklasse) {
        if (testklasse == null) {
            notFound()
            return
        }

        try {
            testklasseService.save(testklasse)
        } catch (ValidationException e) {
            respond testklasse.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'testklasse.label', default: 'Testklasse'), testklasse.id])
                redirect testklasse
            }
            '*'{ respond testklasse, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testklasseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'testklasse.label', default: 'Testklasse'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testklasse.label', default: 'Testklasse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


    def testTest() {
        Question question = Question.findById(2);
        SecUser user = SecUser.findByUsername("guest");
        boolean answer = true;

        def testklasse = new Testklasse();
        testklasse.question = question;
        testklasse.user = user;
        testklasse.answer = answer;

        testklasse.save(flush: true)
    }

//    Testklasse(Question question, SecUser user, boolean answer) {
//        this.question = question;
//        this.user = user;
//        this.answer = answer;
//    }
}
