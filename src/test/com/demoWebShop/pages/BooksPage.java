package com.demoWebShop.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BooksPage extends BasePage {
    public BooksPage() {
    }

    //Computing and internet
    @FindBy(how = How.CLASS_NAME, using = "button-2")
    public WebElement btnComputingAddToCart;

    @FindBy(how = How.CLASS_NAME, using = "cart-label") //<span class="cart-label">Shopping cart</span>
    public WebElement linkShoppingCart;


    public void ClickToAddToCart(){
        btnComputingAddToCart.click();
    }

    public CartPage ClickToNavigateToCart()
    {
        linkShoppingCart.click();
        return GetInstance(CartPage.class);
    }
}
