import java.util.UUID;

abstract class Character {
  private UUID id;
  private String Name;
  private int hp;

  public Character(String name, int hp) {
    this.id = UUID.randomUUID();
    Name = name;
    this.hp = hp;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public boolean isAlive() {
    return hp > 0;
  }


}
