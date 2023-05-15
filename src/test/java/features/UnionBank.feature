Feature: To validate EMI calculator

@Smoke
  Scenario: To validate the EMI calculator
    Given I launch the application.
    And I enter Amount as "10000",rate as "10" and tenure as "120"
    Then I click on calculate Button
    Then I verify the EMI is "132.15"
    And Close the application
 @Regression
  Scenario Outline:  To validate the EMI calculator
    Given I launch the application.
    And I enter Amount as "<Amount>",rate as "<rate>" and tenure as "<tenure>"
    Then I click on calculate Button
    Then I verify the EMI is "<Expected_EMI>"
    And Close the application
    Examples:
      |Amount|rate|tenure|Expected_EMI|
      |20000 |10  |110   |234         |
      |40000 |23  |22    |567         |
      |45000 |22  |12    |9990        |
      |500000|233 |45    |455666      |
