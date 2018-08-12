package com.demoqa.pages;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {


    public String getUsername() {
        return $("#user_login").getValue();

    }
}
