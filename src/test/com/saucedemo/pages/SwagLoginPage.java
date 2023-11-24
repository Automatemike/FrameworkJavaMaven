package com.saucedemo.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwagLoginPage extends BasePage
{
    public SwagLoginPage() {
    }
    @FindBy(how = How.ID_OR_NAME, using = "user-name")
    public WebElement txtSwagUserName;

    @FindBy(how = How.ID_OR_NAME, using = "password")
    public WebElement txtSwagPassword;

    @FindBy(how = How.ID_OR_NAME, using = "login-button")
    public WebElement btnSwagLogin;


    public void EnterSwagLoginDetails(String swagUserName, String swagPassword)
    {
        txtSwagUserName.sendKeys(swagUserName);
        txtSwagPassword.sendKeys(swagPassword);
    }
    public void ClickToLoginSwag()
    {
        btnSwagLogin.submit();
    }
}
