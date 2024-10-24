package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;
import Screens.PlayLevelScreen;
import Screens.PlayLevelScreen.PlayLevelScreenState;

import java.util.HashMap;

// This class is for the new custom NPC
public class Goku extends NPC {
    
    
   

    public Goku(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Ghost.png"), 30, 30), "STAND_LEFT");
        
    }

    @Override
    public void performAction(Player player)  {
        
        if (touching(player)) {
            PlayLevelScreen.playLevelScreenState = PlayLevelScreenState.ENTERING_BATTLE;
            
            
            //System.out.println("WHY DID YOU KILL ME");
            //delete npc once touched?
            this.setLocation(999999,99999);
        }

//not working rn
      //  if(touching(player)){
        //    new SpriteSheet(ImageLoader.load("Walrus.png"), 24, 24);

       // }



    }

        

//use bounds to intersect player
    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
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
