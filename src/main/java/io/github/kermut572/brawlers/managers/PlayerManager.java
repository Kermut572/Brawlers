package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.BrawlPlayer;

import java.util.HashMap;

public class PlayerManager {

    private HashMap<String, BrawlPlayer> players;

    public PlayerManager(GameManager gameManager){
        this.players = new HashMap<>();
    }

    public HashMap<String, BrawlPlayer> getPlayers(){
        return players;
    }

    public void addPlayer(BrawlPlayer player){
        players.put(player.getPlayer().getDisplayName(), player);
    }

    public void removePlayer(BrawlPlayer player){
        players.remove(player.getPlayer().getDisplayName());
    }

    public BrawlPlayer getPlayer(String name){
        return players.get(name);
    }

}
