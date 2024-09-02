package io.github.kermut572.brawlers.listeners;

import io.github.kermut572.brawlers.BrawlPlayer;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LobbyListener implements Listener {

    private GameManager gameManager;

    public LobbyListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(gameManager.getGameState() != GameState.LOBBY){
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            return;
        }
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        gameManager.getPlayerManager().addPlayer(new BrawlPlayer(e.getPlayer()));

        if(gameManager.getPlayerManager().getPlayers().size() >= gameManager.getArena().getMinPlayers() && gameManager.getGameState() == GameState.LOBBY){
            gameManager.setGameState(GameState.INGAME);
        }
    }

}
