package com.maersk.test;

import com.maersk.test.exception.BadPasswordException;

import java.util.ArrayList;
import java.util.List;

import static com.maersk.test.helper.ValidatorPredicate.*;

public class PasswordValidator {

    public List<BadPasswordException> evaluate(String password) {
        List<BadPasswordException> exceptions = new ArrayList<>(0);
        if (EMPTY_PREDICATE.negate().test(password)) {
            exceptions.add(new BadPasswordException(1));
        }
        if (LENGTH_PREDICATE.negate().test(password)) {
            exceptions.add(new BadPasswordException(2));
        }
        if (UPPERCASE_PREDICATE.negate().test(password)) {
            exceptions.add(new BadPasswordException(3));
        }
        if (LOWERCASE_PREDICATE.negate().test(password)) {
            exceptions.add(new BadPasswordException(4));
        }
        if (DIGIT_PREDICATE.negate().test(password)) {
            exceptions.add(new BadPasswordException(5));
        }

        return exceptions;
    }
}
