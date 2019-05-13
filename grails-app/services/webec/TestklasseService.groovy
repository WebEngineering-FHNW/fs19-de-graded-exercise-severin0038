package webec

import grails.gorm.services.Service

@Service(Testklasse)
interface TestklasseService {

    Testklasse get(Serializable id)

    List<Testklasse> list(Map args)

    Long count()

    void delete(Serializable id)

    Testklasse save(Testklasse testklasse)

}