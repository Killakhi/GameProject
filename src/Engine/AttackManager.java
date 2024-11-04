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
    public AttackManager(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
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
        return animation;
    }
}
