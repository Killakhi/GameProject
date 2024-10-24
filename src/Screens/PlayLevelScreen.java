package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Money;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import java.util.ArrayList;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    public static PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected GameOverScreen gameOverScreen;
    protected BattleScreen battleScreen;
    protected FlagManager flagManager;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();
    protected ArrayList<String> obtainableItems = new ArrayList<>();

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
        flagManager.addFlag("hasTalkedToBat", false);
        flagManager.addFlag("hasTalkedToBug", false);
        flagManager.addFlag("hasTalkedToGoku", false);
        flagManager.addFlag("hasTalkedToSword", false);
        flagManager.addFlag("hasTalkedToWand", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasFoughtNPC", false);

        // define/setup map
        map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        winScreen = new WinScreen(this);
        battleScreen = new BattleScreen(screenCoordinator);
        gameOverScreen = new GameOverScreen(screenCoordinator);
        battleScreen.addGameLevel(this);
        gameOverScreen.addGameLevel(this);

        // add a keyLocker to track when the battle button is pressed
        keyLocker.lockKey(Key.B);
        keyPressTimer = 0;
    }

    public void update() {
        // based on screen state, perform specific actions
         if (Keyboard.isKeyDown(Key.B) && !keyLocker.isKeyLocked(Key.B) && keyPressTimer == 0) {
             keyLocker.lockKey(Key.B);
             keyPressTimer = 20;
         }
         else if (Keyboard.isKeyDown(Key.B) && keyLocker.isKeyLocked(Key.B) && keyPressTimer == 0) {
             keyLocker.unlockKey(Key.B);
             keyPressTimer = 20;
         }
         if (!keyLocker.isKeyLocked(Key.B)) {
             playLevelScreenState = PlayLevelScreenState.BATTLING;
        } 
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
            case BATTLING:
                battleScreen.initialize();
                break;
            case GAME_OVER:
                gameOverScreen.update();
                break;
        }

        if (map.getFlagManager().isFlagSet("hasTalkedToWalrus") && !obtainableItems.contains("Walrus")) {
            obtainableItems.add("Walrus");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToDinosaur") && !obtainableItems.contains("Dinosaur")) {
            obtainableItems.add("Dinosaur");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToBat") && !obtainableItems.contains("Bat")) {
            obtainableItems.add("Bat");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToBug") && !obtainableItems.contains("Bug")) {
            obtainableItems.add("Bug");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToGoku") && !obtainableItems.contains("Ghost")) {
            obtainableItems.add("Ghost");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToSword") && !obtainableItems.contains("Sword")) {
            obtainableItems.add("Sword");
            System.out.println(obtainableItems);
        }
        if (map.getFlagManager().isFlagSet("hasTalkedToWand") && !obtainableItems.contains("Wand")) {
            obtainableItems.add("Wand");
            System.out.println(obtainableItems);
        }

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall") || map.getFlagManager().isFlagSet("hasFoughtNPC")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
        if(keyPressTimer > 0) {
            keyPressTimer--;
        }
    }

    public void stopBattle() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
    }

    public void gameOver() {
        playLevelScreenState = PlayLevelScreenState.GAME_OVER;
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case BATTLING:
                battleScreen.draw(graphicsHandler);
                break;
            case GAME_OVER:
                gameOverScreen.draw(graphicsHandler);
                break;
        }

        Money.INSTANCE.draw(graphicsHandler);
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    public void finish() {
        flagManager.setFlag("hasFoughtNPC");
    }
     
    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    public enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, BATTLING, GAME_OVER
    }
}
