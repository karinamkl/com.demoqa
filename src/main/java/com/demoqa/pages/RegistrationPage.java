package com.demoqa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.demoqa.utility.ElementFinders;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    ElementFinders ef = new ElementFinders();
    //@FindBy(name = "radio_4[]") public ElementsCollection martialSt;
    // @FindBy(name = "checkbox_5[]") public ElementsCollection hobbyName;
    ElementsCollection martialSt = $$(By.name("radio_4[]"));
    ElementsCollection hobbyName = $$(By.name("checkbox_5[]"));

    public RegistrationPage open() {
        Selenide.open("/registration");
        return this;
    }

    // Fill out required fields
    public RegistrationPage requiredFields(String firstName, String lastName, String hobby, String phone, String email, String pass) {
        setFirstAndLastNames(firstName, lastName);
        setHobby(hobby);
        setPhoneNumber(phone);
        setUsername(email);
        setEmail(email);
        setPassword(pass);
        return page(RegistrationPage.class);
    }

    // Fill out optional fields
    public RegistrationPage optionalFields(String martialStatus, String country, String monthNumberDOB, String dateDOB, String yearDOB, String filePath, String aboutYourself) {
        setMartialStatus(martialStatus);
        setCountry(country);
        setDOB(monthNumberDOB, dateDOB, yearDOB);
        setProfilePic(filePath);
        setAboutYourself(aboutYourself);
        return this;
    }

    // Success and error messages
    public String getSuccessMessage() {
        return $(By.className("piereg_message")).getText();
    }

    public String getErrors(int numerOfErrors, String errorText) {
        return $$("span.legend.error").shouldHaveSize(numerOfErrors).findBy(text(errorText)).getAttribute("innerHTML").toString();
    }

    public String getPasswordValidationMessage() {
        return $("#piereg_passwordStrength").getText();
    }

    // Form fields
    private RegistrationPage setFirstAndLastNames(String firstName, String lastName) {
        $(By.id("name_3_firstname")).setValue(firstName);
        $(By.id("name_3_lastname")).setValue(lastName);
        return this;
    }

    private RegistrationPage setHobby(String keyword) {
       ef.setCheckboxRadio(keyword, hobbyName);
       return this;
    }

    public RegistrationPage setPhoneNumber(String phone) {
        $(By.id("phone_9")).setValue(phone);
        return this;
    }

    private RegistrationPage setUsername(String username) {
        $(By.id("username")).setValue(username);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        $(By.id("email_1")).setValue(email);
        return this;
    }

    public RegistrationPage setPassword(String pass) {
        $(By.id("password_2")).setValue(pass);
        $(By.id("confirm_password_password_2")).setValue(pass);
        return this;
    }

    public RegistrationPage submit() {
        $(By.name("pie_submit")).click();
        return this;
    }

    private RegistrationPage setMartialStatus(String martialStatus) {
        ef.setCheckboxRadio(martialStatus, martialSt);
        return this;
    }

    private RegistrationPage setCountry(String country) {
        $(By.id("dropdown_7")).selectOption(country);
        return this;
    }

    private RegistrationPage setDOB(String monthNumber, String date, String year) {
        $(By.id("mm_date_8")).selectOption(monthNumber);
        $(By.id("dd_date_8")).selectOption(date);
        $(By.id("yy_date_8")).selectOption(year);
        return this;
    }

    private RegistrationPage setProfilePic(String filePath) {
        $("#profile_pic_10").uploadFile(new File(filePath));
        return this;
    }

    private RegistrationPage setAboutYourself(String aboutYourself) {
        $(By.id("description")).setValue(aboutYourself);
        return this;
    }

}
