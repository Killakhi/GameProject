package Inventory;

import java.util.ArrayList;

import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;
import GameObject.Money;
import Inventory.Items.ItemSword;
import Inventory.Items.ItemWand;

public class Shop extends ScrollableMenuScreen<InventoryItem> {
    public static Shop INSTANCE = new Shop();

    @Override
    protected ScrollableMenu<InventoryItem> createScrollableMenu() {
        ScrollableMenu<InventoryItem> menu = new ScrollableMenu<>(new ArrayList<>());

        menu.items.add(new ItemNavigatorMenuItem(new ItemWand()));
        menu.items.add(new ItemNavigatorMenuItem(new ItemSword()));

        return menu;
    }

    @Override
    public void select() {
        MenuItem<InventoryItem> selectedItem = this.menu.getSelected();

        if (selectedItem == null) {
            return;
        }

        if (Money.INSTANCE.tryTake(20)) {
            Inventory.INSTANCE.addItem(selectedItem.getValue());
            this.menu.items.remove(selectedItem);
        }
    }
}
