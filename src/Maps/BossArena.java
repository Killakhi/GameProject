package Maps;

import Level.Map;
import Level.NPC;
import NPCs.You;
import Tilesets.CommonTileset;
import Utils.Point;
import java.util.ArrayList;

public class BossArena extends Map {
    
    public BossArena() {
        super("Boss_Arena.txt", new CommonTileset());
        this.playerStartPosition = new Point(1, 11);
    }

    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        You you = new You(4, getMapTile(2, 2).getLocation().subtractY(40));
        npcs.add(you);

        
        return npcs;
    }
}
