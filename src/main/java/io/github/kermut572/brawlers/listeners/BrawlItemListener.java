package io.github.kermut572.brawlers.listeners;

import io.github.kermut572.brawlers.managers.GameManager;
import io.github.kermut572.brawlers.runnables.ItemEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class BrawlItemListener implements Listener {

    private final GameManager gameManager;

    public BrawlItemListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e){
        if(!gameManager.getBrawlItemManager().isBrawlerItem(e.getItem().getItemStack()) || !(e.getEntity() instanceof Player p)){
            return;
        }


        ItemEffect effect = new ItemEffect(gameManager, p, gameManager.getBrawlItemManager().getBrawlerItem(e.getItem().getItemStack()), 10);
        effect.runTaskTimer(gameManager.getPlugin(), 0, 20);

        e.setCancelled(true);
        e.getItem().remove();
    }


}
