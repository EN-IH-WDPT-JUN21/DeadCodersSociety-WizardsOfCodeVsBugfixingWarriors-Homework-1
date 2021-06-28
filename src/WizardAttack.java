public class WizardAttack implements Attacker {
    private int damage;
    private int intelligence;
    private int mana;

    public WizardAttack(int intel, int mana) {
        setIntelligence(intel);
        setMana(mana);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public int attack(int intelligence, int mana) {
        if(mana>=5){
            mana-=5;
            return damage = intelligence;
        }else{
            mana+=1;
            return damage=2;
        }

    }


}
