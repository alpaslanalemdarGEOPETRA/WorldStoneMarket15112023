Feature: WebScreaping



  Scenario: Go to target website in order to collect data
    When Go and Collect data as a Array list
    Then Write it into an excell

  Scenario: Put the excell data into WorldStoneMarket
    When Go and Create a Vendor Account and upload all products

