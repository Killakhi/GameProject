package Engine;

import java.awt.image.BufferedImage;

public class EnemyManager {
    protected int enemyID;
    protected BufferedImage enemy;
    protected int damage;
    protected int dodge;
    public EnemyManager() {

    }

    public BufferedImage setSprite(int enemyID) {
        this.enemyID = enemyID;
        if(enemyID == 1) {
            enemy = ImageLoader.load("Ghost Angy Battle.png");
        } else if (enemyID ==2) {
            enemy = ImageLoader.load("angryMoth1.0.png");
        } else if (enemyID ==3) {
            enemy = ImageLoader.load("ImpBattle1.0.png");
        } else if (enemyID ==4) {
            enemy = ImageLoader.load("CultistBattle.png");
             
        }
        return enemy;
    }
    public int dodge(int enemyID) {
        if(enemyID == 1) {
            dodge = 0;
        }
        return dodge;
    }
    public int damage(int enemyID) {
        if(enemyID == 1) {
            int hitRate = ((int)(Math.random() * (100))) + 1;
            if(hitRate < 90){
                damage = ((int)(Math.random() * (10))) + 10;
            } else {
                damage = 0;
            }
        }
        return damage;
    }
}
