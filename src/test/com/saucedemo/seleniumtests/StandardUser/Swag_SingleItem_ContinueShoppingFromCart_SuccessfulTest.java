package com.saucedemo.seleniumtests.StandardUser;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.saucedemo.pages.SwagLoginPage;
import com.saucedemo.pages.SwagProduct_BackpackPage;
import com.saucedemo.pages.SwagProductsPage;
import com.saucedemo.pages.SwagYourCartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Swag_SingleItem_ContinueShoppingFromCart_SuccessfulTest extends FrameworkInitialize {
    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize()
    {
        //Open the chosen browser and website
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://www.saucedemo.com/");
    }

    @Test
    public void AddToCart() throws InterruptedException
    {
        Thread.sleep(2000);  //Adding a wait as system may take time to reach login page

        CurrentPage = GetInstance(SwagLoginPage.class); //SwagLoginPage swagLoginPage = new SwagLoginPage();  //Instantiation

        //Once login page instantiated, attempt to log in
        CurrentPage.As(SwagLoginPage.class).EnterSwagLoginDetails("standard_user", "secret_sauce");  //swagLoginPage.EnterSwagLoginDetails();
        CurrentPage.As(SwagLoginPage.class).ClickToLoginSwag();  //swagLoginPage.ClickToLoginSwag();

        Thread.sleep(2000);  //Adding a wait as system may take time to reach Products page

        CurrentPage = GetInstance(SwagProductsPage.class);  //SwagProductsPage swagProductsPage = new SwagProductsPage();  //Instantiation of Products page

        //Select product
        CurrentPage.As(SwagProductsPage.class).ClickForBackpack();  //SwagProduct_BackpackPage swagProduct_backpackPage = swagProductsPage.ClickForBackpack();  //Select chosen product via Products page.

        Thread.sleep(2000);  //Adding a wait as system may take time to get to the backpack product page

        //Add it to the cart from its own page
        CurrentPage = GetInstance(SwagProduct_BackpackPage.class);  //Instantiation
        CurrentPage.As(SwagProduct_BackpackPage.class).AddToCart();  //Add to cart

        //Navigate to the cart
        CurrentPage.As(SwagProduct_BackpackPage.class).GoToShoppingCart();  //swagProduct_backpackPage.GoToShoppingCart();

        Thread.sleep(2000);  //Adding a wait in case system needs time to reach cart

        CurrentPage = GetInstance(SwagYourCartPage.class);  //SwagYourCartPage swagYourCartPage = new SwagYourCartPage(); //Instantiation of cart page

        //Verify can continue shopping
        CurrentPage.As(SwagYourCartPage.class).ClickContinueShopping();  //swagYourCartPage.ClickContinueShopping();

        //Verify back at Products page
        String actualString = DriverContext.Driver.findElement(By.className("title")).getText();
        String expectedString = "Products";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Passed as can continue shopping from the cart page");
    }
}
