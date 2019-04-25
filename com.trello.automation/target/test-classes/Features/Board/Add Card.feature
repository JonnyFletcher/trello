@card @add_card
Feature: Add card

As an existing user,
I want to add a card to a board,
So that I can remind myself to do something

######################################################################################################################

@gui
Scenario Outline: Add card - Empty list

Given I have already created a board named <board_name>
	And the board has a list named To Do
When I add a card named Buy milk to the To Do list
Then the Buy milk card is displayed in the To Do list

Examples:

| board_name            |
| Add card - Empty list |

######################################################################################################################

@api
Scenario Outline: Add card - Empty list (API setup)

Given I have opened the <board_name> board
When I add a card named Buy milk to the To Do list
Then the Buy milk card is displayed in the To Do list

Examples:

| board_name                        |
| Add card - Empty list (API setup) |

######################################################################################################################