Feature: Table of Usertable Page should contain working "VIP" checkboxes

Scenario: Do interaction with User Table Page
Given I open JDI GitHub site
And I login as user "Roman Iovlev"
And I click on "Service" button in Header
And I click on "User Table" button in Service dropdown
When I select 'vip' checkbox for "Sergey Ivan"
Then 1 log row has "Vip: condition changed to true" text in log section
