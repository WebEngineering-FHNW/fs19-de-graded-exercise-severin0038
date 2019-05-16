package webec

import grails.plugin.springsecurity.annotation.Secured

class Answer {

    Question question;
    SecUser user;
    boolean answer;

    static constraints = {
    }
}
