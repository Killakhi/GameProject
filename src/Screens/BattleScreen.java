package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.FlagManager;
import GameObject.HealthBar;
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
    protected HealthBar playerHealth = new HealthBar(100, 100);
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
        keyLocker.unlockKey(Key.SPACE);
        keyLocker.unlockKey(Key.B);
        keyLocker.unlockKey(Key.UP);
        keyLocker.unlockKey(Key.DOWN);
        update();
    }

    private enum BattleState {
        CHOOSE_ATTACK, APPLY_PLAYER_DAMAGE, SHOW_PLAYER_DAMAGE, APPLY_ENEMY_DAMAGE, SHOW_ENEMY_DAMAGE
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
            if (currentMenuItemHovered == 0) {
                magicAttack.setColor(new Color(49, 207, 240));
            } else if (currentMenuItemHovered == 1) {
                magicAttack.setColor(new Color(255, 215, 0));
            
            }
        }
        else if (currentBattleState == BattleState.APPLY_PLAYER_DAMAGE) {
            if(currentMenuItemHovered == 0) {
                hit = ((int)(Math.random() * (40))) + 20 ;
                battle.setText("You hit for " + hit + " melee damage!"); 
            } else if(currentMenuItemHovered == 1) {
                hit = ((int)(Math.random() * (10))) + 45 ;
                battle.setText("You hit for " + hit + " magic damage!"); 
            }
                       
            flagManager.setFlag("Attacking");
            currentBattleState = BattleState.SHOW_PLAYER_DAMAGE;
        }
        else if (currentBattleState == BattleState.SHOW_PLAYER_DAMAGE) {
            if(currentMenuItemHovered == 0) {
                battle.setText("You hit for " + hit + " melee damage!"); 
            } else if(currentMenuItemHovered == 1) {
                battle.setText("You hit for " + hit + " magic damage!"); 
            }
            flagManager.setFlag("Attacking");
            timer++;
            if(timer > 90) {
                currentBattleState = BattleState.APPLY_ENEMY_DAMAGE;
            }

        }
        else if (currentBattleState == BattleState.APPLY_ENEMY_DAMAGE) {
            damage = ((int)(Math.random() * (10))) + 10;
            battle.setText("You were hit for " + damage + " damage!");
            flagManager.setFlag("Attacking");
            currentBattleState = BattleState.SHOW_ENEMY_DAMAGE;

        }
        else if (currentBattleState == BattleState.SHOW_ENEMY_DAMAGE) {
            battle.setText("You were hit for " + damage + " damage!");
            flagManager.setFlag("Attacking");
            timer--;
            if(timer == 0) {
                currentBattleState = BattleState.CHOOSE_ATTACK;
                flagManager.unsetFlag("Attacking");
                this.playerHealth.damage(damage);
            }
            
        }
        
        
        //
        
        /*if (keyLocker.isKeyLocked(Key.SPACE) && currentMenuItemHovered == 0) {
            int hit = ((int)(Math.random() * (30))) + 20 ;
            int damage = ((int)(Math.random() * (10))) + 10;
            int animation = 20000;
            battle.setText("You hit for " + hit + " melee damage!");
            flagManager.setFlag("Attacking");
            while(animation > 10000) {
                animation--;
                System.out.println(animation);
            }
            battle.setText("You were hit for " + damage + " damage!");
            while(animation > 0) {
                animation--;
                System.out.println(animation);
            } 
            this.playerHealth.damage(damage);
            keyLocker.unlockKey(Key.SPACE);
        }
        else if (keyLocker.isKeyLocked(Key.SPACE) && currentMenuItemHovered == 1) {
            flagManager.setFlag("Attacking");
            battle.setText("You hit for 40 magic damage!");
        }
        else {
            flagManager.unsetFlag("Attacking");
        }*/

        // if up or down is pressed, the health goes up or down
        if (Keyboard.isKeyDown(Key.UP)) {
            //Code for the health system
            this.playerHealth.heal(1);
        } else if (Keyboard.isKeyDown(Key.DOWN)) {
            //Code for the health system
            this.playerHealth.damage(1);
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
        this.playerHealth.setVisible(true);
        this.playerHealth.draw(graphicsHandler, 30, 30);
    }
}
