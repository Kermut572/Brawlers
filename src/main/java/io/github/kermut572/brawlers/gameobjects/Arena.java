package io.github.kermut572.brawlers.gameobjects;

import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;
import java.util.Objects;

public class Arena {

    private final String name;

    private final GameManager gameManager;

    private final int maxPlayers;
    private final int minPlayers;
    private final int time;
    private final int lobbyTime;

    private Location lobby;
    private Location spawn_1;
    private Location spawn_2;
    private Location spawn_3;
    private Location spawn_4;

    //TODO This whole class is trash, REWORK

    public Arena(GameManager gameManager){

        this.gameManager = gameManager;

        this.name = gameManager.getPlugin().getArenaConfig().getString("name");
        this.maxPlayers = gameManager.getPlugin().getArenaConfig().getInt("max_players");
        this.minPlayers = gameManager.getPlugin().getArenaConfig().getInt("min_players");
        this.time = gameManager.getPlugin().getArenaConfig().getInt("game_time");
        this.lobbyTime = gameManager.getPlugin().getArenaConfig().getInt("lobby_time");
        this.lobby = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("spawns.lobby.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.lobby.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.lobby.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.lobby.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.lobby.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.lobby.pitch"));
        this.spawn_1 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("spawns.1.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.1.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.1.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.1.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.1.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.1.pitch"));
        this.spawn_2 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("spawns.2.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.2.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.2.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.2.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.2.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.2.pitch"));
        this.spawn_3 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("spawns.3.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.3.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.3.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.3.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.3.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.3.pitch"));
        this.spawn_4 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("spawns.4.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.4.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.4.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("spawns.4.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.4.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("spawns.4.pitch"));

    }

    public String getName(){
        return name;
    }

    public int getMaxPlayers(){
        return maxPlayers;
    }

    public int getMinPlayers(){
        return minPlayers;
    }

    public int getTime(){
        return time;
    }

    public int getLobbyTime(){
        return lobbyTime;
    }

    public Location getLobby(){
        return lobby;
    }

    //Rework so it is not as hardcoded
    public Location getSpawn1(){
        return spawn_1;
    }

    public Location getSpawn2(){
        return spawn_2;
    }

    public Location getSpawn3(){
        return spawn_3;
    }

    public Location getSpawn4(){
        return spawn_4;
    }

    public void setLobby(Location lobby){
        this.lobby = lobby;

        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.world", lobby.getWorld().getName());
        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.x", lobby.getX());
        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.y", lobby.getY());
        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.z", lobby.getZ());
        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.yaw", lobby.getYaw());
        gameManager.getPlugin().getArenaConfig().set("spawns.lobby.pitch", lobby.getPitch());
        gameManager.getPlugin().saveArenaConfig();
    }

    public void setSpawn1(Location spawn_1){
        this.spawn_1 = spawn_1;

        gameManager.getPlugin().getArenaConfig().set("spawns.1.world", spawn_1.getWorld().getName());
        gameManager.getPlugin().getArenaConfig().set("spawns.1.x", spawn_1.getX());
        gameManager.getPlugin().getArenaConfig().set("spawns.1.y", spawn_1.getY());
        gameManager.getPlugin().getArenaConfig().set("spawns.1.z", spawn_1.getZ());
        gameManager.getPlugin().getArenaConfig().set("spawns.1.yaw", spawn_1.getYaw());
        gameManager.getPlugin().getArenaConfig().set("spawns.1.pitch", spawn_1.getPitch());
        gameManager.getPlugin().saveArenaConfig();
    }

    public void setSpawn2(Location spawn_2){
        this.spawn_2 = spawn_2;

        gameManager.getPlugin().getArenaConfig().set("spawns.2.world", spawn_2.getWorld().getName());
        gameManager.getPlugin().getArenaConfig().set("spawns.2.x", spawn_2.getX());
        gameManager.getPlugin().getArenaConfig().set("spawns.2.y", spawn_2.getY());
        gameManager.getPlugin().getArenaConfig().set("spawns.2.z", spawn_2.getZ());
        gameManager.getPlugin().getArenaConfig().set("spawns.2.yaw", spawn_2.getYaw());
        gameManager.getPlugin().getArenaConfig().set("spawns.2.pitch", spawn_2.getPitch());
        gameManager.getPlugin().saveArenaConfig();
    }

    public void setSpawn3(Location spawn_3){
        this.spawn_3 = spawn_3;

        gameManager.getPlugin().getArenaConfig().set("spawns.3.world", spawn_3.getWorld().getName());
        gameManager.getPlugin().getArenaConfig().set("spawns.3.x", spawn_3.getX());
        gameManager.getPlugin().getArenaConfig().set("spawns.3.y", spawn_3.getY());
        gameManager.getPlugin().getArenaConfig().set("spawns.3.z", spawn_3.getZ());
        gameManager.getPlugin().getArenaConfig().set("spawns.3.yaw", spawn_3.getYaw());
        gameManager.getPlugin().getArenaConfig().set("spawns.3.pitch", spawn_3.getPitch());
        gameManager.getPlugin().saveArenaConfig();
    }

    public void setSpawn4(Location spawn_4){
        this.spawn_4 = spawn_4;

        gameManager.getPlugin().getArenaConfig().set("spawns.4.world", spawn_4.getWorld().getName());
        gameManager.getPlugin().getArenaConfig().set("spawns.4.x", spawn_4.getX());
        gameManager.getPlugin().getArenaConfig().set("spawns.4.y", spawn_4.getY());
        gameManager.getPlugin().getArenaConfig().set("spawns.4.z", spawn_4.getZ());
        gameManager.getPlugin().getArenaConfig().set("spawns.4.yaw", spawn_4.getYaw());
        gameManager.getPlugin().getArenaConfig().set("spawns.4.pitch", spawn_4.getPitch());
        gameManager.getPlugin().saveArenaConfig();
    }

    public List<Location> getSpawns() {
        return List.of(spawn_1, spawn_2, spawn_3, spawn_4);
    }
}
