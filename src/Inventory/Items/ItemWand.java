package Inventory.Items;

import Engine.Battle.FriendlyStats;
import Inventory.InventoryItem;

public class ItemWand extends InventoryItem {
    public ItemWand() {
        super("Wand", "Wand.png");
    }

    @Override
    public void modifyStats(FriendlyStats stats) {
        stats.magicStat += 20;
        stats.currentMagic += 20;
    }
}
