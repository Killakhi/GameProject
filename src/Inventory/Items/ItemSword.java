package Inventory.Items;

import Engine.Battle.FriendlyStats;
import Inventory.InventoryItem;

public class ItemSword extends InventoryItem {
    public ItemSword() {
        super("Sword", "Sword.png");
    }

    @Override
    public void modifyStats(FriendlyStats stats) {
        stats.attackStat += 20;
    }
}
