package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;
import Screens.BattleScreen;
import Screens.PlayLevelScreen;
import Screens.PlayLevelScreen.PlayLevelScreenState;

import java.util.HashMap;

// This class is for the new custom NPC
public class You extends NPC {
    private boolean isPlayerNearby = false;
    private int interactionRange = 150;
    

    public You(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Final_Boss_390_by_210.png"), 390, 210), "ALERT");
        
    }
    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 4),
                getBounds().getHeight() + (interactionRange * 4)
        );
    }

    @Override
    public void performAction(Player player)  {
        //changes the annimation of the enemy to an angry annimation once you get within a certain bounds
        this.currentAnimationName = "ALERT";

        
        //if the enemy touches the player the battle screen begins and the enemy is  sent away
        if (touching(player)) {
            BattleScreen.setHP(250);
            PlayLevelScreen.enemyID = 666;
            
            this.setLocation(999999,99999);
            PlayLevelScreen.playLevelScreenState = PlayLevelScreenState.ENTERING_BATTLE;

        }

        }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
           put("ALERT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0))
                    .withScale(3)
                    .withBounds(0, 0, 390, 210)
                    .build()
    });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
