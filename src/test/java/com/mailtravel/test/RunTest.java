package com.mailtravel.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".", format = {"pretty","html:target/cucumber-reports"},
        monochrome = true, tags = "@regression", dryRun = false)
public class RunTest {
}
