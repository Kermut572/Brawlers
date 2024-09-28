package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.BrawlerItem;
import io.github.kermut572.brawlers.enums.BrawlItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class BrawlItemManager {

    private GameManager gameManager;
    private final Map<ItemStack, BrawlerItem> items;
    private final ArrayList<BrawlerItem> spawnedItems = new ArrayList<>();
    private final int maxItems = 5;

    public BrawlItemManager(GameManager gameManager){
        this.gameManager = gameManager;
        this.items = new HashMap<>();
    }

    public void addItem(BrawlerItem brawlItem){
        items.put(brawlItem.getItem(), brawlItem);
    }

    public void removeItem(ItemStack item){
        items.remove(item);
    }

    public void addSpawnedItem(BrawlerItem item){
        spawnedItems.add(item);
    }

    public void removeSpawnedItem(BrawlerItem item){
        spawnedItems.remove(item);
    }

    public boolean isSpawnedItem(BrawlerItem item){
        return spawnedItems.contains(item);
    }

    public ArrayList<BrawlerItem> getSpawnedItems(){
        return spawnedItems;
    }

    public boolean isBrawlerItem(ItemStack item){
        return items.containsKey(item);
    }

    public BrawlerItem getBrawlerItem(ItemStack item){
        return items.get(item);
    }

    public Map getItems(){
        return items;
    }

    public void parseItemConfig(){
        // Parse the item config and add the items to the items map
        Logger.getLogger("Minecraft").info("===================== Parsing item config ======================");
        for(int item = 0; item < gameManager.getPlugin().getItemConfig().getConfigurationSection("items").getKeys(false).size(); item++){
            Logger.getLogger("Minecraft").info("Parsing item: " + item);
            Logger.getLogger("Minecraft").info("Item type: " + gameManager.getPlugin().getItemConfig().getString("items." + item + ".item_type"));
            @SuppressWarnings("ConstantConditions")
            ItemStack itemStack = new ItemStack(Material.getMaterial(gameManager.getPlugin().getItemConfig().getString("items." + item + ".item_type").toUpperCase()));
            BrawlerItem brawlItem = new BrawlerItem(itemStack,
                    BrawlItem.getBrawlItem(gameManager.getPlugin().getItemConfig().getString("items." + item + ".effect")),
                    gameManager.getPlugin().getItemConfig().getInt("items." + item + ".amount"));

            addItem(brawlItem);
        }
        Logger.getLogger("Minecraft").info("================= Finished parsing item config =================");
    }

    public int getMaxItems() {
        return maxItems;
    }

    Location randomLocation(Location min, Location max)
    {
        Location range = new Location(min.getWorld(), Math.abs(max.getX() - min.getX()), min.getY(), Math.abs(max.getZ() - min.getZ()));
        return new Location(min.getWorld(), (Math.random() * range.getX()) + (Math.min(min.getX(), max.getX())), range.getY(), (Math.random() * range.getZ()) + (min.getZ() <= max.getZ() ? min.getZ() : max.getZ()));
    }

    public void spawnItem(BrawlerItem item) {
        // Spawn the item in a random location between the four spawn points
        Location spawn1 = gameManager.getPlugin().getArena().getSpawn1();
        Location spawn2 = gameManager.getPlugin().getArena().getSpawn2();
        Location spawn3 = gameManager.getPlugin().getArena().getSpawn3();
        Location spawn4 = gameManager.getPlugin().getArena().getSpawn4();

        Location randomLocation1 = randomLocation(spawn1, spawn2);
        Location randomLocation2 = randomLocation(spawn3, spawn4);

        Location randomLocation = randomLocation(randomLocation1, randomLocation2);

        randomLocation.getWorld().dropItem(randomLocation, item.getItem());

    }
}
