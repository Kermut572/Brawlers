package io.github.kermut572.brawlers;

import io.github.kermut572.brawlers.enums.BrawlItem;
import org.bukkit.inventory.ItemStack;

public class BrawlerItem {

    private final ItemStack item;
    private final BrawlItem brawlItem;
    private int amount;

    public BrawlerItem(ItemStack item, BrawlItem brawlItem, int amount){
        this.item = item;
        this.brawlItem = brawlItem;
        this.amount = amount;
    }

    public ItemStack getItem(){
        return item;
    }

    public BrawlItem getBrawlItem(){
        return brawlItem;
    }

    public int getAmount(){
        return amount;
    }

}
