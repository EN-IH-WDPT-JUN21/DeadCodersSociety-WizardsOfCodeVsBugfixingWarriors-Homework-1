import java.util.List;

public class PartyFormatter {
  public static String getString(Character character) {
    String result = "";
    String tail = "";
    if (character.getClass() == Warrior.class) {
      var w = (Warrior) character;
      result += "Warrior";
      tail =
          ConsoleColors.YELLOW_BOLD
              + w.getStamina()
              + ConsoleColors.RESET
              + " stamina, "
              + ConsoleColors.YELLOW_BOLD_BRIGHT
              + w.getStrength()
              + ConsoleColors.RESET
              + " strength";
    } else if (character.getClass() == Wizard.class) {
      var w = (Wizard) character;
      result += "Wizard";
      tail =
          ConsoleColors.BLUE_BOLD
              + w.getMana()
              + ConsoleColors.RESET
              + " mana, "
              + ConsoleColors.BLUE_BOLD_BRIGHT
              + w.getIntelligence()
              + ConsoleColors.RESET
              + " intelligence";
    }
    result +=
        " "
            + ConsoleColors.UNDERLINED
            + character.getName()
            + ConsoleColors.RESET
            + " ("
            + ConsoleColors.RED_BOLD_BRIGHT
            + character.getHp()
            + ConsoleColors.RESET
            + "hp, "
            + tail
            + ")";
    return result;
  }

  public static String getString(List<Character> party) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < party.size(); i++) {
      var character = party.get(i);
      result.append(i + 1).append(". ").append(getString(character)).append(System.lineSeparator());
    }

    return result.toString();
  }

  //  public static void main(String[] args) {
  //    var nameGen = new LinesGenerator("names.csv");
  //    var names = nameGen.getLines();
  //
  //    var gen = new RandomCharacterGenerator(names);
  //    List<Character> party = new ArrayList<>();
  //    gen.addRandomCharacterToParty(party);
  //    gen.addRandomCharacterToParty(party);
  //    gen.addRandomCharacterToParty(party);
  //    gen.addRandomCharacterToParty(party);
  //    System.out.println(getString(party));
  //  }
}
