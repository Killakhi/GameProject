package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class PauseMenu extends Screen {
    protected SpriteFont pauseMenuMessage;
    protected SpriteFont resume;
    protected SpriteFont health;
    protected SpriteFont returnMainMenu;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentpauseMenuItemHovered = 0;
    protected int pauseMenuItemSelected = -1;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected PlayLevelScreen playLevelScreen;
    protected ScreenCoordinator screenCoordinator;

    public PauseMenu(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        initialize();

    }

    public void addGameLevel(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }
 
    @Override
    public void initialize() {
        pauseMenuMessage = new SpriteFont("Pause Menu", 90, 110, "Courier Bold Italic", 45, Color.white);
        pauseMenuMessage.setOutlineColor(Color.black);
        pauseMenuMessage.setOutlineThickness(3);
        resume = new SpriteFont("Resume", 90, 130,"Courier Bold Italic", 20, Color.white);
        resume.setOutlineColor(Color.black);
        resume.setOutlineThickness(3);
        health = new SpriteFont("Health", 90, 140,"Courier Bold Italic", 20, Color.white);
        health.setOutlineColor(Color.black);
        health.setOutlineThickness(3);
        returnMainMenu = new SpriteFont("Return to Main Menu", 90, 150,"Courier Bold Italic", 20, Color.white);
        returnMainMenu.setOutlineColor(Color.black);
        returnMainMenu.setOutlineThickness(3);
        keyPressTimer = 0;
        pauseMenuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }
 
    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if down or up is pressed, change menu item "hovered" over (white square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentpauseMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentpauseMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentpauseMenuItemHovered > 2) {
            currentpauseMenuItemHovered = 0;
        } else if (currentpauseMenuItemHovered < 0) {
            currentpauseMenuItemHovered = 2;
        }

        // sets location for white square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentpauseMenuItemHovered == 0) {
            resume.setColor(new Color(255, 215, 0));
            health.setColor(new Color(49, 207, 240));
            returnMainMenu.setColor(new Color(49, 207, 240));
            pointerLocationX = 60;
            pointerLocationY = 135;
        } else if (currentpauseMenuItemHovered == 1) {
            resume.setColor(new Color(49, 207, 240));
            health.setColor(new Color(255, 215, 0));
            returnMainMenu.setColor(new Color(255, 215, 0));
            pointerLocationX = 60;
            pointerLocationY = 145;
        } else if (currentpauseMenuItemHovered == 2) {
            resume.setColor(new Color(49, 207, 240));
            health.setColor(new Color(255, 215, 0));
            returnMainMenu.setColor(new Color(255, 215, 0));
            pointerLocationX = 60;
            pointerLocationY = 155;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            pauseMenuItemSelected = currentpauseMenuItemHovered;
            if (pauseMenuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.LEVEL);
            } else if (pauseMenuItemSelected == 1) {
            
            }
        } else if (pauseMenuItemSelected == 2) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }
    
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.gray);
        pauseMenuMessage.draw(graphicsHandler);
        resume.draw(graphicsHandler);
        health.draw(graphicsHandler);
        returnMainMenu.draw(graphicsHandler);
    }
}

