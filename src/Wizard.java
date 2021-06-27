public class Wizard extends Character {
  private int mana;
  private int intelligence;

  public Wizard(String name, int hp, int mana, int intelligence) {
    super(name, hp);
    this.mana = mana;
    this.intelligence = intelligence;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }
}
