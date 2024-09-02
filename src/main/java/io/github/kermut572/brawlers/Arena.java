package io.github.kermut572.brawlers;

import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;
import java.util.Objects;

public class Arena {

    private String name;

    private final int maxPlayers;
    private final int minPlayers;
    private final int time;
    private final int lobbyTime;

    private final Location lobby;
    private final Location spawn_1;
    private final Location spawn_2;
    private final Location spawn_3;
    private final Location spawn_4;

    public Arena(GameManager gameManager){

        this.name = gameManager.getPlugin().getArenaConfig().getString("name");
        this.maxPlayers = gameManager.getPlugin().getArenaConfig().getInt("maxPlayers");
        this.minPlayers = gameManager.getPlugin().getArenaConfig().getInt("minPlayers");
        this.time = gameManager.getPlugin().getArenaConfig().getInt("time");
        this.lobbyTime = gameManager.getPlugin().getArenaConfig().getInt("lobbyTime");
        this.lobby = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("lobby.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("lobby.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("lobby.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("lobby.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("lobby.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("lobby.pitch"));
        this.spawn_1 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("1.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("1.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("1.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("1.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("1.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("1.pitch"));
        this.spawn_2 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("2.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("2.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("2.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("2.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("2.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("2.pitch"));
        this.spawn_3 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("3.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("3.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("3.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("3.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("3.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("3.pitch"));
        this.spawn_4 = new Location(Bukkit.getWorld(Objects.requireNonNull(gameManager.getPlugin().getArenaConfig().getString("4.world"))),
                gameManager.getPlugin().getArenaConfig().getDouble("4.x"),
                gameManager.getPlugin().getArenaConfig().getDouble("4.y"),
                gameManager.getPlugin().getArenaConfig().getDouble("4.z"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("4.yaw"),
                (float) gameManager.getPlugin().getArenaConfig().getDouble("4.pitch"));

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

    public List<Location> getSpawns() {
        return List.of(spawn_1, spawn_2, spawn_3, spawn_4);
    }
}
