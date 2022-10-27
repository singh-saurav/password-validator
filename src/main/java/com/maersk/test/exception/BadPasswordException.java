package com.maersk.test.exception;

import org.apache.commons.lang3.StringUtils;

public class BadPasswordException extends RuntimeException {
    int step;

    public BadPasswordException(int step) {
        super("Bad Password");
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public String errorMessage() {
        switch (step) {
            case 1:
                return "Password should not be empty.";
            case 2:
                return "Password should be greater than 8 chars.";
            case 3:
                return "Password should contain at least one uppercase letter.";
            case 4:
                return "Password should contain at least one lowercase letter.";
            case 5:
                return "Password should contain at least one digit.";
            default:
                return StringUtils.EMPTY;
        }
    }

}
