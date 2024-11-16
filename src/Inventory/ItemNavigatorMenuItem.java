package Inventory;

import Engine.Navigation.MenuItem;

public class ItemNavigatorMenuItem implements MenuItem<InventoryItem> {
    public InventoryItem item;

    public ItemNavigatorMenuItem(InventoryItem item) {
        this.item = item;
    }

    @Override
    public String getDisplayName() {
        return this.getValue().name;
    }

    @Override
    public InventoryItem getValue() {
        return this.item;
    }
}
