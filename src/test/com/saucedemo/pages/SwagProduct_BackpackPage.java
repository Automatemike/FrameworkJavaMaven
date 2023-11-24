package com.saucedemo.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwagProduct_BackpackPage extends BasePage
{
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    public WebElement txtSauceLabsBackpack;

    @FindBy(how = How.ID_OR_NAME, using = "add-to-cart-sauce-labs-backpack")
    public WebElement btnAddToCart;

    public void AddToCart()
    {
        btnAddToCart.click();
    }

    //Shopping cart
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_badge")
    public WebElement btnShoppingCart;

    public void GoToShoppingCart()
    {
        btnShoppingCart.click();
    }
}
