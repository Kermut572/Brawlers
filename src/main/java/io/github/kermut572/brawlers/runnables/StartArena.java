package io.github.kermut572.brawlers.runnables;

import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartArena extends BukkitRunnable {

    private int time;
    private final GameManager gameManager;

    public StartArena(GameManager gameManager){
        this.gameManager = gameManager;
        this.time = gameManager.getArena().getLobbyTime();
    }

    @Override
    public void run() {

        if (time == 30 || time == 15 || time == 10 || time == 5 || time == 4 || time == 3 || time == 2 || time == 1) {
            for(Player p : Bukkit.getServer().getOnlinePlayers()){
                p.sendTitle(ChatColor.GREEN + "Game will start in", ChatColor.GRAY + String.valueOf(time) + "s", 10, 70, 20);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            }
        }

        if(gameManager.getPlayerManager().getPlayers().size() < gameManager.getArena().getMinPlayers()){
            for(Player p : Bukkit.getServer().getOnlinePlayers()){
                p.sendMessage(ChatColor.RED + "Not enough players to start the game!");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            }

            gameManager.setGameState(GameState.LOBBY);
            cancel();
            return;
        }

        if(time == 0){
            gameManager.setGameState(GameState.INGAME);
            int i = 0;
            for(Player p : Bukkit.getServer().getOnlinePlayers()){
                p.sendTitle(ChatColor.GOLD + "Game has started!", ChatColor.GRAY + "Good luck!", 10, 70, 20);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                p.teleport(gameManager.getArena().getSpawns().get(i));
                i++;
            }
            cancel();
            return;
        }
        time--;
    }
}
