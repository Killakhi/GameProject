package Inventory;

import java.util.ArrayList;

import Engine.GraphicsHandler;
import Engine.Navigation.Drawable;
import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.Selectable;
import GameObject.Money;
import Inventory.Items.ItemSword;
import Inventory.Items.ItemWand;

public class Shop implements Selectable<InventoryItem>, Drawable {
    public ScrollableMenu<InventoryItem> itemNavigator;
    public static Shop INSTANCE = new Shop();

    public Shop() {
        this.itemNavigator = new ScrollableMenu<>(new ArrayList<>());

        this.itemNavigator.items.add(new ItemNavigatorMenuItem(new ItemWand()));
        this.itemNavigator.items.add(new ItemNavigatorMenuItem(new ItemSword()));
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

        if (Money.INSTANCE.tryTake(20)) {
            Inventory.INSTANCE.addItem(selectedItem.getValue());
            this.itemNavigator.items.remove(selectedItem);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler, int x, int y) {
        this.itemNavigator.draw(graphicsHandler, x, y);
    }
}
