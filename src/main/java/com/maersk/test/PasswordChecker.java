package com.maersk.test;

import com.maersk.test.exception.BadPasswordException;

import java.util.List;
import java.util.function.Predicate;

/**
 * Password Validator
 */
public class PasswordChecker {

    private static final Predicate<List<BadPasswordException>> OK_PREDICATE = (exp) -> exp.size() <=2 && exp.stream().filter(ex -> ex.getStep() == 4).findFirst().isEmpty();

    public static void main(String[] args) {
        System.out.println(check("sssss"));
    }

    public static String check(String password) {
        final PasswordValidator passwordValidator = new PasswordValidator();
        final List<BadPasswordException> exceptions = passwordValidator.evaluate(password);
        if (exceptions.isEmpty() || OK_PREDICATE.test(exceptions)) {
            return "OK";
        }
        return "NOT_OK";
    }
}
