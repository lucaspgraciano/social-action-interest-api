package com.br.social.action.interest;

import java.time.LocalDateTime;

public class CreatedAt extends ValueObject<LocalDateTime> {
    public CreatedAt(LocalDateTime value) {
        setValue(value);
    }
}
