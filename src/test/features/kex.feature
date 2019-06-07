Feature: Kex UI

  Scenario: UI test
    Given I am on the "http://www.kraken.com" home page
    And I choose "British English"
    When I select "Futures"
    Then the "Bitcoin Futures Trading | Cryptocurrency Futures Market | Kraken" page is displayed
    And When I goto the "Support" page
    And I enter "API" into the search input box
    And I pick "API URLs"
    Then the "API URLs – Kraken" page is displayed
    And I select article "https://futures.kraken.com/derivatives/api/v3 "
    Then the futures dashboard page with title containing "| Kraken Futures" is displayed
