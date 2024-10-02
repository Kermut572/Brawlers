package io.github.kermut572.brawlers.runnables;

import io.github.kermut572.brawlers.gameobjects.BrawlerItem;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SpawnItem extends BukkitRunnable {

    private final GameManager gameManager;
    private final ArrayList<BrawlerItem> items;

    public SpawnItem(GameManager gameManager){
        this.gameManager = gameManager;
        this.items = gameManager.getBrawlItemManager().getSpawnedItems();
    }

    @Override
    public void run() {
        if(gameManager.getGameState() != GameState.INGAME){
            cancel();
            return;
        }

        //Logger logger = gameManager.getPlugin().getLogger();
        //logger.log(java.util.logging.Level.INFO, "Spawning item? Current items: " + items.size());
        //logger.log(java.util.logging.Level.INFO, "Max items: " + gameManager.getBrawlItemManager().getMaxItems());
        if(items.size() >= gameManager.getBrawlItemManager().getMaxItems()){
            return;
        }

        int randInt = ThreadLocalRandom.current().nextInt(0, gameManager.getBrawlItemManager().getItems().size());
        BrawlerItem item = (BrawlerItem) gameManager.getBrawlItemManager().getItems().values().toArray()[randInt];

        gameManager.getBrawlItemManager().addSpawnedItem(item);
        gameManager.getBrawlItemManager().spawnItem(item);
    }
}
