package com.mailtravel.test;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.apache.commons.io.FileUtils.copyFile;


public class Utils extends BasePage {

    //Resuable method for click
    public static void clickElementBy(By by) {
        driver.findElement(by).click();
    }

    //Reusable method for entering any text/string (eg: entering name/password/email)
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //Reusable method to check if element is present and element is not present
    public static void webElementPresent(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is Present");
        } else {
            System.out.println("Element is not Present");
        }
    }

    //Reusable Method for Implicit wait for element to be displayed
    public static void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    //Reusable Method for PageLoadTimeout wait for page to be loaded
    public static void pageLoadTimeOut(int time) {
        driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
    }

    //Reusable Method for Explicit wait for element to be displayed/visible
    public static void waitForElementDisplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Reusable method for Explicit wait for element to be clickable
    public static void waitForElementClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Reusable Method for date short
    public static String shortDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("mmddyyyyHHmmss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    //Reusable Method for selecting any value i.e.numbers (eg: dropdown menu for selecting numbers)
    public static void selectTextByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //Reusable Method to get screenshot of browser
    public static void takeScreenshot(WebDriver driver, String testName)
    {
        try {
            File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File("./src/Screenshots/" + testName + ".png");
            copyFile(sourcepath, destinationPath);
            System.out.println("Screenshot saved in src/Screenshots folder");
        }
        catch(Exception e)
        {
            System.out.println("Exception while taking Screenshot" + e.getMessage());
        }
    }

    //Reusable Method to do assert URL
    public static void assertURL(String expected)
    {
        try {
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, expected);
            System.out.println("Expected Result : " + expected);
            System.out.println("Actual Result : " + URL);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Reusable Method to do expected = actual
    public static String getTextFromElement(By by)
    {
        String text = driver.findElement(by).getText();
        return text;
    }

    //Reusable Method to do expected = actual Text Message
    public static void assertTextMessage(String expected, By by) {
        try {
            String actual = getTextFromElement(by);
            Assert.assertEquals(expected, actual);
            System.out.println("Expected Result : " + expected);
            System.out.println("Actual Result : " + actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Reusable Method for Taking Screenshot when test Fail
    public static void screenShotCucumber(Scenario scenario){
        {
            String screenshotName = scenario.getName().replaceAll(".,:;?!", "") + shortDate() + ".png";
            try {
                //This takes a screenshot from the driver at save it to the location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'Screenshots' within the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/extent-reports/screenshots/" + screenshotName);
                //Copy taken sceenshot from source location to destination location
                copyFile(sourcePath, destinationPath);
                scenario.write("!!!!!!....Scenario Failed....!!!!Please see attached screenshot for the error/issue");
                //attach the screenshot to our report
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
