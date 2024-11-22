/*
 * Diego Matayoshi 11/7/2024
 * 
 * AttackManager Class
 */

package Engine;

import Level.FlagManager;
import Screens.BattleScreen;
import java.awt.image.BufferedImage;

public class AttackManager {
    protected int[] playerSpeed = new int[4];
    protected int[] theTurnOrder = new int[4];
    protected FlagManager flagManager;
    protected BufferedImage animation;
    protected BattleScreen battleScreen;
    protected int attackType;
    protected int attack;
    protected int speed;
    protected int hitRate;
    protected int hit;
    protected String displayAttack;

    public AttackManager(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
    }

    public int[] turnOrder(int[] players, int enemyID) {
        playerSpeed = players;
        if(enemyID == 1) {
            playerSpeed[3] = 10;
        } else if(enemyID == 2) {
            playerSpeed[3] = 20;
        } else if(enemyID == 3) {
            playerSpeed[3] = 0;
        } else if(enemyID == 4) {
            playerSpeed[3] = 17;
        }
        int max = Math.max((Math.max(playerSpeed[0], playerSpeed[1])),(Math.max(playerSpeed[2], playerSpeed[3])));
        int min = Math.min((Math.min(playerSpeed[0], playerSpeed[1])),(Math.min(playerSpeed[2], playerSpeed[3])));
        for(int i = 0; i < 4; i++) {
            if(playerSpeed[i] == max) {
                playerSpeed[i] = 0;
                theTurnOrder[0] = i;
            } else if (playerSpeed[i] == min) {
                playerSpeed[i] = 0;
                theTurnOrder[3] = i;
            }
        }
        max = Math.max((Math.max(playerSpeed[0], playerSpeed[1])),(Math.max(playerSpeed[2], playerSpeed[3])));
        theTurnOrder[1] = max;
        for(int i = 0; i < 4; i++) {
            if(playerSpeed[i] == max) {
                playerSpeed[i] = 0;
                theTurnOrder[1] = i;
            }
        }
        for(int i = 0; i < 4; i++) {
            if(playerSpeed[i] != 0) {
                playerSpeed[i] = 0;
                theTurnOrder[2] = i;
            }
        }
        System.out.println(theTurnOrder[0]);
        System.out.println(theTurnOrder[1]);
        System.out.println("Midway");
        System.out.println(theTurnOrder[2]);
        System.out.println(theTurnOrder[3]);
        System.out.println("Finish");
        return theTurnOrder;
    }

    public int setHit(int attackType, int attack) {
        if(attackType == 0) {
            hit = ((int)(Math.random() * (40))) + attack;
        }
        else if(attackType == 1) {
            hit = ((int)(Math.random() * (20))) + (10 + attack);
        } 
        else if(attackType == 2) {
            hit = ((int)(Math.random() * (10))) + (20 + attack);
        }
        else if(attackType == 3) {
            hit = ((int)(Math.random() * (10))) + (20 + (attack));
        }
        else if(attackType == 4) {
            hit = ((int)(Math.random() * (10))) + (20 + (attack));
        }
        else if(attackType == 5) {
            hit = ((int)(Math.random() * (10))) + (20 + (attack));
        }
        else if(attackType == 6) {
            hit = ((int)(Math.random() * (10))) + (20 + (attack));
        }
        else if(attackType == 7) {
            hit = ((int)(Math.random() * (10))) + (20 + (attack));
        }
        return hit;
    }
    
    public String setDisplay(int attackType, int hit, int turn) {
        if(attackType == 0) {
            if(turn == 0) {
                displayAttack = "You hit for " + hit + " melee damage!";
            } else if(turn == 1) {
                displayAttack = "Maya hit for " + hit + " melee damage!";
            } else if(turn == 2) {
                displayAttack = "Damion hit for " + hit + " melee damage!";
            }
        }
        else if(attackType == 1) {
            displayAttack = "You hit for " + hit + " fire damage!";
        } 
        else if(attackType == 2) {
            displayAttack = "You hit for " + hit + " water damage!";
        }
        else if(attackType == 3) {
            displayAttack = "You hit for " + hit + " wind damage!";
        }
        else if(attackType == 4) {
            displayAttack = "Maya hit for " + hit + " earth damage!";
        }
        else if(attackType == 5) {
            displayAttack = "Maya hit for " + hit + " light damage!";
        }
        else if(attackType == 6) {
            displayAttack = "Damion hit for " + hit + " ice damage!";
        }
        else if(attackType == 7) {
            displayAttack = "Damion hit for " + hit + " dark damage!";
        }
        return displayAttack;
    }

    public int setHitRate(int attackType) {
        if(attackType == 0) {
            hitRate = 1000;
        }
        else if(attackType == 1) {
            hitRate = 20;
        }
        else if(attackType == 2) {
            hitRate = 30;
        }
        else if(attackType == 3) {
            hitRate = 70;
        }
        else if(attackType == 4) {
            hitRate = 10;
        }
        else if(attackType == 5) {
            hitRate = 40;
        }
        else if(attackType == 6) {
            hitRate = 50;
        }
        else if(attackType == 7) {
            hitRate = 20;
        }
        return hitRate;
    }

    public BufferedImage animation(int attackType, int timer) {
        if(attackType == 0) {
            if(timer < 50) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 50 && timer < 57) {
                animation = ImageLoader.load("Melee_1.png");
            } else if (timer >= 57 && timer < 64) {                 
                animation = ImageLoader.load("Melee_2.png");
            } else if (timer >= 64 && timer < 71) {                 
                animation = ImageLoader.load("Melee_3.png");
            } else if (timer >= 71 && timer < 80) {                 
                animation = ImageLoader.load("Melee_4.png");
            } else if (timer >= 80 && timer < 90) {                 
                animation = ImageLoader.load("Melee_5.png");
            }
        }
        if(attackType == 1) {
            if(timer < 30) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 30 && timer < 42) {
                animation = ImageLoader.load("Fire_Magic_1.png");
            } else if (timer >= 42 && timer < 54) {                 
                animation = ImageLoader.load("Fire_Magic_2.png");
            } else if (timer >= 54 && timer < 66) {                 
                animation = ImageLoader.load("Fire_Magic_3.png");
            } else if (timer >= 66 && timer < 78) {                 
                animation = ImageLoader.load("Fire_Magic_4.png");
            } else if (timer >= 78 && timer < 90) {                 
                animation = ImageLoader.load("Fire_Magic_5.png");
            }
            
        }
        if(attackType == 2) {
            if(timer < 30 || (timer >= 50 && timer < 70)) {
                animation = ImageLoader.load("Empty.png");
            } else if ((timer >= 30 && timer < 35) || (timer >= 70 && timer < 75)) {
                animation = ImageLoader.load("Water_Magic_1.png");
            } else if ((timer >= 35 && timer < 40) || (timer >= 75 && timer < 80)) {                 
                animation = ImageLoader.load("Water_Magic_2.png");
            } else if ((timer >= 40 && timer < 45) || (timer >= 80 && timer < 85)) {                 
                animation = ImageLoader.load("Water_Magic_3.png");
            } else if ((timer >= 45 && timer < 50) || (timer >= 85 && timer < 90)) {                 
                animation = ImageLoader.load("Water_Magic_4.png");
            }
            
        }
        if(attackType == 3) {
            if(timer < 30) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 30 && timer < 40) {
                animation = ImageLoader.load("Wind_Magic_1.png");
            } else if (timer >= 40 && timer < 50) {                 
                animation = ImageLoader.load("Wind_Magic_2.png");
            } else if (timer >= 50 && timer < 60) {                 
                animation = ImageLoader.load("Wind_Magic_3.png");
            } else if (timer >= 60 && timer < 70) {                 
                animation = ImageLoader.load("Wind_Magic_4.png");
            } else if (timer >= 70 && timer < 80) {                 
                animation = ImageLoader.load("Wind_Magic_5.png");
            } else if (timer >= 80 && timer < 90) {
                animation = ImageLoader.load("Wind_Magic_6.png");
            }
        }
        if(attackType == 4) {
            if(timer < 20) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 20 && timer < 25) {
                animation = ImageLoader.load("Earth_Magic_1.png");
            } else if (timer >= 25 && timer < 30) {                 
                animation = ImageLoader.load("Earth_Magic_2.png");
            } else if (timer >= 30 && timer < 60) {                 
                animation = ImageLoader.load("Earth_Magic_3.png");
            } else if (timer >= 60 && timer < 70) {                 
                animation = ImageLoader.load("Earth_Magic_4.png");
            } else if (timer >= 70 && timer < 80) {                 
                animation = ImageLoader.load("Earth_Magic_5.png");
            } else if (timer >= 80 && timer < 90) {
                animation = ImageLoader.load("Earth_Magic_6.png");
            }
        }
        if(attackType == 5) {
            if(timer < 20) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 20 && timer < 25) {
                animation = ImageLoader.load("Light_Magic_1.png");
            } else if (timer >= 25 && timer < 30) {                 
                animation = ImageLoader.load("Light_Magic_2.png");
            } else if (timer >= 30 && timer < 35) {                 
                animation = ImageLoader.load("Light_Magic_3.png");
            } else if (timer >= 35 && timer < 40) {                 
                animation = ImageLoader.load("Light_Magic_4.png");
            } else if (timer >= 40 && timer < 45) {                 
                animation = ImageLoader.load("Light_Magic_5.png");
            } else if (timer >= 45 && timer < 70) {
                animation = ImageLoader.load("Light_Magic_6.png");
            } else if (timer >= 70 && timer < 75) {
                animation = ImageLoader.load("Light_Magic_7.png");
            } else if (timer >= 75 && timer < 80) {
                animation = ImageLoader.load("Light_Magic_8.png");
            } else if (timer >= 80 && timer < 85) {
                animation = ImageLoader.load("Light_Magic_9.png");
            } else if (timer >= 85 && timer < 90) {
                animation = ImageLoader.load("Light_Magic_10.png");
            }
        }

        if(attackType == 6) {
            if(timer < 20) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 20 && timer < 30) {
                animation = ImageLoader.load("Ice_Magic_1.png");
            } else if(timer >= 30 && timer < 40) {
                animation = ImageLoader.load("Ice_Magic_2.png");
            } else if (timer >= 40 && timer < 50) {                 
                animation = ImageLoader.load("Ice_Magic_3.png");
            } else if (timer >= 50 && timer < 60) {                 
                animation = ImageLoader.load("Ice_Magic_4.png");
            } else if (timer >= 60 && timer < 70) {                 
                animation = ImageLoader.load("Ice_Magic_5.png");
            } else if (timer >= 70 && timer < 80) {                 
                animation = ImageLoader.load("Ice_Magic_6.png");
            } else if (timer >= 80 && timer < 90) {
                animation = ImageLoader.load("Ice_Magic_7.png");
            } 
        }

        if(attackType == 7) {
            if(timer < 30) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 30 && timer < 40) {
                animation = ImageLoader.load("Dark_Magic_1.png");
            } else if (timer >= 40 && timer < 45) {                 
                animation = ImageLoader.load("Dark_Magic_2.png");
            } else if (timer >= 45 && timer < 50) {                 
                animation = ImageLoader.load("Dark_Magic_3.png");
            } else if (timer >= 50 && timer < 55) {                 
                animation = ImageLoader.load("Dark_Magic_4.png");
            } else if (timer >= 55 && timer < 60) {                 
                animation = ImageLoader.load("Dark_Magic_5.png");
            } else if (timer >= 60 && timer < 65) {
                animation = ImageLoader.load("Dark_Magic_6.png");
            } else if (timer >= 65 && timer < 70) {
                animation = ImageLoader.load("Dark_Magic_7.png");
            } else if (timer >= 70 && timer < 75) {
                animation = ImageLoader.load("Dark_Magic_8.png");
            } else if (timer >= 75 && timer < 80) {
                animation = ImageLoader.load("Dark_Magic_9.png");
            } else if (timer >= 80 && timer < 90) {
                animation = ImageLoader.load("Dark_Magic_10.png");
            }
        }
        return animation;
    }
}
