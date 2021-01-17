package com.haythamxu.blogpostman.utils;

import java.security.SecureRandom;
import java.util.Random;

public class CodeGeneratorUtil {

    public static final String ALPHANUMERIC = CodeGeneratorUtil.ALPHA + CodeGeneratorUtil.NUMERIC;

    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static final String NUMERIC = "0123456789";

    private static final Random RAND = new SecureRandom();

    public static String randomAlphanumeric(int amountOfChars) {
        return CodeGeneratorUtil.random(CodeGeneratorUtil.ALPHANUMERIC, amountOfChars);
    }

    private static String random(final String universe, final int amountOfChars) {
        final StringBuilder ret = new StringBuilder(amountOfChars);
        for(int i=0;i<amountOfChars;i++) {
            ret.append(CodeGeneratorUtil.random(universe));
        }
        return ret.toString();
    }

    private static char random(final String universe) {
        return universe.charAt(CodeGeneratorUtil.RAND.nextInt(universe.length()));
    }

}
