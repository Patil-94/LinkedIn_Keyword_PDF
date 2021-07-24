package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PageLogout extends BaseClass  {

    @FindBy(id = "ember33")
    WebElement ClickOnAccount;

    @FindBy(xpath = "//a[normalize-space()='Sign Out']")
    WebElement signOut;

    public PageLogout (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void logoutTO_Page() throws InterruptedException {
        Thread.sleep(500);
        ClickOnAccount.click();
        Thread.sleep(500);
        signOut.click();
        Thread.sleep(500);
    }
}
