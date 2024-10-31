package se.trixzta.adventure.model;

public abstract class Creature {
    private int health;
    private int damage;
    private String name;


    public Creature(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }
    public void takeDamage(int damage) {
        this.health -= damage;
    }
    public void attack (Creature toAttack) {
        toAttack.takeDamage(this.damage);
    }
    public boolean isAlive(){
        return this.health > 0;
    }
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
}
