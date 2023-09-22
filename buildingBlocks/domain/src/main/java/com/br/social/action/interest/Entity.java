package com.br.social.action.interest;

import com.br.social.action.interest.rules.BusinessRule;
import com.br.social.action.interest.rules.BusinessRuleValidationException;

public abstract class Entity {

    protected void checkRule(BusinessRule rule) throws Exception {
        if (rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
}
