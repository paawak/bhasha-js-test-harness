 Feature: Bangla Typing
 	
Scenario: Typing a basic word কাক
  Given I am on the Bhasha editor
  When I type "kak"
  Then Bhasha editor should display "কাক"
    