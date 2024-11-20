package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.HealthBar;
import GameObject.SpriteSheet;
import Level.Player;
import java.util.HashMap;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Cat extends Player {

    public Cat(float x, float y) {
        super(new SpriteSheet(ImageLoader.load("Main Character New Sprite Sheet.png"), 20, 31), x, y, "STAND_RIGHT");
        walkSpeed = 2.3f;

        this.healthBar = new HealthBar(100, 100);
        this.healthBar.setVisible(false);
    }

    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
    
    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(4, 0), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 1), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(4, 2), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
            });

            put("STAND_LEFT", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(3, 0), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 1), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(3, 2), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
            });

            put("STAND_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(7, 0), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 1), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(7, 2), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),

            });

            put("STAND_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(0, 0), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 1), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),
                new FrameBuilder(spriteSheet.getSprite(0, 2), 14)
                        .withScale(3)
                        .withBounds(3, 1, 15, 30)
                        .build(),

            });
         
            

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(5, 0), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 1), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 2), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(5, 3), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build()
            });

            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(2, 0), 14)
                            .withScale(3)
                            //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 1), 14)
                            .withScale(3)
                           // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 2), 14)
                            .withScale(3)
                           // .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(2, 3), 14)
                            .withScale(3)
                            //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(3, 1, 15, 30)
                            .build()
            });

            put("WALK_UP", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(6, 0), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(6, 1), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(6, 2), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(6, 3), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build()
           });
          
           put("WALK_DOWN", new Frame[] {
                new FrameBuilder(spriteSheet.getSprite(1, 0), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 14)
                            .withScale(3)
                            .withBounds(3, 1, 15, 30)
                            .build()
           });

        }};
       
    }
}
