package com.br.social.action.interest;

public abstract class BaseId {

    private final Long value;

    protected BaseId(Long value) throws Exception {
        if (value == null) {
            throw new Exception("Id cannot be null");
        }

        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
