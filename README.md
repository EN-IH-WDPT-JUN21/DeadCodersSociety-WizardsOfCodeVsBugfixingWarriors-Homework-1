# WizardsOfCodeVsBugfixingWarriors
Wizards vs Warriors (WvW) is a console based text game.
User moves through the text menu by typing the number assigned to desired option and confirming with Enter key.
For example main menu has following options:

1. Start a new game
2. Quit


By typing 1 and confirming with Enter key, app will move user to the second menu. Similarly typing 2 and confirming with Enter key will close the app.

WvW is based on rivalry between two teams consisting of characters from two classes: Wizards and Warriors.
Parties can be created in various ways:
- random generation (limited to 20 characters per party) - user takes no part in parties generation.
- semi-random genration - user sets the party size, but characters assigned to the parties are created at random.
- manual - user removes characters from current parties and then can add manually characters with stats set by the user.

Parties are hold in temporary app space, but can be exported to CSV files by using "Export parties to files". In such cases, current state of both parties will be exported to firstParty.csv and secondParty.csv files. <br/>
Similarly user can import custom parties from CSV files. To do so user needs to add files named firstParty.csv and secondParty.csv to working directory and then choose "Import parties from files" in partyCreationMenu.<br/>
Data contained in import file needs to hold data in a specific order:<br/>
Class,Name,HP,Stamina/Mana,Strength/Intelligence<br/>
Example:<br/>
Warrior,Niqille,133,36,7<br/>
Wizard,Khishann,72,24,22<br/>
Warrior,Colore,126,14,7<br/>
Wizard,Ulador,57,42,4<br/>

After creating valid parties user can proceed further and proceed with the battle.<br/>
Battles can be resolved automatically or manually.<br/>
Automatic battle will be resolved by randomly assigning characters to battle untill one of the teams is fully depleted.<br/>
Manual battle will allow user to choose characters from both parties. <br/>

Dead characters will be moved to the Graveyard.<br/>
Graveyard is the resting place for the dead. There are no parties here, all are equally dead. <br/>
User can print the grevayard to see which characters died during the battle.<br/>



