package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class BattleScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected SpriteFont magicAttack;
    protected SpriteFont physicalAttack;
    protected SpriteFont health;
    protected SpriteFont intro;
    protected SpriteFont battle;
    protected SpriteFont attacks;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int keyPressTimer;
    protected PlayLevelScreen playLevelScreen;
    protected FlagManager flagManager;

    public BattleScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void addGameLevel(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }

    @Override
    public void initialize() {
        keyPressTimer = 0;
        flagManager = new FlagManager();
        intro = new SpriteFont("A nefarious ghost approaches!", 200, 50, "Arial", 30, Color.white);
        battle = new SpriteFont("You hit for some damage!", 240, 279,"Arial", 20, Color.white);
        flagManager.addFlag("Attacking", false);
        physicalAttack = new SpriteFont("Physical Attack                                     " , 90, 500, "Arial", 30, Color.white );
        magicAttack = new SpriteFont("                                       Magic Attack               " , 90, 500, "Arial", 30, Color.white );
        keyLocker.lockKey(Key.SPACE);
        keyLocker.lockKey(Key.B);
        keyLocker.lockKey(Key.UP);
        keyLocker.lockKey(Key.DOWN);
        update();
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.B) && keyPressTimer == 0) {
            playLevelScreen.stopBattle();
            keyPressTimer = 60;
        }
        if(Keyboard.isKeyDown(Key.LEFT)){
            keyLocker.unlockKey(Key.LEFT);
        }
        if(Keyboard.isKeyDown(Key.RIGHT)){
            keyLocker.unlockKey(Key.RIGHT);
        }
        // if left or right is pressed, change menu item "hovered" over
        if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
            keyPressTimer = 60;
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
            keyPressTimer = 60;
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
        
        // 
        if (Keyboard.isKeyDown(Key.SPACE) && currentMenuItemHovered == 0) {
            flagManager.setFlag("Attacking");
            battle.setText("You hit for 30 melee damage!");
        }
        else if (Keyboard.isKeyDown(Key.SPACE) && currentMenuItemHovered == 1) {
            flagManager.setFlag("Attacking");
            battle.setText("You hit for 40 magic damage!");
        }
        else {
            flagManager.unsetFlag("Attacking");
        }

    }
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        if(flagManager.isFlagSet("Attacking")) {
            battle.draw(graphicsHandler);
        }
        else {
            intro.draw(graphicsHandler);
        }
        physicalAttack.draw(graphicsHandler);
        magicAttack.draw(graphicsHandler);
    }
}
