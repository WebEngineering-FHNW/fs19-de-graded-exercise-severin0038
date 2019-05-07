package webec

import grails.plugin.springsecurity.annotation.Secured

@Secured(SecRole.ROLE_ADMIN)
class Answer {

    int question_id;
    int user_id;
    boolean answer;

    static constraints = {
    }
}
