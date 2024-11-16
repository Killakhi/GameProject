package Maps;

import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class NewMap extends Map {
    
    public NewMap() {
        super("my_new_map.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }
}
