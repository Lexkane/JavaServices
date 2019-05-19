package com.mortal_combat_droid_edition.model;


import java.util.Random;


public class K2So extends Droid {
    private int accuracy;
    private int firstComboCount;
    private int secondComboCount;
    private int criticalHealth;
    private final static int ONE_HUNDRED = 100;
    private final static int FROM = 50;
    private final static int TO = 100;

    public K2So() {
        super(750, 75, 1000);
        this.accuracy = FROM + new Random().nextInt(TO - FROM + 1);
        this.firstComboCount = 0;
        this.secondComboCount = 0;
        this.criticalHealth = getHealth() / 2;
    }

    public void itDependsOnYourAccuracy(Droid droid) {
        if (this.firstComboCount < 2) {
            if (accuracy >= 75) {
                if (droid.getArmor() == 0) {
                    droid.setHealth(droid.getHealth() - 3 * this.getDamage());
                } else if (droid.getArmor() - 3 * this.getDamage() < 0) {
                    int k = 3 * this.getDamage() - droid.getArmor();
                    droid.setArmor(0);
                    droid.setHealth(droid.getHealth() - k);
                } else {
                    droid.setArmor(droid.getArmor() - 3 * this.getDamage());
                }
                this.firstComboCount++;
            } else {
                if (droid.getArmor() == 0) {
                    droid.setHealth(droid.getHealth() - 2 * this.getDamage());
                } else if (droid.getArmor() - 2 * this.getDamage() < 0) {
                    int k = 2 * this.getDamage() - droid.getArmor();
                    droid.setArmor(0);
                    droid.setHealth(droid.getHealth() - k);
                } else {
                    droid.setArmor(droid.getArmor() - 2 * this.getDamage());
                }
                this.firstComboCount++;
            }
        } else {
            System.out.println("This droid hasn`t already this combo");
            System.out.println("It will be the simple attack.");
            this.attack(droid);
        }
    }

    public void itsYourDead(Droid droid) {
        if (this.secondComboCount < 1) {
            if (this.getHealth() < this.criticalHealth) {
                this.setArmor(300);
                this.setDamage(ONE_HUNDRED);
                secondComboCount++;
            } else {
                System.out.println("Your health is higher than 50%");
                System.out.println("It will be the simple attack.");
                this.attack(droid);
            }
        } else {
            System.out.println("This droid hasn`t already combo");
            System.out.println("It will be the simple attack.");
            this.attack(droid);
        }
    }

    @Override
    public void beginRound(int b, Droid droid) {

        switch (b) {
            case 1:
                attack(droid);
                break;
            case 2:
                itDependsOnYourAccuracy(droid);
                break;
            case 3:
                itsYourDead(droid);
                break;
            default:
                beginRound(b,droid);
                break;
        }
    }

    public String droidStatus() {
        String health = String.valueOf(getHealth());
        String armor = String.valueOf(getArmor());
        return "\nHealth - " + health
                + "\nArmor - " + armor
                + "\nDamage - " + this.getDamage();
    }

    @Override
    public void attack(Droid droid) {
        if (droid.getArmor() == 0) {
            droid.setHealth(droid.getHealth() - this.getDamage());
        } else if (droid.getArmor() - this.getDamage() < 0) {
            int k = this.getDamage() - droid.getArmor();
            droid.setArmor(0);
            droid.setHealth(droid.getHealth() - k);
        } else {
            droid.setArmor(droid.getArmor() - this.getDamage());
        }
        droid.defense(this.getDamage());
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void defense(int damage) {
        if (getArmor() <= 0)
            this.setHealth(getHealth() - new Random().nextInt(damage / 2));
        else
            this.setArmor(getArmor() - new Random().nextInt(damage / 2));
        this.setHistory(" received " + new Random().nextInt(damage / 2) + " damage!\n");
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n'It Depends On Your Accuracy' combo "
                + "\n    Damage -  depends on your droid`s generated accuracy"
                + "\n    Max times to use - 2"
                + "\n    Description: Attack the enemy with higher damage"
                + "\n'It Your Dead' combo"
                + "\n    Damage - depends on droid`s armor"
                + "\n    Max times to use - 1"
                + "\n    Description: If your health is less than 50, "
                + "increase your armor to 300 and increase your damage to 100"
                + "\n";
    }


}
