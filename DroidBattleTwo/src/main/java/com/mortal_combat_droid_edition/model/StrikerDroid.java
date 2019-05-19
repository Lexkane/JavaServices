package com.mortal_combat_droid_edition.model;




public class StrikerDroid extends Droid {

    private static final int STRIKER_DAMAGE = 100;
    private int tempHealth;
    private int tempArmor;
    private int superBladeCoolDown = 0;

    public StrikerDroid() {
        super(400, 100, 800);
    }

    @Override
    public void attack(Droid droid) {
        droid.defense(100);
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void defense(int damage) {
        if (getArmor() == 0) {
            this.setHealth(this.getHealth() - damage);
        } else {
            this.setArmor(this.getArmor() - damage);
        }
        this.setHistory(" received " + damage + " damage!\n");
    }

    @Override
    public void beginRound(int b,Droid droid) {
        if (tempHealth != 0 && tempArmor != 0) {
            setHealth(tempHealth);
            setArmor(tempArmor);
            tempHealth = 0;
            tempArmor = 0;
        }
        switch (b) {
            case 1:
                attack(droid);
                break;
            case 2:
                superBlade(droid);
                break;
            default:
                beginRound(b,droid);
                break;
        }
        checkStatus();
    }

    @Override
    public String droidStatus() {
        String health = String.valueOf(getHealth());
        String armor = String.valueOf(getArmor());
        return  "\nHealth - " + health
                + "\nArmor - " + armor
                + "\nDamage - " + this.getDamage();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n'Super Blade'"
                + "\n    Damage - " + STRIKER_DAMAGE
                + "\n    CoolDown - " + superBladeCoolDown + "rounds"
                + "\n    Description: Use Super Blade to your enemy"
                + "\n";

    }

    private void superBlade(Droid droid) {
        if (superBladeCoolDown == 0) {
            droid.defense(STRIKER_DAMAGE);
            superBladeCoolDown = 5;
            this.setHistory(" made superblade attack!!!\n + damage points: " + STRIKER_DAMAGE + "\n");
        } else {
            this.setHistory(" You can't !!!!! "
                    +"\nCoolDown = " + superBladeCoolDown + "\n"
                    + "Try to attack again!" + "\n"
            );
        }
    }

    private void checkStatus() {
        superBladeCoolDown = (superBladeCoolDown != 0) ? --superBladeCoolDown : superBladeCoolDown;
    }


}
