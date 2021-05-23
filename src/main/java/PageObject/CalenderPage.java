package PageObject;

import com.mailtravel.test.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class CalenderPage extends Utils {
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    private By _assertSelectTheDateMessage = By.cssSelector(".nbf_tpl_pms_bf_errortext.nbf_tpl_pms_bf_errortext_haserror");
    private By _verifyFirstAvailableDate = By.cssSelector(".nbf_tpl_pms_calendar_day_available.nbf_tpl_pms_calendar_box.nbf_pms_tpl_calendar_selecteddate");
    private By _clickContinue = By.xpath("(//*[.='Continue'])[2]");

    public void assertSelectTheDate(){
        jse.executeScript("window.scrollBy(0,380)","");
        waitForElementDisplay(_assertSelectTheDateMessage,20);
        assertTextMessage("The selected date has changed from Thursday, 1 January 1970 to Monday, 28 February 2022.",_assertSelectTheDateMessage);
    }

    public void verifyFirstDateInCalender(){
        waitForElementDisplay(_verifyFirstAvailableDate,20);
        String actual = driver.findElement(_verifyFirstAvailableDate).getText();
        Assert.assertEquals("28"+"\n£1,197",actual);
    }

    public void clickContinue(){
        clickElementBy(_clickContinue);
    }
}
