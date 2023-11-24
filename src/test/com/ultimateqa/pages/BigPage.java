package com.ultimateqa.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BigPage extends BasePage {
    public BigPage() {
    }

    @FindBy(how = How.NAME, using = "Button")
    public WebElement btnButton;
}
