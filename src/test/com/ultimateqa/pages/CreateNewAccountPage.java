package com.ultimateqa.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateNewAccountPage extends BasePage {

    @FindBy(how = How.ID_OR_NAME, using = "user[first_name]")
    public WebElement txtUserFirstName;

    @FindBy(how = How.ID_OR_NAME, using = "user[last_name]")
    public WebElement txtUserLastName;

    @FindBy(how = How.ID_OR_NAME, using = "user[email]")
    public WebElement txtUserEmail;

    @FindBy(how = How.ID_OR_NAME, using = "user[password]")
    public WebElement txtUserPassword;

    @FindBy(how = How.ID_OR_NAME, using = "user[terms]")
    public WebElement txtUserTerms;

    @FindBy(how = How.NAME, using = "Sign up")
    public WebElement btnSignup;

    public void Signup(String userFirstName, String userLastName, String userEmail, String userPassword)
    {
        txtUserFirstName.sendKeys(userFirstName);
        txtUserLastName.sendKeys(userLastName);
        txtUserLastName.sendKeys(userEmail);
        txtUserPassword.sendKeys(userPassword);
    }
    public void SubmitDetails()
    {
        btnSignup.submit();
    }
}
