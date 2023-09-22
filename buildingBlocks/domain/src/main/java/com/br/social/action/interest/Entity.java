package com.br.social.action.interest;

public abstract class Entity {

    protected void checkRule(BusinessRule rule) throws Exception {
        if (rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
}
