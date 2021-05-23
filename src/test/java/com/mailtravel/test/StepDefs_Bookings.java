package com.mailtravel.test;

import PageObject.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefs_Bookings {
    HomePage homePage = new HomePage();
    ChosenCountryPage chosenCountryPage = new ChosenCountryPage();
    CalenderPage calenderPage = new CalenderPage();
    AccommodationAndConfirmDetailsPage accommodationAndConfirmDetailsPage = new AccommodationAndConfirmDetailsPage();
    ExtraPage extraPage = new ExtraPage();
    PassengerDetailsPage passengerDetailsPage = new PassengerDetailsPage();


    @Given("^I am on homepage$")
    public void i_am_on_homepage(){
        homePage.clickOnAcceptCookies();
    }

    @When("^I enter country name in search box$")
    public void i_enter_country_name_in_search_box(){
        homePage.enterCountryNameInSearchBox();
    }

    @When("^I navigate to available holidays in the country mentioned$")
    public void i_navigate_to_available_holidays_in_the_country_mentioned(){
        chosenCountryPage.landedOnHolidayOfferPageInCountryChosen();
    }

    @When("^I click more info on the first result$")
    public void i_click_more_info_on_the_first_result(){
        chosenCountryPage.clickMoreInfoOnTheFirstOffer();
    }

    @When("^I navigate to chosen holiday page$")
    public void i_navigate_to_chosen_holiday_page(){
        chosenCountryPage.navigatedToChosenFirstHolidayPackagePage();
    }

    @When("^I click on Book Online$")
    public void i_click_on_Book_Online(){
        chosenCountryPage.clickOnBookOnline();
    }

    @When("^I navigate to calender with holiday first available date$")
    public void i_navigate_to_calender_with_holiday_first_available_date(){
        calenderPage.assertSelectTheDate();
        calenderPage.verifyFirstDateInCalender();
    }

    @When("^I click continue button on the calender page$")
    public void i_click_continue_button_on_the_calender_page(){
        calenderPage.clickContinue();
    }

    @When("^I navigate to accommodation Page$")
    public void i_navigate_to_accommodation_Page(){
        accommodationAndConfirmDetailsPage.accommodationTextPresent();
    }

    @When("^I select standardOrDouble room$")
    public void i_select_standardOrDouble_room(){
        accommodationAndConfirmDetailsPage.selectStandardRoomFromDropDown();
        accommodationAndConfirmDetailsPage.verifyTotalPrice();
        accommodationAndConfirmDetailsPage.clickOnSelectYourRoomAndContinue();
    }

    @When("^I continue without extras$")
    public void i_continue_without_extras(){
        extraPage.verifyLandedOnExtraPage();
        extraPage.clickOnContinueWithoutExtras();
    }

    @When("^I navigate to passenger details form$")
    public void i_navigate_to_passenger_details_form(){
        passengerDetailsPage.passengerDetailsTextPresent();
    }

    @When("^I enters passengers details$")
    public void i_enters_passengers_details(){
        passengerDetailsPage.enterPassengersDetailsAdultOne();
        passengerDetailsPage.enterPassengersDetailsAdultTwo();
        passengerDetailsPage.assertLeadContactDetails();
        passengerDetailsPage.enterMobileNumber();
        passengerDetailsPage.enterEmail();
        passengerDetailsPage.enterAddress();
        passengerDetailsPage.clickContinue();
    }

    @Then("^I navigate to payment page with all selected accommodation details$")
    public void i_navigate_to_payment_page_with_all_selected_accommodation_details(){
        accommodationAndConfirmDetailsPage.landedOnConfirmDetailsAndBookPage();
        accommodationAndConfirmDetailsPage.verifyThePaymentAmountAsPerTheAccommodationSelected();
    }
}
