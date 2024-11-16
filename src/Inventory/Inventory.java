package Inventory;

import java.util.ArrayList;

import Engine.GraphicsHandler;
import Engine.Navigation.Drawable;
import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.Selectable;

public class Inventory implements Selectable<InventoryItem>, Drawable {
    public InventoryItem equipped = null;
    public ScrollableMenu<InventoryItem> itemNavigator;
    public static Inventory INSTANCE = new Inventory();

    public Inventory() {
        this.itemNavigator = new ScrollableMenu<>(new ArrayList<>());
        this.itemNavigator.items.add(new MenuItem<InventoryItem>() {

            @Override
            public String getDisplayName() {
                return "Unequip current item";
            }

            @Override
            public InventoryItem getValue() {
                return null;
            }
        });
    }

    @Override
    public void navigateUp() {
        itemNavigator.navigateUp();
    }

    @Override
    public void navigateDown() {
        itemNavigator.navigateDown();
    }

    @Override
    public InventoryItem getSelected() {
        return itemNavigator.getSelectedItem();
    }

    @Override
    public void select() {
        MenuItem<InventoryItem> selectedItem = this.itemNavigator.getSelected();

        if (selectedItem == null) {
            return;
        }

        InventoryItem unequipped = this.equipped;
        InventoryItem toEquip = selectedItem.getValue();

        this.equipped = toEquip;
        
        if (toEquip != null) {
            // this isn't the fake "unequip" item
            this.itemNavigator.items.remove(selectedItem);
        }

        if (unequipped != null) {
            // let them re-equip it later
            this.itemNavigator.items.add(new ItemNavigatorMenuItem(unequipped));
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler, int x, int y) {
        this.itemNavigator.draw(graphicsHandler, x, y);
    }

    public void addItem(InventoryItem inventoryItem) {
        this.itemNavigator.items.add(new ItemNavigatorMenuItem(inventoryItem));
    }
}
