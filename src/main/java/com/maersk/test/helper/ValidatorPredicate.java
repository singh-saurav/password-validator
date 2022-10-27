package com.maersk.test.helper;


import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public final class ValidatorPredicate {

    public static final Predicate<String> LENGTH_PREDICATE = (p) -> StringUtils.length(p) > 8;
    public static final Predicate<String> EMPTY_PREDICATE = (p) -> StringUtils.isNotBlank(p);
    public static final Predicate<String> LOWERCASE_PREDICATE = (p) -> p.matches("(.*[a-z].*)");
    public static final Predicate<String> UPPERCASE_PREDICATE = (p) -> p.matches("(.*[A-Z].*)");
    public static final Predicate<String> DIGIT_PREDICATE = (p) -> p.matches("(.*\\d.*)");

}
