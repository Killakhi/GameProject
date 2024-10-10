package GameObject;

import java.awt.Color;
import java.awt.Font;

import Engine.GraphicsHandler;
/*
 * This class contains currency logic. There is only one instance of this in the game.
 */
public class Money {
    public static final Money INSTANCE = new Money();

    protected int money = 0;
    protected int visibilityTimer = 0;

    public Money() {

    }

    public int getMoney() {
        return money;
    }

    /*
     * This should be called to show the balance on screen temporarily when it changes
     */
    public void makeVisible() {
        this.visibilityTimer = 60 * 5;
    }

    public void setMoney(int value) {
        this.makeVisible();

        this.money = value;
    }

    /*
     * Give some money to the player. This never fails.
     */
    public void give(int value) {
        this.makeVisible();

        this.money += value;
    }

    /*
     * Take some money away. Returns true if we were able to charge the player, false if they don't have enough.
     */
    public boolean tryTake(int value) {
        this.makeVisible();

        if (this.money < value) {
            return false;
        } else {
            this.money -= value;
            return true;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        if (this.visibilityTimer <= 0) return;

        this.visibilityTimer--;

        graphicsHandler.drawStringWithOutline("$" + String.valueOf(this.money), 30, 30, Font.decode("Monospaced 40"), Color.GREEN, Color.BLACK, 1.0f);
    }
}
