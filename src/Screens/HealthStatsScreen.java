package Screens;
import Engine.*;
import Engine.Battle.PartyStats;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class HealthStatsScreen extends Screen {
    protected SpriteFont healthScreenMessage = new SpriteFont("Stats - Press 'M' to go back.", 85, 50, "Courier Bold Italic", 45, Color.white);
    protected SpriteFont currentHpMessage;
    protected SpriteFont attackStatMessage;
    protected SpriteFont magicStatMessage;
    protected SpriteFont speedStatMessage;
    protected KeyLocker keyLocker = PlayLevelScreen.keyLocker;
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
        healthScreenMessage = new SpriteFont("Stats - Press 'M' to go back.", 85, 50, "Courier Bold Italic", 45, Color.white);
        healthScreenMessage.setOutlineColor(Color.black);
        healthScreenMessage.setOutlineThickness(3);
            currentHpMessage = new SpriteFont("HP: " + PartyStats.PLAYER.currentHp + " / " + PartyStats.PLAYER.hpStat, 85, 130, "Arial", 30, Color.white);
            currentHpMessage.setOutlineColor(Color.black);
            currentHpMessage.setOutlineThickness(3);
            attackStatMessage = new SpriteFont("Attack: " + PartyStats.PLAYER.attackStat, 85, 170, "Arial", 30, Color.white);
            attackStatMessage.setOutlineColor(Color.black);
            attackStatMessage.setOutlineThickness(3);
            magicStatMessage = new SpriteFont("Magic Points: " +  PartyStats.PLAYER.currentMagic + " / " + PartyStats.PLAYER.magicStat, 85, 210, "Arial", 30, Color.white);
            magicStatMessage.setOutlineColor(Color.black);
            magicStatMessage.setOutlineThickness(3);
            speedStatMessage = new SpriteFont("Speed: " + PartyStats.PLAYER.speedStat, 85, 250, "Arial", 30, Color.white);
            speedStatMessage.setOutlineColor(Color.black);
            speedStatMessage.setOutlineThickness(3);
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

        if (Keyboard.isKeyDown(Key.M)) {
            playLevelScreen.pauseMenu();
        }

        }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.gray);
        healthScreenMessage.draw(graphicsHandler);
        currentHpMessage.draw(graphicsHandler);
        attackStatMessage.draw(graphicsHandler);
        // graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(0, 0, 0), Color.white, 2);
        magicStatMessage.draw(graphicsHandler);
        speedStatMessage.draw(graphicsHandler);
    }

    
}

