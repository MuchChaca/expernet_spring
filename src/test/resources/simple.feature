Feature: the todo list can be retrieved
  Scenario: client makes call to GET /todo/all
    When the client calls /todo/all
    Then the client receives status code of 200
