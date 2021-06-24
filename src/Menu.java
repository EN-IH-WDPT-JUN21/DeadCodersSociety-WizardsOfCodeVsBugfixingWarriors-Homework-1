import java.util.Scanner;
import java.util.Arrays;

public abstract class Menu {
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
        String[] mainMenuOptions = {"1", "2", "enableGraphics"};
        boolean validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);

        System.out.println(menuChoice);
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Try again!");
            System.out.println(mainMenu);
            menuChoice = console.next();
            validMainMenuOption = Arrays.stream(mainMenuOptions).anyMatch(menuChoice::equals);
        }
        switch (menuChoice) {
            case "1":
                System.out.println("1");
            case "2":
                System.out.println("2");
            case "enableGraphics": Menu.enableGraphics();
        }
    }



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
        Scanner console = new Scanner(System.in);
        String menuChoice = console.next();
        switch (menuChoice){
            case "1": Menu.mainMenu();
            case "imagination": {
                System.out.println("No, seriously use YOUR OWN imagination and start playing the game!\n1. Go back to menu");
                menuChoice = console.next();
                if(menuChoice.equals("1")){
                    Menu.mainMenu();
                }else{
                    System.out.println("Oh, i see you are the funny type, eh? You are going to main menu!");
                        menuChoice = console.next();
                        Menu.mainMenu();
                }
            }
            case "enableGraphics": Menu.enableGraphics();
            default: {
                System.out.println("that's not a valid choice, let me help you!");
                menuChoice = console.next();
                Menu.mainMenu();
            }
        }
    }

}



//Welcome to possibly the greatest text battle simulator ever!
//For excellent graphics try enableGraphics command.
//1. Start a new game
//2. Quit
//"
//if the user will type enableGraphics we can print a simple ASCII image in the console and then the menu again.
//
//If the user will type 2 we print a funny message.
//
//If the user will type 1 then we go to the second step:
//"
//Create your teams:
//1. Generate random teams.
//2. Create custom teams.
//3. Import teams from a file.
//4.Quit (not recommended).
//"
