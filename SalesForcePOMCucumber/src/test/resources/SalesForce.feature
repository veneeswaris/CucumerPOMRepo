

Feature: Login into SalesForce appliaction

  Scenario: Login with valid username and password
    Given user open salesforce appliaction
  When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
  When  user enters value into text box password as "Dreamb0y" 
    When Click on Login button
    Then verify the home page title as "Home Page ~ Salesforce - Developer Edition"
    
    Scenario: Login with invalid username and password
    Given user open salesforce appliaction
  When user on "LoginPage"
  When user enters value into text box username as "veninitish@gmail.com"
  When  user enters value into text box password as "Drea" 
    When Click on Login button
    Then verify the error "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
    
    
  