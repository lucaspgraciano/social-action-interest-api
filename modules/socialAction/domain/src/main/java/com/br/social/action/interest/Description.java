package com.br.social.action.interest;

import com.br.social.action.interest.rules.DescriptionCannotBeEmptyRule;

public class Description extends ValueObject<String> {

    public Description(String value) throws Exception {
        checkRule(new DescriptionCannotBeEmptyRule(value));

        setValue(value);
    }
}
