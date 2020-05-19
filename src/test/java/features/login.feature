Feature: Aplicaton Login

Scenario: Home page default login text
Given webpage link is given
When search for home page text
Then validate the text matches with home page text or not
And close driver

Scenario: Validation of navigation bar in home page
Given webpage link is given
When search for navigation bar
Then validate navigation bar is present or not
And close driver

Scenario Outline: Validation of login page
Given webpage link is given
When user login into application with "<email>" and "<password>"
Then login should fail and validate login fail text
And validate login page text

Examples:
	| email					| password		|
	| hero@gmail.com		| hero1234		|
	| jemu@gmail.com		| jemu22234		|		 





