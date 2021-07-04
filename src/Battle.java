import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Battle {

  private final List<String> battleCries;
  private int roundDelay;

  public Battle(List<String> battleCries, int roundDelay) {
    this.battleCries = battleCries;
    this.roundDelay = roundDelay;
  }

  public void duel(Character a, Character b) {
    while (a.isAlive() && b.isAlive()) {
      try {
        TimeUnit.MILLISECONDS.sleep(roundDelay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      round(a, b);
    }
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

    var dmgA = aa.attack();
    var dmgB = bb.attack();
    a.setHp(a.getHp() - dmgB.getDamage());
    b.setHp(b.getHp() - dmgA.getDamage());

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
            + " with "
            + getDamageTypeText(dmgA)
            + " for "
            + ConsoleColors.RED_BOLD
            + dmgA.getDamage()
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
            + " with "
            + getDamageTypeText(dmgB)
            + " for "
            + ConsoleColors.RED_BOLD
            + dmgB.getDamage()
            + ConsoleColors.RESET
            + "!");
  }

  private String getDamageTypeText(Damage damage) {
    switch (damage.getType()) {
      case HEAVY_ATTACK -> {
        return ConsoleColors.YELLOW_BACKGROUND + "heavy attack" + ConsoleColors.RESET;
      }
      case WEAK_ATTACK -> {
        return ConsoleColors.YELLOW + "weak (very weak) attack" + ConsoleColors.RESET;
      }
      case FIREBALL -> {
        return ConsoleColors.BLUE_BACKGROUND + ConsoleColors.RED_BOLD_BRIGHT + "SWOOOOSH!!!!!!!!!!!! FIREBALLL!!!!" + ConsoleColors.RESET;
      }
      case STAFF_HIT -> {
        return ConsoleColors.BLUE + "staff hit (on the head)" + ConsoleColors.RESET;
      }
      default -> throw new IllegalStateException("Unexpected value: " + damage.getType());
    }
  }

  private String getRandomBattleCry() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(battleCries.size());
    String battleCry = battleCries.get(randomIndex);
    return battleCry;
  }

//  public static void main(String[] args) {
//    var nameGen = new LinesGenerator("names.csv");
//    var names = nameGen.getLines();
//
//    var gen = new RandomCharacterGenerator(names);
//    var a = gen.getRandomCharacter();
//    var b = gen.getRandomCharacter();
//    System.out.println(a);
//    System.out.println(b);
//
//    var battleCries = new LinesGenerator("battle_cries.csv").getLines();
//    var battle = new Battle(battleCries, 300);
//    battle.duel(a, b);
//
//    System.out.println(a);
//    System.out.println(b);
//  }
}
