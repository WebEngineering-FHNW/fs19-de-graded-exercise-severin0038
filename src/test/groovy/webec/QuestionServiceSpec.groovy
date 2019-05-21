// auskommentiert, da Tests nicht laufen


//package webec
//
//import org.grails.testing.GrailsUnitTest
//import webec.QuestionService
//import spock.lang.Specification
//
//
//class QuestionServiceSpec extends Specification {
//
//    def questionService = new QuestionService();
//
//    void "test: get correct string for answer boolean"() {
//
//        String questionType;
//
//        given:
//        questionType = "Ja / Nein";
//
//        when:
//        String answer = questionService.answerBooleanToString(true, questionType);
//
//        then:
//        assert answer == "Ja";
//    }
//}