package com.ultimateqa.pages;

import com.qa.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FillOutFormsPage extends BasePage
{
    public FillOutFormsPage(){
    }

    @FindBy(how = How.ID, using = "et_pb_contact_name_0")
    public WebElement txtFormName;

    @FindBy(how = How.ID, using = "et_pb_contact_message_0")
    public WebElement txtFormMessage;

    @FindBy(how = How.NAME, using = "et_builder_submit_button")
    public WebElement btnFormSubmit;

    public void EnterFormDetails(String formName, String formMessage)
    {
        txtFormName.sendKeys(formName);
        txtFormMessage.sendKeys(formMessage);
    }
    public void Submit()
    {
        btnFormSubmit.click();
    }
}
