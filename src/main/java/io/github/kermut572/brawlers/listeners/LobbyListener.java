package io.github.kermut572.brawlers.listeners;

import io.github.kermut572.brawlers.BrawlPlayer;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.managers.GameManager;
import io.github.kermut572.brawlers.runnables.StartArena;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LobbyListener implements Listener {

    private final GameManager gameManager;

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
            new StartArena(gameManager).runTaskTimer(gameManager.getPlugin(), 0, 20);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(gameManager.getGameState() != GameState.LOBBY){
            return;
        }
        gameManager.getPlayerManager().removePlayer(gameManager.getPlayerManager().getPlayer(e.getPlayer().getDisplayName()));
    }

}
