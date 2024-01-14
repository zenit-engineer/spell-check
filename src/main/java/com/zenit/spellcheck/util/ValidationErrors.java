package com.zenit.spellcheck.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationErrors {

    private ValidationErrors() {

        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");

    }

    /* This regex valid given word must only contains letters a-z or A-Z */
    public static boolean isValidString(String word) {

        String regex = "^[A-Za-z]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(word);

        return matcher.matches();

    }

}

