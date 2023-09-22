package com.br.social.action.interest;

public abstract class ValueObject<TType> {

    private TType value;

    protected void checkRule(BusinessRule rule) throws Exception {
        if (rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }

    public void setValue(TType value) { this.value = value; }

    public TType getValue() { return value; }
}
