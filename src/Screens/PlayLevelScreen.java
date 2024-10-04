package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected WinScreen winScreen;
    protected BattleScreen battleScreen;
    protected FlagManager flagManager;
    protected int keyPressTimer;
    protected KeyLocker keyLocker = new KeyLocker();

    public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // setup state
        flagManager = new FlagManager();
        flagManager.addFlag("hasLostBall", false);
        flagManager.addFlag("hasTalkedToWalrus", false);
        flagManager.addFlag("hasTalkedToDinosaur", false);
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
        battleScreen.addGameLevel(this);

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
        }
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
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, BATTLING
    }
}
