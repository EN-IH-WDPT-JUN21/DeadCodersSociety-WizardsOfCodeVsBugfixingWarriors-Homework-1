import java.util.Scanner;
import java.util.Arrays;

public abstract class Menu {

    // main menu which will print the first screen and allow the user to choose next step
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
                Menu.mainMenu();
                break;
            }
        }
    }

    //Second layer of the menu, which will allow User to decide the way the parties will be created
    public static void partyCreatorMenu() {
        Scanner console = new Scanner(System.in);
        String mainMenu = ("""
                For the battle to commence we need to create two parties.
                How would you like to do it?
                 1. Generate random parties
                 2. Create custom parties
                 3. Import parties from a file
                 4. Go back
                 5. Quit
                """);
        System.out.print(mainMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "5", "enableGraphics", "imagination"};

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
    }

    //third layer of the menu -- generate random parties
    public static void randomPartyCreatorMenu() {
        Scanner console = new Scanner(System.in);
        String mainMenu = ("""
                How chaotic teams do you prefer?
                 1. Let the chaos reign! <generates random characters in random sized parties>
                 2. Decide the parties size.
                 3. Go back
                 4. Quit
                """);
        System.out.print(mainMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "enableGraphics", "imagination"};

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
            //invoke the random generation menu
            case "1": {
                System.out.println("So, you want to generate random parties!");
                break;
            }
            //invoke the custom generation menu
            case "2": {
                System.out.println("Okay, so let's custom create those parties!");
                break;
            }
            //invoke import file menu
            case "3": {
                System.out.println("You have already saved your teams? Great, let's import them");
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
                System.out.println("You really are stubborn, you know?!");
                menuChoice = console.next();
                System.out.println("But this stubborness requires an award... yet as a punishment, you need to start from scratch... buahahahaaha");
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

            default: {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
                break;
            }
        }
    }


    //third layer of the menu -- generate custom parties
    public static void customPartyCreatorMenu() {
        Scanner console = new Scanner(System.in);
        String mainMenu = ("""
                Create your parties:
                 1. Manage parties size
                 2. Manage characters 
                 3. Go back
                 4. Quit
                """);
        System.out.print(mainMenu);
        String menuChoice = console.next();

        //valid options
        String[] mainMenuOptions = {"1", "2","3", "4", "enableGraphics", "imagination"};

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
            //invoke the random generation menu
            case "1": {
                System.out.println("Set size for first party");
                int firstPartySize = Integer.parseInt(console.next());
                System.out.println(firstPartySize);
                break;
            }
            //invoke the custom generation menu
            case "2": {
                System.out.println("Okay, so let's custom create those parties!");
                break;
            }
            //invoke import file menu
            case "3": {
                System.out.println("You have already saved your teams? Great, let's import them");
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
                System.out.println("You really are stubborn, you know?!");
                menuChoice = console.next();
                System.out.println("But this stubborness requires an award... yet as a punishment, you need to start from scratch... buahahahaaha");
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

            default: {
                System.out.println("This is not a valid option");
                Menu.partyCreatorMenu();
                break;
            }
        }
    }
}
