package com.br.social.action.interest;

import com.br.social.action.interest.rules.NameCannotBeEmptyRule;

public class Name extends ValueObject<String>{

    public Name(String value) throws Exception {
        checkRule(new NameCannotBeEmptyRule(value));

        setValue(value);
    }

}
