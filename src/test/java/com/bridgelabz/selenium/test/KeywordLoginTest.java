package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.engine.KeywordEngine;
import com.bridgelabz.selenium.utility.PageLogout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeywordLoginTest extends KeywordEngine{
    public KeywordEngine keywordEngine;

    @Test
    public void loginTest() throws InterruptedException {
        keywordEngine =new KeywordEngine();
        keywordEngine.startExecution("Sheet1");


        //validation
        String actualUrl= driver.getCurrentUrl();
        String expected="https://www.linkedin.com/feed/?trk=homepage-basic_signin-form_submit";
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl,expected);

        PageLogout page=new PageLogout(driver);
        page.logoutTO_Page();
    }


}
