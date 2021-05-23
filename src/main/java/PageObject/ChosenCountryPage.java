package PageObject;

import com.mailtravel.test.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertTrue;


public class ChosenCountryPage extends Utils {
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    private By _moreInfo = By.cssSelector("#iterator_1_product_custom_more-info-button");
    private By _phoneNumber = By.cssSelector("[id='supplier-phone']");
    private By _daysFromAndPerPerson = By.cssSelector("#price-pin_pin-wrapper");
    private By _clickBookOnline = By.xpath("(//*[contains(text(),'Book Online')])[1]");

    public void landedOnHolidayOfferPageInCountryChosen(){
        assertURL("https://www.mailtravel.co.uk/quicksearch.php?imgsrc=slide&searchtext=&searchtag=india");
    }

    public void clickMoreInfoOnTheFirstOffer(){
        waitForElementDisplay(_moreInfo,10);
        jse.executeScript("window.scrollBy(0,300)","");
        waitForElementClickable(_moreInfo,10);
        clickElementBy(_moreInfo);
    }

    public void navigatedToChosenFirstHolidayPackagePage(){
        jse.executeScript("window.scrollBy(0,240)","");
        waitForElementDisplay(_phoneNumber,10);
        takeScreenshot(driver,"Displaying days, price and telephone number");

        String actual = driver.findElement(_daysFromAndPerPerson).getText();
        String expected = "days from";
        assertTrue(actual.contains(expected));
        System.out.println(actual);

        String actual1 = driver.findElement(_phoneNumber).getText();
        String expected1 = "0808 239";
        assertTrue(actual1.contains(expected1));
        System.out.println(actual1);
    }

    public void clickOnBookOnline(){
        clickElementBy(_clickBookOnline);
    }
}
