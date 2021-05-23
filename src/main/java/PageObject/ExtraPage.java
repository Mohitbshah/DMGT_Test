package PageObject;

import com.mailtravel.test.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ExtraPage extends Utils {

    private By _verifyExtraText = By.xpath("//*[.='4. Extras']");
    private By _clickContinueWithoutExtras = By.cssSelector("button[class='nbf_button nbf_tpl_pms_button']");

    public void verifyLandedOnExtraPage(){
        pageLoadTimeOut(15);
        String actual = driver.findElement(_verifyExtraText).getText();
        Assert.assertEquals("4. Extras",actual);
    }

    public void clickOnContinueWithoutExtras(){
        waitForElementDisplay(_clickContinueWithoutExtras,20);
        clickElementBy(_clickContinueWithoutExtras);
    }
}
