package com.br.social.action.interest.rules;

import com.br.social.action.interest.BusinessRule;

public class DescriptionCannotBeEmptyRule implements BusinessRule {
    private final String name;

    public DescriptionCannotBeEmptyRule(String name) {
        this.name = name;
    }

    @Override
    public String getId() { return "DESCRIPTION_CANNOT_BE_EMPTY"; }

    @Override
    public String getMessage() { return "The description of the social action must not be empty"; }

    @Override
    public Boolean isBroken() {
        return name.isEmpty();
    }
}
