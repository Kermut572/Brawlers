package io.github.kermut572.brawlers;

import org.bukkit.entity.Player;

public class BrawlPlayer {

    private final Player player;
    private int lives;
    private int damageTaken;
    private int takedowns;

    public BrawlPlayer(Player player){
        this.player = player;
        this.lives = 3;
        this.damageTaken = 0;
        this.takedowns = 0;
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
    }

    public void addDamageTaken(int damage){
        this.damageTaken += damage;
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

}
