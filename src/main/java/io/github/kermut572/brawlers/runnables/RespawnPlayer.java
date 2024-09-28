package io.github.kermut572.brawlers.runnables;

import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

public class RespawnPlayer extends BukkitRunnable {

    private int time = 10;
    private final GameManager gameManager;
    private final Player p;

    public RespawnPlayer(GameManager gameManager, Player p){
        this.gameManager = gameManager;
        this.p = p;
    }

    @Override
    public void run() {
        p.sendTitle(ChatColor.RED + "You are dead", ChatColor.GRAY + "Respawning in " + time + "s", 10, 70, 20);
        if(time == 0){
            p.setGameMode(GameMode.ADVENTURE);
            int randInt = ThreadLocalRandom.current().nextInt(0, 4);
            p.sendTitle(ChatColor.GREEN + "You have respawned", "", 10, 20, 20);
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
            cancel();
            return;
        }
        time--;
    }
}
