package com.saucedemo.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwagYourCartPage extends BasePage
{
    //Remove button where a backpack exists
    @FindBy(how = How.ID_OR_NAME, using = "remove-sauce-labs-backpack")
    public WebElement txtSauceLabsBackpack;

    public void ClickRemove()
    {
        txtSauceLabsBackpack.click();
    }

    //Continue Shopping button
    @FindBy(how = How.ID_OR_NAME, using = "continue-shopping")
    public WebElement txtSauceLabsContinueShopping;

    public void ClickContinueShopping()
    {
        txtSauceLabsContinueShopping.click();
    }
}
