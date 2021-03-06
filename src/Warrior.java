public class Warrior extends Character implements Attacker {
  private int stamina;
  private int strength;

  public Warrior(String name, int hp, int stamina, int strength) {
    super(name, hp);
    setStamina(stamina);
    setStrength(strength);
  }
  // For log printer
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
  // For csv file
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

  /*
  Warriors are strong well armored characters that focus on the attribute strength.
  Every round a warrior will try to do a “Heavy attack”.
  The damage of a heavy attack is equals to their strength and every hit will decrease their stamina by 5 points.
  If he can’t make a heavy attack he will do a “Weak attack”.
  The damage of a weak attack is the half of the strength (truncate decimals).
  Every weak attack will recover his stamina by 1.
   */
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
