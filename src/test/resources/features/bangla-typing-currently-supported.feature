 Feature: Bangla typing currently supported
 	
Scenario: Typing a basic word কাক
  Given I am on the Bhasha editor
  When I type "kak"
  Then Bhasha editor should display "কাক"
 
        