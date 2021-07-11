import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {
    private static List<Character> firstParty;
    private static List<Character> secondParty;
    private static final List<Character> graveyard = new ArrayList<>();
    private static final int AUTO_BATTLE_DELAY = 0;
    private static final int MANUAL_BATTLE_DELAY = 300;

    //Layer1 -- mainMenu which will print the first screen and allow the user to choose next step
    public static void mainMenu() {
        Scanner console = new Scanner(System.in);
        String mainMenu = ("""
                Welcome to possibly the greatest text battle simulator ever!
                For excellent graphics try enableGraphics command.
                 1. Start a new game
                 2. Quit
                """);
        System.out.print(mainMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2", "enableGraphics"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(mainMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);
        }

        // valid options decision tree
        switch (menuChoice) {
            //go to the party creation menu
            case "1" -> Menu.partyCreatorMenu();


            // quit the game - such a shame
            case "2" -> System.out.println("So... You've chosen to quit the game without even trying? So be it!");

            //invokes enableGraphics method which prints some high level graphics
            case "enableGraphics" -> Menu.enableGraphics();

            //just a security valve - probably redundant
            default -> System.out.println("This is not a valid option. Lets start again!");

        }
        //A goodbye message
        System.out.println("Bye!");
        console.close();
    }

    //Layer2Graphics enabled menu which invoke some sophisticated, top notch, super duper interactive (not really),  high level ASCII art
    public static void enableGraphics(){
        //Print graphic
        Graphics.graphics1();
        //Allow User to go back to the mainMenu
        Scanner console = new Scanner(System.in);
        String menuChoice = console.next();
        switch (menuChoice){
            case "1": {
                //go back to mainMenu -- only for unimaginative or bored users!
                Menu.mainMenu();
                break;
            }
            //easter egg for imaginative users
            case "imagination": {
                System.out.println("No, seriously use YOUR OWN imagination and start playing the game!\n1. Go back to menu");
                menuChoice = console.next();
                //jokes aside, let's go back to mainMenu
                if(!menuChoice.equals("1")){
                    //creative users may still want to test input validation, so let's give them a last treat and go back to mainMenu.
                    System.out.println("Oh, i see you are the funny type, eh? You are going to main menu anyway!");
                    console.next();
                }
                Menu.mainMenu();
                break;
            }
            //if user wants to repeat the graphics, so lets loop back to start of this method
            case "enableGraphics": Menu.enableGraphics();
            //every other case we move user to main menu
            default: {
                System.out.println("that's not a valid choice, let me help you!");
                console.next();
                console.close();
                Menu.mainMenu();
                break;
            }
        }
        console.close();
    }

    //Layer2 -- partyCreatorMenu which will allow User to decide the way the parties will be created
    public static void partyCreatorMenu() {
        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                For the battle to commence we need to create two parties.
                How would you like to do it?
                 1. Generate random parties
                 2. Modify current or create custom parties
                 3. Import parties from a file
                 4. Start Battle!
                 5. Go back
                 6. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "5", "6", "enableGraphics", "imagination"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);
        }

        // valid options decision tree
        switch (menuChoice) {
            //invoke the random generation menu
            case "1" -> {
                System.out.println("So, you want to generate random parties!");
                Menu.randomPartyCreatorMenu();
            }

            //invoke the custom generation menu
            case "2" -> {
                System.out.println("Okay, so let's custom create those parties!");
                Menu.customPartyCreatorMenu();
            }

            //invoke import file menu
            case "3" -> {
                System.out.println("You have already saved your teams? Great, let's import them");
                try {
                    Menu.importPartiesFromCSV();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Parties imported");
                Menu.partyCreatorMenu();
            }

            //go to battle menu
            case "4" -> {
                if (firstParty == null || firstParty.size() == 0 || secondParty == null || secondParty.size() == 0) {
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                } else {
                    System.out.println("Let the battle begin!");
                    Menu.battleMenu();
                }
            }

            //go back to mainMenu
            case "5" -> Menu.mainMenu();
            //quit the game - only for losers... and maybe beta testers
            case "6" -> System.out.println("Looser!");
            case "enableGraphics" -> {
                System.out.println("Haha! No graphics here!");
                console.next();
                Menu.partyCreatorMenu();
            }

            //another easter egg for people trying to break the code
            case "imagination" -> {
                System.out.println("Imagine that you should use commands given on the screen...");
                System.out.println("Type anything to go back to main menu.");
                console.next();
                Menu.mainMenu();
            }
            default -> {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
            }
        }
        console.close();
    }

    //Layer3 -- generate random parties
    public static void randomPartyCreatorMenu() {
        int firstPartySize;
        int secondPartySize;

        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                How chaotic teams do you prefer?
                 1. Let the chaos reign! <generates random characters in random sized parties(max party size is 20)>
                 2. Decide the parties size.
                 3. Export parties to a file
                 4. To Battle!
                 5. Go back
                 6. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4","5", "enableGraphics", "imagination"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);
        }

        // valid options decision tree
        switch (menuChoice) {
            //Generate random parties up to limit size
            case "1" -> {
                //invoke method to create random parties
                var nameGen = new LinesGenerator("names.csv");
                var names = nameGen.getLines();
                var gen = new RandomCharacterGenerator(names);
                List<Character> party1 = new ArrayList<>();
                List<Character> party2 = new ArrayList<>();

                //generate random party size, up to 20 characters in each party
                int p1Size = (int) ((Math.random() * (20-1)) + 1);
                int p2Size = (int) ((Math.random() * (20-1)) + 1);

                //populate the party1
                for (int i = 1; i <= p1Size; i++) {
                    gen.addRandomCharacterToParty(party1);
                }
                //populate the party2
                for (int i = 1; i <= p2Size; i++) {
                    gen.addRandomCharacterToParty(party2);
                }
                System.out.println("Random parties created!");
                System.out.println("Party1: ");
                System.out.println(PartyFormatter.getString(party1));
                System.out.println("Party2: ");
                System.out.println(PartyFormatter.getString(party2));
                firstParty = party1;
                secondParty = party2;
                Menu.randomPartyCreatorMenu();
            }

            //Decide party sizes
            case "2" -> {
                var nameGen = new LinesGenerator("names.csv");
                var names = nameGen.getLines();
                var gen = new RandomCharacterGenerator(names);
                List<Character> party1 = new ArrayList<>();
                List<Character> party2 = new ArrayList<>();

                System.out.println("Set size for the first party");
                String size = console.next();
                //loop while user input is invalid type or party size is <=0
                while (Main.isNumeric(size) || Integer.parseInt(size) <= 0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size = console.next();
                }
                System.out.println("First party size was set to: " + size);
                firstPartySize = Integer.parseInt(size);

                //set second party size
                System.out.println("Set size for the second party");
                size = console.next();

                //loop while user input is invalid type or party size is <=0
                while (Main.isNumeric(size) || Integer.parseInt(size) <= 0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size = console.next();
                }
                System.out.println("Second party size was set to: " + size);
                secondPartySize = Integer.parseInt(size);


                //populate the party1
                for (int i = 1; i <= firstPartySize; i++) {
                    gen.addRandomCharacterToParty(party1);
                }
                //populate the party2
                for (int i = 1; i <= secondPartySize; i++) {
                    gen.addRandomCharacterToParty(party2);
                }
                System.out.println("Random parties created!");
                System.out.println("Party1: ");
                System.out.println(PartyFormatter.getString(party1));
                System.out.println();
                System.out.println("Party2: ");
                System.out.println(PartyFormatter.getString(party2));

                //store created parties in class fields
                firstParty = party1;
                secondParty = party2;

                //go back to the menu
                Menu.randomPartyCreatorMenu();
            }

            //export parties to files
            case "3" -> {
                if (firstParty == null || firstParty.size() == 0 || secondParty == null || secondParty.size() == 0) {
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                } else {
                    try {
                        Menu.exportPartiesToCSV();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Parties exported to files");
                    Menu.randomPartyCreatorMenu();
                }
            }
            case "4" -> {
                if (firstParty == null || firstParty.size() == 0 || secondParty == null || secondParty.size() == 0) {
                    System.out.println("You need to create parties first!");
                    Menu.randomPartyCreatorMenu();
                    break;
                } else {
                    System.out.println("Let the battle begin!");
                }
                Menu.battleMenu();
            }

            //Go back to partyCreatorMenu
            case "5" -> {
                System.out.println("Let's go back then!");
                Menu.partyCreatorMenu();
            }

            //quit the game - only for losers... and maybe beta testers
            case "6" -> System.out.println("Looser!");

            //Little treat for those who are stubborn and try to break the code :)
            case "enableGraphics" -> {
                System.out.println("You really are stubborn, you know?!");
                console.next();
                System.out.println("But this stubbornness requires an award... yet as a punishment, you need to go back to main menu ;)");
                console.next();
                Graphics.graphics2();
                console.next();
                Menu.mainMenu();
            }

            //another easter egg for people trying to break the code
            case "imagination" -> {
                System.out.println("Imagine that here is another several lines of code and that you do not need to go back from the mainMenu!");
                System.out.println("Ready?!.");
                console.next();
                System.out.println("It doesn't really matter, you are going back to the main menu anyway!");
                Menu.mainMenu();
            }

            //handles all other types of input
            default -> {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
            }
        }
        console.close();
    }

    //Layer3 -- create custom parties
    public static void customPartyCreatorMenu() {
        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                Create your parties:
                 1. Modify current parties
                 2. Export parties to a file
                 3. Go back
                 4. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4","5", "enableGraphics", "imagination"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);
        }

        // valid options decision tree
        switch (menuChoice) {
            // modify current parties
            case "1" -> {
                //check if first party is null
                List<Character> party1 = new ArrayList<>();
                if (firstParty != null) {
                    party1 = firstParty;
                }
                System.out.println("firstParty has following characters:");
                // loop through party members and decide if remove them
                for (int i = 0; i < party1.size(); i++) {
                    System.out.println(party1.get(i).toString());
                    System.out.println("""
                            Do you want to remove this character?
                            1.Remove
                            2.Leave as is
                            """);
                    menuChoice = console.next();
                    if (menuChoice.equals("1")) {
                        party1.remove(i);
                        i -= 1;
                        System.out.println("Character removed");
                    }
                }
                //possibility to add a new character
                boolean newCharacter = true;
                while (newCharacter) {
                    System.out.println("""
                            Do you want to add new character to first party?
                            1. Add Warrior
                            2. Add Wizard
                            3. Move to second party
                            """);
                    menuChoice = console.next();
                    if (menuChoice.equals("1")) {
                        party1.add(Menu.createNewWarrior());
                        System.out.println("New character added: " + party1.get(party1.size() - 1).toString());
                    } else if (menuChoice.equals("2")) {
                        party1.add(Menu.createNewWizard());
                        System.out.println("New character added: " + party1.get(party1.size() - 1).toString());
                    } else {
                        newCharacter = false;
                    }
                }

                List<Character> party2 = new ArrayList<>();
                if (secondParty != null) {
                    party2 = secondParty;
                }
                System.out.println("secondParty has following characters:");
                // loop through party members and decide if they should be removed
                for (int i = 0; i < party2.size(); i++) {
                    System.out.println(party2.get(i).toString());
                    System.out.println("""
                            What fo you want to do with this character?
                            1.Remove
                            2.Leave as is
                            """);
                    menuChoice = console.next();
                    if (menuChoice.equals("1")) {
                        party2.remove(i);
                        i -= 1;
                        System.out.println("Character removed");
                    }
                }
                //possibility to add a new character
                boolean newCharacter2 = true;
                while (newCharacter2) {
                    System.out.println("""
                            Do you want to add new character to second party?
                            1. Add Warrior
                            2. Add Wizard
                            3. End editing parties
                            """);
                    menuChoice = console.next();
                    if (menuChoice.equals("1")) {
                        party2.add(Menu.createNewWarrior());
                        System.out.println("New character added: " + party2.get(party2.size() - 1).toString());
                    } else if (menuChoice.equals("2")) {
                        party2.add(Menu.createNewWizard());
                        System.out.println("New character added: " + party2.get(party2.size() - 1).toString());
                    } else {
                        newCharacter2 = false;
                    }
                }
                //update main parties and go back to the menu
                firstParty = party1;
                secondParty = party2;
                Menu.customPartyCreatorMenu();
            }

            //export parties to csv
            case "2" -> {
                if (firstParty == null || firstParty.size() == 0 || secondParty == null || secondParty.size() == 0) {
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                } else {
                    try {
                        Menu.exportPartiesToCSV();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //confirm and go back to menu
                    System.out.println("Parties exported to files");
                    Menu.customPartyCreatorMenu();
                }
            }

            //go back to partyCreatorMenu
            case "3" -> partyCreatorMenu();

            //quit the game - only for losers... and maybe beta testers
            case "4" -> System.out.println("Looser!");

            //Easter egg cow
            case "enableGraphics" -> {
                System.out.println("You really are stubborn, you know?!");
                console.next();
                System.out.println("Ok, last one!");
                console.next();
                Graphics.graphics3();
                console.next();
                Menu.mainMenu();
            }

            //another easter egg for people trying to break the code
            case "imagination" -> {
                System.out.println("Imagine that here is another several lines of code and that you do not need to go back from the mainMenu!");
                System.out.println("Ready?!.");
                console.next();
                System.out.println("It doesn't really matter, you are going back to the main menu anyway!");
                Menu.mainMenu();
            }
            default -> {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
            }
        }
        console.close();
    }

    //Layer4 -- BattleMenu
    public static void battleMenu() {
        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                Select mode for your battle:
                 1. Automatic battle
                 2. Manual battle
                 3. Graveyard
                 4. Go back to party creation menu
                 5. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4","5"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.asList(mainMenuOptions).contains(menuChoice);
        }

        // valid options decision tree
        switch (menuChoice) {
            // Auto battle
            case "1" -> {
                //Check if the parties are null
                Predicate<Character> isAlive = Character -> Character.getHp() > 0;
                List<Character> party1= firstParty.stream().filter(isAlive)
                        .collect(Collectors.toList());
                List<Character> party2= secondParty.stream().filter(isAlive)
                        .collect(Collectors.toList());

                if (party1.size() == 0 || party2.size() == 0) {
                    System.out.println("Both parties cannot be empty to start a battle");
                    battleMenu();
                }

                //Battle characters as long as one team has no more alive characters.
                while (party1.size() > 0 && party2.size() > 0){
                    //choose random characters
                    Random rand = new Random();
                    Character char1=party1.get(rand.nextInt(party1.size()));
                    Character char2=party2.get(rand.nextInt(party2.size()));
                    //battle
                    var battleCries = new LinesGenerator("battle_cries.csv").getLines();
                    var battle = new Battle(battleCries, AUTO_BATTLE_DELAY);
                    battle.duel(char1, char2);
                    //dig graves
                    if (!char1.isAlive()) graveyard.add(char1);
                    if (!char2.isAlive()) graveyard.add(char2);
                    //again filter parties for alive champions
                    party1= party1.stream().filter(isAlive)
                            .collect(Collectors.toList());
                    party2= party2.stream().filter(isAlive)
                            .collect(Collectors.toList());
                }

                if(party1.size()==0 && party2.size()==0) {
                    Graphics.graphicsAllDead();
                    System.out.println("Both parties died at the same time! there were no survivors!");
                }else if(party1.size()!=0){
                    Graphics.graphicsSecondDead();
                    System.out.println("The first Party won with surviving characters: ");
                    System.out.println(PartyFormatter.getString(party1));
                } else {
                    Graphics.graphicsFirstDead();
                    System.out.println("The second Party won with surviving characters: ");
                    System.out.println(PartyFormatter.getString(party2));
                }
                //update main parties and go back to the menu
                firstParty = party1;
                secondParty = party2;
                Menu.battleMenu();
            }

            //Manual battle
            case "2" -> {
                //Check if the parties are null
                Predicate<Character> isAlive = Character -> Character.getHp() > 0;
                List<Character> party1= firstParty.stream().filter(isAlive)
                    .collect(Collectors.toList());
                List<Character> party2= secondParty.stream().filter(isAlive)
                    .collect(Collectors.toList());

                if (party1.size() == 0 || party2.size() == 0) {
                    System.out.println("Both parties cannot be empty to start a battle");
                    battleMenu();
                }

                //Battle characters once
                //choose characters
                System.out.println("Choose a fighter from party 1 (using index):");
                System.out.println(PartyFormatter.getString(party1));

                String strN = console.next();
                //loop while user input is invalid type or party size is <=0
                while (Main.isNumeric(strN) || Integer.parseInt(strN) <= 0 || Integer.parseInt(strN) > party1.size() ) {
                    System.out.println("This is not a valid character index! Try again!");
                    strN = console.next();
                }
                int chIdx1 =  Integer.parseInt(strN) -1 ;
                Character char1=party1.get(chIdx1);

                System.out.println("Choose a fighter from party 2 (using index):");
                System.out.println(PartyFormatter.getString(party2));

                strN = console.next();
                //loop while user input is invalid type or party size is <=0
                while (Main.isNumeric(strN) || Integer.parseInt(strN) <= 0 || Integer.parseInt(strN) > party2.size() ) {
                    System.out.println("This is not a valid character index! Try again!");
                    strN = console.next();
                }
                int chIdx2 =  Integer.parseInt(strN) -1 ;
                Character char2=party2.get(chIdx2);

                //battle
                var battleCries = new LinesGenerator("battle_cries.csv").getLines();
                var battle = new Battle(battleCries, MANUAL_BATTLE_DELAY);
                battle.duel(char1, char2);
                //dig graves
                if (!char1.isAlive()) graveyard.add(char1);
                if (!char2.isAlive()) graveyard.add(char2);
                //again filter parties for alive champions
                party1= party1.stream().filter(isAlive)
                    .collect(Collectors.toList());
                party2= party2.stream().filter(isAlive)
                    .collect(Collectors.toList());

                if(!char1.isAlive() && !char2.isAlive()) {
                    Graphics.graphicsAllDead();
                    System.out.println("Both fighters died at the same time! there were no survivors!");
                }else if(!char2.isAlive()){
                    Graphics.graphicsSecondDead();
                    System.out.println("The first Party won with surviving characters: ");
                    System.out.println(PartyFormatter.getString(party1));
                } else {
                    Graphics.graphicsFirstDead();
                    System.out.println("The second Party won with surviving characters: ");
                    System.out.println(PartyFormatter.getString(party2));
                }
                //update main parties and go back to the menu
                firstParty = party1;
                secondParty = party2;
                Menu.battleMenu();
            }
            //print the graveyard
            case "3" -> graveyardMenu();


            //go back to partyCreatorMenu
            case "4" -> partyCreatorMenu();

            //quit the game - only for losers... and maybe beta testers
            case "5" -> System.out.println("Looser!");
            default -> {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
            }
        }
        console.close();
    }

    //Layer4 -- GraveyardMenu
    public static void graveyardMenu() {
        System.out.println("Graveyard:" );
        System.out.println(PartyFormatter.getString(graveyard));
        battleMenu();
    }

    //create custom Warrior
    public static Warrior createNewWarrior(){
        Scanner console = new Scanner(System.in);
        System.out.println("Set name");
        String name = console.next();
        System.out.println("Set hp");
        int hp = Integer.parseInt(console.next());
        System.out.println("Set stamina");
        int stamina = Integer.parseInt(console.next());
        System.out.println("Set strength");
        int strength = Integer.parseInt(console.next());
        console.close();
        return new Warrior(name, hp, stamina, strength);
    }

    //create custom Wizard
    public static Wizard createNewWizard(){
        Scanner console = new Scanner(System.in);
        System.out.println("Set name");
        String name = console.next();
        System.out.println("Set hp");
        int hp = Integer.parseInt(console.next());
        System.out.println("Set mana");
        int mana = Integer.parseInt(console.next());
        System.out.println("Set intelligence");
        int intelligence = Integer.parseInt(console.next());
        return new Wizard(name, hp, mana, intelligence);
    }

    //export parties to csv files
    public static void exportPartiesToCSV() throws IOException {
        FileWriter csvWriter = null;
        //loop through first file and create valid class objects
        try {
            csvWriter = new FileWriter("firstParty.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Character ch : firstParty) {
            if (firstParty.get(firstParty.indexOf(ch)).getClass()==Wizard.class){
                Wizard wiz1= (Wizard) firstParty.get(firstParty.indexOf(ch));
                assert csvWriter != null;
                csvWriter.append(wiz1.exportCharacter());
            }else {
                Warrior war1= (Warrior) firstParty.get(firstParty.indexOf(ch));
                assert csvWriter != null;
                csvWriter.append(war1.exportCharacter());
            }
            csvWriter.append("\n");
        }
        assert csvWriter != null;
        csvWriter.flush();
        csvWriter.close();

        //loop through second file and create valid class objects
        try {
            csvWriter = new FileWriter("secondParty.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Character ch : secondParty) {
            if (secondParty.get(secondParty.indexOf(ch)).getClass()==Wizard.class){
                Wizard wiz1= (Wizard) secondParty.get(secondParty.indexOf(ch));
                csvWriter.append(wiz1.exportCharacter());
            }else {
                Warrior war1= (Warrior) secondParty.get(secondParty.indexOf(ch));
                csvWriter.append(war1.exportCharacter());
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    //import parties from csv files
    public static void importPartiesFromCSV() throws IOException {
        List<Character> party1 = new ArrayList<>();
        List<Character> party2 = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("firstParty.csv"))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("")) {
                String[] values = line.split(";");
                String[] v=values[0].split(",");

                if (v[0].equals("Wizard")) {
                    Wizard w1=new Wizard(v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), Integer.parseInt(v[4]));
                    party1.add(w1);
                } else{
                    Warrior w1=new Warrior(v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), Integer.parseInt(v[4]));
                    party1.add(w1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("secondParty.csv"))) {
            String line;
            while ((line = br.readLine()) != null && !line.equals("")) {
                String[] values = line.split(";");
                String[] v=values[0].split(",");
                if (v[0].equals("Wizard" )) {
                    Wizard w1=new Wizard(v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), Integer.parseInt(v[4]));
                    party2.add(w1);
                } else{
                    Warrior w1=new Warrior(v[1], Integer.parseInt(v[2]), Integer.parseInt(v[3]), Integer.parseInt(v[4]));
                    party2.add(w1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        firstParty=party1;
        secondParty=party2;
    }

}
