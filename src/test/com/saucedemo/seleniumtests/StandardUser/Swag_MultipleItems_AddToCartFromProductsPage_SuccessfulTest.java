package com.saucedemo.seleniumtests.StandardUser;

import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import com.saucedemo.pages.SwagLoginPage;
import com.saucedemo.pages.SwagProductsPage;
import com.saucedemo.pages.SwagYourCartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Swag_MultipleItems_AddToCartFromProductsPage_SuccessfulTest extends FrameworkInitialize {
    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize() {
        //Open the chosen browser and website
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://www.saucedemo.com/");
    }

    @Test
    public void AddToCart() throws InterruptedException
    {
        Thread.sleep(2000);  //Adding a wait as system may take time to reach login page

        CurrentPage = GetInstance(SwagLoginPage.class);  //Instantiation

        //Attempt to log in
        CurrentPage.As(SwagLoginPage.class).EnterSwagLoginDetails("standard_user", "secret_sauce");
        CurrentPage.As(SwagLoginPage.class).ClickToLoginSwag();

        Thread.sleep(2000);  //Adding a wait as system may take time to reach Products page

        //Once logged in select chosen product items from the Products page.
        CurrentPage = GetInstance(SwagProductsPage.class); //swagProductsPage = new SwagProductsPage();  //Instantiation of Products page
        CurrentPage.As(SwagProductsPage.class).AddBackpackToCart();  //swagProductsPage.AddBackpackToCart();  //Select Backpack
        CurrentPage.As(SwagProductsPage.class).AddFleeceJacketToCart();  //swagProductsPage.AddFleeceJacketToCart();  //Select Fleece Jacket
        CurrentPage.As(SwagProductsPage.class).AddBoltTShirtToCart();  //swagProductsPage.AddBoltTShirtToCart();  //Select Bolt T-shirt

        //Navigate to cart
        CurrentPage.As(SwagProductsPage.class).GoToShoppingCart();  //swagProductsPage.GoToShoppingCart();
        CurrentPage = GetInstance(SwagYourCartPage.class);  //SwagYourCartPage swagYourCartPage = new SwagYourCartPage(); //Instantiation of cart page

        Thread.sleep(2000);  //Adding a wait in case system needs time to reach cart

        //Verify items are in the cart
        //Backpack
        String actualString = DriverContext.Driver.findElement(By.id("item_4_title_link")).getText();
        String expectedString = "Sauce Labs Backpack";

        Assertions.assertTrue(actualString.contains(expectedString));

        System.out.println("Passed as can find the Backpack");

        //Assert.isTrue(true, "Sauce Labs Backpack");  Leaving this in favour of above.
        //Assertion limited at present and doesn't work as intended
        //System.out.println("Assert passed");

        //Fleece Jacket
        String actualString1 = DriverContext.Driver.findElement(By.id("item_5_title_link")).getText();
        String expectedString1 = "Sauce Labs Fleece Jacket";

        Assertions.assertTrue(actualString1.contains(expectedString1));

        System.out.println("...the Fleece Jacket");

        //Bolt T-Shirt
        String actualString2 = DriverContext.Driver.findElement(By.id("item_1_title_link")).getText();
        String expectedString2 = "Sauce Labs Bolt T-Shirt";

        Assertions.assertTrue(actualString2.contains(expectedString2));

        System.out.println("...and the Bolt T-Shirt");
    }
}
