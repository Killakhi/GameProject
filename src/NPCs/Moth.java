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
import Screens.PlayLevelScreen;
import Screens.PlayLevelScreen.PlayLevelScreenState;

import java.util.HashMap;

// This class is for the new custom NPC
public class Moth extends NPC {
    private boolean isPlayerNearby = false;
    private int interactionRange = 50;
    
    
   

    public Moth(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Moth.png"), 27, 27), "STAND_LEFT");
        
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
        if(this.getInteractionRange().intersects(player.getBounds())){
            if(!isPlayerNearby){
                isPlayerNearby = true;
                this.currentAnimationName = "ALERT";
            }
        } else {
            if(isPlayerNearby) {
                isPlayerNearby = false;
                this.currentAnimationName = "STAND_LEFT";
            }
        }

        
        //if the enemy touches the player the battle screen begins and the enemy is  sent away
        if (touching(player)) {
            PlayLevelScreen.playLevelScreenState = PlayLevelScreenState.ENTERING_BATTLE;
            PlayLevelScreen.enemyID = 2;
            
            this.setLocation(999999,99999);
        }

        }



    

        


    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0))
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(1, 0))
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build()
           });
           put("ALERT", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0))
                    .withScale(3)
                    .withBounds(7, 13, 11, 7)
                    .build()
    });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
