package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.BrawlPlayer;
import io.github.kermut572.brawlers.enums.GameState;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

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
        if(player.getLives() <= 0){
            players.remove(player.getPlayer().getDisplayName());
            player.getPlayer().setGameMode(GameMode.SPECTATOR);

            if(players.size() == 1){
                gameManager.setGameState(GameState.RESTARTING);
            }

        }

        Player p = player.getPlayer();
        p.setFireTicks(0);

        int randInt = ThreadLocalRandom.current().nextInt(0, 4);
        switch (randInt){
            case 0:
                p.teleport(gameManager.getArena().getSpawn1());
                break;
            case 1:
                p.teleport(gameManager.getArena().getSpawn2());
                break;
            case 2:
                p.teleport(gameManager.getArena().getSpawn3());
                break;
            case 3:
                p.teleport(gameManager.getArena().getSpawn4());
                break;
            default:
                break;
        }
    }

}
