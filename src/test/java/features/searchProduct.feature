Feature: Search and place the order for products

  @SmokeTest
  Scenario: Search experience for product search in both home and offers page
    Given User is on GreenKart Landing Page
    When User searched with shortname "Tom" and extracted actual name of product
    Then User searched with "Tom" shortname in offers page
    And Validate product name in offers page matches with landing page
    
  Scenario: Search experience for product search in both home and offers page
    Given User is on GreenKart Landing Page
    When User searched with shortname "Beet" and extracted actual name of product
    Then User searched with "Beet" shortname in offers page
    And Validate product name in offers page matches with landing page