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
    protected int[] playerSpeed = new int[4];
    protected AttackManager attackManager;
    protected EnemyManager enemyManager;
    protected BufferedImage enemy1;
    protected BufferedImage turnPlayer;
    protected int enemyX;
    protected int enemyY;
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
    protected SpriteFont earthAttack;
    protected SpriteFont lightAttack;
    protected SpriteFont iceAttack;
    protected SpriteFont darkAttack;
    protected SpriteFont intro;
    protected SpriteFont turn;
    protected SpriteFont battle;
    protected SpriteFont attacks;
    protected SpriteFont mp;
    protected HealthBar playerHealth = new HealthBar(90, 90);
    protected static HealthBar enemyHealth = new HealthBar(100, 100);
    protected KeyLocker keyLocker = PlayLevelScreen.keyLocker;
    protected int keyPressTimer;
    protected int attackType;
    protected int hitRate;
    protected int currentTurn;
    //player stats
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
        turn = new SpriteFont("", 200, 50, "Arial", 30, Color.white);
        battle = new SpriteFont("You hit for some damage!", 200, 50,"Arial", 30, Color.white);
        flagManager.addFlag("Attacking", false);
        flagManager.addFlag("Animation", false);
        physicalAttack = new SpriteFont("Physical Attack" , 10, 500, "Arial", 30, Color.white );
        items = new SpriteFont("Items", 260, 500, "Arial", 30, Color.white);
        runAway = new SpriteFont("Run Away", 400, 500, "Arial", 30, Color.white);
        switchMenu = new SpriteFont("Magic Attack", 600, 500, "Arial", 30, Color.white);
        fireAttack = new SpriteFont("Fire Attack", 500, 400, "Arial", 30, Color.white);
        waterAttack = new SpriteFont("Water Attack", 500, 300, "Arial", 30, Color.white);
        windAttack = new SpriteFont("Wind Attack", 500, 200, "Arial", 30, Color.white);
        earthAttack = new SpriteFont("Earth Attack", 500, 400, "Arial", 30, Color.white);
        lightAttack = new SpriteFont("Light Attack", 500, 300, "Arial", 30, Color.white);
        iceAttack = new SpriteFont("Ice Attack", 500, 400, "Arial", 30, Color.white);
        darkAttack = new SpriteFont("Dark Attack", 500, 300, "Arial", 30, Color.white);
        mp = new SpriteFont(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat, 30, 90, "Arial", 30, Color.white);
        // Player Stats
        hpStat = playLevelScreen.hpStat;
        currentHp = playLevelScreen.currentHp;
        attackStat = playLevelScreen.attackStat;
        magicStat = playLevelScreen.magicStat;
        currentMagic = playLevelScreen.currentMagic;
        speedStat = playLevelScreen.speedStat;
        // Maya's stats
        mayaHpStat = playLevelScreen.mayaHpStat;
        mayaCurrentHp = playLevelScreen.mayaCurrentHp;
        mayaAttackStat = playLevelScreen.mayaAttackStat;
        mayaMagicStat = playLevelScreen.mayaMagicStat;
        mayaCurrentMagic = playLevelScreen.mayaCurrentMagic;
        mayaSpeedStat = playLevelScreen.mayaSpeedStat;
        // Damion's stats
        damionHpStat = playLevelScreen.damionHpStat;
        damionCurrentHp = playLevelScreen.damionCurrentHp;
        damionAttackStat = playLevelScreen.damionAttackStat;
        damionMagicStat = playLevelScreen.damionMagicStat;
        damionCurrentMagic = playLevelScreen.damionCurrentMagic;
        damionSpeedStat = playLevelScreen.damionSpeedStat;
        enemyID = playLevelScreen.enemyID;
        enemy1 = enemyManager.setSprite(enemyID);
        enemyX = 270;
        enemyY = 180;
        playerSpeed[0] = speedStat;
        playerSpeed[1] = mayaSpeedStat;
        playerSpeed[2] = damionSpeedStat;
        int[] dummy = playerSpeed;
        playerSpeed = attackManager.turnOrder(dummy, enemyID);
        update();
    }

    private enum BattleState {
        DECIDE_TURN_ORDER, CHOOSE_ATTACK, MAYA_CHOOSE_ATTACK, DAMION_CHOOSE_ATTACK, APPLY_PLAYER_DAMAGE, MISS, SHOW_PLAYER_DAMAGE, APPLY_ENEMY_DAMAGE, SHOW_ENEMY_DAMAGE, VICTORY, LEVEL_UP, MAGIC_MENU,  MAYA_MAGIC_MENU, DAMION_MAGIC_MENU, PURGATORY
    }

    int hit = 0;
    int damage = 0;
    int timer = 0; 
    int target = 0;
    int turnTrack = -1;
    BattleState currentBattleState = BattleState.DECIDE_TURN_ORDER;
    @Override
    public void update() {
        if(currentBattleState == BattleState.DECIDE_TURN_ORDER) {
            turnTrack++;
            if (turnTrack > 3) {
                turnTrack = 0;
            } else if (turnTrack < 0) {
                turnTrack = 0;
            }
            currentTurn = playerSpeed[turnTrack];
            if(currentTurn == 0) {

                if(enemyID == 666) {
                    currentBattleState = BattleState.APPLY_ENEMY_DAMAGE;
                } else {
                    playerHealth.setCurrentHealth(currentHp);
                    playerHealth.setMaxHealth(hpStat);
                    mp.setText(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat);
                    turn.setText("What will you do?");
                    turnPlayer = ImageLoader.load("You.png");
                    currentBattleState = BattleState.CHOOSE_ATTACK;
                }

            } else if(currentTurn == 1) {

                if(mayaCurrentHp <= 0) {
                    currentBattleState = BattleState.DECIDE_TURN_ORDER;
                } else {
                    playerHealth.setCurrentHealth(mayaCurrentHp);
                    playerHealth.setMaxHealth(mayaHpStat);
                    mp.setText(playLevelScreen.mayaCurrentMagic + " / " + playLevelScreen.mayaMagicStat);
                    turn.setText("What will Maya do?");
                    turnPlayer = ImageLoader.load("Maya.png");
                    currentBattleState = BattleState.MAYA_CHOOSE_ATTACK;
                }

            } else if(currentTurn == 2) {

                if(damionCurrentHp <= 0) {
                    currentBattleState = BattleState.DECIDE_TURN_ORDER;
                } else {
                    playerHealth.setCurrentHealth(damionCurrentHp);
                    playerHealth.setMaxHealth(damionHpStat);
                    mp.setText(damionCurrentMagic + " / " + damionMagicStat);
                    turn.setText("What will Damion do?");
                    turnPlayer = ImageLoader.load("Damion.png");
                    currentBattleState = BattleState.DAMION_CHOOSE_ATTACK;
                }
            } else if(currentTurn == 3) {
                System.out.println("enemy attack");
                turnPlayer = ImageLoader.load("Empty.png");
                currentBattleState = BattleState.APPLY_ENEMY_DAMAGE;
            }
        } 
        else if (currentBattleState == BattleState.CHOOSE_ATTACK) {
            // if left or right is pressed, change menu item "hovered" over
            if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered--;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered++;
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
        if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0 && !keyLocker.isKeyLocked(Key.SPACE)){
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

        else if (currentBattleState == BattleState.MAYA_CHOOSE_ATTACK) {
            // if left or right is pressed, change menu item "hovered" over

            if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered--;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered++;
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
                currentBattleState = BattleState.MAYA_MAGIC_MENU;
                keyPressTimer = 60;
            }
        }
        }

        else if (currentBattleState == BattleState.DAMION_CHOOSE_ATTACK) {
            // if left or right is pressed, change menu item "hovered" over

            if (Keyboard.isKeyDown(Key.LEFT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered--;
            } else if (Keyboard.isKeyDown(Key.RIGHT) && keyPressTimer == 0) {
                keyPressTimer = 30;
                currentMenuItemHovered++;
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
                currentBattleState = BattleState.DAMION_MAGIC_MENU;
                keyPressTimer = 60;
            }
        }
        }

        else if (currentBattleState == BattleState.APPLY_PLAYER_DAMAGE) {
            int check = ((int)(Math.random() * (100))) + 1;
            hitRate = attackManager.setHitRate(attackType);
            int playerSpeed = 0;
            if(currentTurn == 0) {
                playerSpeed = speedStat;
            } else if(currentTurn == 1) {
                playerSpeed = mayaSpeedStat;
            } else if(currentTurn == 2) {
                playerSpeed = damionSpeedStat;
            }
            if((attackType >= 1 && attackType <= 3 && currentMagic < 2) || (attackType >= 4 && attackType <= 5 && mayaCurrentMagic < 2) || (attackType >= 6 && attackType <= 7 && damionCurrentMagic < 3)) {
                turn.setText("You don't have enough MP to cast!");
                timer++;
                if (timer == 90) {
                    timer = 0;
                    if(currentTurn == 0) {
                        turn.setText("What will you do?");
                        currentBattleState = BattleState.CHOOSE_ATTACK;
                    } else if(currentTurn == 1) {
                        turn.setText("What will Maya do?");
                        currentBattleState = BattleState.MAYA_CHOOSE_ATTACK;
                    } else if(currentTurn == 2) {
                        turn.setText("What will Damion do?");
                        currentBattleState = BattleState.DAMION_CHOOSE_ATTACK;
                    }
                }
            }
            else if (check > ((playerSpeed)*5 + hitRate) - enemyManager.dodge(enemyID)){
                currentBattleState = BattleState.MISS;
            } 
            else {
                if(currentMenuItemHovered != 0) {
                    if(currentTurn == 0) {
                        currentMagic = currentMagic - 2;
                    } else if(currentTurn == 1) {
                        mayaCurrentMagic = mayaCurrentMagic - 2;
                    } else if(currentTurn == 2) {
                        damionCurrentMagic = damionCurrentMagic - 3;
                    }

                }
                if(currentTurn == 0) {
                    hit = attackManager.setHit(attackType, playLevelScreen.attackStat);
                } else if(currentTurn == 1) {
                    hit = attackManager.setHit(attackType, playLevelScreen.mayaAttackStat);
                } else if(currentTurn == 2) {
                    hit = attackManager.setHit(attackType, playLevelScreen.damionAttackStat);
                }
                
                battle.setText(attackManager.setDisplay(attackType, hit, currentTurn)); 
                flagManager.setFlag("Attacking");
                flagManager.unsetFlag("Animation");
                currentBattleState = BattleState.SHOW_PLAYER_DAMAGE;
            }
        }
        else if (currentBattleState == BattleState.MISS) {
            flagManager.unsetFlag("Attacking");
            flagManager.unsetFlag("Animation");
            turn.setText("Whoops, you missed!"); 
            timer++;
            if(timer >= 60) {
                currentBattleState = BattleState.DECIDE_TURN_ORDER;
            }
        }
        else if (currentBattleState == BattleState.SHOW_PLAYER_DAMAGE) {
            if(currentTurn == 0) {
                mp.setText(playLevelScreen.currentMagic + " / " + playLevelScreen.magicStat);
            } else if(currentTurn == 1) {
                mp.setText(playLevelScreen.mayaCurrentMagic + " / " + playLevelScreen.mayaMagicStat);
            } else if(currentTurn == 2) {
                mp.setText(playLevelScreen.damionCurrentMagic + " / " + playLevelScreen.damionMagicStat);
            }
            battle.setText(attackManager.setDisplay(attackType, hit, currentTurn)); 
            flagManager.setFlag("Attacking");
            animation = attackManager.animation(attackType, timer);
            timer++;
            if(timer >= 80 && timer < 90) {
                enemyX = 270;
                enemyY = 180;
            } else if(timer >= 75) {
                enemyX = 265;
                enemyY = 175;
            } else if(timer >= 70) {
                enemyX = 260;
                enemyY = 170;
            } else if(timer >= 65) {
                enemyX = 280;
                enemyY = 170;
            } else if(timer >= 60) {
                enemyX = 280;
                enemyY = 180;
            } else if(timer >= 55) {
                enemyX = 280;
                enemyY = 190;
            } else if(timer >= 50) {
                enemyX = 260;
                enemyY = 190;
            } 
            if(timer == 90) {
                enemyHealth.damage(hit);
                flagManager.unsetFlag("Animation");
                animation = ImageLoader.load("Empty.png");
                flagManager.unsetFlag("Attacking");
                if(enemyHealth.isDead()) {
                    currentBattleState = BattleState.VICTORY;
                } else {
                    enemyX = 270;
                    enemyY = 180;
                    timer = 0;
                    currentBattleState = BattleState.DECIDE_TURN_ORDER;
                }
            }
        

        }
        else if (currentBattleState == BattleState.APPLY_ENEMY_DAMAGE) {
            damage = enemyManager.damage(enemyID);
            flagManager.setFlag("Attacking");
            flagManager.unsetFlag("Animation");
            target = ((((int)(Math.random() * (3)) + 1)) % 3);

            currentBattleState = BattleState.SHOW_ENEMY_DAMAGE;

        }
        else if (currentBattleState == BattleState.SHOW_ENEMY_DAMAGE) {
            if(damage == 0) {
                battle.setText("Whoops, the enemy missed!");
            } else {
                if(target == 0) {
                    battle.setText("You were hit for " + damage + " damage!");
                } else if(target == 1) {
                    battle.setText("Maya was hit for " + damage + " damage!");
                } else if(target == 2) {
                    battle.setText("Damion was hit for " + damage + " damage!");
                }
            }
                
            flagManager.setFlag("Attacking");
            flagManager.unsetFlag("Animation");
            timer++;
            if(timer == 90) {
                if(target == 0) {
                    currentHp = currentHp - damage;
                } else if(target == 1) {
                    mayaCurrentHp = mayaCurrentHp - damage;
                } else if(target == 2) {
                    damionCurrentHp = damionCurrentHp - damage;
                }
                if(this.currentHp<= 0) {
                    playLevelScreen.stopBattle();
                    playLevelScreen.gameOver();
                } else if(enemyID == 666) {
                    if(mayaCurrentHp == 0 && damionCurrentHp == 0){
                        playLevelScreen.gameOver();
                        playLevelScreen.stopBattle();
                    }
                }else  {
                    timer = 0;
                    currentBattleState = BattleState.DECIDE_TURN_ORDER;
                    flagManager.unsetFlag("Attacking");
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
        } else if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0 && !keyLocker.isKeyLocked(Key.SPACE)) {
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

        else if (currentBattleState == BattleState.MAYA_MAGIC_MENU) {
            if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
                keyPressTimer = 20;
                currentMagicAttackHovered++;
            } else if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
                keyPressTimer = 20;
                currentMagicAttackHovered--;
            } else if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
                attackType = currentMagicAttackHovered + 4;
                currentBattleState = BattleState.APPLY_PLAYER_DAMAGE;
            } else {
                if(keyPressTimer > 0) {
                    keyPressTimer--;
                }
            }
            
    
            if(currentMagicAttackHovered > 1){
                currentMagicAttackHovered = 0;
            } else if (currentMagicAttackHovered <0) {
                currentMagicAttackHovered = 1;
            }
            
            //magic menu hover
            //earth
            if (currentMagicAttackHovered == 0) {
                earthAttack.setColor(new Color(255, 215, 0));
            } else if (currentMagicAttackHovered != 0) {
                earthAttack.setColor(new Color(49, 207, 240));
            }
    
    
            //light
            if (currentMagicAttackHovered == 1) {
                lightAttack.setColor(new Color(255, 215, 0));
            } else if (currentMagicAttackHovered != 1) {
                lightAttack.setColor(new Color(49, 207, 240));
            }
     
            }
            else if (currentBattleState == BattleState.DAMION_MAGIC_MENU) {
                if (Keyboard.isKeyDown(Key.UP) && keyPressTimer == 0) {
                    keyPressTimer = 20;
                    currentMagicAttackHovered++;
                } else if (Keyboard.isKeyDown(Key.DOWN) && keyPressTimer == 0) {
                    keyPressTimer = 20;
                    currentMagicAttackHovered--;
                } else if (Keyboard.isKeyDown(Key.SPACE) && keyPressTimer == 0) {
                    attackType = currentMagicAttackHovered + 6;
                    currentBattleState = BattleState.APPLY_PLAYER_DAMAGE;
                } else {
                    if(keyPressTimer > 0) {
                        keyPressTimer--;
                    }
                }
                
        
                if(currentMagicAttackHovered > 1){
                    currentMagicAttackHovered = 0;
                } else if (currentMagicAttackHovered <0) {
                    currentMagicAttackHovered = 1;
                }
                
                //magic menu hover
                //ice
                if (currentMagicAttackHovered == 0) {
                    iceAttack.setColor(new Color(255, 215, 0));
                } else if (currentMagicAttackHovered != 0) {
                    iceAttack.setColor(new Color(49, 207, 240));
                }
        
        
                //dark
                if (currentMagicAttackHovered == 1) {
                    darkAttack.setColor(new Color(255, 215, 0));
                } else if (currentMagicAttackHovered != 1) {
                    darkAttack.setColor(new Color(49, 207, 240));
                }
                }

        else if(currentBattleState == BattleState.VICTORY) {
            flagManager.unsetFlag("Attacking");

            timer--;
            if(timer > 0) {
                turn.setText("You defeated the enemy! Nice work");
            } else if(timer <= 0) {            
                turn.setText("You earned " + (enemyID * 10) + " Experience!");
                
            }
            if(timer == -90) {
                playLevelScreen.exp = playLevelScreen.exp + (enemyID * 10);
                if(enemyID == 666) {
                    playLevelScreen.finish();
                }
                if(playLevelScreen.exp >= (80 + (playLevelScreen.level*20))){
                    currentBattleState = BattleState.LEVEL_UP;
                } else{
                    playLevelScreen.hpStat = hpStat;
                    playLevelScreen.currentHp = playerHealth.getCurrentHealth();
                    playLevelScreen.attackStat = attackStat;
                    playLevelScreen.magicStat = magicStat;
                    playLevelScreen.currentMagic = currentMagic;
                    playLevelScreen.speedStat = speedStat;
                    currentBattleState = BattleState.PURGATORY;
                    this.playLevelScreen.stopBattle();
                }
            }
        }
        else if(currentBattleState == BattleState.LEVEL_UP) {
            turn.setText("Level Up! You are now at Level " + (playLevelScreen.level + 1));
            timer++;
            if(timer == 0) {
                playLevelScreen.level++;
                attackStat = attackStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*2);
                speedStat = speedStat + ((int)(Math.random() * (10))) + playLevelScreen.level;
                hpStat = hpStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*5);
                currentHp = hpStat;
                magicStat = magicStat + ((int)(Math.random() * (10))) + (playLevelScreen.level*3);
                playLevelScreen.exp = playLevelScreen.exp - (80 + (playLevelScreen.level*20));
                playLevelScreen.hpStat = hpStat;
                playLevelScreen.currentHp = currentHp;
                playLevelScreen.attackStat = attackStat;
                playLevelScreen.magicStat = magicStat;
                playLevelScreen.currentMagic = currentMagic;
                playLevelScreen.speedStat = speedStat;
                currentBattleState = BattleState.PURGATORY;
                this.playLevelScreen.stopBattle();
            }
        }
        else if(currentBattleState == BattleState.PURGATORY) {
            if(enemyHealth.isDead()) {

            } else {
                currentBattleState = BattleState.DECIDE_TURN_ORDER;
            }
        }
    }

    public static void setHP(int i) {
        enemyHealth.setCurrentHealth(i);
        enemyHealth.setMaxHealth(i);
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        if(flagManager.isFlagSet("Attacking")) {
            battle.draw(graphicsHandler);
        }
        else {
            turn.draw(graphicsHandler);
        }
        if(!enemyHealth.isDead()) {
            graphicsHandler.drawImage(turnPlayer, 0, 0);
            graphicsHandler.drawImage(enemy1, enemyX, enemyY);
        }
        if(flagManager.isFlagSet("Attacking")) {
            graphicsHandler.drawImage(animation, 240, 150);
        }
       
        if(currentBattleState == BattleState.MAGIC_MENU){
            waterAttack.draw(graphicsHandler);
            fireAttack.draw(graphicsHandler);
            windAttack.draw(graphicsHandler);
        }
        if(currentBattleState == BattleState.MAYA_MAGIC_MENU){
            earthAttack.draw(graphicsHandler);
            lightAttack.draw(graphicsHandler);
        }
        if(currentBattleState == BattleState.DAMION_MAGIC_MENU){
            iceAttack.draw(graphicsHandler);
            darkAttack.draw(graphicsHandler);
        }
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
