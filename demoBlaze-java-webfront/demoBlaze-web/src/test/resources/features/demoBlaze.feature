@tag
Feature: DEMOBLAZE SCENARIOS

  @DemoBlaze_001 @all
  Scenario: User register and login
    Given Open Form
    When Register and Login with user created
    Then Logout and check

  @DemoBlaze_002 @all
  Scenario: User add to cart and check
    Given User select a product
    When Add to cart
    Then Check added to cart
