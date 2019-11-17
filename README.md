# swim-cwk
Object-Oriented Development CWK Part 2


# Functional Requirements 

When a player starts the game, they will be asked for the admiral's name. The system will create an instance of the game and automatically load all the required data on forces and battles into appropriate variables/collections. This includes a war chest of 1000 bit coins. 

The player must then create their active Star Fleet(ASF). They may request to see a list of all the forces in the United Forces Fleet (UFF). They may then activate some of the forces into their active Star Fleet (ASF). On activation of a force to the active Star Fleet, appropriate deductions should be made from war chest and both the result of the activation and the state of the war chest returned. If there are not enough resources in the war chest to activate a force, an appropriate message should be returned. 

Once the player has some forces in their active Star Fleet(ASF), they can do battle. In this prototype, this will require the player to enter a battle number. The system will then select the first appropriate force from the active Star Fleet (ASF) which can be used in the battle. The result of the battle will be processed as described in the specification above and a suitable message returned.

If the war chest is running out of money, the player may recall a force from the ASF back to the UFF dock. This will remove the force from the player's ASF and add half of the force's activation fee to the war chest. Note: forces which have been destroyed cannot be recalled or used in further battles.

The player may activate or recall forces at any point in the game. The player may also request to see: the state of their war chest, information about all the forces in their active star fleet (ASF), all forces inactive in the United Forces Fleet's dock, a list of all the possible battles, the state of one of the forces. The system should also provide facilities to determine whether a battle or a force is part of the system (for validation purposes).

Finally, it should be possible for the player to save a game to a named file and to load a game from a named file.These functional requirements will be specified in Part 2 in the SWIM interface
