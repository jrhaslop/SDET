Feature: Search Feature

  Scenario Outline: As a Customer we want to see if the second iPhone
    related ad from the second results page from www.aliexpress.com has at
    least 1 item to be bought.

    Given I navigate to homePage
    When I search for "<item>" on the searchBox
    And I navegate to the second page from the related list
    Then There must be at least one item to be bought

    Examples: 
      | item   |
      | iPhone |
      
