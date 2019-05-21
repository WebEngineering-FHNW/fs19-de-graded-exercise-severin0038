//package webec
//
//import grails.testing.mixin.integration.Integration
//import grails.transaction.*
//import geb.spock.GebSpec
//import geb.spock.*
//
///**
// * See http://www.gebish.org/manual/current/ for more instructions
// */
//@Integration
//@Rollback
//class LoginAccessSpec extends GebSpec {
//
//    def setup() {
//    }
//
//    def cleanup() {
//    }
//
//    void "secured guest access of task overview"() {
//
//        when:
//        go '/question/openQuestions'
//
//        then: "security leads us to login screen"
//        title == "Anmeldung"
//
////        when:
////        $("form").username = "severin"
////        $("form").password = "severin"
////        $("input", type: "submit").click()
////
////        then: "successful login leads to requested task overview page"
////        title == "Swipinion - offene Fragen"
////
////
////        when:
////        go '/logout'
////
////        then:
////        title == 'Anmeldung'
//
//    }
///*
//    void "secured admin access of person overview"() {
//
//        when: "case 1: guest"
//        go '/person'
//
//        then: "security leads us to login screen"
//        title == "Login"
//
//        when: "enter guest login"
//        $("form").username = "guest"
//        $("form").password = "guest"
//        $("input", type: "submit").click()
//
//        then: "login not successful, only admin access"
//        title == "Zugriff abgelehnt"
//
//
//        when: "case 2: admin"
//        go '/logout'
//        go '/person'
//
//        then: "security leads us to login screen"
//        title == "Login"
//
//        when: "enter admin login"
//        $("form").username = "admin"
//        $("form").password = "admin"
//        $("input", type: "submit").click()
//
//        then: "successful login leads to requested person overview page"
//        title == "Mitbewohnerinnen der Villa Kunterbunt"
//
//    }*/
//
//}