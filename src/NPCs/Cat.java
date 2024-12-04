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
public class Cat extends NPC {
    public static int direction = -1;
   

    public Cat(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Cat Party Member.png"), 32, 32), "STAND");
        isUncollidable = true;
    }
    
    public static void setDirection(int i) {
        direction = i;
    }

    @Override
    public void performAction(Player player)  {
        //changes the annimation of the enemy to an angry annimation once you get within a certain bounds
        //
        if(direction == 0) {
            this.currentAnimationName = "WALK_UP";
        } else if(direction == 1) {
            this.currentAnimationName = "WALK_LEFT";
        } else if(direction == 2) {
            this.currentAnimationName = "WALK_DOWN";
        } else if(direction == 3) {
            this.currentAnimationName = "WALK_RIGHT";
        } else {
            this.currentAnimationName = "STAND";
        }
    }

    

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("WALK_DOWN", new Frame[]  {
                new FrameBuilder(spriteSheet.getSprite(1, 0), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 1), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 2), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(1, 3), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build()
           });
            put("WALK_LEFT", new Frame[]  {
                new FrameBuilder(spriteSheet.getSprite(5, 0), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 1), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 2), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(5, 3), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build()
           });
            put("WALK_RIGHT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(4, 0), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
                new FrameBuilder(spriteSheet.getSprite(4, 1), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(4, 2), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build(),
                new FrameBuilder(spriteSheet.getSprite(4, 3), 14)
                    .withScale(3)
                    .withBounds(6, 12, 12, 7)
                    .build()
           });
           put("WALK_UP", new Frame[]  {
            new FrameBuilder(spriteSheet.getSprite(2, 0), 14)
            .withScale(3)
            .withBounds(6, 12, 12, 7)
            .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 1), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 2), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(2, 3), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build()
       });
           put("STAND", new Frame[] {
            new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
            new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                .withScale(3)
                .withBounds(6, 12, 12, 7)
                .build(),
    });
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
