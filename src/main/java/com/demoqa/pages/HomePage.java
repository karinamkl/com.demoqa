package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage {

    public boolean isLoggedIn() {
        return $(By.className("ab-item")).has(Condition.value("http://demoqa.com/wp-admin/profile.php"));
    }

    public RegistrationPage openRegistration() {
        $(By.id("menu-registration")).click();
        return page(RegistrationPage.class);
    }

    public AccountPage goToMyAccount() {
        open("http://demoqa.com/wp-admin/profile.php");
        return page(AccountPage.class);
    }


}
