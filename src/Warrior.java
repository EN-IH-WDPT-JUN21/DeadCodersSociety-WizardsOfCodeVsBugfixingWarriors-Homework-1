public class Warrior extends Character implements Attacker {
  private int stamina;
  private int strength;

  public Warrior(String name, int hp, int stamina, int strength) {
    super(name, hp);
    setStamina(stamina);
    setStrength(strength);
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
        + getName()
        + ","
        + getHp()
        + ","
        + stamina
        + ","
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

  @Override
  public Damage attack() {
    if (stamina >= 5) {
      stamina -= 5;
      return new Damage(strength, DamageType.HEAVY_ATTACK);
    } else {
      stamina += 1;
      return new Damage(strength / 2, DamageType.WEAK_ATTACK);
    }
  }
}
