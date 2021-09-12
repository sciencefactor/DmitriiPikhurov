Feature: Logs Panel on Elements page should show all user interactions

  Scenario Outline: Do interactions with Elements page: checkboxes <checkbox_one>, <checkbox_two>, radio <radio> and dropdown list <dropdown>
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I navigate to Different Elements Page
    When I click on '<checkbox_one>' checkbox
    And I click on '<checkbox_two>' checkbox
    And I click on '<radio>' radio
    And I choose '<dropdown>' color in dropdown list
    Then All actions should be visible on Logs panel: '<actions>'

    Examples:
    |checkbox_one|checkbox_two|radio|dropdown|actions                                          |
    |Water       |Wind        |Selen|Yellow  |Water=true, Wind=true, metal=Selen, Colors=Yellow|
