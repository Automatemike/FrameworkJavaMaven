package com.saucedemo.seleniumtests.StandardUser;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.saucedemo.pages.SwagLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SwagLogin_SuccessfulTest extends FrameworkInitialize
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
        //DriverContext.Browser.Maximize();
    }
    @Test
    public void Login() throws InterruptedException {

        //Adding a wait as system may take time to reach login page
        Thread.sleep(2000);

        CurrentPage = GetInstance(SwagLoginPage.class);  //Home page instantiation using BDD style generic in Base class
        //SwagLoginPage swagLoginPage = new SwagLoginPage();  //Instantiation

        //Once login page instantiated, attempt to log in with the standard user
        CurrentPage.As(SwagLoginPage.class).EnterSwagLoginDetails("standard_user", "secret_sauce");
        //swagLoginPage.EnterSwagLoginDetails("standard_user", "secret_sauce");
        CurrentPage.As(SwagLoginPage.class).ClickToLoginSwag();

        Thread.sleep(2000);  //Adding a wait as system may take time to get past login page

        //Verify that once click to log in you reach a Products page.
        String actualString = DriverContext.Driver.findElement(By.className("title")).getText();
        String expectedString = "Products";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Passed as next to come up is the Products page");
    }
}
