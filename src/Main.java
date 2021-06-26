public class Main {
    public static void main(String[] args) {
        System.out.println("""
 __    __  ____  _____   ____  ____   ___     _____      ____  ____   ___        __    __   ____  ____   ____   ____   ___   ____    _____ __  \s
|  |__|  ||    ||     | /    ||    \\ |   \\   / ___/     /    ||    \\ |   \\      |  |__|  | /    ||    \\ |    \\ |    | /   \\ |    \\  / ___/|  | \s
|  |  |  | |  | |__/  ||  o  ||  D  )|    \\ (   \\_     |  o  ||  _  ||    \\     |  |  |  ||  o  ||  D  )|  D  ) |  | |     ||  D  )(   \\_ |  | \s
|  |  |  | |  | |   __||     ||    / |  D  | \\__  |    |     ||  |  ||  D  |    |  |  |  ||     ||    / |    /  |  | |  O  ||    /  \\__  ||__| \s
|  `  '  | |  | |  /  ||  _  ||    \\ |     | /  \\ |    |  _  ||  |  ||     |    |  `  '  ||  _  ||    \\ |    \\  |  | |     ||    \\  /  \\ | __  \s
 \\      /  |  | |     ||  |  ||  .  \\|     | \\    |    |  |  ||  |  ||     |     \\      / |  |  ||  .  \\|  .  \\ |  | |     ||  .  \\ \\    ||  | \s
  \\_/\\_/  |____||_____||__|__||__|\\_||_____|  \\___|    |__|__||__|__||_____|      \\_/\\_/  |__|__||__|\\_||__|\\_||____| \\___/ |__|\\_|  \\___||__| \s
                                                                                                                                               \s
 _        ___  ______      ______  __ __    ___      ____    ____  ______  ______  _        ___      ____     ___   ____  ____  ____   __      \s
| |      /  _]|      |    |      ||  |  |  /  _]    |    \\  /    ||      ||      || |      /  _]    |    \\   /  _] /    ||    ||    \\ |  |     \s
| |     /  [_ |      |    |      ||  |  | /  [_     |  o  )|  o  ||      ||      || |     /  [_     |  o  ) /  [_ |   __| |  | |  _  ||  |     \s
| |___ |    _]|_|  |_|    |_|  |_||  _  ||    _]    |     ||     ||_|  |_||_|  |_|| |___ |    _]    |     ||    _]|  |  | |  | |  |  ||__|     \s
|     ||   [_   |  |        |  |  |  |  ||   [_     |  O  ||  _  |  |  |    |  |  |     ||   [_     |  O  ||   [_ |  |_ | |  | |  |  | __      \s
|     ||     |  |  |        |  |  |  |  ||     |    |     ||  |  |  |  |    |  |  |     ||     |    |     ||     ||     | |  | |  |  ||  |     \s
|_____||_____|  |__|        |__|  |__|__||_____|    |_____||__|__|  |__|    |__|  |_____||_____|    |_____||_____||___,_||____||__|__||__|   \s

""");

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
