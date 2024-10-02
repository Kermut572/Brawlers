package io.github.kermut572.brawlers.runnables;

import io.github.kermut572.brawlers.gameobjects.BrawlerItem;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemEffect extends BukkitRunnable {

    private final GameManager gameManager;
    private final Player p;
    private final BrawlerItem item;
    private int time;
    private final int time_old;

    public ItemEffect(GameManager gameManager, Player p, BrawlerItem item, int time){
        this.gameManager = gameManager;
        this.p = p;
        this.item = item;
        this.time = time;
        this.time_old = time;
    }

    @Override
    public void run() {
        if(time == 0){

            switch (item.getBrawlItem()) {
                case DAMAGE:
                    gameManager.getPlayerManager().getPlayer(p.getDisplayName()).setAttackDamage(gameManager.getPlayerManager().getPlayer(p.getDisplayName()).getAttackDamage() - item.getAmount());
                    break;
                case ARMOR:
                    gameManager.getPlayerManager().getPlayer(p.getDisplayName()).setArmor(gameManager.getPlayerManager().getPlayer(p.getDisplayName()).getArmor() - item.getAmount());
                    break;
            }

            gameManager.getBrawlItemManager().removeSpawnedItem(item);

            cancel();
            return;
        }
        if(time == time_old) {
            switch (item.getBrawlItem()) {
                case HEAL:
                    gameManager.getPlayerManager().healPlayer(gameManager.getPlayerManager().getPlayer(p.getDisplayName()), item.getAmount());
                    break;
                case DAMAGE:
                    gameManager.getPlayerManager().getPlayer(p.getDisplayName()).setAttackDamage(gameManager.getPlayerManager().getPlayer(p.getDisplayName()).getAttackDamage() + item.getAmount());
                    break;
                case ARMOR:
                    gameManager.getPlayerManager().getPlayer(p.getDisplayName()).setArmor(gameManager.getPlayerManager().getPlayer(p.getDisplayName()).getArmor() + item.getAmount());
                    break;
            }
        }
        time--;
    }
}
