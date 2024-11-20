package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class BossArena extends Map {
    
    public BossArena() {
        super("Boss_Arena.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
