$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/Resources/Features/Booking.feature");
formatter.feature({
  "line": 2,
  "name": "This feature will make sure booking holidays with accommodation",
  "description": "",
  "id": "this-feature-will-make-sure-booking-holidays-with-accommodation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.before({
  "duration": 9847408049,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "I should see the accommodation selected amount and payment to be amount should be same",
  "description": "",
  "id": "this-feature-will-make-sure-booking-holidays-with-accommodation;i-should-see-the-accommodation-selected-amount-and-payment-to-be-amount-should-be-same",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter country name in search box",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I navigate to available holidays in the country mentioned",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I click more info on the first result",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I navigate to chosen holiday page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on Book Online",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I navigate to calender with holiday first available date",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click continue button on the calender page",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I navigate to accommodation Page",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I select standardOrDouble room",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I continue without extras",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I navigate to passenger details form",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I enters passengers details",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I navigate to payment page with all selected accommodation details",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefs_Bookings.i_am_on_homepage()"
});
formatter.result({
  "duration": 532651150,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_enter_country_name_in_search_box()"
});
formatter.result({
  "duration": 2854516157,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_available_holidays_in_the_country_mentioned()"
});
formatter.result({
  "duration": 99391167,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_click_more_info_on_the_first_result()"
});
formatter.result({
  "duration": 3631852238,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_chosen_holiday_page()"
});
formatter.result({
  "duration": 1798439123,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_click_on_Book_Online()"
});
formatter.result({
  "duration": 3164802263,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_calender_with_holiday_first_available_date()"
});
formatter.result({
  "duration": 796561719,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_click_continue_button_on_the_calender_page()"
});
formatter.result({
  "duration": 253516900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_accommodation_Page()"
});
formatter.result({
  "duration": 3015853864,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_select_standardOrDouble_room()"
});
formatter.result({
  "duration": 2459640120,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_continue_without_extras()"
});
formatter.result({
  "duration": 2432611738,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_passenger_details_form()"
});
formatter.result({
  "duration": 83560295,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_enters_passengers_details()"
});
formatter.result({
  "duration": 8546171500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefs_Bookings.i_navigate_to_payment_page_with_all_selected_accommodation_details()"
});
formatter.result({
  "duration": 4774692608,
  "status": "passed"
});
formatter.after({
  "duration": 112899,
  "status": "passed"
});
});