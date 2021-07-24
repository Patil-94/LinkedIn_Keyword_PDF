package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.engine.KeywordEngine;
import com.bridgelabz.selenium.listener.CustomListener;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.utility.DataProvider;
import com.bridgelabz.selenium.utility.PageLogout;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LinkedInTest extends BaseClass {


    /**
     * test for Login Page
     * and also check actual result and expected result
     */

    //mention data provider method name in test method
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void logoutPage(String userName, String passWord) throws InterruptedException {

        //create object of Login Class
        Login login = new Login(driver);
        login.loginTo_Application(userName, passWord);


        PageLogout logout = new PageLogout(driver);
        logout.logoutTO_Page();

        //validation
        String expectedUsername = "ankitakhairnar10@gmail.com";
        Assert.assertEquals(userName, expectedUsername);
    }

}