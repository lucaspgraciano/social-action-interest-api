package com.br.social.action.interest;

import java.time.LocalDateTime;

public class CompletedAt extends ValueObject<LocalDateTime> {
    public CompletedAt(LocalDateTime value) {
        setValue(value);
    }
}
