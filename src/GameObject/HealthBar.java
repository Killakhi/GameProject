package GameObject;

import java.awt.Color;

import Engine.GraphicsHandler;
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

    public boolean isAlive() {
        return currentHealth > 0;
    }

    /*
     * Reduces the HP by the specified amount
     */
    public void damage(int amount) {
        this.currentHealth -= amount;
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

    public void draw(GraphicsHandler graphicsHandler, int x, int y, int width, int height) {
        if (!this.visible) return;

        float percentageLeft = this.currentHealth * 1.0f / this.maxHealth;

        int aliveWidth = Math.round(percentageLeft * width);

        graphicsHandler.drawFilledRectangle(x, y, width, height, Color.RED);
        graphicsHandler.drawFilledRectangle(x, y, aliveWidth, height, Color.GREEN);
    }
}
