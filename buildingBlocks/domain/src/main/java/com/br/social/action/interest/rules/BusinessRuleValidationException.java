package com.br.social.action.interest.rules;

public class BusinessRuleValidationException extends Exception {

    public BusinessRule brokenRule;
    public String id;
    public String message;

    public BusinessRuleValidationException(BusinessRule brokenRule) {
        this.brokenRule = brokenRule;
        this.id = brokenRule.getId();
        this.message = brokenRule.getMessage();
    }
}
