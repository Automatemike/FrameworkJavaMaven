package com.ultimateqa.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage
{
    //9_11 Blanked out as have now created a DriverContext constructor to handle the WebDriver.
    //POM Simplicity - super = BasePage class where PageFactory has been moved to
    public LoginPage() {
    }

    @FindBy(how = How.ID_OR_NAME, using = "user[email]")
    public WebElement txtUserName;

    @FindBy(how = How.ID_OR_NAME, using = "user[password]")
    public WebElement txtPassword;

    @FindBy(how = How.CLASS_NAME, using = "button")
    public WebElement btnSignin;

    @FindBy(how = How.LINK_TEXT, using = "Create a new account")
    public WebElement linkCreateAccount;

    public void EnterLoginDetails(String userName, String password)
    {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }
    public void ClickToLogin()
    {
        btnSignin.click();
    }

    public CreateNewAccountPage ClickCreateAccount()
    {
        linkCreateAccount.click();
        return new CreateNewAccountPage();
    }

}
