@list @add_list
Feature: Add list

As an existing user,
I want to add a list to a board,
So that I can track the status of my tasks

######################################################################################################################

@gui
Scenario Outline: Add list - Empty board

Given I have already created a board named <board_name>
When I add a list named To Do to the board
Then the To Do list is displayed

Examples:

| board_name             |
| Add list - Empty board |

######################################################################################################################

@api
Scenario Outline: Add list - Empty board (API setup)

Given I have opened the <board_name> board
When I add a list named To Do to the board
Then the To Do list is displayed

Examples:

| board_name                         |
| Add list - Empty board (API setup) |

######################################################################################################################
