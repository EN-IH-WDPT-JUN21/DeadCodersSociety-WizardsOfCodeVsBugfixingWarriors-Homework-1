public class Wizard extends Character implements Attacker {
  private int mana;
  private int intelligence;

  public Wizard(String name, int hp, int mana, int intelligence) {
    super(name, hp);
    setMana(mana);
    setIntelligence(intelligence);
  }
  // For log printer
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
  // For csv file
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

  /*
  Wizards are the masters of the arcane their main attribute is intelligence.
  Every round a wizard will try to cast a “Fireball”.
  The damage of a fireball is equals to his intelligence and every fireball will decrease their mana by 5 points.
  If he can’t cast a fireball he will do a “Staff hit”.
  The damage of a staff hit is equals to 2.
  Every staff hit will recover his mana by 1.
   */
  @Override
  public Damage attack() {
    if (mana >= 5) {
      mana -= 5;
      return new Damage(intelligence, DamageType.FIREBALL);
    } else {
      mana += 1;
      return new Damage(2, DamageType.STAFF_HIT);
    }
  }
}
