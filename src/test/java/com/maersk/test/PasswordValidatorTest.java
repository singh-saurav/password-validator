package com.maersk.test;

import com.maersk.test.exception.BadPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator = new PasswordValidator();

    @DisplayName("Password satisfying conditions.")
    @Test
    void passwordMatchesConditionValidTest() {
        assertTrue(passwordValidator.evaluate("Password123").size() == 0);
    }

    @DisplayName("Password is empty.")
    @Test
    void emptyConditionTest() {
        assertTrue(passwordValidator.evaluate("").size() == 5);
    }

    @DisplayName("Password less then 8 chars.")
    @Test
    void lengthConditionFalseTest() {
        List<BadPasswordException> evaluate = passwordValidator.evaluate("Pwd1");
        assertTrue(evaluate.size() == 1);
        assertEquals("Password should be greater than 8 chars.", evaluate.get(0).errorMessage());
    }

    @DisplayName("Password doesn't contain at least one uppercase.")
    @Test
    void upperCaseConditionFalseTest() {
        List<BadPasswordException> evaluate = passwordValidator.evaluate("password123");
        assertTrue(evaluate.size() == 1);
        assertEquals("Password should contain at least one uppercase letter.", evaluate.get(0).errorMessage());
    }

    @DisplayName("Password doesn't contain at least one lowercase.")
    @Test
    void lowerCaseConditionFalseTest() {
        List<BadPasswordException> evaluate = passwordValidator.evaluate("PASSWORD123");
        assertTrue(evaluate.size() == 1);
        assertEquals("Password should contain at least one lowercase letter.", evaluate.get(0).errorMessage());
    }

    @DisplayName("Password doesn't contain at least one digit.")
    @Test
    void digitConditionFalseTest() {
        List<BadPasswordException> evaluate = passwordValidator.evaluate("PasswordTesting");
        assertTrue(evaluate.size() == 1);
        assertEquals("Password should contain at least one digit.", evaluate.get(0).errorMessage());
    }
}
