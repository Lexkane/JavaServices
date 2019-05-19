package com.mortal_combat_droid_edition.model;

public abstract class Droid {

    private int health;
    private int damage;
    private int armor;

    private String history;


    public Droid(int health, int damage, int armor) {
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.history = "lol";
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }


    @Override
    public String toString() {
        return  "\nHealth - " + this.getHealth()
                + "\nArmor - " + this.getArmor()
                + "\nDamage - " + this.getDamage()
                + "\n\n    Super powers    \n";
    }


    abstract public void beginRound(int b, Droid droid);

    abstract public void attack(Droid droid);

    abstract public void defense(int damage);

    abstract public String droidStatus();
}
