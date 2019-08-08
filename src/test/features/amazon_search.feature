Feature: Amazon basic search
  Given User is on Amazon starting page


  Scenario: User performs basic search
    When Enter "Haribo" in search box
     And Press key "enter"
    Then Search results should be visible
     And There are more than 15 search results

  Scenario: User adds a random item to cart
    When Enter "Selenium" in search box
     And Click on "search"-button
    Then Search results should be visible
    When A Random item is opened
    Then Item Details should be visible
    When Click on button "Add to cart"
    Then Success Message should be visible
