package com.mortal_combat_droid_edition.model;

import java.util.Random;

public class UltronDroid extends Droid {
    private static final double PARALYZE_PROBABILITY = 0.2;
    private int tempHealth;
    private int tempArmor;
    private boolean isOpponentParalyzed;
    private int paralyzationCounter;
    private int movesCounter;

    public UltronDroid() {
        super(1000, 70, 800);
        isOpponentParalyzed = false;
        paralyzationCounter = 0;
        movesCounter = 0;
    }

    @Override
    public void attack(Droid droid) {
        droid.defense(70);
        this.setHistory(" made " + this.getDamage() + " damage!\n");
    }

    @Override
    public void defense(int damage) {
        if (isOpponentParalyzed && movesCounter < 3) {
            System.out.println("Opponent is paralyzed, no damage)");
            movesCounter++;
            return;
        }
        if (getArmor() == 0) {
            this.setHealth(this.getHealth() - damage);
        } else {
            this.setArmor(this.getArmor() - damage);
        }
        this.setHistory(" received " + damage + " damage!\n");
    }

    private void paralyze() {
        if (paralyzationCounter > 1)
        {
            this.setHistory("Cannot be paralyzed more than once per battle!");
            isOpponentParalyzed = false;
            return;
        }
        double chance = new Random().nextDouble();
        if (paralyzationCounter == 0)
            isOpponentParalyzed = (chance <= PARALYZE_PROBABILITY);
        if (isOpponentParalyzed) {
            paralyzationCounter++;
            this.setHistory("Opponent has been paralyzed for 3 moves");
        }
        else {
            this.setHistory("Opponent is lucky! Not paralyzed!");
        }
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
                paralyze();
                break;
            default:
                beginRound(b,droid);
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
        String hasBeenUsed = (paralyzationCounter == 0) ? "true" : "false";
        return super.toString()
                + "\n'Paralyze'"
                + "\n    Paralyzation probability: " + PARALYZE_PROBABILITY
                + "\n    Has been used: " + hasBeenUsed
                + "\n    Description: can try to paralyze opponent for 3 moves (1 time per battle)"
                + "\n";

    }


}
