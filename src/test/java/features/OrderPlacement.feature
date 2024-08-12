
@tag
Feature: This feature is used to add products to the cart and place orders 

@productCartValidation
Scenario Outline: Order placement Experience
Given User lands on GreenCart website
When user searches with <Name> and <Quantity> and <numberOfItems> to the basket 
And user selects cart page and proceeds to checkout and validates
And validates the product <Name> and <numberOfItems> then clicks on place order
Then user enters the country agrees terms and conditions then places the order
Examples:
|Name      |Quantity|numberOfItems|
|Strawerry|  1/4   |3            |
 