package com.ultimateqa.seleniumtests;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.ultimateqa.pages.CreateNewAccountPage;
import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateNewAccountTest extends FrameworkInitialize
{
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
    public void CreateNewAccount() throws InterruptedException {

        //Once url runs it arrives to the Home page first.
        CurrentPage = GetInstance(HomePage.class); //HomePage homePage = new HomePage();  //Home page instantiation
        CurrentPage.As(HomePage.class).ClickLoginAuto();  //LoginPage loginPage = homePage.ClickLoginAuto(); //Navigate to login page via home page method (Page navigation added)

        Thread.sleep(3000);  //Adding a wait as system may take time to reach login page

        //Navigate to Account creation page via login page method
        CurrentPage = GetInstance(LoginPage.class);
        CurrentPage.As(LoginPage.class).ClickCreateAccount();  //CreateNewAccountPage newCreateAccount = loginPage.ClickCreateAccount();  //Page navigation added

        Thread.sleep(3000);

        CurrentPage = GetInstance(CreateNewAccountPage.class);

        /*CreateNewAccount createNewAccount = new CreateNewAccount();> no longer need as instantiation moved to the homepage
        and represented above in the loginPage variable*/

        Thread.sleep(2000);

        //Once Create account page instantiated, attempt to Sign up
        //newCreateAccount.Signup("TestFirstName1", "TestLastName1", "michael.lawrence@yahoo.co.uk","1password2");
        //newCreateAccount.SubmitDetails();

        //9_11 using course and assuming assertions and or Cucumber will come later.

        //(Enter system behaviour)
        //Assert.isTrue();
    }
}
