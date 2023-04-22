
@Buggycar
Feature: Buggy car Registration,login,profileupdation,carrating and logout

  @Buggycar_tc_001
  Scenario: Register as a new user and verify user is able to login to application.
    Given Register as a new user 
    Then verify user is successfully registered
    When logs in with registered credentials
    Then verify user is successfully loggedin
    
    
    @Buggycar_tc_002
  Scenario: Profile updation
    Given Register as a new user 
    Then verify user is successfully registered
    When logs in with registered credentials
    Then verify user is successfully loggedin
    And verify user is able to update profile details
    
    
      
    @Buggycar_tc_003
  Scenario: Resetting Password
    Given Register as a new user 
    Then verify user is successfully registered
    When logs in with registered credentials
    Then verify user is successfully loggedin
    And verify user is able to reset password
    
    
      @Buggycar_tc_004
  Scenario Outline: Carrating
    Given Register as a new user 
    Then verify user is successfully registered
    When logs in with registered credentials
    And user selects the "<Carsection>" 
    #And user selects the first ranked car
    #And user add comments and click vote
    #Then verify if vote is incremented successfully
    Examples:
|Carsection|
|Popular Make|



 @Buggycar_tc_005
  Scenario:Logout
    Given Register as a new user 
    Then verify user is successfully registered
    When logs in with registered credentials
    Then verify user is successfully loggedin
    And Verify user is able to logout
    
#
