package com.demoWebShop.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShopHomePage extends BasePage {

    public ShopHomePage() {
    }

    @FindBy(how = How.LINK_TEXT, using = "Books")
    public WebElement homeBooks;

    @FindBy(how = How.CLASS_NAME, using = "ico-login")
    public WebElement homeLogin;

    @FindBy(how = How.CLASS_NAME, using = "Gift")
    public WebElement homeGiftCards;


    public BooksPage ClickBooks()
    {
        homeBooks.click();
        return new BooksPage();
    }

    public GiftCardsPage ClickGiftCards()
    {
        homeGiftCards.click();
        return new GiftCardsPage();
    }

    public ShopLoginPage ClickLogin()
    {
        homeLogin.click();
        return new ShopLoginPage();
    }
}