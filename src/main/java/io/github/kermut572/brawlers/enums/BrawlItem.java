package io.github.kermut572.brawlers.enums;

public enum BrawlItem {
    DAMAGE, ARMOR, HEAL;

    public static BrawlItem getBrawlItem(String name){
        for(BrawlItem item : values()){
            if(item.name().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }
}
