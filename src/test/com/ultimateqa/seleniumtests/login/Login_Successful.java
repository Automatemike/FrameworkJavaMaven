package com.ultimateqa.seleniumtests.login;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Login_Successful extends FrameworkInitialize
{
    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize()
    {
        //Open the browser
        InitializeBrowser(BrowserType.Chrome); //Would end up in the framework config package.
        DriverContext.Browser.GoToUrl("https://ultimateqa.com/automation/"); //Same as above.
        //DriverContext.Browser.Maximize(); --don't need for this test.
    }
    @Test
    public void Login() throws InterruptedException {

        /*_driver.findElement(By.name("Username")).sendKeys(standard_user);
        _driver.findElement(By.name("Password")).sendKeys(secret_sauce);
        _driver.findElement(By.name("login-button")).submit();*/
        //Created the above before the POM and no longer need

        //Once url runs it arrives to the Home page first.
        CurrentPage = GetInstance(HomePage.class);  //Home page instantiation using BDD style generic in Base class

        //Navigate to login page via BDD generic in Base class
        CurrentPage = CurrentPage.As(HomePage.class).ClickLoginAuto();

        Thread.sleep(2000);  //Adding a wait as system may take time to reach login page

        CurrentPage.As(LoginPage.class).EnterLoginDetails("michael.lawrence@ttcglobal.com", "!@#password");

        /*LoginPage loginPage = new LoginPage(); > no longer need as instantiation moved to the homepage
        and represented above in the loginPage variable*/

        //Once login page instantiated, attempt to log in -- 21/11 no longer needed
        //loginPage.EnterLoginDetails("michael.lawrence@ttcglobal.com", "!@#password"); -- as above

        Thread.sleep(2000);  //Adding a wait to see if can see what system does after

        CurrentPage.As(LoginPage.class).ClickToLogin();

        Thread.sleep(2000);  //Adding a wait to see if can see what system does after clicking

        //9_11 using course and assuming assertions and or Cucumber will come later.

        //Once clicked to Sign in verify you reach a captcha screen - note it's an iframe so need to work it out.
        String text = DriverContext.Driver.switchTo().frame(0).findElement(By.className("rc-button-default")).getText();

        //String actualString = DriverContext.Driver.findElement(By.className("rc-button-default")).getText();

        String expectedString = "SKIP";

        Assertions.assertTrue(text.contains(expectedString));

        System.out.println("Passed as next to come up is a captcha");
    }
}
