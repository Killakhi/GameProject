package Engine.Navigation;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Screens.PlayLevelScreen;

public abstract class ScrollableMenuScreen<T> extends Screen {
    protected int keyPressTimer = 0;
    public static KeyLocker keyLocker = PlayLevelScreen.keyLocker;
    protected ScrollableMenu<T> menu;

    public ScrollableMenuScreen() {
        this.menu = this.createScrollableMenu();
    }

    protected abstract ScrollableMenu<T> createScrollableMenu();

    @Override
    public void initialize() {
        // pass
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (keyPressTimer <= 0) {
            if (Keyboard.isKeyDown(Key.DOWN)) {
                keyPressTimer = 14;
                this.menu.navigateDown();
            } else if (Keyboard.isKeyDown(Key.UP)) {
                keyPressTimer = 14;
                this.menu.navigateUp();
            }
        } else {
            keyPressTimer--;
        }

        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            keyLocker.lockKey(Key.SPACE);

            this.select();
        }
    }

    public abstract void select();

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, 5000, 5000, Color.GRAY);

        this.menu.draw(graphicsHandler, 50, 50);
    }
}
