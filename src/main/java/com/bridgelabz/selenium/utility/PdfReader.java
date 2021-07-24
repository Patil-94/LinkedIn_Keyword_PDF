package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClassPdf;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PdfReader  extends BaseClassPdf {

    public void pdfRead() throws IOException {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        URL url = new URL(currentURL);

        InputStream is = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        PDDocument document = null ;

        document = PDDocument.load(bufferedInputStream);
        String pdfContent = new PDFTextStripper().getText(document);
        System.out.println(pdfContent);
    }
}

