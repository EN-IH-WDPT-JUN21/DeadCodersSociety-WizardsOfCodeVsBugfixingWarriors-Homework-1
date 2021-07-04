import java.util.List;
import java.util.Random;

public class Battle {

  private final List<String> battleCries;

  public Battle(List<String> battleCries) {
    this.battleCries = battleCries;
  }

  public void duel(Character a, Character b) {
    while (a.isAlive() && b.isAlive()) round(a, b);
    if (!a.isAlive())
      System.out.println(
          ConsoleColors.BLUE_BOLD
              + a.getName()
              + ConsoleColors.RESET
              + " "
              + ConsoleColors.RED_BACKGROUND_BRIGHT
              + "died!"
              + ConsoleColors.RESET);
    if (!b.isAlive())
      System.out.println(
          ConsoleColors.GREEN_BOLD
              + b.getName()
              + ConsoleColors.RESET
              + " "
              + ConsoleColors.RED_BACKGROUND_BRIGHT
              + "died!"
              + ConsoleColors.RESET);
  }

  private void round(Character a, Character b) {
    Attacker aa = (Attacker) a;
    Attacker bb = (Attacker) b;

    var dmgB = aa.attack();
    var dmgA = bb.attack();
    a.setHp(a.getHp() - dmgA);
    b.setHp(b.getHp() - dmgB);

    System.out.println(
        ConsoleColors.BLUE_BOLD
            + a.getName()
            + ConsoleColors.RESET
            + ": "
            + ConsoleColors.BLUE
            + getRandomBattleCry()
            + ConsoleColors.RESET);
    System.out.println(
        ConsoleColors.GREEN_BOLD
            + b.getName()
            + ConsoleColors.RESET
            + ": "
            + ConsoleColors.GREEN
            + getRandomBattleCry()
            + ConsoleColors.RESET);

    System.out.println(
        ConsoleColors.BLUE_BOLD
            + a.getName()
            + ConsoleColors.RESET
            + " hits "
            + ConsoleColors.GREEN_BOLD
            + b.getName()
            + ConsoleColors.RESET
            + " for "
            + ConsoleColors.RED_BOLD
            + dmgB
            + ConsoleColors.RESET
            + "!");
    System.out.println(
        ConsoleColors.GREEN_BOLD
            + b.getName()
            + ConsoleColors.RESET
            + " hits "
            + ConsoleColors.BLUE_BOLD
            + a.getName()
            + ConsoleColors.RESET
            + " for "
            + ConsoleColors.RED_BOLD
            + dmgA
            + ConsoleColors.RESET
            + "!");
  }

  private String getRandomBattleCry() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(battleCries.size());
    String battleCry = battleCries.get(randomIndex);
    return battleCry;
  }

  public static void main(String[] args) {
    var nameGen = new LinesGenerator("names.csv");
    var names = nameGen.getLines();

    var gen = new RandomCharacterGenerator(names);
    var a = gen.getRandomCharacter();
    var b = gen.getRandomCharacter();
    System.out.println(a);
    System.out.println(b);

    var battleCries = new LinesGenerator("battle_cries.csv").getLines();
    var battle = new Battle(battleCries);
    battle.duel(a, b);

    System.out.println(a);
    System.out.println(b);
  }
}
