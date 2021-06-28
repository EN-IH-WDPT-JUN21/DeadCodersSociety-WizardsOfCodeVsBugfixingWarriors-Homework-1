public class Warrior extends Character {
  private int stamina;
  private int strength;

  public Warrior(String name, int hp, int stamina, int strength) {
    super(name, hp);
    this.stamina = stamina;
    this.strength = strength;
  }

  @Override
  public String toString() {
    return "Warrior{"
        + "id="
        + getId().toString().substring(1, 8)
        + ", Name="
        + getName()
        + ", hp="
        + getHp()
        + ", stam="
        + stamina
        + ", str="
        + strength
        + '}';
  }

  public String exportCharacter() {
    return "Warrior,"
//            + getId().toString().substring(1, 8)+","
            + getName()+","
            + getHp()+","
            + stamina+","
            + strength;
  }


  public int getStamina() {
    return stamina;
  }

  public void setStamina(int stamina) {
    this.stamina = stamina;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

}
