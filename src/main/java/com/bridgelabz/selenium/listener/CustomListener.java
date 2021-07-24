package com.bridgelabz.selenium.listener;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.CaptureScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class CustomListener extends BaseClass implements ITestListener {
    CaptureScreenShot screenshot = new CaptureScreenShot();

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed Test");
        screenshot.failed();
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success Test");
        screenshot.success();
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
}

