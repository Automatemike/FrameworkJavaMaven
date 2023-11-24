package com.ultimateqa.seleniumtests.login.negativeTests;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.LoginPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest_Fail_IncorrectCredentials_UserPasswordBlank extends FrameworkInitialize {

    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize()
    {
        //Open the browser
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://ultimateqa.com/automation/");
    }
    @Test
    public void Login() throws InterruptedException {

        //Once url runs it arrives to the Home page first.
        CurrentPage = GetInstance(HomePage.class);  //Home page instantiation using BDD style generic in Base class
        CurrentPage = CurrentPage.As(HomePage.class).ClickLoginAuto();

        Thread.sleep(2000);  //Adding a wait as system may take time to reach login page

        /*LoginPage loginPage = new LoginPage(); > no longer need as instantiation moved to the homepage
        and represented above in the loginPage variable*/

        //Once login page instantiated, attempt to log in with a blank password
        CurrentPage.As(LoginPage.class).EnterLoginDetails("mike_lawrence12000@yahoo.co.uk", "");
        CurrentPage.As(LoginPage.class).ClickToLogin();

        //Verify applicable message displays
        WebElement Message = DriverContext.Driver.findElement(By.className("form__error-msg"));
        Assert.isTrue(true, Message.getText());
        System.out.println("Passed as an error message appears");
    }
}
