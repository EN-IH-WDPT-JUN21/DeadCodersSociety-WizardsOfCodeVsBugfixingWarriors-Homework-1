public class Main {
    public static void main(String[] args) {
        System.out.println("Wizards and Warriors - let's the battle begin!");
        Menu.mainMenu();
    }
//method to catch if console input is numeric
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
