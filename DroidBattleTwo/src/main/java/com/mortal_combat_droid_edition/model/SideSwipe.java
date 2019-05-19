package com.mortal_combat_droid_edition.model;


public class SideSwipe extends Droid {
    private static final int ROCKET_DAMAGE = 500;
    private static final int IMMORTALITY = 1000000;
    private int tempHealth;
    private int tempArmor;
    private int rocketCoolDown = 0;
    private int immortalCoolDown = 0;


    public SideSwipe() {
        super(500, 50, 1000);
    }

    @Override
    public void attack(Droid droid) {
        droid.defense(50);
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void defense(int damage) {
        if (getArmor() == 0) {
            this.setHealth(this.getHealth() - damage);
        } else {
            this.setArmor(this.getArmor() - damage);
        }
        if (immortalCoolDown != 10)
            this.setHistory(" received " + damage + " damage!\n");
    }

    private void rocketLaunch(Droid droid) {
        if (rocketCoolDown == 0) {
            droid.defense(ROCKET_DAMAGE);
            rocketCoolDown = 5;
            this.setHistory(" made rocket launch!!!\n + damage points: " + ROCKET_DAMAGE + "\n");
        } else {
            this.setHistory(" You can't !!!!! "
                    +"\nCoolDown = " + rocketCoolDown + "\n"
                    + "Try to attack again!" + "\n"

            );
        }
    }

    private void getImmortality() {
        if (immortalCoolDown == 0) {
            tempHealth = getHealth();
            tempArmor = getArmor();
            setHealth(IMMORTALITY);
            setArmor(IMMORTALITY);
            immortalCoolDown = 10;
            this.setHistory(" became IMMORTAL!!!\n");
        } else {
            setHistory(getHistory() + (" You can't !!!!! "
                    + "\nCoolDown = " + rocketCoolDown + "\n"
                    + "Try to attack again!" + "\n"
            ));

        }
    }

    @Override
    public void beginRound(int b, Droid droid) {
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
                rocketLaunch(droid);
                break;
            case 3:
                getImmortality();
                break;
            default:
                beginRound(b, droid);
                break;
        }
        checkStatus();
    }

    private void checkStatus() {
        rocketCoolDown = (rocketCoolDown != 0) ? --rocketCoolDown : rocketCoolDown;
        immortalCoolDown = (immortalCoolDown != 0) ? --immortalCoolDown : immortalCoolDown;
    }

    @Override
    public String droidStatus() {
        String health = String.valueOf(getHealth());
        String armor = String.valueOf(getArmor());
        if (getHealth() >= 2000 && getArmor() >= 2000) {
            health = "Immortal";
            armor = "Immortal";
        }
        return "\nHealth - " + health
                + "\nArmor - " + armor
                + "\nDamage - " + this.getDamage();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n'Rocket launch'"
                + "\n    Damage - " + ROCKET_DAMAGE
                + "\n    CoolDown - " + rocketCoolDown + "rounds"
                + "\n    Description: Launch rocket to your enemy"
                + "\n'Immortal'"
                + "\n    Damage - " + "any"
                + "\n    CoolDown - " + immortalCoolDown + "rounds"
                + "\n    Description: Give you super shield at one round"
                + "\n";

    }


}
