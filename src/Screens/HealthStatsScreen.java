package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class HealthStatsScreen extends Screen {
    protected SpriteFont healthScreenMessage;
    protected SpriteFont currentHpMessage;
    protected SpriteFont attackStatMessage;
    protected SpriteFont magicStatMessage;
    protected SpriteFont currentMagicMessage;
    protected SpriteFont speedStatMessage;
    protected KeyLocker keyLocker = new KeyLocker();
    // protected int currentpauseMenuItemHovered = 0;
    // protected int pauseMenuItemSelected = -1;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    protected PlayLevelScreen playLevelScreen;
    protected ScreenCoordinator screenCoordinator;

    public HealthStatsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;

    }

    public void addGameLevel(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
    }
 
    @Override
    public void initialize() {
        keyLocker.lockKey(Key.M);
        healthScreenMessage = new SpriteFont("Health", 85, 50, "Courier Bold Italic", 45, Color.white);
        healthScreenMessage.setOutlineColor(Color.black);
        healthScreenMessage.setOutlineThickness(3);
        if (playLevelScreen != null) {
            currentHpMessage = new SpriteFont("CurrentHpStats:" + playLevelScreen.currentHp, 85, 130, "Arial", 30, Color.white);
            currentHpMessage.setOutlineColor(Color.black);
            currentHpMessage.setOutlineThickness(3);
            attackStatMessage = new SpriteFont("attackStats:" + playLevelScreen.attackStat, 85, 170, "Arial", 30, Color.white);
            attackStatMessage.setOutlineColor(Color.black);
            attackStatMessage.setOutlineThickness(3);
            magicStatMessage = new SpriteFont("magicStats:" + playLevelScreen.magicStat, 85, 210, "Arial", 30, Color.white);
            magicStatMessage.setOutlineColor(Color.black);
            magicStatMessage.setOutlineThickness(3);
            currentMagicMessage = new SpriteFont("currentMagic:" + playLevelScreen.currentMagic, 85, 250, "Arial", 30, Color.white);
            currentMagicMessage.setOutlineColor(Color.black);
            currentMagicMessage.setOutlineThickness(3);
            speedStatMessage = new SpriteFont("speedStats:" + playLevelScreen.speedStat, 85, 290, "Arial", 30, Color.white);
            speedStatMessage.setOutlineColor(Color.black);
            speedStatMessage.setOutlineThickness(3);
        }
        else {
            currentHpMessage = new SpriteFont("CurrentHpStats: 100", 85, 130, "Arial", 30, Color.white);
            currentHpMessage.setOutlineColor(Color.black);
            currentHpMessage.setOutlineThickness(3);
            attackStatMessage = new SpriteFont("CurrentHpStats: 20", 85, 170, "Arial", 30, Color.white);
            attackStatMessage.setOutlineColor(Color.black);
            attackStatMessage.setOutlineThickness(3);
            magicStatMessage = new SpriteFont("magicStats: 30", 85, 210, "Arial", 30, Color.white);
            magicStatMessage.setOutlineColor(Color.black);
            magicStatMessage.setOutlineThickness(3);
            currentMagicMessage = new SpriteFont("currentMagic: 30", 85, 250, "Arial", 30, Color.white);
            currentMagicMessage.setOutlineColor(Color.black);
            currentMagicMessage.setOutlineThickness(3);
            speedStatMessage = new SpriteFont("speedStats: 15", 85, 290, "Arial", 30, Color.white);
            speedStatMessage.setOutlineColor(Color.black);
            speedStatMessage.setOutlineThickness(3);
        }
        keyPressTimer = 0;
    }
 
    @Override
    public void update() {

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (Keyboard.isKeyDown(Key.L)) {
            screenCoordinator.setGameState(GameState.LEVEL);
        }

        }

    public void draw(GraphicsHandler graphicsHandler) {
        initialize();
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.gray);
        healthScreenMessage.draw(graphicsHandler);
        currentHpMessage.draw(graphicsHandler);
        attackStatMessage.draw(graphicsHandler);
        // graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(0, 0, 0), Color.white, 2);
        magicStatMessage.draw(graphicsHandler);
        currentMagicMessage.draw(graphicsHandler);
        speedStatMessage.draw(graphicsHandler);
    }

    
}

