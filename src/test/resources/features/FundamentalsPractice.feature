Feature: Ticket booking for bus
  Background: Login with userName and Password
    Given User open the home page
      |username|password|
      |alok    |Password@123|
    When User login with "UserName" and "Password"
    Then He should be able to login to booking application
