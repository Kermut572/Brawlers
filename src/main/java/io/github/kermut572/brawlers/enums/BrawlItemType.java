package io.github.kermut572.brawlers.enums;

public enum BrawlItemType {
    DAMAGE, ARMOR, HEAL;

    public static BrawlItemType getBrawlItem(String name){
        for(BrawlItemType item : values()){
            if(item.name().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }
}
