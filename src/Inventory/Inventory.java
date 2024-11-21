package Inventory;

import java.util.ArrayList;

import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;

public class Inventory extends ScrollableMenuScreen<InventoryItem> {
    public InventoryItem equipped = null;
    public static Inventory INSTANCE = new Inventory();

    @Override
    protected ScrollableMenu<InventoryItem> createScrollableMenu() {
        ScrollableMenu<InventoryItem> menu = new ScrollableMenu<>(new ArrayList<>());

        menu.items.add(new MenuItem<InventoryItem>() {

            @Override
            public String getDisplayName() {
                return "Unequip current item";
            }

            @Override
            public InventoryItem getValue() {
                return null;
            }
        });

        return menu;
    }

    @Override
    public void select() {
        MenuItem<InventoryItem> selectedItem = this.menu.getSelected();

        if (selectedItem == null) {
            return;
        }

        InventoryItem unequipped = this.equipped;
        InventoryItem toEquip = selectedItem.getValue();

        this.equipped = toEquip;
        
        if (toEquip != null) {
            // this isn't the fake "unequip" item
            this.menu.items.remove(selectedItem);
        }

        if (unequipped != null) {
            // let them re-equip it later
            this.menu.items.add(new ItemNavigatorMenuItem(unequipped));
        }
    }

    public void addItem(InventoryItem inventoryItem) {
        this.menu.items.add(new ItemNavigatorMenuItem(inventoryItem));
    }
}
