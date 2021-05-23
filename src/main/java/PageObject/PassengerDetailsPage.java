package PageObject;

import com.mailtravel.test.LoadProperties;
import com.mailtravel.test.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;


public class PassengerDetailsPage extends Utils {
    LoadProperties loadProperties = new LoadProperties();

    private By _verifyPassengerDetailsTextPresent = By.xpath("(//*[.='5. Passenger Details'])[2]");
    //  Passenger Adult 1 Details:
    private By _verifyAdult1TextPresent = By.xpath("//*[.='Adult 1']");
    private By _title = By.cssSelector("#pax-a-title-1");
    private By _firstName = By.cssSelector("#pax-a-first-1");
    private By _lastName = By.cssSelector("#pax-a-last-1");
    private By _selectDate = By.cssSelector("#pax-a-dobd-1");
    private By _selectMonth = By.cssSelector("#pax-a-dobm-1");
    private By _selectYear = By.cssSelector("#pax-a-doby-1");
    //  Passenger Adult 2 Details:
    private By _verifyAdult2TextPresent = By.xpath("//*[.='Adult 2']");
    private By _title1 = By.cssSelector("#pax-a-title-2");
    private By _firstName1 = By.cssSelector("#pax-a-first-2");
    private By _lastName1 = By.cssSelector("#pax-a-last-2");
    private By _selectDate1 = By.cssSelector("#pax-a-dobd-2");
    private By _selectMonth1 = By.cssSelector("#pax-a-dobm-2");
    private By _selectYear1 = By.cssSelector("#pax-a-doby-2");
    // ****
    private By _verifyLeadContactDetailsTextPresent = By.xpath("//*[.='Lead Contact Details']");
    private By _mobileNumber = By.cssSelector("#contact-mobile");
    private By _email = By.cssSelector("#contact-email");
    private By _addressLine1 = By.cssSelector("#contact-address1");
    private By _addressLine2 = By.cssSelector("#contact-address2");
    private By _city = By.cssSelector("#contact-city");
    private By _postCode = By.cssSelector("#contact-postcode");
    private By _tickForNotToBeContactedByPost = By.cssSelector("#contact-marketingPreference-0");
    private By _tickForNotToBeContactedByEmail = By.cssSelector("#contact-marketingPreference-1");
    private By _clickContinueButton = By.cssSelector("[class='nbf_fancy_paxButton nbf_fg_pms_button_text ']");


    public void passengerDetailsTextPresent(){
        webElementPresent(_verifyPassengerDetailsTextPresent);
    }

    public void enterPassengersDetailsAdultOne(){
        pageLoadTimeOut(12);
        waitForElementDisplay(_verifyAdult1TextPresent,20);
        String actual = driver.findElement(_verifyAdult1TextPresent).getText();
        Assert.assertEquals("Adult 1",actual);

        try {
            implicitWait(15);
            Select select = new Select(driver.findElement(_title));
            select.selectByVisibleText("Mr");
        }
        catch(StaleElementReferenceException e)
        {
            waitForElementClickable(_title,20);
            Select select = new Select(driver.findElement(_title));
            select.selectByVisibleText("Mr");
            System.out.println("Element is attached to the page document");
        }
        catch(Exception e){
            System.out.println("Element is not attached to the page document");
        }

        enterText(_firstName,loadProperties.getProperty("Adult1FirstName"));

        enterText(_lastName,loadProperties.getProperty("Adult1LastName"));

        Select select1 = new Select(driver.findElement(_selectDate));
        select1.selectByValue(loadProperties.getProperty("Adult1DOBD"));

        Select select2 = new Select(driver.findElement(_selectMonth));
        select2.selectByValue(loadProperties.getProperty("Adult1DOBM"));

        Select select3 = new Select(driver.findElement(_selectYear));
        select3.selectByValue(loadProperties.getProperty("Adult1DOBY"));
    }
    //Below Method is different from above method,In below method Used Reusable Methods from Utils and InputData from Config.properties
    public void enterPassengersDetailsAdultTwo(){
        String actual = driver.findElement(_verifyAdult2TextPresent).getText();
        Assert.assertEquals(loadProperties.getProperty("Verify_Adult2_Text"),actual);

        selectTextByValue(_title1,loadProperties.getProperty("Adult2Title"));

        enterText(_firstName1,loadProperties.getProperty("Adult2FirstName"));

        enterText(_lastName1,loadProperties.getProperty("Adult2LastName"));

        selectTextByValue(_selectDate1,loadProperties.getProperty("Adult2DOBD"));

        selectTextByValue(_selectMonth1,loadProperties.getProperty("Adult2DOBM"));

        selectTextByValue(_selectYear1,loadProperties.getProperty("Adult2DOBY"));
    }

    public void assertLeadContactDetails(){
        String actual = driver.findElement(_verifyLeadContactDetailsTextPresent).getText();
        Assert.assertEquals(loadProperties.getProperty("Verify_LeadContactDetails_Text"),actual);
    }

    public void enterMobileNumber(){
        enterText(_mobileNumber,loadProperties.getProperty("MobileNumber"));
    }

    public void enterEmail(){
        enterText(_email,loadProperties.getProperty("Email"));
    }

    public void enterAddress(){
        enterText(_addressLine1,loadProperties.getProperty("AddressLine1"));
        enterText(_addressLine2,loadProperties.getProperty("AddressLine2"));
        enterText(_city,loadProperties.getProperty("City"));
        enterText(_postCode,loadProperties.getProperty("PostCode"));
        clickElementBy(_tickForNotToBeContactedByPost);
        clickElementBy(_tickForNotToBeContactedByEmail);
    }

    public void clickContinue(){
        clickElementBy(_clickContinueButton);
    }
}
