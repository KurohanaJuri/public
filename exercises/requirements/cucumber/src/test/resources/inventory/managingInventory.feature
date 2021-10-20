Feature: Managing inventory

  Scenario: Adding a product actually adds it to the inventory
    Given there are 4 sweaters in the inventory
    When I add 1 sweaters to the inventory
    Then the inventory contains 5 sweaters

  Scenario: Removing a product actually removes it
    Given there are 4 sweaters in the inventory
    When I remove 3 sweater to the inventory
    Then the inventory contains 1 sweaters