package com.demoWebShop.seleniumtests;

import com.demoWebShop.pages.BooksPage;
import com.demoWebShop.pages.CartPage;
import com.demoWebShop.pages.ShopHomePage;
import com.qa.framework.base.BrowserType;
import com.qa.framework.base.DriverContext;
import com.qa.framework.base.FrameworkInitialize;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddBookToCartTest extends FrameworkInitialize
{
    /**
     * Mike
     */

    @BeforeAll
    public static void Initialize()
    {
        //Open the browser
        InitializeBrowser(BrowserType.Chrome);
        DriverContext.Browser.GoToUrl("https://demowebshop.tricentis.com/");
    }

    @Test
    public void AddBookToCart() throws InterruptedException {

        //Once url runs it arrives to the Home page first.
        CurrentPage = GetInstance(ShopHomePage.class);  //Home page instantiation

        //Navigate to Books
        CurrentPage.As(ShopHomePage.class).ClickBooks();

        Thread.sleep(3000);  //Adding a wait as system may take time to reach Books page

        //Add Computing book to the cart
        CurrentPage = GetInstance(BooksPage.class);  //Instantiation of Books page
        CurrentPage.As(BooksPage.class).ClickToAddToCart();  //Add book to cart

        Thread.sleep(3000);

        //Navigate to cart page from Books page
        CurrentPage.As(BooksPage.class).ClickToNavigateToCart();
        CurrentPage = GetInstance(CartPage.class);  //Instantiation of Cart page

        Thread.sleep(2000);

        //(Enter system behaviour)
        //Assert.isTrue();
    }
}
