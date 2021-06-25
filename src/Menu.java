import java.util.Scanner;
import java.util.Arrays;

public abstract class Menu {


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
                System.out.println("So... you've chosen to quit the game without even trying? so be it!");
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

    //Graphics enabled menu which invoke some sophisticated, top notch, super duper interactive (not really),  high level ASCII art
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
                 2. Create custom parties
                 3. Import parties from a file
                 4. Go back
                 5. Quit
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
                Menu.importMenu();
                break;
            }
            //go back to mainMenu
            case "4": {
                Menu.mainMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "5": {
                System.out.println("Looser!");
                break;
            }
            case "enableGraphics": {
                System.out.println("seriously?! this was one time offer! there are no more graphics in this game, so stop looking for them!");
                menuChoice = console.next();
                console.close();
                Menu.mainMenu();
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

    //Layer3 of the menu -- generate random parties
    public static void randomPartyCreatorMenu() {
        int firstPartySize;
        int secondPartySize;

        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                How chaotic teams do you prefer?
                 1. Let the chaos reign! <generates random characters in random sized parties>
                 2. Decide the parties size.
                 3. Export parties to a file
                 4. Go back
                 5. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "enableGraphics", "imagination"};

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
                //invoke method to create random parties
                System.out.println("Random parties created!");
                Menu.battleMenu();
                break;
            }
            //Decide party sizes
            case "2": {
                System.out.println("Set size for the first party");
                String size=console.next();
                //loop while user input is invalid type or party size is <=0
                while (!Main.isNumeric(size) || Integer.parseInt(size)<=0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size=console.next();
                }
                //call the party.setSize method for the first team
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
                //call the party.setSize method for the second team
                System.out.println("Second party size was set to: "+size);
                secondPartySize=Integer.parseInt(size);

                //invoke method to create random parties
                System.out.println("Random parties created!");
                Menu.battleMenu();
                break;
            }
            //invoke export to file menu
            case "3": {
                System.out.println("Let's export this parties");
                Menu.exportMenu();
                break;
            }
            //Go back to partyCreatorMenu
            case "4": {
                System.out.println("Let's go back then!");
                Menu.partyCreatorMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "5": {
                System.out.println("Looser!");
                console.close();
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

    //Layer3 of the menu -- generate custom parties
    public static void customPartyCreatorMenu() {
        int firstPartySize;
        int secondPartySize;
        Scanner console = new Scanner(System.in);
        String currentMenu = ("""
                Create your parties:
                 1. Manage parties size
                 2. Manage characters 
                 3. Export parties to a file
                 4. Go back
                 5. Quit
                """);
        System.out.print(currentMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "enableGraphics", "imagination"};

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
            // set party sizes
            case "1": {
                System.out.println("Set size for the first party");
                String size=console.next();
                //loop while user input is invalid type or party size is <=0
                while (!Main.isNumeric(size) || Integer.parseInt(size)<=0) {
                    System.out.println("This is not a valid party size! Try again!");
                    size=console.next();
                }
                //call the party.setSize method for the first team
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
                //call the party.setSize method for the second team
                System.out.println("Second party size was set to: "+size);
                firstPartySize=Integer.parseInt(size);
                //go back to the customPartyCreatorMenu
                Menu.customPartyCreatorMenu();
                break;
            }
            //Manage characters
            case "2": {
                //Insert 2 loops to create/modify characters in both parties
                System.out.println("Here will be the option to customise your characters");
                //go back to the customPartyCreatorMenu
                Menu.customPartyCreatorMenu();
                break;
            }
            //invoke export file menu
            case "3": {
                System.out.println("Let's export this parties");
                Menu.exportMenu();
                break;
            }
            //go back to partyCreatorMenu
            case "4": {
                partyCreatorMenu();
                break;
            }
            //quit the game - only for losers... and maybe beta testers
            case "5": {
                System.out.println("Looser!");
                break;
            }
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
    //Layer3 ImportMenu
    public static void importMenu() {
        System.out.println("Import menu is not ready!");
    }
    //Layer3 ExportMenu
    public static void exportMenu() {
        System.out.println("Export menu is not ready!");
    }
    //Layer4 BattleMenu
    public static void battleMenu() {
        System.out.println("Battle menu is not ready!");
    }

}