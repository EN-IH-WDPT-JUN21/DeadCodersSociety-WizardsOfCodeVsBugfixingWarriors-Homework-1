public class Wizard extends Character implements Attacker {
  private int mana;
  private int intelligence;

  public Wizard(String name, int hp, int mana, int intelligence) {
    super(name, hp);
    this.mana = mana;
    this.intelligence = intelligence;
  }

  @Override
  public String toString() {
    return "Wizard{"
        + "id="
        + getId().toString().substring(1, 8)
        + ", Name="
        + getName()
        + ", hp="
        + getHp()
        + ", mana="
        + mana
        + ", int="
        + intelligence
        + '}';
  }

  public String exportCharacter() {
    return "Wizard,"
        //            + getId().toString().substring(1, 8)+","
        + getName()
        + ","
        + getHp()
        + ","
        + mana
        + ","
        + intelligence;
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

  @Override
  public int attack() {
    if (mana >= 5) {
      mana -= 5;
      return intelligence;
    } else {
      mana += 1;
      return 2;
    }
  }
}
