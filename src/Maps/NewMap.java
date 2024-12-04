package Maps;

import Level.Map;
import Tilesets.CommonTileset;


public class NewMap extends Map {
    
    public NewMap() {
        super("my_new_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(8, 10).getLocation(); 
    }
    
}
