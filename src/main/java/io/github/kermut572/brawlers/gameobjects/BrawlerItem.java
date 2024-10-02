package io.github.kermut572.brawlers.gameobjects;

import io.github.kermut572.brawlers.enums.BrawlItemType;
import org.bukkit.inventory.ItemStack;

public class BrawlerItem {

    private final ItemStack item;
    private final BrawlItemType brawlItemType;
    private final int amount;

    public BrawlerItem(ItemStack item, BrawlItemType brawlItemType, int amount){
        this.item = item;
        this.brawlItemType = brawlItemType;
        this.amount = amount;
    }

    public ItemStack getItem(){
        return item;
    }

    public BrawlItemType getBrawlItem(){
        return brawlItemType;
    }

    public int getAmount(){
        return amount;
    }

}
