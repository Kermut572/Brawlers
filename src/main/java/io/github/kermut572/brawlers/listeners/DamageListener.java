package io.github.kermut572.brawlers.listeners;

import io.github.kermut572.brawlers.BrawlPlayer;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener{

    private final GameManager gameManager;

    public DamageListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        if(gameManager.getGameState() != GameState.INGAME){
            e.setCancelled(true);
            return;
        }

        if(e.getEntity() instanceof Player damaged && e.getDamager() instanceof Player attacker){
            e.setDamage(0);

            BrawlPlayer damagedPlayer = gameManager.getPlayerManager().getPlayer(damaged.getDisplayName());
            BrawlPlayer attackerPlayer = gameManager.getPlayerManager().getPlayer(attacker.getDisplayName());

            attackerPlayer.damageOtherPlayer(damagedPlayer);
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent e){
        if(gameManager.getGameState() != GameState.INGAME){
            e.setCancelled(true);
            return;
        }

        if(e.getEntity() instanceof Player && (e.getCause() == EntityDamageEvent.DamageCause.FALL)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onLavaDamage(EntityDamageEvent e){
        if(gameManager.getGameState() != GameState.INGAME){
            e.setCancelled(true);
            return;
        }

        if(e.getEntity() instanceof Player damaged && (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.VOID)){
            e.setDamage(0);
            e.setCancelled(true);

            if(((Player) e.getEntity()).getGameMode() != GameMode.ADVENTURE){
                return;
            }

            BrawlPlayer damagedPlayer = gameManager.getPlayerManager().getPlayer(damaged.getDisplayName());
            gameManager.getPlayerManager().killPlayer(damagedPlayer);
        }
    }


}
