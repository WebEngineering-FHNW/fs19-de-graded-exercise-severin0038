package webec

import grails.plugin.springsecurity.annotation.Secured

class Answer {

    int question_id;
    int user_id;
    boolean answer;

    static constraints = {
    }
}
