package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.close;

public class BaseClass {

  //  public WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void startBrowserSetBaseUrl(@Optional("chrome") String browser) {

       /* System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();*/

        Configuration.baseUrl = "http://demoqa.com/";

        if(browser.equals("chrome")) {
            Configuration.browser = "chrome";
        }
        if(browser.equals("firefox")) {
            Configuration.browser = "firefox";
        }
        if(browser.equals("safari")) {
            Configuration.browser = "safari";
        }
    }


    @AfterClass
    public void closeBrowser() {

        if(browser.equals("chrome") || browser.equals("firefox") || browser.equals("safari")) {
            close();
        }

    }
}
