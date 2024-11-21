package Inventory;

import java.awt.image.BufferedImage;

import Engine.ImageLoader;
import Engine.Battle.FriendlyStats;

public class InventoryItem {
    public String name;
    public BufferedImage icon;

    public InventoryItem(String name, String texturePath) {
        this.name = name;
        this.icon = ImageLoader.load(texturePath);
    }

    public void modifyStats(FriendlyStats stats) {
        // pass
    }
}
