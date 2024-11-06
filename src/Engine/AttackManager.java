/*
 * Diego Matayoshi 11/7/2024
 * 
 * AttackManager Class
 */

package Engine;

import java.awt.image.BufferedImage;

import Level.FlagManager;
import Screens.BattleScreen;

public class AttackManager {
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
        return hit;
    }
    
    public String setDisplay(int attackType, int hit) {
        if(attackType == 0) {
            displayAttack = "You hit for " + hit + " melee damage!";
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
        return displayAttack;
    }

    public int setHitRate(int attackType) {
        if(attackType == 0) {
            hitRate = 100;
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
        return hitRate;
    }

    public BufferedImage animation(int attackType, int timer) {
        if(attackType == 0) {
            if(timer < 60) {
                animation = ImageLoader.load("Empty.png");
            } else if(timer >= 60 && timer < 66) {
                animation = ImageLoader.load("Melee_1.png");
            } else if (timer >= 66 && timer < 72) {                 
                animation = ImageLoader.load("Melee_2.png");
            } else if (timer >= 72 && timer < 78) {                 
                animation = ImageLoader.load("Melee_3.png");
            } else if (timer >= 78 && timer < 84) {                 
                animation = ImageLoader.load("Melee_4.png");
            } else if (timer >= 84 && timer < 90) {                 
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
        return animation;
    }
}
