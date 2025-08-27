package org.trial;

import java.util.*;

public final class PasswordValidator {
    static final Set<String> commonPasswords = new HashSet<>(Arrays.asList("password", "passwort1", "12345678", "aa345678"));

    public static boolean hasMinLength(String password, int min) {
        return password != null && !password.isEmpty() && password.length() >= min;
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

        String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowers = "abcdefghijklmnopqrstuvwxyz";

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
        return commonPasswords.contains(p);
    }

    public static boolean isValid(String password) {
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

        // final
        System.out.println("Password is valid!");
        return true;
    }

//    public static boolean containsSpecialChar(String password, String allowed);



}
