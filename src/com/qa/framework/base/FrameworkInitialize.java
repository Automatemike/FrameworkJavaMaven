package com.qa.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base
{
    public static void InitializeBrowser(BrowserType browserType)
    {
        WebDriver driver = null;
        switch (browserType)
          {
              case Firefox:
              {
                  driver = new FirefoxDriver();
                  break;
              }
              case Chrome:
              {
                  //Open the browser
                  System.setProperty("WebDriver.chromedriver", "C:\\Users\\MichaelLawrence\\Documents\\Test Automation");
                  driver = new ChromeDriver();
                  break;
              }
              case Safari:
              {
                  break;
              }
          }
        //Set the Driver
        DriverContext.setDriver(driver);
        //Browser
        DriverContext.Browser = new Browser(driver);
    }
}
