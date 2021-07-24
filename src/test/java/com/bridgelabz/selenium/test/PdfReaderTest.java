package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClassPdf;
import com.bridgelabz.selenium.utility.PdfReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PdfReaderTest extends BaseClassPdf  {

    @Test
    public void pdf_test() throws IOException {
        PdfReader pdfReader = new PdfReader();
        pdfReader.pdfRead();

        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);
        String expectedUrl ="https://mrcet.com/downloads/digital_notes/HS/OOP_10122018.pdf";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}

