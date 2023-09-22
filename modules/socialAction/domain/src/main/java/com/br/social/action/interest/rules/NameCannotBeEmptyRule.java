package com.br.social.action.interest.rules;

public class NameCannotBeEmptyRule implements BusinessRule {
    private final String name;

    public NameCannotBeEmptyRule(String name) { this.name = name; }

    @Override
    public String getId() { return "NAME_CANNOT_BE_EMPTY"; }

    @Override
    public String getMessage() {
        return "The name of the social action must not be empty";
    }

    @Override
    public Boolean isBroken() {
        return name.isEmpty();
    }
}
