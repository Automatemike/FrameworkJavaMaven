package com.demoWebShop.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GiftCardsPage extends BasePage {
    public GiftCardsPage() {
    }

    @FindBy(how = How.NAME, using = "Button")
    public WebElement btnButton;
}
