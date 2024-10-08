package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.Money;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Point;

public class Coin extends EnhancedMapTile {
    public Coin(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Coin.png"), 16, 16), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player);
        if (player.touching(this) && !this.isHidden) {
            this.isHidden = true;
            Money.INSTANCE.give(25);
        }
    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(3)
                .build();
        return new GameObject(x, y, frame);
    }
}
