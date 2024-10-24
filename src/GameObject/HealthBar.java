package GameObject;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
/*
 * This class contains health logic - things that have an HP have one of these attached.
 * Things that don't have health have their HealthBar set to null in their GameObject.
 * 
 * It also contains logic for drawing the health bar.
 */
public class HealthBar {
    protected int currentHealth;
    protected int maxHealth;
    protected boolean visible = false;

    public HealthBar(int currentHealth, int maxHealth) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }

    
    /*
     * Reduces the HP by the specified amount
     */
    public void damage(int amount) {
        //this.currentHealth -= amount;
        this.currentHealth -= Math.min(this.currentHealth, amount); //Makes the health unable to go past 0
        
    }

    /*
     * Increases the HP by the specified amount
     */
    public void heal(int amount) {
        this.currentHealth = Math.min(this.currentHealth + amount, maxHealth);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    protected static SpriteSheet heartSpriteSheet = getHeartSpriteSheet();

    protected static SpriteSheet getHeartSpriteSheet() {
        BufferedImage image = ImageLoader.load("Hearts.png");

        return new SpriteSheet(image, 127, 128);
    }

    protected Color getHealthColor() {
        float scalar = Math.max(0.0f, Math.min(1.0f, this.currentHealth * 1.0f / this.maxHealth));

        float[] lowColor = Color.RED.getRGBColorComponents(null);
        float[] hiColor = Color.GREEN.getRGBColorComponents(null);

        // linearly interpolate the values

        return new Color(
            lowColor[0] + scalar * (hiColor[0] - lowColor[0]),
            lowColor[1] + scalar * (hiColor[1] - lowColor[1]),
            lowColor[2] + scalar * (hiColor[2] - lowColor[2])
        );
    }

    public void draw(GraphicsHandler graphicsHandler, int x, int y) {
        if (!this.visible) return;

        // evenly change the heart depending on which third of the health region we are in

        float ratio = this.currentHealth * 1.0f / this.maxHealth;
        int column;

        if (ratio > 0.67f) {
            column = 0;
        } else if (ratio > 0.33f) {
            column = 1;
        } else if (ratio > 0.00f) {
            column = 2;
        } else {
            column = 3;
        }

        graphicsHandler.drawImage(heartSpriteSheet.getSubImage(0, column), x, y, 80, 80);
        graphicsHandler.drawStringWithOutline(String.valueOf(this.currentHealth), x + 80, y + 50, Font.decode("Monospaced 40"), this.getHealthColor(), Color.BLACK, 1.0f);
    }
}
