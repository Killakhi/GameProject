package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the win level screen
public class BattleScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont battleDescription;
    protected SpriteFont instructions;
    protected SpriteFont health;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;

    public BattleScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void addGameLevel(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }

    @Override
    public void initialize() {
        battleDescription = new SpriteFont("Welcome to battle!", 150, 239, "Arial", 30, Color.white);
        instructions = new SpriteFont("Press B to go back to the game or Up and down to change health", 120, 279,"Arial", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.UP);
        keyLocker.lockKey(Key.DOWN);
        update();
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.B)) {
            playLevelScreen.stopBattle();
        }
        if (Keyboard.isKeyUp(Key.UP)) {
            keyLocker.unlockKey(Key.UP);
        }
        if (Keyboard.isKeyUp(Key.DOWN)) {
            keyLocker.unlockKey(Key.DOWN);
        }

        // if up or down is pressed, the health goes up or down
        if (Keyboard.isKeyDown(Key.UP) && !keyLocker.isKeyLocked(Key.UP)) {
            //Code for the health system
        } else if (Keyboard.isKeyDown(Key.UP) && !keyLocker.isKeyLocked(Key.UP)) {
            //Code for the health system
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        battleDescription.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
