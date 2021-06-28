public class WarriorAttack implements Attacker {
    private int damage;
    private int strength;
    private int stamina;

    public WarriorAttack(int strength, int stamina) {
        setStrength(strength);
        setStamina(stamina);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int attack(int strength, int stamina) {
        if(stamina>=5){
            stamina-=5;
            return damage = strength;
        }else{
            stamina+=1;
            return damage=strength/2;
        }

    }
}
