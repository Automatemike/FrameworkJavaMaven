package com.ultimateqa.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    //9_11 Blanked out as have now created a DriverContext constructor to handle the WebDriver.
    public HomePage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Fill out forms")
    public WebElement linkFillForms;

    @FindBy(how = How.LINK_TEXT, using = "Login automation")
    public WebElement linkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Big page with many elements")
    public WebElement linkBigPage;


    public void ClickBigPage()
    {
        linkBigPage.click();
    }

    public FillOutFormsPage ClickFillForms()
    {
        linkFillForms.click();
        return new FillOutFormsPage();
    }

    public LoginPage ClickLoginAuto()
    {
        linkLogin.click();
        return GetInstance(LoginPage.class);
    }
}