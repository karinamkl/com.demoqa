package com.demoqa;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.utility.DataProvidersRegistrationLogin;
import com.demoqa.utility.EmailGenerator;
//import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ReportPortalTestNGListener.class})
public class RegisterTest extends BaseClass {

    RegistrationPage registrationPage = new RegistrationPage();
    public String email = EmailGenerator.generateUniqueEmail();

    @Test(description = "TC-001: Check the required fields by not filling any data")
    void registerAccNoData() {
        registrationPage
                .open()
                .submit();
        Assert.assertEquals(registrationPage.getErrors(7, "* This field is required"), "* This field is required");
      //  LoggingUtils.log()
    }


    @Test(description = "TC-002: Check the required fields by filling the data")
    void registerAcc() {
        registrationPage
                .open()
                .requiredFields("Test", "QA", "Reading", "1234567890", email, "Test1234!")
                .submit();
        Assert.assertEquals(registrationPage.getSuccessMessage(), "Thank you for your registration");
    }

    @Test(description = "TC-003: Check all the optional field when do not fill data")
    void registerAccEmptyOptional() {
        registrationPage
                .open()
                .requiredFields("Test", "QA", "Dance", "1234567890", EmailGenerator.generateUniqueEmail(), "AJFI234!")
                // .optionalFields("", "Afghanistan", "Month", "Day", "Year", "", "")
                .submit();
        Assert.assertEquals(registrationPage.getSuccessMessage(), "Thank you for your registration");

    }

    @Test(description = "TC-004: Check all the optional field when fill data")
    void registerAccountAllFields() {
        registrationPage
                .open()
                .requiredFields("Test", "QA", "Cricket ", "1234567890", EmailGenerator.generateUniqueEmail(), "Test1234!")
                .optionalFields("Married", "United States", "12", "1", "1994",
                        "misc//profilepic.png", "about me placeholder text")
                .submit();
        Assert.assertEquals(registrationPage.getSuccessMessage(), "Thank you for your registration");
    }

    @Test(description = "TC-005: Check email validation", dataProvider = "Invalid Emails", dataProviderClass = DataProvidersRegistrationLogin.class)
    void registrationEmailValidation(String email) {
        registrationPage
                .open()
                .setEmail(email)
                .submit();
        Assert.assertEquals(registrationPage.getErrors(1, "* Invalid email address"), "* Invalid email address");
    }

    @Test(description = "TC-006: Check phone number validation", dataProvider = "Invalid Phone Numbers", dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPhoneNumberValidation(String phoneNumber) {
        registrationPage
                .open()
                .setPhoneNumber(phoneNumber)
                .submit();
        Assert.assertEquals(registrationPage.getErrors(1, "* Minimum 10 Digits starting with Country Code"),
                "* Minimum 10 Digits starting with Country Code");
    }

    @Test(description = "TC-007: Check the password validation when enter value less than 8 characters", dataProvider = "Passwords less than 8 chars",
            dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPassValidationLessThan8Chars(String pass) {
        registrationPage
                .open()
                .setPassword(pass);
        Assert.assertEquals(registrationPage.getErrors(1, "* Minimum  8  characters required"), "* Minimum  8  characters required");
    }

    @Test(description = "TC-008: Check the password validation entering very weak passwords", dataProvider = "Very Weak Passwords", dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPassValidationVeryWeakPass(String pass) {
        registrationPage
                .open()
                .setPassword(pass);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), "Very weak");
    }

    @Test(description = "TC-009: Check the password validation entering weak passwords", dataProvider = "Weak Passwords", dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPassValidationWeakPass(String pass) {
        registrationPage
                .open()
                .setPassword(pass);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), "Weak");
    }

    @Test(description = "TC-010: Check the password validation entering medium passwords", dataProvider = "Medium Passwords", dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPassValidationMediumPass(String pass) {
        registrationPage
                .open()
                .setPassword(pass);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), "Medium");
    }

    @Test(description = "TC-011: Check the password validation entering strong passwords", dataProvider = "Strong Passwords", dataProviderClass = DataProvidersRegistrationLogin.class)
    void checkPassValidationStrongPass(String pass) {
        registrationPage
                .open()
                .setPassword(pass);
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), "Strong");
    }
}
