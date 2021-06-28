import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static List<Character> firstParty;
    private static List<Character> secondParty;

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
        boolean validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(mainMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);
        }

        // valid options decision tree
        switch (menuChoice) {
            //go to the party creation menu
            case "1": {
                Menu.partyCreatorMenu();
                break;
            }
            // quit the game - such a shame
            case "2": {
                System.out.println("So... You've chosen to quit the game without even trying? So be it!");
                break;
            }
            //invokes enableGraphics method which prints some high level graphics
            case "enableGraphics": {
                Menu.enableGraphics();
                break;
            }
            //just a security valve - probably redundant
            default: {
                System.out.println("This is not a valid option. Lets start again!");
                break;
            }
        }
        //A goodbye message
        System.out.println("Bye!");
        console.close();
    }

    //Layer2Graphics enabled menu which invoke some sophisticated, top notch, super duper interactive (not really),  high level ASCII art
    public static void enableGraphics(){
        System.out.println("""
                                      (      )\s
                                      ~(^^^^)~\s
                                       ) @@ \\~_          |\\\s
                                      /     | \\        \\~ /\s
                                     ( 0  0  ) \\        | |\s
                                      ---___/~  \\       | |\s
                                       /'__/ |   ~-_____/ |\s
                        o          _   ~----~      ___---~\s
                          O       //     |         |\s
                                 ((~\\  _|         -|\s
                           o  O //-_ \\/ |        ~  |\s
                                ^   \\_ /         ~  |\s
                                       |          ~ |\s
                                       |     /     ~ |\s
                                       |     (       |\s
                                        \\     \\      / \\\s
                                       / -_____-\\   \\ ~~-*\s
                                       |  /       \\  \\\s
                                       / /         / /\s
                                     /~  |       /~  |\s
                                     ~~~~        ~~~~\s
        That's enough graphics for you! Now use imagination!
        1. Go back to menu.
        """);
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
                if(menuChoice.equals("1")){
                    Menu.mainMenu();
                    break;
                    //creative users may still want to test input validation, so let's give them a last treat and go back to mainMenu.
                }else{
                    System.out.println("Oh, i see you are the funny type, eh? You are going to main menu anyway!");
                        menuChoice = console.next();
                        Menu.mainMenu();
                        break;
                }
            }
            //if user wants to repeat the graphics, so lets loop back to start of this method
            case "enableGraphics": Menu.enableGraphics();
            //every other case we move user to main menu
            default: {
                System.out.println("that's not a valid choice, let me help you!");
                menuChoice = console.next();
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
        String[] mainMenuOptions = {"1", "2","3", "4", "5", "enableGraphics", "imagination"};

        //check if the input is one of the valid options
        boolean validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);
        }

        // valid options decision tree
        switch (menuChoice) {
            //invoke the random generation menu
            case "1": {
                System.out.println("So, you want to generate random parties!");
                Menu.randomPartyCreatorMenu();
                break;
            }
            //invoke the custom generation menu
            case "2": {
                System.out.println("Okay, so let's custom create those parties!");
                Menu.customPartyCreatorMenu();
                break;
            }
            //invoke import file menu
            case "3": {
                System.out.println("You have already saved your teams? Great, let's import them");
                try {
                    Menu.importPartiesFromCSV();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Parties imported");
                Menu.partyCreatorMenu();
                break;
            }
            //go to battle menu
            case "4": {
                if (firstParty== null || firstParty.size() == 0|| secondParty== null || secondParty.size() == 0 ){
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                    break;
                } else {
                    System.out.println("Let the battle begin!");
                    Menu.battleMenu();
                    break;
                }
            }
            //go back to mainMenu
            case "5": {
                Menu.mainMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "6": {
                System.out.println("Looser!");
                break;
            }
            case "enableGraphics": {
                System.out.println("Haha! No graphics here!");
                menuChoice = console.next();
                Menu.partyCreatorMenu();
                break;
            }
            //another easter egg for people trying to break the code
            case "imagination": {
                System.out.println("Imagine that you should use commands given on the screen...");
                System.out.println("Type anything to go back to main menu.");
                menuChoice = console.next();
                Menu.mainMenu();
                break;
            }

            default: {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
                break;
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
        boolean validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);
        }

        // valid options decision tree
        switch (menuChoice) {
            //Generate random parties up to limit size
            case "1": {
                //invoke method to create random parties
                var nameGen = new NameListGenerator("names.csv");
                var names = nameGen.getNames();
                var gen = new RandomCharacterGenerator(names);
                List<Character> party1 = new ArrayList<>();
                List<Character> party2 = new ArrayList<>();

                //generate random party size, up to 20 characters in each party
                int p1Size = (int) (Math.random() * 20);
                int p2Size = (int) (Math.random() * 20);

                //populate the party1
                for(int i=1; i<=p1Size; i++) {
                    gen.addRandomCharacterToParty(party1);
                }
                //populate the party2
                for(int i=1; i<=p2Size; i++) {
                    gen.addRandomCharacterToParty(party2);
                }
                System.out.println("Random parties created!");
                System.out.println("Party1: "+party1);
                System.out.println();
                System.out.println("Party2: "+party2);
                firstParty=party1;
                secondParty=party2;
                Menu.randomPartyCreatorMenu();
                break;
                }
            //Decide party sizes
            case "2": {
                var nameGen = new NameListGenerator("names.csv");
                var names = nameGen.getNames();
                var gen = new RandomCharacterGenerator(names);
                List<Character> party1 = new ArrayList<>();
                List<Character> party2 = new ArrayList<>();

                System.out.println("Set size for the first party");
                String size=console.next();
                //loop while user input is invalid type or party size is <=0
                while (!Main.isNumeric(size) || Integer.parseInt(size)<=0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size=console.next();
                }
                System.out.println("First party size was set to: "+size);
                firstPartySize=Integer.parseInt(size);

                //set second party size
                System.out.println("Set size for the second party");
                size=console.next();

                //loop while user input is invalid type or party size is <=0
                while (!Main.isNumeric(size) || Integer.parseInt(size)<=0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size=console.next();
                }
                System.out.println("Second party size was set to: "+size);
                secondPartySize=Integer.parseInt(size);


                //populate the party1
                for(int i=1; i<=firstPartySize; i++) {
                    gen.addRandomCharacterToParty(party1);
                }
                //populate the party2
                for(int i=1; i<=secondPartySize; i++) {
                    gen.addRandomCharacterToParty(party2);
                }
                System.out.println("Random parties created!");
                System.out.println("Party1: "+party1);
                System.out.println();
                System.out.println("Party2: "+party2);

                //store created parties in class fields
                firstParty=party1;
                secondParty=party2;

                //go back to the menu
                Menu.randomPartyCreatorMenu();
                break;
            }
            //export parties to files
            case "3":{
                if (firstParty== null || firstParty.size() == 0|| secondParty== null || secondParty.size() == 0 ){
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                    break;
                }else {
                try {
                    Menu.exportPartiesToCSV();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Parties exported to files");
                Menu.randomPartyCreatorMenu();
                break;}
                }
            case "4": {
                if (firstParty== null || firstParty.size() == 0|| secondParty== null || secondParty.size() == 0 ){
                    System.out.println("You need to create parties first!");
                    Menu.randomPartyCreatorMenu();
                    break;
                } else {
                    System.out.println("Let the battle begin!");
                }
                Menu.battleMenu();
                break;
            }
            //Go back to partyCreatorMenu
            case "5": {
                System.out.println("Let's go back then!");
                Menu.partyCreatorMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "6": {
                System.out.println("Looser!");
                break;
            }
            //Little treat for those who are stubborn and try to break the code :)
            case "enableGraphics": {
                System.out.println("You really are stubborn, you know?!");
                menuChoice = console.next();
                System.out.println("But this stubbornness requires an award... yet as a punishment, you need to go back to main menu ;)");
                menuChoice = console.next();
                System.out.println("""
                             /)  (\\ \s
                        .-._((,~~.))_.-, \s
                         `=.   99   ,=' \s
                           / ,o~~o. \\ \s
                          { { .__. } } \s
                           ) `~~~\\' ( \s
                          /`-._  _\\.-\\ \s
                         /         )  \\ \s
                       ,-X        #   X-. \s
                      /   \\          /   \\ \s
                     (     )| |  | |(     ) \s
                      \\   / | |  | | \\   / \s
                       \\_(.-( )--( )-.)_/ \s
                       /_,\\ ) /  \\ ( /._\\ \s
                           /_,\\  /._\\ \s
                """);
                menuChoice = console.next();
                Menu.mainMenu();
                break;
            }
            //another easter egg for people trying to break the code
            case "imagination": {
                System.out.println("Imagine that here is another several lines of code and that you do not need to go back from the mainMenu!");
                System.out.println("Ready?!.");
                menuChoice = console.next();
                System.out.println("It doesn't really matter, you are going back to the main menu anyway!");
                Menu.mainMenu();
                break;
            }
            //handles all other types of input
            default: {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
                break;
            }
        }
    }

    //Layer3 -- create custom parties
    public static void customPartyCreatorMenu() {
        int firstPartySize;
        int secondPartySize;
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
        boolean validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);

        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(currentMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);
        }

        // valid options decision tree
        switch (menuChoice) {
            // modify current parties
            case "1": {
                //check if first party is null
                List<Character> party1 = new ArrayList<>();
                if (firstParty != null) {
                    party1 = firstParty;
                }
                System.out.println("firstParty has following characters:");
                // loop through party members and decide if remove them
                if (party1 != null) {
                    for (int i = 0; i < party1.size(); i++) {
                        System.out.println(party1.get(i).toString());
                        System.out.println("""
                                What fo you want to do with this character?
                                1.Remove
                                2.Leave as is
                                """);
                        menuChoice = console.next();
                        if (menuChoice.equals("1")) {
                            party1.remove(i);
                            i-=1;
                            System.out.println("Character removed");
                        }
                    }
                }
                //possibility to add a new character
                boolean newCharacter = true;
                while (newCharacter == true) {
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
                if (party2 != null) {
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
                            i-=1;
                            System.out.println("Character removed");
                        }
                    }
                }
                //possibility to add a new character
                boolean newCharacter2 = true;
                while (newCharacter2 == true) {
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
                firstParty=party1;
                secondParty=party2;
                Menu.customPartyCreatorMenu();
                break;
            }
            //export parties to csv
            case "2": {
                if (firstParty== null || firstParty.size() == 0|| secondParty== null || secondParty.size() == 0 ){
                    System.out.println("You need to create parties first!");
                    Menu.partyCreatorMenu();
                    break;
                }else {
                    try {
                        Menu.exportPartiesToCSV();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //confirm and go back to menu
                    System.out.println("Parties exported to files");
                    Menu.customPartyCreatorMenu();
                    break;}
            }
            //go back to partyCreatorMenu
            case "3": {
                partyCreatorMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "4": {
                System.out.println("Looser!");
                break;
            }
            //Easter egg cow
            case "enableGraphics": {
                System.out.println("You really are stubborn, you know?!");
                menuChoice = console.next();
                System.out.println("Ok, last one!");
                menuChoice = console.next();
                System.out.println("""
                                 /( ,,,,, )\\  \s
                                _\\,;;;;;;;,/_ \s
                             .-"; ;;;;;;;;; ;"-. \s
                             '.__/`_ / \\ _`\\__.' \s
                                | (')| |(') | \s
                                | .--' '--. | \s
                                |/ o     o \\| \s
                                |           | \s
                               / \\ _..=.._ / \\ \s
                              /:. '._____.'   \\ \s
                             ;::'    / \\      .; \s
                             |     _|_ _|_   ::| \s
                           .-|     '==o=='    '|-. \s
                          /  |  . /       \\    |  \\ \s
                          |  | ::|         |   | .| \s
                          |  (  ')         (.  )::| \s
                          |: |   |; U U U ;|:: | `| \s
                          |' |   | \\ U U / |'  |  | \s
                          ##V|   |_/`" "`\\_|   |V## \s
                             U# ##         ##V## \s
                                    """);
                menuChoice = console.next();
                Menu.mainMenu();
                break;
            }
            //another easter egg for people trying to break the code
            case "imagination": {
                System.out.println("Imagine that here is another several lines of code and that you do not need to go back from the mainMenu!");
                System.out.println("Ready?!.");
                menuChoice = console.next();
                System.out.println("It doesn't really matter, you are going back to the main menu anyway!");
                Menu.mainMenu();
                break;
            }
            default: {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
                break;
            }
        }
    }

    //Layer4 -- BattleMenu
    public static void battleMenu() {
        System.out.println("Battle menu is not ready!");
    }

    //Layer4 -- GraveyardMenu
    public static void graveyardMenu() {
        System.out.println("Graveyard menu is not ready!");
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
        Warrior w1=new Warrior(name, hp, stamina, strength);
        return w1;
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
        Wizard w1=new Wizard(name, hp, mana, intelligence);
        return w1;
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
                csvWriter.append(wiz1.exportCharacter());
            }else {
                Warrior war1= (Warrior) firstParty.get(firstParty.indexOf(ch));
                csvWriter.append(war1.exportCharacter());
            }
            csvWriter.append("\n");
        }
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
