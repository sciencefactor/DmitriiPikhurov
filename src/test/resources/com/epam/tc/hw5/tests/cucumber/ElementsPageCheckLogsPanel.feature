Feature: Logs Panel on Elements page should show all user interactions

  Scenario Outline: Do interactions with Elements page: checkboxes <checkbox_one>, <checkbox_two>, radio <radio> and dropdown list <dropdown>
    Given User opens Gdi Home page
    And User login
    And User navigate to Different Elements Page
    When User clicks on '<checkbox_one>' checkbox
    And User clicks on '<checkbox_two>' checkbox
    And User clicks on '<radio>' radio
    And User choose '<dropdown>' color in dropdown list
    Then All actions should be visible on Logs panel: '<actions>'

    Examples:
    |checkbox_one|checkbox_two|radio|dropdown|actions                                          |
    |Water       |Wind        |Selen|Yellow  |Water=true, Wind=true, metal=Selen, Colors=Yellow|

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    Then "User Table" page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulksome description             |
    And droplist should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |

    Scenario: Do interaction with User Table Page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
