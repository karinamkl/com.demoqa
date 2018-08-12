package com.demoqa.utility;

import org.testng.annotations.DataProvider;

public class DataProvidersRegistrationLogin {


    @DataProvider(name = "Invalid Emails")
    public static Object[][] invalidEmails() {
        return new Object[][]{
                {"test"},
                {"testAtgmail.com"},
                {"test@gmail"},
                {"test@gmailcom"},
                {"@gmail"}
        };
    }

    @DataProvider(name = "Invalid Phone Numbers")
    public static Object[][] invalidPhoneNumbers() {
        return new Object[][]{
                {"dada5$7567#7"},
                {"813800999"},
                {"1d23456789"},
        };
    }

    @DataProvider(name = "Passwords less than 8 chars")
    public static Object[][] passLessThan8Chars() {
        return new Object[][] {
                {"test"},
                {"Passwo"},
                {"#$test@"}
        };
    }

    @DataProvider(name = "Very Weak Passwords")
    public static Object[][] veryWeakPasswords() {
        return new Object[][] {
                {"test1234"},
                {"Temp!2345"},
                {"Password@18"}
        };
    }


    @DataProvider(name = "Weak Passwords")
    public static Object[][] weakPasswords() {
        return new Object[][] {
                {"whcwbyda"},
                {"5479437253"}
        };
    }

    @DataProvider(name = "Medium Passwords")
    public static Object[][] mediumPasswords() {
        return new Object[][] {
                {"6ng8g88z"},
                {"xAESxpnD"}
        };
    }

    @DataProvider(name = "Strong Passwords")
    public static Object[][] strongPasswords() {
        return new Object[][] {
                {"6~(u_,)HW"},
                {"1x81689w6z7a"}
        };
    }

    @DataProvider(name = "Login Credentials")
    public static Object[][] loginCreds() {
        return new Object[][] {
                {"bayshoretst@gmail.com", "Test1234!"}
        };
    }


}
