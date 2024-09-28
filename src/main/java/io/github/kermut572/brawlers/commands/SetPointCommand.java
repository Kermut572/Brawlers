package io.github.kermut572.brawlers.commands;

import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPointCommand implements CommandExecutor {

    private final GameManager gameManager;

    public SetPointCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        if(!p.hasPermission("brawlers.setpoint")){
            p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
        }

        if(args.length != 1){
            p.sendMessage(ChatColor.RED + "Usage: /setpoint <lobby/1-4>");
            return true;
        }

        switch(args[0]){
            case "lobby":
                gameManager.getArena().setLobby(p.getLocation());
                p.sendMessage(ChatColor.GREEN + "Lobby point set!");
                break;
            case "1":
                gameManager.getArena().setSpawn1(p.getLocation());
                p.sendMessage(ChatColor.GREEN + "Spawn point 1 set!");
                break;
            case "2":
                gameManager.getArena().setSpawn2(p.getLocation());
                p.sendMessage(ChatColor.GREEN + "Spawn point 2 set!");
                break;
            case "3":
                gameManager.getArena().setSpawn3(p.getLocation());
                p.sendMessage(ChatColor.GREEN + "Spawn point 3 set!");
                break;
            case "4":
                gameManager.getArena().setSpawn4(p.getLocation());
                p.sendMessage(ChatColor.GREEN + "Spawn point 4 set!");
                break;
            default:
                p.sendMessage(ChatColor.RED + "Usage: /setpoint <lobby/1-4>");
                break;
        }

        return true;
    }
}
