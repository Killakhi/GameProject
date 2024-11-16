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
import Screens.PlayLevelScreen.PlayLevelScreenState;
import Utils.Direction;
import java.util.ArrayList;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    public int level;
    public int exp;
    public int hpStat;
    public int currentHp;
    public int magicStat;
    public int currentMagic;
    public int attackStat;
    public int speedStat;
    //maya stats
    public int mayaHpStat;
    public int mayaCurrentHp;
    public int mayaMagicStat;
    public int mayaCurrentMagic;
    public int mayaAttackStat;
    public int mayaSpeedStat;
    //damion stats
    public int damionHpStat;
    public int damionCurrentHp;
    public int damionMagicStat;
    public int damionCurrentMagic;
    public int damionAttackStat;
    public int damionSpeedStat;
    public static PlayLevelScreenState playLevelScreenState = PlayLevelScreenState.RUNNING;
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected WinScreen winScreen;
    protected PauseMenu pauseMenu;
    protected HealthStatsScreen healthMenu;
    protected GameOverScreen gameOverScreen;
    protected BattleScreen battleScreen;
    protected FlagManager flagManager;
    protected int keyPressTimer;
    public static int enemyID;
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
        pauseMenu = new PauseMenu(screenCoordinator);
        healthMenu = new HealthStatsScreen(screenCoordinator);
        battleScreen = new BattleScreen(screenCoordinator);
        gameOverScreen = new GameOverScreen(screenCoordinator);
        pauseMenu.addGameLevel(this);
        healthMenu.addGameLevel(this);
        battleScreen.addGameLevel(this);
        gameOverScreen.addGameLevel(this);

        // add a keyLocker to track when the battle button is pressed
        keyLocker.lockKey(Key.B);
        keyPressTimer = 0;

        //add a keyLocker to pause the screen when the space button is pressed
        keyLocker.lockKey(Key.SPACE);
        keyPressTimer = 0;
        // Universal Level
        level = 1;
        // Player Stats
        hpStat = 100;
        currentHp = 100;
        attackStat = 20;
        magicStat = 30;
        currentMagic = 30;
        speedStat = 15;
        // Maya Stats
        mayaHpStat = 150;
        mayaCurrentHp = 150;
        mayaAttackStat = 15;
        mayaMagicStat = 40;
        mayaCurrentMagic = 40;
        mayaSpeedStat = 13;
        // Damion Stats
        damionHpStat = 90;
        damionCurrentHp = 90;
        damionAttackStat = 30;
        damionMagicStat = 25;
        damionCurrentMagic = 25;
        damionSpeedStat = 18;
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);
                break;
            // if game is paused
            case PAUSE_MENU:
                pauseMenu.update();
                break;
            case STATS:
                healthMenu.update();
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                break;
            case ENTERING_BATTLE:
                battleScreen.initialize();
                playLevelScreenState = PlayLevelScreenState.BATTLING;
                // fallthrough to next case
            case BATTLING:
                battleScreen.update();
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

        if (Keyboard.isKeyDown(Key.M))  {
            
            pauseMenu();
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

    public void pauseMenu(){
        playLevelScreenState = PlayLevelScreenState.PAUSE_MENU;
    }

    public void stats(){
        healthMenu.initialize();
        playLevelScreenState = PlayLevelScreenState.STATS;
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
            case PAUSE_MENU:
                pauseMenu.draw(graphicsHandler);
                break;
            case STATS:
                healthMenu.draw(graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case ENTERING_BATTLE:
                battleScreen.initialize();
                playLevelScreenState = PlayLevelScreenState.BATTLING;
                // fallthrough to next case
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
        RUNNING, PAUSE_MENU, STATS, LEVEL_COMPLETED, ENTERING_BATTLE, BATTLING, GAME_OVER
    }
}
