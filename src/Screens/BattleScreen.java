package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class BattleScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected SpriteFont intro;
    protected SpriteFont battle;
    protected SpriteFont attacks;
    protected int damage;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();
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
        update();
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.B) && keyPressTimer == 0) {
            playLevelScreen.stopBattle();
            keyPressTimer = 60;
        }
        /* 
        if(Keyboard.isKeyDown(Key.UP) && !keyLocker.isKeyLocked(Key.UP) && keyPressTimer == 0)  {
            keyPressTimer = 60;
            keyLocker.lockKey(Key.UP);
            if(keyLocker.isKeyLocked(Key.DOWN)) {
                keyLocker.unlockKey(Key.DOWN);
            }
        } else if(Keyboard.isKeyDown(Key.UP) && keyLocker.isKeyLocked(Key.UP))  {
            keyLocker.unlockKey(Key.UP);
        }
        if(Keyboard.isKeyDown(Key.DOWN) && !keyLocker.isKeyLocked(Key.DOWN) && keyPressTimer == 0)  {
            keyPressTimer = 60;
            keyLocker.lockKey(Key.DOWN);
            if(keyLocker.isKeyLocked(Key.UP)) {
                keyLocker.unlockKey(Key.UP);
            }
        } else if(Keyboard.isKeyDown(Key.DOWN) && keyLocker.isKeyLocked(Key.DOWN))  {
            keyLocker.unlockKey(Key.DOWN);
        }
        
        if (keyLocker.isKeyLocked(Key.UP)) {
            flagManager.setFlag("Attacking");
            damage = getDamage("a");
            battle.setText("You hit for " + damage + " melee damage!");
        }
        if (keyLocker.isKeyLocked(Key.DOWN)) {
            flagManager.setFlag("Attacking");
            damage = getDamage("m");
            battle.setText("You hit for " + damage + " magic damage!");
        }
        */
        if(keyPressTimer > 0) {
            keyPressTimer--;
        }
    }
    public int getDamage(String type) {
        if(type.equals("a")) {
            return 30;
        }
        else if(type.equals("m")) {
            return 40;
        }
        else{
            return 100;
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
    }
}
