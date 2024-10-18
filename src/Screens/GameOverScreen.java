package Screens;

import Engine.*;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class GameOverScreen extends Screen {
    protected SpriteFont winMessage;
    protected SpriteFont instructions;
    protected KeyLocker keyLocker = new KeyLocker();
    protected BattleScreen battleScreen;

    public GameOverScreen(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
        initialize();
    }

    @Override
    public void initialize() {
        winMessage = new SpriteFont("Game Over!", 350, 239, "Arial", 30, Color.red);
        instructions = new SpriteFont("Press Space to go back to the main menu", 120, 279,"Arial", 20, Color.white);
        keyLocker.lockKey(Key.SPACE);
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
            battleScreen.goBackToMenu();
        } 
       /*  
        else if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            battleScreen.goBackToMenu();
        }
        */
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        winMessage.draw(graphicsHandler);
        instructions.draw(graphicsHandler);
    }
}
