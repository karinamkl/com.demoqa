package com.demoqa;

import com.demoqa.pages.AccountPage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utility.DataProvidersRegistrationLogin;
//import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ReportPortalTestNGListener.class})
public class LogInTest extends BaseClass {

    private RegisterTest ra = new RegisterTest();
    private String loginEmail = ra.email;
    private LoginPage loginPage = new LoginPage();
    private AccountPage accountPage = new AccountPage();


    @Test(description = "TC-013: Check that login unsuccessful when user passes invalid username")
    void loginInvalidUsername() {
        loginPage
                .open()
                .logIn("bad@email.com", "Test1234!");
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "ERROR: Invalid email address. Lost your password?");
    }

    //@Test(description = )

    @Test(description = "TC-016: User can login with valid credentials", dataProvider = "Login Credentials", dataProviderClass = DataProvidersRegistrationLogin.class)
    void loginValidCreds(String username, String pass) {
        loginPage
                .open()
                .logIn(username, pass)
                .goToMyAccount();
        Assert.assertEquals(accountPage.getUsername(), username);
    }

    @Test(description = "TC-019: Check that newly created user can login")
    void loginWithNewlyCreatedAccount() {
        loginPage
                .open()
                .logIn(loginEmail, "Test1234!")
                .goToMyAccount();
        Assert.assertEquals(accountPage.getUsername(), loginEmail);
    }




}

