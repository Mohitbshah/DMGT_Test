package com.mailtravel.test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.util.concurrent.TimeUnit;


public class Hooks extends Utils {
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperties loadProperties = new LoadProperties();

    @Before
    public void openBrowser(){
        browserSelector.selectBrowser();
        driver.get(loadProperties.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
     @After
    public void closeBrowser(Scenario scenario){
        if(scenario.isFailed()){
            screenShotCucumber(scenario);
        }
        //driver.quit();
    }
}
