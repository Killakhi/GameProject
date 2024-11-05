package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
import GameObject.HealthBar;
import SpriteFont.SpriteFont;
import java.awt.*;
import java.awt.image.BufferedImage;

// This class is for the battle screen
public class BattleScreen extends Screen {
    protected AttackManager attackManager;
    protected BufferedImage enemy1;
    protected int enemyID;
    protected BufferedImage animation;
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected SpriteFont magicAttack;
    protected SpriteFont physicalAttack;
    protected SpriteFont intro;
    protected SpriteFont battle;
    protected SpriteFont attacks;
    protected SpriteFont mp;
    protected HealthBar playerHealth;
    protected HealthBar enemyHealth = new HealthBar(100, 100);
    protected KeyLocker keyLocker = new KeyLocker();
    protected int keyPressTimer;
    protected int attackType;
    protected int hitRate;
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
        playerHealth = new HealthBar(playLevelScreen.currentHp, playLevelScreen.hpStat);
        keyPressTimer = 0;
        flagManager = new FlagManager();
        attackManager = new AttackManager(this);
        intro = new SpriteFont("A nefarious ghost approaches!", 200, 50, "Arial", 30, Color.white);
        battle = new SpriteFont("You hit for some damage!", 240, 50,"Arial", 20, Color.white);
        flagManager.addFlag("Attacking", false);
        flagManager.addFlag("Animation", false);
        physicalAttack = new SpriteFont("Physical Attack                                     " , 90, 500, "Arial", 30, Color.white );
        magicAttack = new SpriteFont("                                       Magic Attack               " , 90, 500, "Arial", 30, Color.white );
        mp = new SpriteFont(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat, 30, 90, "Arial", 30, Color.white);
        keyLocker.unlockKey(Key.SPACE);
        keyLocker.unlockKey(Key.B);
        keyLocker.unlockKey(Key.UP);
        keyLocker.unlockKey(Key.DOWN);
        enemy1 = ImageLoader.load("Ghost Angy Battle.png");
        enemyID = 1;
        update();
    }

    private enum BattleState {
        CHOOSE_ATTACK, APPLY_PLAYER_DAMAGE, MISS, SHOW_PLAYER_DAMAGE, APPLY_ENEMY_DAMAGE, SHOW_ENEMY_DAMAGE, VICTORY, LEVEL_UP
    }
    int hit = 0;
    int damage = 0;
    int timer = 0; 
    BattleState currentBattleState = BattleState.CHOOSE_ATTACK;
    @Override
    public void update() {
        if (currentBattleState == BattleState.CHOOSE_ATTACK) {
            // if left or right is pressed, change menu item "hovered" over
            if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
                keyPressTimer = 60;
                currentMenuItemHovered++;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 60;
                currentMenuItemHovered--;
            } else if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0){
                keyLocker.lockKey(Key.SPACE);
                keyPressTimer = 60;
                currentBattleState = BattleState.APPLY_PLAYER_DAMAGE;
            }
            else if (Keyboard.isKeyDown(Key.B) && keyPressTimer == 0) {
                playLevelScreen.stopBattle();
                keyPressTimer = 60;
            }
            else { 
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
        }
        else if (currentBattleState == BattleState.APPLY_PLAYER_DAMAGE) {
            int check = ((int)(Math.random() * (100))) + 1;
            hitRate = attackManager.setHitRate(attackType);
            if (check > (playLevelScreen.speedStat)*5 + hitRate) {
                currentBattleState = BattleState.MISS;
            } 
            else if(currentMenuItemHovered == 1 && playLevelScreen.currentMagic < 10) {
                intro.setText("You don't have enough MP to cast!");
                timer++;
                if (timer == 90) {
                    timer = 0;
                    intro.setText("A nefarious ghost approaches!");
                    currentBattleState = BattleState.CHOOSE_ATTACK;
                }
            }
            else {
                if(currentMenuItemHovered == 0) {
                    hit = ((int)(Math.random() * (40))) + 20 ;
                    attackType = 0; 
                } else if(currentMenuItemHovered == 1) {
                    hit = ((int)(Math.random() * (10))) + 45 ;
                    attackType = 3;
                    playLevelScreen.currentMagic = playLevelScreen.currentMagic - 10;
                }
                battle.setText(attackManager.setDisplay(attackType, hit)); 
                flagManager.setFlag("Attacking");
                flagManager.unsetFlag("Animation");
                currentBattleState = BattleState.SHOW_PLAYER_DAMAGE;
            }
        }
        else if (currentBattleState == BattleState.MISS) {
            flagManager.unsetFlag("Attacking");
            flagManager.unsetFlag("Animation");
            intro.setText("Whoops, you missed!"); 
            timer++;
            if(timer >= 60) {
                currentBattleState = BattleState.APPLY_ENEMY_DAMAGE;
                intro.setText("A nefarious ghost approaches!");
            }
        }
        else if (currentBattleState == BattleState.SHOW_PLAYER_DAMAGE) {
            if(currentMenuItemHovered == 0) {
                attackType = 0; 
            } else if(currentMenuItemHovered == 1) {
                attackType = 3;
                mp.setText(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat);
            }
            battle.setText(attackManager.setDisplay(attackType, hit)); 
            flagManager.setFlag("Attacking");
            animation = attackManager.animation(attackType, timer);
            timer++;
            if(timer == 90) {
                enemyHealth.damage(hit);
                flagManager.unsetFlag("Animation");
                animation = ImageLoader.load("Empty.png");
                if(enemyHealth.isDead()) {
                    currentBattleState = BattleState.VICTORY;
                } else {
                    currentBattleState = BattleState.APPLY_ENEMY_DAMAGE;
                }
            }
        

        }
        else if (currentBattleState == BattleState.APPLY_ENEMY_DAMAGE) {
            damage = ((int)(Math.random() * (10))) + 10;
            battle.setText("You were hit for " + damage + " damage!");
            flagManager.setFlag("Attacking");
            flagManager.unsetFlag("Animation");
            currentBattleState = BattleState.SHOW_ENEMY_DAMAGE;

        }
        else if (currentBattleState == BattleState.SHOW_ENEMY_DAMAGE) {
            battle.setText("You were hit for " + damage + " damage!");
            flagManager.setFlag("Attacking");
            flagManager.unsetFlag("Animation");
            timer--;
            if(timer == 0) {
                currentBattleState = BattleState.CHOOSE_ATTACK;
                flagManager.unsetFlag("Attacking");
                this.playerHealth.damage(damage);
                if(this.playerHealth.isDead()) {
                    playLevelScreen.stopBattle();
                    playLevelScreen.gameOver();
                }
            }
            
        } 
        else if(currentBattleState == BattleState.VICTORY) {
            flagManager.unsetFlag("Attacking");

            timer--;
            if(timer > 0) {
                intro.setText("You defeated the enemy! Nice work");
            } else if(timer <= 0) {            
                intro.setText("You earned " + (enemyID * 10) + " Experience!");
            }
            if(timer == -90) {
                if(playLevelScreen.exp >= (80 + (playLevelScreen.level*20))){
                    currentBattleState = BattleState.LEVEL_UP;
                } else{
                this.playLevelScreen.stopBattle();
                }
            }
        }
        else if(currentBattleState == BattleState.LEVEL_UP) {
            intro.setText("Level Up! You are now at Level " + (playLevelScreen.level + 1));
            timer++;
            if(timer == 0) {
                this.playLevelScreen.stopBattle();
            }
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
        if(!enemyHealth.isDead()) {
            graphicsHandler.drawImage(enemy1, 270, 180);
        }
        if(flagManager.isFlagSet("Attacking")) {
            graphicsHandler.drawImage(animation, 240, 150);
        }
        physicalAttack.draw(graphicsHandler);
        magicAttack.draw(graphicsHandler);
        mp.draw(graphicsHandler);
        this.playerHealth.setVisible(true);
        this.enemyHealth.setVisible(true);
        this.playerHealth.draw(graphicsHandler, 30, 30);
        this.enemyHealth.draw(graphicsHandler, 270, 100);
    }
}
