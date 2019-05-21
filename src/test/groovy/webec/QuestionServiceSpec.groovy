package webec

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification


class QuestionServiceSpec extends Specification implements ServiceUnitTest<QuestionService>{

        void "test method calculatePercentagesForEvaluation"() {
            given:
            int answersPositive
            int answersNegative

            when:
            answersPositive = 5;
            answersNegative = 1;

            then:
            assert webec.QuestionService.calculatePercentagesForEvaluation(answersPositive, answersNegative, true) == 100
            assert webec.QuestionService.calculatePercentagesForEvaluation(answersPositive, answersNegative, false) == 0
        }
}

