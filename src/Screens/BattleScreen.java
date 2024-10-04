package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class BattleScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected SpriteFont battleDescription;
    protected SpriteFont magicAttack;
    protected SpriteFont physicalAttack;
    protected SpriteFont instructions;
    protected SpriteFont health;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int keyPressTimer;
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
        physicalAttack = new SpriteFont("Physical Attack                                     " , 90, 500, "Arial", 30, Color.white );
        magicAttack = new SpriteFont("                                       Magic Attack               " , 90, 500, "Arial", 30, Color.white );
        //battleOptions = new SpriteFont("Physical Attack                      Magic Attack               " , 90, 500, "Arial", 30, Color.white );
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
        if(Keyboard.isKeyDown(Key.LEFT)){
            keyLocker.unlockKey(Key.LEFT);
        }
        if(Keyboard.isKeyDown(Key.RIGHT)){
            keyLocker.unlockKey(Key.RIGHT);
        }
        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
            keyPressTimer = 14;
            currentMenuItemHovered--;
        } else {
            if (keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if (currentMenuItemHovered > 1) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 1;
        }

        if (currentMenuItemHovered == 0) {
            physicalAttack.setColor(new Color(255, 215, 0));
        } else if (currentMenuItemHovered == 1) {
            physicalAttack.setColor(new Color(49, 207, 240));
           
        }
        if (currentMenuItemHovered == 0) {
            magicAttack.setColor(new Color(49, 207, 240));
        } else if (currentMenuItemHovered == 1) {
            magicAttack.setColor(new Color(255, 215, 0));
           
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
        physicalAttack.draw(graphicsHandler);
        magicAttack.draw(graphicsHandler);
    }
}
