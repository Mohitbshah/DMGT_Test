package PageObject;

import com.mailtravel.test.LoadProperties;
import com.mailtravel.test.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class AccommodationAndConfirmDetailsPage extends Utils {
    LoadProperties loadProperties = new LoadProperties();
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    String expected702;

    private By _assertAccommodationText = By.xpath("//*[.='3. Accommodation']");
    private By _standardRoomSelection = By.cssSelector("#room-0-numselect");
    private By _verifyTotalPrice = By.cssSelector("[class*='room_enumerated_price'] span");
    private By _selectYourRoomAndContinue = By.xpath("//*[.='Select your room and continue']");
    private By _verifyConfirmDetailsText = By.cssSelector("td[class='nbf_stage_current']");
    private By _depositAsPayable = By.cssSelector(".nbf_depositpayablenow span");

    public void accommodationTextPresent(){
        waitForElementDisplay(_assertAccommodationText,20);
        String actual = driver.findElement(_assertAccommodationText).getText();
        Assert.assertEquals("3. Accommodation",actual);
    }

    public void selectStandardRoomFromDropDown(){
        waitForElementClickable(_standardRoomSelection,10);
        Select select = new Select(driver.findElement(_standardRoomSelection));
        select.selectByValue("1");
    }

    public void verifyTotalPrice(){
        waitForElementDisplay(_verifyTotalPrice,10);
        expected702 = driver.findElement(_verifyTotalPrice).getText();
        driver.findElement(_verifyTotalPrice).isDisplayed();
        System.out.println("Price from AccommodationPage as Total: " +expected702);
        takeScreenshot(driver,"To be Verify the payment amount displayed on Accommodation Page");
    }

    public void clickOnSelectYourRoomAndContinue(){
        clickElementBy(_selectYourRoomAndContinue);
    }

    public void landedOnConfirmDetailsAndBookPage(){
        waitForElementDisplay(_verifyConfirmDetailsText,15);
        String actual = driver.findElement(_verifyConfirmDetailsText).getText();
        String expected = loadProperties.getProperty("Verify_ConfirmDetails_Text");
        Assert.assertEquals(expected,actual);
        jse.executeScript("window.scrollBy(0,850)","");
    }

    public void verifyThePaymentAmountAsPerTheAccommodationSelected() {
        takeScreenshot(driver, "Verify the Payable as Deposit Amount + £1 Admin Charge");
        waitForElementDisplay(_depositAsPayable, 10);
        String actual = driver.findElement(_depositAsPayable).getText();
        String actualPrice = actual.replace(".00","");
        Assert.assertEquals(expected702,actualPrice);
        System.out.println(expected702);
        System.out.println(actualPrice);
    }
}

