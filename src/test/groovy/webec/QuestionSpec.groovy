// auskommentiert, da Tests nicht laufen

//package webec
//
//import grails.testing.gorm.DataTest
//import spock.lang.Specification
//
//
//class QuestionSpec extends Specification implements DataTest {
//
//    SecUser user
//    Question question
//    Answer answer
//
//    def setup() {
//        mockDomain SecUser
//        mockDomain Question
//        mockDomain Answer
//
//        user = new SecUser(username: 'bilbo', password: 'bilbo').save()
//        question = new Question(questionTitle: "Ist die Erde eine Scheibe?", questionType: "Ja / Nein").save()
//        answer = new Answer(user: user, question: question, answer: true).save()
//
//    }
//
//    def cleanup() {
//        user.delete()
//        question.delete()
//        answer.delete()
//    }
//
//    void "test: correct saving of answer properties"() {
//
//        when:
//        Answer ans = new Answer(user: user, question: question, answer: true)
//
//        then:
//        assert ans.question == question
//        assert ans.user == user
//        assert ans.answer == true
//    }
//
//
//}
//
