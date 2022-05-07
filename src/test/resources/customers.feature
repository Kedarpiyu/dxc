Feature: Nace API Testing

  Scenario: Calling get API details
    Given user calling API for nace number 398481
    When getNaceDetail API should return status 200
    Then Response should contains nace details
