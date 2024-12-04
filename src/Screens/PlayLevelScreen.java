package Screens;

import Engine.Battle.PartyStats;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.SoundHandler;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Money;
import Level.*;
import Maps.BossArena;
import Maps.NewMap;
import Maps.TestMap;
import Players.Cat;
import Screens.Pause.PauseMenu;
import Screens.Stats.HealthStatsPanel;
import Utils.Direction;
import java.util.ArrayList;

// This class is for when the RPG game is actually being played
public class PlayLevelScreen extends Screen {
    public int level;
    public int exp;
    public boolean paused = false;
    public static PlayLevelScreenState playLevelScreenState = PlayLevelScreenState.RUNNING;
    protected ScreenCoordinator screenCoordinator;
    protected Map map;
    protected Player player;
    protected WinScreen winScreen;
    protected PauseMenu pauseMenu;
    protected HealthStatsPanel healthMenu;
    protected GameOverScreen gameOverScreen;
    protected BattleScreen battleScreen;
    protected FlagManager flagManager;
    protected int keyPressTimer;
    public static int enemyID;
    public static KeyLocker keyLocker = new KeyLocker();
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
        flagManager.addFlag("hasTalkedToQuestSeeker", false);
        flagManager.addFlag("hasTalkedToMysteryQuest", false);
        flagManager.addFlag("hasTalkedToMP", false);
        flagManager.addFlag("hasFoundBall", false);
        flagManager.addFlag("hasFoughtNPC", false);
        flagManager.addFlag("hasOpenDoor", false);
        flagManager.addFlag("YestoBoss", false);
        flagManager.addFlag("talkedtoInnGuy", false);

        // define/setup map
        map = new TestMap();
        map.setFlagManager(flagManager);

        // setup player
        player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        player.setMap(map);
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        player.setFacingDirection(Direction.LEFT);

        map.setPlayer(player);
        SoundHandler.RunMusic("Resources/GameMusic.wav");

        // let pieces of map know which button to listen for as the "interact" button
        map.getTextbox().setInteractKey(player.getInteractKey());

        // preloads all scripts ahead of time rather than loading them dynamically
        // both are supported, however preloading is recommended
        map.preloadScripts();

        winScreen = new WinScreen(this);
        pauseMenu = new PauseMenu(screenCoordinator, this);
        battleScreen = new BattleScreen(screenCoordinator);
        gameOverScreen = new GameOverScreen(screenCoordinator);
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
        PartyStats.PLAYER.hpStat = 100;
        PartyStats.PLAYER.currentHp = 100;
        PartyStats.PLAYER.attackStat = 20;
        PartyStats.PLAYER.magicStat = 30;
        PartyStats.PLAYER.currentMagic = 30;
        PartyStats.PLAYER.speedStat = 15;
        // Maya Stats
        PartyStats.MAYA.hpStat = 150;
        PartyStats.MAYA.currentHp = 150;
        PartyStats.MAYA.attackStat = 15;
        PartyStats.MAYA.magicStat = 40;
        PartyStats.MAYA.currentMagic = 40;
        PartyStats.MAYA.speedStat = 13;
        // Damion Stats
        PartyStats.DAMION.hpStat = 90;
        PartyStats.DAMION.currentHp = 90;
        PartyStats.DAMION.attackStat = 30;
        PartyStats.DAMION.magicStat = 25;
        PartyStats.DAMION.currentMagic = 25;
        PartyStats.DAMION.speedStat = 18;
    }

    public void releaseKeyLockGuard(Key key) {
        if (Keyboard.isKeyUp(key)) {
            keyLocker.unlockKey(key);
        }
    }

    public void update() {
        releaseKeyLockGuard(Key.SPACE);
        releaseKeyLockGuard(Key.ESC);
        releaseKeyLockGuard(Key.B);
        releaseKeyLockGuard(Key.UP);
        releaseKeyLockGuard(Key.DOWN);

        if (paused) {
            this.pauseMenu.update();
            return;
        } else if (!keyLocker.isKeyLocked(Key.ESC) && Keyboard.isKeyDown(Key.ESC)) {
            keyLocker.lockKey(Key.ESC);

            pauseMenu();
        }

        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
                player.update();
                map.update(player);

                if (flagManager.isFlagSet("hasOpenDoor")) {
                    map = new NewMap();
                    map.setFlagManager(flagManager);
                    player.setLocation(400,850);
                    player.unlock();
                    player.setMap(map);
                    playLevelScreenState = PlayLevelScreenState.RUNNING;
                    player.setFacingDirection(Direction.UP);

                    map.setPlayer(player);
                    map.getTextbox().setInteractKey(player.getInteractKey());
                    
                    flagManager.unsetFlag("hasOpenDoor");
                }

                if (flagManager.isFlagSet("YestoBoss")) {
                    map = new BossArena();
                    map.setFlagManager(flagManager);
                    player.setLocation(550,950);
                    player.unlock();
                    player.setMap(map);
                    playLevelScreenState = PlayLevelScreenState.RUNNING;
                    player.setFacingDirection(Direction.UP);

                    map.setPlayer(player);
                    map.getTextbox().setInteractKey(player.getInteractKey());


                    
                    flagManager.unsetFlag("YestoBoss");
                }

                if (flagManager.isFlagSet("talkedtoInnGuy")) {
                    map = new TestMap();
                    map.setFlagManager(flagManager);
                    player.setLocation(550,950);
                    player.unlock();
                    player.setMap(map);
                    playLevelScreenState = PlayLevelScreenState.RUNNING;
                    player.setFacingDirection(Direction.DOWN);

                    map.setPlayer(player);
                    map.getTextbox().setInteractKey(player.getInteractKey());

                    flagManager.unsetFlag("talkedtoInnGuy");

                }
                break;
            // if game is paused
            case PAUSE_MENU:
                pauseMenu.update();
                break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                winScreen.update();
                SoundHandler.StopMusic("Resources/BattleMusic30sec.wav");
                break;
            case ENTERING_BATTLE:
            battleScreen.initialize();
            SoundHandler.StopMusic("Resources/GameMusic.wav");
            SoundHandler.RunMusic("Resources/BattleMusic30sec.wav");
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

        // if flag is set at any point during gameplay, game is "won"
        if (map.getFlagManager().isFlagSet("hasFoundBall") || map.getFlagManager().isFlagSet("hasFoughtNPC")) {
            playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
        }
        if(keyPressTimer > 0) {
            keyPressTimer--;
        }
    }

    public void setPlayLevelScreenState(){


        playLevelScreenState = PlayLevelScreenState.RUNNING;
 
 
        if (true) {
          
         SoundHandler.RunMusic("Resources/GameMusic.wav");
        }
 
 
        playLevelScreenState = PlayLevelScreenState.ENTERING_BATTLE;
 
 
        if(true){
 
 
            SoundHandler.RunMusic("Resources/BattleMusic30sec.wav");
        }
        }
 

    public void stopBattle() {
        playLevelScreenState = PlayLevelScreenState.RUNNING;
        SoundHandler.StopMusic("Resources/BattleMusic30sec.wav");
        SoundHandler.RunMusic("Resources/GameMusic.wav");
    }

    public void pauseMenu(){
        paused = true;
    }


    public void gameOver() {
        playLevelScreenState = PlayLevelScreenState.GAME_OVER;
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        if (paused) {
            this.pauseMenu.draw(graphicsHandler);
            return;
        }

        if (paused) {
            this.pauseMenu.draw(graphicsHandler);
            return;
        }

        switch (playLevelScreenState) {
            case RUNNING:
                map.draw(player, graphicsHandler);
                break;
            case LEVEL_COMPLETED:
                winScreen.draw(graphicsHandler);
                break;
            case ENTERING_BATTLE:
                //battleScreen.initialize();
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
        SoundHandler.RunMusic("Resources/GameMusic.wav");

    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);

    }

    // This enum represents the different states this screen can be in
    public enum PlayLevelScreenState {
        RUNNING, PAUSE_MENU, STATS, LEVEL_COMPLETED, ENTERING_BATTLE, BATTLING, GAME_OVER,
    }
}
