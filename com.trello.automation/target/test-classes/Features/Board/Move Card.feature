@card @move_card
Feature: Move card

As an existing user,
I want to move a card to another list,
So that I can monitor progress of tasks

######################################################################################################################

@gui
Scenario Outline: Move card - Single card in list

Given I have already created a board named <board_name>
	And the <board_name> board has the following lists
		| To Do |
		| Done  |
	And the To Do list has the following cards
		| Buy milk |
When I move the Buy milk card from the To Do list to the Done list
Then the Buy milk card is displayed in the Done list

Examples:

| board_name                      |
| Move card - Single card in list |

######################################################################################################################

@api
Scenario Outline: Move card - Single card in list (API setup)

Given I have opened the <board_name> board
When I move the Buy milk card from the To Do list to the Done list
Then the Buy milk card is displayed in the Done list

Examples:

| board_name                                  |
| Move card - Single card in list (API setup) |

######################################################################################################################

@gui
Scenario Outline: Move card - Multiple cards in list

Given I have already created a board named <board_name>
	And the <board_name> board has the following lists
		| To Do |
		| Doing |
		| Done  |
	And the To Do list has the following cards
		| Buy eggs   |
		| Buy milk   |
		| Buy coffee |
		| Buy sugar  |
		| Buy bread  |
		| Buy butter |
		| Buy tea    |
		| Buy cheese |
When I move the Buy bread card from the To Do list to the Doing list
Then the Buy bread card is displayed in the Doing list

Examples:

| board_name                         |
| Move card - Multiple cards in list |

######################################################################################################################

@api
Scenario Outline: Move card - Multiple cards in list (API setup)

Given I have opened the <board_name> board
When I move the Buy bread card from the To Do list to the Doing list
Then the Buy bread card is displayed in the Doing list
Examples:

| board_name                                     |
| Move card - Multiple cards in list (API setup) |

######################################################################################################################