$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Board/Add Card.feature");
formatter.feature({
  "line": 2,
  "name": "Add card",
  "description": "\r\nAs an existing user,\r\nI want to add a card to a board,\r\nSo that I can remind myself to do something",
  "id": "add-card",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@card"
    },
    {
      "line": 1,
      "name": "@add_card"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 8,
      "value": "######################################################################################################################"
    }
  ],
  "line": 11,
  "name": "Add card - Empty list",
  "description": "",
  "id": "add-card;add-card---empty-list",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I have already created a board named \u003cboard_name\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the board has a list named To Do",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I add a card named Buy milk to the To Do list",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the Buy milk card is displayed in the To Do list",
  "keyword": "Then "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "add-card;add-card---empty-list;",
  "rows": [
    {
      "cells": [
        "board_name"
      ],
      "line": 20,
      "id": "add-card;add-card---empty-list;;1"
    },
    {
      "cells": [
        "Add card - Empty list"
      ],
      "line": 21,
      "id": "add-card;add-card---empty-list;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 114491454800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Add card - Empty list",
  "description": "",
  "id": "add-card;add-card---empty-list;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@card"
    },
    {
      "line": 1,
      "name": "@add_card"
    },
    {
      "line": 10,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I have already created a board named Add card - Empty list",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the board has a list named To Do",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I add a card named Buy milk to the To Do list",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the Buy milk card is displayed in the To Do list",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add card - Empty list",
      "offset": 37
    }
  ],
  "location": "ActionSteps.iHaveAlreadyCreatedABoardCalledX(String)"
});
formatter.result({
  "duration": 13905735800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "To Do",
      "offset": 27
    }
  ],
  "location": "BoardPageSteps.theBoardHasAListNamedX(String)"
});
formatter.result({
  "duration": 1731233300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy milk",
      "offset": 19
    },
    {
      "val": "To Do",
      "offset": 35
    }
  ],
  "location": "BoardPageSteps.iAddACardNamedXToTheXList(String,String)"
});
formatter.result({
  "duration": 2077282600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy milk",
      "offset": 4
    },
    {
      "val": "To Do",
      "offset": 38
    }
  ],
  "location": "BoardPageSteps.theXCardIsDisplayedInTheXList(String,String)"
});
formatter.result({
  "duration": 194600500,
  "status": "passed"
});
formatter.after({
  "duration": 7447562000,
  "status": "passed"
});
formatter.uri("Board/Move Card.feature");
formatter.feature({
  "line": 2,
  "name": "Move card",
  "description": "\r\nAs an existing user,\r\nI want to move a card to another list,\r\nSo that I can monitor progress of tasks",
  "id": "move-card",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@card"
    },
    {
      "line": 1,
      "name": "@move_card"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 8,
      "value": "######################################################################################################################"
    }
  ],
  "line": 11,
  "name": "Move card - Single card in list",
  "description": "",
  "id": "move-card;move-card---single-card-in-list",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I have already created a board named \u003cboard_name\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the \u003cboard_name\u003e board has the following lists",
  "rows": [
    {
      "cells": [
        "To Do"
      ],
      "line": 15
    },
    {
      "cells": [
        "Done"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the To Do list has the following cards",
  "rows": [
    {
      "cells": [
        "Buy milk"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I move the Buy milk card from the To Do list to the Done list",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the Buy milk card is displayed in the Done list",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "move-card;move-card---single-card-in-list;",
  "rows": [
    {
      "cells": [
        "board_name"
      ],
      "line": 24,
      "id": "move-card;move-card---single-card-in-list;;1"
    },
    {
      "cells": [
        "Move card - Single card in list"
      ],
      "line": 25,
      "id": "move-card;move-card---single-card-in-list;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9855037100,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Move card - Single card in list",
  "description": "",
  "id": "move-card;move-card---single-card-in-list;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@card"
    },
    {
      "line": 10,
      "name": "@gui"
    },
    {
      "line": 1,
      "name": "@move_card"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I have already created a board named Move card - Single card in list",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "the Move card - Single card in list board has the following lists",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "To Do"
      ],
      "line": 15
    },
    {
      "cells": [
        "Done"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "the To Do list has the following cards",
  "rows": [
    {
      "cells": [
        "Buy milk"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I move the Buy milk card from the To Do list to the Done list",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the Buy milk card is displayed in the Done list",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Move card - Single card in list",
      "offset": 37
    }
  ],
  "location": "ActionSteps.iHaveAlreadyCreatedABoardCalledX(String)"
});
formatter.result({
  "duration": 10263924800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Move card - Single card in list",
      "offset": 4
    }
  ],
  "location": "BoardPageSteps.theXBoardHasTheFollowingLists(String,DataTable)"
});
formatter.result({
  "duration": 2675216600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "To Do",
      "offset": 4
    }
  ],
  "location": "BoardPageSteps.theXListHasTheFollowingCards(String,DataTable)"
});
formatter.result({
  "duration": 1431539500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy milk",
      "offset": 11
    },
    {
      "val": "To Do",
      "offset": 34
    },
    {
      "val": "Done",
      "offset": 52
    }
  ],
  "location": "BoardPageSteps.iMoveTheXCardToTheXList(String,String,String)"
});
formatter.result({
  "duration": 2354062000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy milk",
      "offset": 4
    },
    {
      "val": "Done",
      "offset": 38
    }
  ],
  "location": "BoardPageSteps.theXCardIsDisplayedInTheXList(String,String)"
});
formatter.result({
  "duration": 59947100,
  "status": "passed"
});
formatter.after({
  "duration": 2688070800,
  "status": "passed"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 41,
      "value": "######################################################################################################################"
    }
  ],
  "line": 44,
  "name": "Move card - Multiple cards in list",
  "description": "",
  "id": "move-card;move-card---multiple-cards-in-list",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 43,
      "name": "@gui"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I have already created a board named \u003cboard_name\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "the \u003cboard_name\u003e board has the following lists",
  "rows": [
    {
      "cells": [
        "To Do"
      ],
      "line": 48
    },
    {
      "cells": [
        "Doing"
      ],
      "line": 49
    },
    {
      "cells": [
        "Done"
      ],
      "line": 50
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "the To Do list has the following cards",
  "rows": [
    {
      "cells": [
        "Buy eggs"
      ],
      "line": 52
    },
    {
      "cells": [
        "Buy milk"
      ],
      "line": 53
    },
    {
      "cells": [
        "Buy coffee"
      ],
      "line": 54
    },
    {
      "cells": [
        "Buy sugar"
      ],
      "line": 55
    },
    {
      "cells": [
        "Buy bread"
      ],
      "line": 56
    },
    {
      "cells": [
        "Buy butter"
      ],
      "line": 57
    },
    {
      "cells": [
        "Buy tea"
      ],
      "line": 58
    },
    {
      "cells": [
        "Buy cheese"
      ],
      "line": 59
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "I move the Buy bread card from the To Do list to the Doing list",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "the Buy bread card is displayed in the Doing list",
  "keyword": "Then "
});
formatter.examples({
  "line": 63,
  "name": "",
  "description": "",
  "id": "move-card;move-card---multiple-cards-in-list;",
  "rows": [
    {
      "cells": [
        "board_name"
      ],
      "line": 65,
      "id": "move-card;move-card---multiple-cards-in-list;;1"
    },
    {
      "cells": [
        "Move card - Multiple cards in list"
      ],
      "line": 66,
      "id": "move-card;move-card---multiple-cards-in-list;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13695283800,
  "status": "passed"
});
formatter.scenario({
  "line": 66,
  "name": "Move card - Multiple cards in list",
  "description": "",
  "id": "move-card;move-card---multiple-cards-in-list;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@card"
    },
    {
      "line": 43,
      "name": "@gui"
    },
    {
      "line": 1,
      "name": "@move_card"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I have already created a board named Move card - Multiple cards in list",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "the Move card - Multiple cards in list board has the following lists",
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "To Do"
      ],
      "line": 48
    },
    {
      "cells": [
        "Doing"
      ],
      "line": 49
    },
    {
      "cells": [
        "Done"
      ],
      "line": 50
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "the To Do list has the following cards",
  "rows": [
    {
      "cells": [
        "Buy eggs"
      ],
      "line": 52
    },
    {
      "cells": [
        "Buy milk"
      ],
      "line": 53
    },
    {
      "cells": [
        "Buy coffee"
      ],
      "line": 54
    },
    {
      "cells": [
        "Buy sugar"
      ],
      "line": 55
    },
    {
      "cells": [
        "Buy bread"
      ],
      "line": 56
    },
    {
      "cells": [
        "Buy butter"
      ],
      "line": 57
    },
    {
      "cells": [
        "Buy tea"
      ],
      "line": 58
    },
    {
      "cells": [
        "Buy cheese"
      ],
      "line": 59
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "I move the Buy bread card from the To Do list to the Doing list",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "the Buy bread card is displayed in the Doing list",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Move card - Multiple cards in list",
      "offset": 37
    }
  ],
  "location": "ActionSteps.iHaveAlreadyCreatedABoardCalledX(String)"
});
formatter.result({
  "duration": 24862446500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Move card - Multiple cards in list",
      "offset": 4
    }
  ],
  "location": "BoardPageSteps.theXBoardHasTheFollowingLists(String,DataTable)"
});
formatter.result({
  "duration": 3994646400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "To Do",
      "offset": 4
    }
  ],
  "location": "BoardPageSteps.theXListHasTheFollowingCards(String,DataTable)"
});
formatter.result({
  "duration": 11224405100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy bread",
      "offset": 11
    },
    {
      "val": "To Do",
      "offset": 35
    },
    {
      "val": "Doing",
      "offset": 53
    }
  ],
  "location": "BoardPageSteps.iMoveTheXCardToTheXList(String,String,String)"
});
formatter.result({
  "duration": 1785885700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Buy bread",
      "offset": 4
    },
    {
      "val": "Doing",
      "offset": 39
    }
  ],
  "location": "BoardPageSteps.theXCardIsDisplayedInTheXList(String,String)"
});
formatter.result({
  "duration": 58938800,
  "status": "passed"
});
formatter.after({
  "duration": 7686716000,
  "status": "passed"
});
});