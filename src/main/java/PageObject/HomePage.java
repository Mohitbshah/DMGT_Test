package PageObject;

import com.mailtravel.test.LoadProperties;
import com.mailtravel.test.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class HomePage extends Utils {
    LoadProperties loadProperties = new LoadProperties();
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    private By _acceptCookies = By.cssSelector("[title='Accept Cookies']");
    private By _searchBox = By.cssSelector("[id='searchtext_freetext_search_form']");

    public void clickOnAcceptCookies(){
        clickElementBy(_acceptCookies);
    }

    public void enterCountryNameInSearchBox(){
        assertURL("https://www.mailtravel.co.uk/");
        waitForElementClickable(_searchBox,10);
        enterText(_searchBox,loadProperties.getProperty("countryName"));
        driver.findElement(_searchBox).sendKeys(Keys.ENTER);
    }
}

