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

public class Swag_SingleItem_AddToCartFromProductPageAndRemove_SuccessfulTest extends FrameworkInitialize {
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

        CurrentPage = GetInstance(SwagLoginPage.class);  //SwagLoginPage swagLoginPage = new SwagLoginPage();  //Instantiation

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
        CurrentPage.As(SwagProduct_BackpackPage.class).AddToCart();  //swagProduct_backpackPage.AddToCart();  //Add to cart

        //Navigate to the cart
        CurrentPage.As(SwagProduct_BackpackPage.class).GoToShoppingCart();  //swagProduct_backpackPage.GoToShoppingCart();

        Thread.sleep(2000);  //Adding a wait in case system needs time to reach cart

        CurrentPage = GetInstance(SwagYourCartPage.class); //SwagYourCartPage swagYourCartPage = new SwagYourCartPage(); //Instantiation of cart page

        //Verify Backpack is in the cart
        String actualString = DriverContext.Driver.findElement(By.className("inventory_item_name")).getText();
        String expectedString = "Sauce Labs Backpack";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Passed as can find the backpack in the cart");

        //Assert.isTrue(true, "Sauce Labs Backpack"); left in favour of above
        //System.out.println("Assert passed");

        Thread.sleep(2000);  //Adding a wait so can see cart before backpack removed

        //Remove Backpack from the cart
        CurrentPage.As(SwagYourCartPage.class).ClickRemove();  //swagYourCartPage.ClickRemove();

        System.out.println("Also, the item can be removed from the cart");

        //Verify backpack no longer exists in cart page - need to think about how can do this.
        //DriverContext.Driver.findElement(By.className("inventory_item_name")));
        //System.out.println("Passed as can't find the backpack - no element exists");
    }
}
