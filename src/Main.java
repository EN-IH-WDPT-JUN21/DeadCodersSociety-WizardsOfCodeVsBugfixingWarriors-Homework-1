
public class Main {
    public static void main(String[] args) {
        //Print main menu graphic
        Graphics.graphicsMainMenu();
        //Print main menu
        Menu.mainMenu();
    }
//method to catch if console input is numeric
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }



}

