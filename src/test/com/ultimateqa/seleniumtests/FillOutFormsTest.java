package com.ultimateqa.seleniumtests;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.ultimateqa.pages.FillOutFormsPage;
import com.ultimateqa.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FillOutFormsTest extends FrameworkInitialize
{
    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize()
    {
        //Open the browser via DriverContext which now contains the applicable code
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://ultimateqa.com/automation/");
        DriverContext.Browser.Maximize();
    }

    @Test
    public void FillOutForms() throws InterruptedException
    {
        //Once url runs it arrives to the Home page first.
        CurrentPage = GetInstance(HomePage.class); //Home page instantiation
        CurrentPage = CurrentPage.As(HomePage.class).ClickFillForms(); //Navigate to Fill out forms page via home page method (Page navigation added)

        CurrentPage = GetInstance(FillOutFormsPage.class);  //Instantiation

        Thread.sleep(2000);  //Adding a wait as system may take time to reach page

        //Once FillOutForms page instantiated, enter in details and submit
        CurrentPage.As(FillOutFormsPage.class).EnterFormDetails("TestName", "Hello, this is a test message for submission");
        CurrentPage.As(FillOutFormsPage.class).Submit();

        //Adding a wait as system may take time to refresh
        Thread.sleep(2000);

        //Once submitted the system returns a successful message.
        String actualString = DriverContext.Driver.findElement(By.className("et-pb-contact-message")).getText();
        String expectedString = "Thanks for contacting us";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Assert passed as message is Thanks for contacting us");
    }
}
