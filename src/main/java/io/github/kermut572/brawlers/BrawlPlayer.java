package io.github.kermut572.brawlers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public class BrawlPlayer {

    private final Player player;
    private int attackDamage;
    private int armor;
    private int lives;
    private int damageTaken;
    private int takedowns;

    public BrawlPlayer(Player player){
        this.player = player;
        player.setLevel(0);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setSaturation(20);
        player.setExp(0);
        player.setFireTicks(0);


        this.lives = 3;
        this.damageTaken = 0;
        this.takedowns = 0;
        this.attackDamage = 5;
        this.armor = 0;
    }

    public Player getPlayer(){
        return player;
    }

    public int getLives(){
        return lives;
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public int getDamageTaken(){
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken){
        this.damageTaken = damageTaken;
        player.setLevel(damageTaken);
    }

    public void damageOtherPlayer(BrawlPlayer otherPlayer){
        int damage = this.attackDamage^2/(this.attackDamage + otherPlayer.getArmor());
        otherPlayer.addDamageTaken(damage);

        Player damaged = otherPlayer.getPlayer();

        Vector direction = damaged.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();
        damaged.setVelocity(direction.multiply(otherPlayer.getDamageTaken()/25));
    }

    public void addDamageTaken(int damage){
        this.damageTaken += damage;
        player.setLevel(damageTaken);
    }

    public int getTakedowns(){
        return takedowns;
    }

    public void setTakedowns(int takedowns){
        this.takedowns = takedowns;
    }

    public void addTakedown(){
        this.takedowns++;
    }

    public boolean isAlive(){
        return lives > 0;
    }

    public int getAttackDamage(){
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage){
        this.attackDamage = attackDamage;
    }

    public int getArmor(){
        return armor;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

}
