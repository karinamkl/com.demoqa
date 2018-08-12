package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("/admin");
        return this;
    }

    private LoginPage setUsername(String username) {
        $(By.id("user_login")).setValue(username);
        return this;
    }

    private LoginPage setPass(String pass){
        $(By.id("user_pass")).setValue(pass);
        return this;
    }

    private LoginPage submit() {
        $(By.id("wp-submit")).click();
        return this;
    }

    // ToDo 2 methods for successful and unsuccessful login
    public HomePage logIn(String username, String pass) {
        setUsername(username);
        setPass(pass);
        submit();
        return page(HomePage.class);
    }

    public String getLoginErrorMessage() {
        return $("#login_error").getText();
    }
}
