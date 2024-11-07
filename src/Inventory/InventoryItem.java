package Inventory;

import java.awt.image.BufferedImage;

import Engine.ImageLoader;

public class InventoryItem {
    public String name;
    public BufferedImage icon;

    public InventoryItem(String name, String texturePath) {
        this.name = name;
        this.icon = ImageLoader.load(texturePath);
    }
}
