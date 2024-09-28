package io.github.kermut572.brawlers.runnables;

import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.scheduler.BukkitRunnable;

public class RestartServer extends BukkitRunnable {

    private int time = 10;
    private GameManager gameManager;

    public RestartServer(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        if(time == 0){
            gameManager.getPlugin().getServer().spigot().restart();
            cancel();
            return;
        }
        time--;
    }
}
