package com.saucedemo.seleniumtests.locked_out_user;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.saucedemo.pages.SwagLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SwagLogin_LockedOut_UnsuccessfulTest extends FrameworkInitialize
{
    /**
    *  Mike
    */

    @BeforeAll
    public static void Initialize()
    {
        //Open the browser
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://www.saucedemo.com/");
    }
    @Test
    public void Login() throws InterruptedException {

        //Adding a wait as system may take time to reach login page
        Thread.sleep(2000);

        CurrentPage = GetInstance(SwagLoginPage.class);  //SwagLoginPage swagLoginPage = new SwagLoginPage();  //Instantiation

        //Once login page instantiated, attempt to log in with the standard user
        CurrentPage.As(SwagLoginPage.class).EnterSwagLoginDetails("locked_out_user", "secret_sauce");  //swagLoginPage.EnterSwagLoginDetails();
        CurrentPage.As(SwagLoginPage.class).ClickToLoginSwag();  //swagLoginPage.ClickToLoginSwag();

        //Adding a wait as system may take time to process the user
        Thread.sleep(2000);

        //Verify that once click to log in you get an error message.
        String actualString = DriverContext.Driver.findElement(By.className("error-message-container")).getText();
        String expectedString = "Epic sadface: Sorry, this user has been locked out.";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Passed as received expected error message");
    }
}