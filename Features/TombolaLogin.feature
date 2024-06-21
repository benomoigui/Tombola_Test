
Feature: Login test

  Scenario: User is able to login with a valid credential
  
    Given User launch browser
    And  opens URL "https://stage.tombola.co.uk/userauthenticationids/loginsso#/login"
    And User enters email as "techtest1" and Password as "TechTest1!"
    And Clicks on Login button
    Then User navigates to Account Page

   
