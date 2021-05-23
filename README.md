# DMGT_Test

Verify DMGT SDET Take Home Test works as expected.

# Build and run code:
> Go to RunTest.java class which is located under test > java> com.mailtravel.test > RunTest; 
> You will see a green play button besides "public class RunTest”;
> Click the play button;
> You will see a menu open with three options;
> Select the first option "Run RunTest".


# Dependencies:
You will see a pom.xml file. Here all the dependencies are located to enable to run the tests in the framework.
I have used: 
> Junit 4.11; 
>Junit 4.13-beta-2;
> selenium-support 3.141.59;
>ashot 1.5.3;
>ashot 1.4.12;
> selenium-chrome-driver  3.141.59;
> selenium-api 3.141.59;
> selenium-firefox-driver 3.141.59;
> webdrivermanager 4.4.3;
> cucumber-core 1.2.5;
> cucumber-java 1.2.5;   
> cucumber-junit 1.2.5;

# Automation Tools and framework Specifications:
  I have developed a BDD style framework using Page Object Model. In this framework, I have used:
  > Java as a coding language;
  > Selenium as an automation tool;
  > Maven as a build tool to enable auto-downloading of dependencies;
  > Gherkin language to enable writing feature files in Given, When, Then format;
  > Cucumber to integrate BDD style framework using CucumberOptions;
  > Junit for annotations such as @Before and @After;
  > Page Object Model design in the framework to avoid duplication of code and efficient maintenance and refactoring of code.
  
# Exploring framework structure:
I have used inheritance, one of the OOPS concepts of Java.

There are 3 sections in this framework main/Java, test/Java and Screenshots

The main/Java section consists of  Java classes and 2 Packages:

Java classes in Main/Java section/com.mailtravel.test

BasePage: Here I have instantiated WebDriver to use in the whole framework with the help of inheritance.
Utils: This extends BasePage class to use it's properties, mainly WebDriver. It has all the reusable methods to be used in the test scripts.
BrowserSelector: BrowserSelector extends Utils to use the properties of BasePage class and Utils class. It has the logic to open the desired browser which is assigned to 'browser' variable in TestData/Config.properties file which I will explain more about it , also implemented WebDriverManager. WebDriverManager helps to download binanries/executables in an automated way. It supports browsers such as Chrome, Firefox, Opera, PhantomJS, Microsoft Edge, or Internet Explorer. We just need to add its dependency through Maven or Gradle to download all the necessary drivers.

Loadproperties: This class has the logic to assign test data and browser names by creating a TestData/Config.properties file for the test to fetch the data from this file run test in relevant browser and use data assigned in relevant variables. You will find a path defined in this class, This is the path to TestDataConfig.properties file.

PageObjects Package: This interface has Java .java files for every page user navigates to. These .java files have names relevant to the pages user is on and contains locators and methods for the user to perform some action. This will avoid duplication of code and the code will be easy to maintain and refactor as whenever there is any change to a feature on the page we change it in one place. It saves a lot of time and effort and also it is more readable for someone else reading the code. .java files in Page object extends Utils to use the properties of  Utils.
Screenshots: This folder stores screenshots which is taken when takeScreenshot method is implemented to get screenshot for a scenario. 

# The Test/Java section consists of 3 Java classes and a Directory:
Java classes in Test/Java section/com.mailtravel.test

Hooks: This class extends Utils to use the properties of  Utils required. There are mainly 2 Junit annotations @Before and @After. @Before will execute the logic written in it before any feature files are executed. @After will execute the logic written in it after the completion of a feature file journey and also takes ascreenshot when test fails.

StepDefs_Bookings: This .java file has snippets created via feature file's Given, When, Then steps written in it. This is integrated with the help of @Runwith and @CucumberOptions annotations in Runtest .java file. These snippets are converted to methods of the same Given, When, Then steps written in .feature files in Gherkin language.

RunTest: This.java file has @Runwith and @CucumberOptions annotations which are used to integrate with BDD style frameworks.




Resources Directory: Resources Directory has 2 Directories within it. They are:

                 Features_Booking: This has .feature file which has test cases in it in Given, When, Then format.
                                              
                 TestData: This as TestData/Config.properties file mentioned previously for fetching data from it when the tests are running.

I haven't mentioned other files which are as important such as target directory, .idea directory and others.
