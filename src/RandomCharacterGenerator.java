import java.util.List;
import java.util.Random;

public class RandomCharacterGenerator {
  private final List<String> names;
  /*
  Gets list of names from f.e. names.csv using LinesGenerator
   */
  public RandomCharacterGenerator(List<String> names) {
    this.names = names;
  }

  /*
  name: based on an array of names, pick a random position
  hp: random between 100-200 to warriors, 50-100 for wizards)
  mana: random between 10-50
  intelligence: random between 1-50
   */
  public Wizard getRandomWizard() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(names.size());
    String name = names.get(randomIndex);
    // rand.nextInt(51) returns value between 0 and 50(including)
    int hp = rand.nextInt(51) + 50;
    int mana = rand.nextInt(41) + 10;
    int intelligence = rand.nextInt(50) + 1;
    return new Wizard(name, hp, mana, intelligence);
  }

  /*
  name: based on an array of names, pick a random position
  hp: random between 100-200 to warriors, 50-100 for wizards)
  stamina: random between 10-50
  strength: random between 1-10
   */
  public Warrior getRandomWarrior() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(names.size());
    String name = names.get(randomIndex);
    int hp = rand.nextInt(101) + 100;
    int stamina = rand.nextInt(41) + 10;
    int strength = rand.nextInt(10) + 1;
    return new Warrior(name, hp, stamina, strength);
  }

  /*
  returns random character of random class
   */
  public Character getRandomCharacter() {
    Random rand = new Random();
    int n = rand.nextInt(2);
    if (n == 0) {
      return getRandomWizard();
    } else {
      return getRandomWarrior();
    }
  }

  /*
  add random character to an existing party
  and if name is already in the party add Jr at the end.
   */
  public void addRandomCharacterToParty(List<Character> party) {
    Character newGuy = getRandomCharacter();
    for (Character ch : party) {
      String name = ch.getName();
      if (name.equals(newGuy.getName())) {
        newGuy.setName(ch.getName() + " Jr");
        break;
      }
    }
    party.add(newGuy);
  }

  /*
  public static void main(String[] args) {
    var nameGen = new NameListGenerator("names.csv");
    var names = nameGen.getNames();

    var gen = new RandomCharacterGenerator(names);
    var wiz1 = gen.getRandomWizard();
    var war1 = gen.getRandomWarrior();
    System.out.println(wiz1);
    System.out.println(gen.getRandomWizard());
    System.out.println(war1);
    System.out.println(gen.getRandomCharacter());
    System.out.println(gen.getRandomCharacter());
    List<Character> party = new ArrayList<>();
    gen.addRandomCharacterToParty(party);
    gen.addRandomCharacterToParty(party);
    gen.addRandomCharacterToParty(party);
    gen.addRandomCharacterToParty(party);
    System.out.println(party);
  }
  // */

}
