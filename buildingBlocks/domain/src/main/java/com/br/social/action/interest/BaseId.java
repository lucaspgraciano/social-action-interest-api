package com.br.social.action.interest;


import java.util.UUID;

public abstract class BaseId {

    private final UUID value;

    protected BaseId(UUID value) throws Exception {
        if (value == null) {
            throw new Exception("Id cannot be null");
        }

        this.value = value;
    }

    public UUID getValue() {
        return value;
    }
}
