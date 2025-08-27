package org.trial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void hasMinLength_ShouldBeTrue_ifLengthMoreThan_8() {
        String str = "12345678";
        int min = 8;

        boolean expected = true;

        boolean actual = PasswordValidator.hasMinLength(str, min);

        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldBeFalse_ifLengthMoreThan_7() {
        String str = "1234567";
        int min = 8;

        boolean expected = false;

        boolean actual = PasswordValidator.hasMinLength(str, min);

        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldBeTrue_ifLengthMoreThan_9() {
        String str = "123456789";
        int min = 8;

        boolean expected = true;

        boolean actual = PasswordValidator.hasMinLength(str, min);

        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldBeFalse_ifStringIs_Empty() {
        String str = "";
        int min = 8;

        boolean expected = false;

        boolean actual = PasswordValidator.hasMinLength(str, min);

        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldBeFalse_ifStringIs_Null() {
        String str = null;
        int min = 8;

        boolean expected = false;

        boolean actual = PasswordValidator.hasMinLength(str, min);

        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldBeTrueContains_OneDigit() {
        String str = "mypassword1";

        boolean expected = true;

        boolean actual = PasswordValidator.containsDigit(str);

        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldBeFalseContains_ZeroDigit() {
        String str = "mypassword";

        boolean expected = false;

        boolean actual = PasswordValidator.containsDigit(str);

        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldBeTrueContains_Digits() {
        String str = "mypassword1111";

        boolean expected = true;

        boolean actual = PasswordValidator.containsDigit(str);

        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldBeTrueContains_OnlyDigits() {
        String str = "123456781111";

        boolean expected = true;

        boolean actual = PasswordValidator.containsDigit(str);

        assertEquals(expected, actual);
    }


    @Test
    void containsUpperAndLower_shouldBeFalse_whenContains_OnlyUpper() {
        String str = "MYPASSWORD";

        boolean expected = false;

        boolean actual = PasswordValidator.containsUpperAndLower(str);

        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_shouldBeFalse_whenContains_OnlyLower() {
        String str = "mypassword";

        boolean expected = false;

        boolean actual = PasswordValidator.containsUpperAndLower(str);

        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_shouldBeTrue_whenContains_UpperAndLower() {
        String str = "MYpasSworD";

        boolean expected = true;

        boolean actual = PasswordValidator.containsUpperAndLower(str);

        assertEquals(expected, actual);

    }

    @Test
    void containsUpperAndLower_shouldBeTrue_whenContains_One() {
        String str = "D";

        boolean expected = false;

        boolean actual = PasswordValidator.containsUpperAndLower(str);

        assertEquals(expected, actual);

    }

    @Test
    void isCommonPassword_shouldBeFalse_whenStrIs_password() {
        String str = "password";

        boolean expected = true;

        boolean actual = PasswordValidator.isCommonPassword(str);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldBeFalse_whenStrIs_PASSWORD() {
        String str = "PASSWORD";

        boolean expected = true;

        boolean actual = PasswordValidator.isCommonPassword(str);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldBeFalse_whenStrIs_Passwort1() {
        String str = "Passwort1";

        boolean expected = true;

        boolean actual = PasswordValidator.isCommonPassword(str);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldBeFalse_whenStrIs_12345678() {
        String str = "12345678";

        boolean expected = true;

        boolean actual = PasswordValidator.isCommonPassword(str);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldBeFalse_whenStrIs_Aa345678() {
        String str = "Aa345678";

        boolean expected = true;

        boolean actual = PasswordValidator.isCommonPassword(str);

        assertEquals(expected, actual);
    }

    // final tests

    @Test
    void isValid_shouldBeFalse_whenStrIs_Null() {
        String str = null;

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_Empty() {
        String str = "";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeTrue_whenStrIs_ThisisValidPassword() {
        String str = "ThisisValidPassword2";

        boolean expected = true;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_WithoutNumbers() {
        String str = "ThisisNotValidPassword";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeTrue_whenStrIs_ValidPassword() {
        String str = "KrainaMrii0384940-'";

        boolean expected = true;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_OneLetter() {
        String str = "G";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_WithoutLetters() {
        String str = "7484940304949-4044";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_TooShort() {
        String str = "Abc1def";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldBeFalse_whenStrIs_CommonPassword() {
        String str = "Passwort1";

        boolean expected = false;

        boolean actual = PasswordValidator.isValid(str);

        assertEquals(expected, actual);
    }

}