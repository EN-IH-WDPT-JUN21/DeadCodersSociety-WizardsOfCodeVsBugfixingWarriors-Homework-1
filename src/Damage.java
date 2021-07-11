enum DamageType {
  HEAVY_ATTACK,
  WEAK_ATTACK,
  FIREBALL,
  STAFF_HIT
}

public class Damage {
  private final int damage;
  private final DamageType type;

  public Damage(int damage, DamageType type) {
    this.damage = damage;
    this.type = type;
  }

  public int getDamage() {
    return damage;
  }

  public DamageType getType() {
    return type;
  }
}
