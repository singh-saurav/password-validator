package com.maersk.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordCheckerTest {

    @DisplayName("OK password matching all or special conditions.")
    @ParameterizedTest
    @Timeout(value = 1)
    @ValueSource(strings = {"Password123", "passwd1"})
    void checkOk(String password) {
        assertEquals("OK", PasswordChecker.check(password));
    }

    @DisplayName("NOT_OK password not matching all or special conditions.")
    @ParameterizedTest
    @Timeout(value = 1)
    @ValueSource(strings = {"", "passwd", "SAURAV"})
    void checkInValid(String password) {
        assertEquals("NOT_OK", PasswordChecker.check(password));
    }
}