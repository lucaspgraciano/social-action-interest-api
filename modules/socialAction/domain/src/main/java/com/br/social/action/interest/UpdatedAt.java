package com.br.social.action.interest;

import java.time.LocalDateTime;

public class UpdatedAt extends ValueObject<LocalDateTime> {
    public UpdatedAt(LocalDateTime value) {
        setValue(value);
    }
}
