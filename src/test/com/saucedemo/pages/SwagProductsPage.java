package com.saucedemo.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwagProductsPage extends BasePage
{
    //Backpack elements and methods
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    public WebElement txtSauceLabsBackpack;

    @FindBy(how = How.ID_OR_NAME, using = "add-to-cart-sauce-labs-backpack")
    public WebElement btnBackpackAddToCart;

    public SwagProduct_BackpackPage ClickForBackpack()
    {
        txtSauceLabsBackpack.click();
        return new SwagProduct_BackpackPage();
    }
    public void AddBackpackToCart()
    {
        btnBackpackAddToCart.click();
    }

    //Fleece Jacket elements and methods
    @FindBy(how = How.ID_OR_NAME, using = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement btnFleeceJacketAddToCart;

    public void AddFleeceJacketToCart()
    {
        btnFleeceJacketAddToCart.click();
    }

    //Bolt T-shirt elements and methods
    @FindBy(how = How.ID_OR_NAME, using = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement btnBoltTShirtAddToCart;

    public void AddBoltTShirtToCart()
    {
        btnBoltTShirtAddToCart.click();
    }

    //Shopping cart
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_badge")
    public WebElement btnShoppingCart;

    public void GoToShoppingCart()
    {
        btnShoppingCart.click();
    }
}
