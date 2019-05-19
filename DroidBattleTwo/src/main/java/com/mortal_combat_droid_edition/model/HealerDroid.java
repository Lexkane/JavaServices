package com.mortal_combat_droid_edition.model;

import java.util.Random;
import java.util.Scanner;


public class HealerDroid extends Droid {

    private static final int HEALTH_HEAL = 20;
    private static final double CRIT_HEAL_PROBABILITY = 0.8;
    private static final double BLOCK_PROBABILITY = 0.2;
    private boolean state;
    private Random random;

    public HealerDroid() {
        super(1000, 50, 40);
        random = new Random();
    }

    @Override
    public void attack(Droid droid) {
        droid.defense(getDamage());
        this.setHistory(" made " + this.getDamage() + " damage!\n");
        heal();
    }

    @Override
    public void defense(int damage) {
        if (!state) {
            if (getArmor() - damage < 0) {
                setHealth(getHealth() + getArmor() - damage);
                setArmor(0);
            } else {
                setArmor(getArmor() - damage);
            }
        }
        heal();
        state = false;
        this.setHistory(" received " + damage + " damage!\n"
        + "but healed a little\n");
    }

    @Override
    public void beginRound(int b, Droid droid) {
        switch (b) {
            case 1:
                attack(droid);
                break;
            case 2:
                blockAttack();
                break;
            default:
                beginRound(b,droid);
                break;
        }
    }

    @Override
    public String droidStatus() {
        return  "\nHealth - " + getHealth()
                + "\nArmor - " + getArmor()
                + "\nDamage - " + getDamage()
                + "\nBlock attack - " + state;
    }


    private void blockAttack() {
        double chance = random.nextDouble();
        state = chance > BLOCK_PROBABILITY;
        heal();
    }

    //heal droid after attack and defense methods
    private void heal() {
        double chance = random.nextDouble();
        if (chance < CRIT_HEAL_PROBABILITY) {
            setHealth(getHealth() + HEALTH_HEAL);
        } else {
            setHealth(getHealth() + 2 * HEALTH_HEAL);
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n'Active super power - Block attack'"
                + "\n    Block chance - " + (100 - BLOCK_PROBABILITY * 100)
                + "\n    Description: Block enemy enemy attack"
                + "\n'Passive super power - Heal droid'"
                + "\n    Health heal - " + HEALTH_HEAL
                + "\n    Double health heal chance - "
                + (100 - CRIT_HEAL_PROBABILITY * 100)
                + "\n    Description: Heal your droid"
                + "\n";

    }

}