package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import GameObject.HealthBar;
import Level.FlagManager;
import SpriteFont.SpriteFont;
import java.awt.*;
import java.awt.image.BufferedImage;

// This class is for the battle screen
public class BattleScreen extends Screen {
    protected AttackManager attackManager;
    protected EnemyManager enemyManager;
    protected BufferedImage enemy1;
    protected int enemyID;
    protected BufferedImage animation;
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int currentMagicAttackHovered =0;
    protected SpriteFont magicAttack;
    protected SpriteFont physicalAttack;
    protected SpriteFont items;
    protected SpriteFont runAway;
    protected SpriteFont switchMenu;
    protected SpriteFont fireAttack;
    protected SpriteFont waterAttack;
    protected SpriteFont windAttack;
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
        enemyManager = new EnemyManager();     
        intro = new SpriteFont("A nefarious ghost approaches!", 200, 50, "Arial", 30, Color.white);
        battle = new SpriteFont("You hit for some damage!", 240, 50,"Arial", 20, Color.white);
        flagManager.addFlag("Attacking", false);
        flagManager.addFlag("Animation", false);
        physicalAttack = new SpriteFont("Physical Attack" , 10, 500, "Arial", 30, Color.white );
        items = new SpriteFont("Items", 260, 500, "Arial", 30, Color.white);
        runAway = new SpriteFont("Run Away", 400, 500, "Arial", 30, Color.white);
        switchMenu = new SpriteFont("Magic Attack", 600, 500, "Arial", 30, Color.white);
        fireAttack = new SpriteFont("Fire Attack", 500, 400, "Arial", 30, Color.white);
        waterAttack = new SpriteFont("Water Attack", 500, 300, "Arial", 30, Color.white);
        windAttack = new SpriteFont("Wind Attack", 500, 200, "Arial", 30, Color.white);
        
        mp = new SpriteFont(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat, 30, 90, "Arial", 30, Color.white);
        keyLocker.unlockKey(Key.SPACE);
        keyLocker.unlockKey(Key.B);
        keyLocker.unlockKey(Key.UP);
        keyLocker.unlockKey(Key.DOWN);
        enemyID = playLevelScreen.enemyID;
        enemy1 = enemyManager.setSprite(enemyID);
        update();
    }

    private enum BattleState {
        CHOOSE_ATTACK, APPLY_PLAYER_DAMAGE, MISS, SHOW_PLAYER_DAMAGE, APPLY_ENEMY_DAMAGE, SHOW_ENEMY_DAMAGE, VICTORY, LEVEL_UP, MAGIC_MENU
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
                keyPressTimer = 30;
                currentMenuItemHovered--;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered++;
            } else if (Keyboard.isKeyDown(Key.B) && keyPressTimer == 0) {
                playLevelScreen.stopBattle();
                keyPressTimer = 60;
            }
            else { 
                if (keyPressTimer > 0) {
                    keyPressTimer--;
                }
            }

            if (currentMenuItemHovered > 3) {
                currentMenuItemHovered = 0;
            } else if (currentMenuItemHovered < 0) {
                currentMenuItemHovered = 3;
            }

//change color of text
//physical attack
            if(currentMenuItemHovered == 0){
                physicalAttack.setColor(new Color(255, 215, 0));
            }else if(currentMenuItemHovered !=0){
                physicalAttack.setColor(new Color(49, 207, 240));
            } 

//items
        if (currentMenuItemHovered == 1) {
            items.setColor(new Color(255, 215, 0));
        } else if (currentMenuItemHovered != 1) {
            items.setColor(new Color(49, 207, 240));
        
        }  


     //runAway   
        
        if (currentMenuItemHovered == 2) {
            runAway.setColor(new Color(255, 215, 0));
        } else if (currentMenuItemHovered != 2) {
            runAway.setColor(new Color(49, 207, 240));
        
        }


//Menu switch

         if (currentMenuItemHovered == 3) {
            switchMenu.setColor(new Color(255, 215, 0));
        } else if (currentMenuItemHovered != 3) {
            switchMenu.setColor(new Color(49, 207, 240));
        
        }

        // decide option
        if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0){
            if(currentMenuItemHovered == 0){
                attackType = 0;
                currentBattleState = BattleState.APPLY_PLAYER_DAMAGE;
            } else if(currentMenuItemHovered == 1) {

            } else if(currentMenuItemHovered == 2) {
                playLevelScreen.stopBattle();
            } else if(currentMenuItemHovered == 3) {
                currentBattleState = BattleState.MAGIC_MENU;
                keyPressTimer = 60;
            }
        }

        }
        else if (currentBattleState == BattleState.APPLY_PLAYER_DAMAGE) {
            int check = ((int)(Math.random() * (100))) + 1;
            hitRate = attackManager.setHitRate(attackType);
            if (check > ((playLevelScreen.speedStat)*5 + hitRate) - enemyManager.dodge(enemyID)) {
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
                if(currentMenuItemHovered != 0) {
                    playLevelScreen.currentMagic = playLevelScreen.currentMagic - 10;
                }
                hit = attackManager.setHit(attackType, playLevelScreen.attackStat);

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

            if(currentMagicAttackHovered != 0) {
                mp.setText(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat);
            } else if(currentMenuItemHovered == 1) {
                //attackType = 3;
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
            damage = enemyManager.damage(enemyID);
            flagManager.setFlag("Attacking");
            flagManager.unsetFlag("Animation");
            currentBattleState = BattleState.SHOW_ENEMY_DAMAGE;

        }
        else if (currentBattleState == BattleState.SHOW_ENEMY_DAMAGE) {
            if(damage == 0) {
                battle.setText("Whoops, the enemy missed!");
            } else {
                battle.setText("You were hit for " + damage + " damage!");
            }
                
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
    else if (currentBattleState == BattleState.MAGIC_MENU) {
        if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
            keyPressTimer = 30;
            currentMagicAttackHovered++;
        } else if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
            keyPressTimer = 30;
            currentMagicAttackHovered--;
        } else if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
            attackType = currentMagicAttackHovered + 1;
            currentBattleState = BattleState.APPLY_PLAYER_DAMAGE;
        } else {
            if(keyPressTimer > 0) {
                keyPressTimer--;
            }
        }

        if(currentMagicAttackHovered > 2){
            currentMagicAttackHovered = 0;
        } else if (currentMagicAttackHovered <0) {
            currentMagicAttackHovered = 2;
        }
        
        //magic menu hover
        //fire
        if (currentMagicAttackHovered == 0) {
            fireAttack.setColor(new Color(255, 215, 0));
        } else if (currentMagicAttackHovered != 0) {
            fireAttack.setColor(new Color(49, 207, 240));
        }


        //water
        if (currentMagicAttackHovered == 1) {
            waterAttack.setColor(new Color(255, 215, 0));
        } else if (currentMagicAttackHovered != 1) {
            waterAttack.setColor(new Color(49, 207, 240));
        }

        //wind
        if (currentMagicAttackHovered == 2) {
            windAttack.setColor(new Color(255, 215, 0));
        } else if (currentMagicAttackHovered != 2) {
            windAttack.setColor(new Color(49, 207, 240));
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
                playLevelScreen.exp = playLevelScreen.exp + (enemyID * 10);
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
                playLevelScreen.level++;
                playLevelScreen.attackStat = playLevelScreen.attackStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*2);
                playLevelScreen.speedStat = playLevelScreen.speedStat + ((int)(Math.random() * (10))) + playLevelScreen.level;
                playLevelScreen.hpStat = playLevelScreen.hpStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*5);
                playLevelScreen.currentHp = playLevelScreen.hpStat;
                playLevelScreen.magicStat = playLevelScreen.magicStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*3);
                this.playLevelScreen.stopBattle();
                playLevelScreen.exp = playLevelScreen.exp - (80 + (playLevelScreen.level*20));
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
       
        if(currentBattleState == BattleState.MAGIC_MENU){
            waterAttack.draw(graphicsHandler);
            fireAttack.draw(graphicsHandler);
            windAttack.draw(graphicsHandler);
        } else 
        physicalAttack.draw(graphicsHandler);
        physicalAttack.draw(graphicsHandler);
        items.draw(graphicsHandler);
        runAway.draw(graphicsHandler);
        switchMenu.draw(graphicsHandler);
        mp.draw(graphicsHandler);
        this.playerHealth.setVisible(true);
        this.enemyHealth.setVisible(true);
        this.playerHealth.draw(graphicsHandler, 30, 30);
        this.enemyHealth.draw(graphicsHandler, 270, 100);
    }
}
