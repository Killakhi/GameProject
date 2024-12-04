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
        } else if (enemyID == 666) {
            //Final boss sprite
            enemy = ImageLoader.load("Final_Boss_650_by_350.png");
        }
        return enemy;
    }
    public int dodge(int enemyID) {
        if(enemyID == 1) {
            dodge = 0;
        } else if(enemyID ==2) {
            dodge =40;
        } else if(enemyID ==3){
            dodge =20;
        } else if(enemyID ==4){
            dodge = 4;
        } else if(enemyID == 666) {
            dodge = 30;
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
        } else if (enemyID == 2) {
            int hitRate = ((int)(Math.random() * (100))) + 1;
            if(hitRate < 99){
                damage = ((int)(Math.random() * (10)));
            } else {
                damage = 0;
            }
        } else if (enemyID == 3) {
            int hitRate = ((int)(Math.random() * (100))) + 1;
            if(hitRate < 80){
                damage = ((int)(Math.random() * (10))) + 15;
            } else {
                damage = 0;
            }
        } else if (enemyID == 4) {
            int hitRate = ((int)(Math.random() * (100))) + 1;
            if(hitRate < 20){
                damage = ((int)(Math.random() * (30))) + 50;
            } else {
                damage = 0;
            }
        } else if (enemyID == 666) {
                damage = ((int)(Math.random() * (30))) + 10;
        }
        return damage;
    }
}
