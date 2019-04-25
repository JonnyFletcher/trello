@board @create_board
Feature: Create board

As an existing user,
I want to create a board,
So that I can manage my tasks

######################################################################################################################

@gui
Scenario: Create board - None exist

Given I am on the Boards page
	And no other boards exist
#When I create a new board called <board_name>
#Then the <board_name> board is opened
#	And the following lists are displayed
#		| To Do |
#		| Doing |
#		| Done  |
#
#Examples:
#
#| board_name            |
#| Add card - Empty list |
#
#######################################################################################################################
#
#@api
#Scenario Outline: Add card - Empty list (API setup)
#
#Given I have opened the <board_name> board
#When I add a card named Buy milk to the To Do list
#Then the Buy milk card is displayed in the To Do list
#
#Examples:
#
#| board_name                        |
#| Add card - Empty list (API setup) |
#
#######################################################################################################################