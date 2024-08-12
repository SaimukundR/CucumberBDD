Feature: Searching and placing orders


Scenario: Search Experience in both homepage and offers page
Given User lands on GreenCart website
When user searches with "Strawberry" and "1/4" and validates the results and navigates on offers page
And user searches with "Strawberry" in offers page and validates the results
Then validates the price in offers page and homepage

@productPriceValidation
Scenario Outline: Search Experience in both homepage and offers page
Given User lands on GreenCart website
When user searches with <Name> and <Quantity> and validates the results and navigates on offers page
And user searches with <Name> in offers page and validates the results
Then validates the price in offers page and homepage
Examples:
|Name      |Quantity|
|Strawberry|  1/4   |
|Beans     |  1     |
|Brinjal   |  7     |
  