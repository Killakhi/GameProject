package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class GameOverScreen extends Screen {
    protected SpriteFont gameOverMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected PlayLevelScreen playLevelScreen;
    protected ScreenCoordinator screenCoordinator;

    public GameOverScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();

    }

    public void addGameLevel(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }

    @Override
    public void initialize() {
        gameOverMessage = new SpriteFont("Game Over!", 320, 239, "Arial", 30, Color.red);
        instructions = new SpriteFont("Press Space to go back to the main menu", 215, 279,"Arial", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
        System.out.println("It got here?");
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (Keyboard.isKeyUp(Key.ESC)) {
            keyLocker.unlockKey(Key.ESC);
        }

        // if space is pressed, reset level. if escape is pressed, go back to main menu
        if (Keyboard.isKeyDown(Key.SPACE) && !keyLocker.isKeyLocked(Key.SPACE)) {
            playLevelScreen.goBackToMenu();
        } 
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        gameOverMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
