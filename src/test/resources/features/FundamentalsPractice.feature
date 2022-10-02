Feature: The Selenium Operations
    Background: Login with userName and Password
        Given User open the home page for basic Operations
        And   He should be able to open the page
    Scenario: User perform keyboard operations
        Given User search the test area in home page
        When  He enter the test "Hello Cucumber test"
        Then  He should be able to enter the correct text
    Scenario: User perform Mouse operations for radio button
        Given User search radio button in home Page
        When  He Checked radio button
        Then  Checked radio should be enable
    Scenario: User perform Mouse operations date picker
        Given User search date picker
        When  He click the date picker and select the date
        Then  He should be able to select the date