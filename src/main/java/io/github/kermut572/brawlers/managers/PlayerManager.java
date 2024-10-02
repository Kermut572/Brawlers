package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.gameobjects.BrawlPlayer;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.runnables.RespawnPlayer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerManager {

    private HashMap<String, BrawlPlayer> players;
    private GameManager gameManager;

    public PlayerManager(GameManager gameManager){
        this.gameManager = gameManager;
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

    public void killPlayer(BrawlPlayer player){
        player.setLives(player.getLives() - 1);
        player.setDamageTaken(0);
        player.getPlayer().setGameMode(GameMode.SPECTATOR);
        if(player.getLives() <= 0){
            players.remove(player.getPlayer().getDisplayName());
            if(players.size() == 1){
                gameManager.setGameState(GameState.RESTARTING);
            }
            return;
        }

        Player p = player.getPlayer();
        p.setFireTicks(0);
        RespawnPlayer respawnPlayer = new RespawnPlayer(gameManager, p);
        respawnPlayer.runTaskTimer(gameManager.getPlugin(), 0, 20);


    }

    public void healPlayer(BrawlPlayer p, int amount) {
        p.setDamageTaken(Math.clamp(p.getDamageTaken() - amount, 0, Integer.MAX_VALUE));
    }
}
