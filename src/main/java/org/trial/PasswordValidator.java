package org.trial;

import java.security.SecureRandom;
import java.util.*;

public final class PasswordValidator {
    static final Set<String> COMMON_PASSWORDS = new HashSet<>(Arrays.asList("password", "passwort1", "12345678", "aa345678"));
    static final String ALLOWED_SPECIALS = "!@#$%^&*()-_+=?.,;:";
    static final int MIN_LENGTH = 8;
    static final String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String lowers = "abcdefghijklmnopqrstuvwxyz";

    public static boolean hasMinLength(String password, int min) {
        return password != null && password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null || password.isEmpty()) return false;

        char[] chars = password.toCharArray();

        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        if (password == null || password.isEmpty()) return false;
        if (password.length() == 1) return false;

        boolean foundUpper = false;
        boolean foundLower = false;

        for (int i = 0; i < password.length(); i++) {
            if (uppers.contains(String.valueOf(password.charAt(i)))) {
                foundUpper = true;
            }

            if (lowers.contains(String.valueOf(password.charAt(i)))) {
                foundLower = true;
            }

            if (foundLower && foundUpper) {
                return true;
            }

        }

        return false;

    }

    public static boolean isCommonPassword(String password) {
        String p = (password == null ? "" : password.trim().toLowerCase(Locale.ROOT));
        return COMMON_PASSWORDS.contains(p);
    }

    public static boolean containsSpecialChar(String password) {
        if (password == null || password.isEmpty()) return false;

        for (int i = 0; i < password.length(); i++) {
            if (ALLOWED_SPECIALS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValid(String password) {
        if (password == null || password.isEmpty()) return false;
        if (!hasMinLength(password, 8)) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        if (!containsDigit(password)) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        if (!containsUpperAndLower(password)) {
            System.out.println("Password must contain both uppercase and lowercase letters.");
            return false;
        }

        if (isCommonPassword(password)) {
            System.out.println("Password is too common/weak.");
            return false;
        }

        if (!containsSpecialChar(password)) {
            System.out.println("Password must contain at least one special char: '!@#$%^&*()-_+=?.,;:'");
            return false;
        }

        // final
        System.out.println("Password is valid!");
        return true;
    }

    public static String generateSecurePassword() {

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 4; i++) {

            str.append(uppers.charAt(secureRandom.nextInt(uppers.length())));
            str.append(lowers.charAt(secureRandom.nextInt(lowers.length())));
            str.append(ALLOWED_SPECIALS.charAt(secureRandom.nextInt(ALLOWED_SPECIALS.length())));
            str.append(secureRandom.nextInt(10));

        }
        System.out.println("Old str: " + str);

        List<String> newStrList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            newStrList.add(String.valueOf(str.charAt(i)));
        }
        Collections.shuffle(newStrList);

        String result = String.join("", newStrList);

        System.out.println("New str: " + result);

        return result;

    }
}
