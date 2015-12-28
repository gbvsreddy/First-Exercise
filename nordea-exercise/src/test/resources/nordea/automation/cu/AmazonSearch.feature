Feature: It should be possible to search for "Nikon" at http://www.amazon.com, 
         sort by price : high to low and then open second item from search results.


Scenario: User can find right "Nikon" product

    Given Amazon home page is open
    When User searches for Nikon
    And Sorts results by price : high to low
    And Opens the second item
    Then Product title of opened item contains Nikon D4S
        