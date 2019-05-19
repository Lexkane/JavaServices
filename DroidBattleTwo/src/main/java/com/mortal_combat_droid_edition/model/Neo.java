package com.mortal_combat_droid_edition.model;


public class Neo extends Droid {
    private static final double REACTION_COEFFICIENT = 0.2;
    private int tempHealth;
    private int tempArmor;
    private double currentReaction;


    public Neo() {
        super(700, 40, 500);
        currentReaction = REACTION_COEFFICIENT;
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void attack(Droid droid) {
        droid.defense(40);
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void defense(int damage) {
        if (getArmor() == 0) {
            this.setHealth(this.getHealth() - damage + (int) (damage * currentReaction));
        } else {
            this.setArmor(this.getArmor() - damage + (int) (damage * currentReaction));
        }
        this.setHistory(" received " + (damage - (int) (damage * currentReaction)) + " damage!\n" +
        "Chosen one avoided " + +(int) (damage * currentReaction) + " damage!\n");
    }

    private void increaseReaction() {
        currentReaction += 0.2;
        if (currentReaction >= 0.5) {
            currentReaction = REACTION_COEFFICIENT;
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
                increaseReaction();
                break;
            default:
                beginRound(b, droid);
                break;
        }
    }


    @Override
    public String droidStatus() {
        String health = String.valueOf(getHealth());
        String armor = String.valueOf(getArmor());
        return "\nHealth - " + health
                + "\nArmor - " + armor
                + "\nDamage - " + this.getDamage();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n'Increase reaction'"
                + "\n    Current reaction: " + currentReaction
                + "\n    Description: increase damage that can be avoided in future"
                + "\n";

    }


}
