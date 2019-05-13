package webec

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TestklasseServiceSpec extends Specification {

    TestklasseService testklasseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Testklasse(...).save(flush: true, failOnError: true)
        //new Testklasse(...).save(flush: true, failOnError: true)
        //Testklasse testklasse = new Testklasse(...).save(flush: true, failOnError: true)
        //new Testklasse(...).save(flush: true, failOnError: true)
        //new Testklasse(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //testklasse.id
    }

    void "test get"() {
        setupData()

        expect:
        testklasseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Testklasse> testklasseList = testklasseService.list(max: 2, offset: 2)

        then:
        testklasseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testklasseService.count() == 5
    }

    void "test delete"() {
        Long testklasseId = setupData()

        expect:
        testklasseService.count() == 5

        when:
        testklasseService.delete(testklasseId)
        sessionFactory.currentSession.flush()

        then:
        testklasseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Testklasse testklasse = new Testklasse()
        testklasseService.save(testklasse)

        then:
        testklasse.id != null
    }
}
