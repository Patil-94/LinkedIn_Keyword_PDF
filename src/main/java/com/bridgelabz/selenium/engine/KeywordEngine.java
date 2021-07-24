package com.bridgelabz.selenium.engine;

import com.bridgelabz.selenium.keyword.KeywordBaseClass;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/***
 * @locatorvalue used to access the value from sheet
 * @locatorName used to access the locators from sheet
 * @workbookfactory used for creating file and getSheet used for to get sheet name
 * switch() case used for action's and locator name
 */

public class KeywordEngine extends KeywordBaseClass {
    public static WebDriver driver;
    public static Properties prop;

    public static Workbook workbook;
    public static Sheet sheet;

    public  static KeywordBaseClass baseClass;
    public static WebElement element;

    public final static String filePath = "C:\\Users\\sachin\\IdeaProjects\\DataProviderLinkedInApp\\src\\main\\resources\\SigninLinedin.xlsx";

    public static void startExecution(String sheetName)  {

        String locatorName = null;
        String locatorValue = null;

        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(file);
        }catch (InvalidFormatException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetName);
        int k = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            try {
                String locatorColValue = sheet.getRow(i + 1).getCell(k + 1).toString().trim();//id=sessionkey
                if (!locatorColValue.equalsIgnoreCase("NA")) {
                    locatorName = locatorColValue.split("=")[0].trim();  //id
                    locatorValue = locatorColValue.split("=")[1].trim();
                }
                String action = sheet.getRow(i + 1).getCell(k + 2).toString();
                String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();

                switch (action) {
                    case "open browser":
                        /* baseClass = new BaseClass();*/
                        prop = KeywordBaseClass.init_properties();
                        if (value.isEmpty() || value.equals("NA")) {
                            driver = KeywordBaseClass.init_driver(prop.getProperty("browser"));
                        } else {
                            driver = KeywordBaseClass.init_driver(value);
                        }
                        break;
                    case "enter url":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(prop.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                   /* case "quit":
                        driver.quit();
                       break;*/
                    default:
                        break;
                }

                switch (locatorName) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys"))  {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        }
                        locatorName = null;
                        break;
                   case "class":
                        element = driver.findElement(By.className(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        }
                        break;

                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
