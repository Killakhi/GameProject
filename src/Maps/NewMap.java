package Maps;

import Level.Map;
import Level.NPC;
import NPCs.Cat;
import NPCs.NPC3;
import NPCs.SusCat;
import NPCs.Taverncat;
import Scripts.TestMap.CatScript;
import Scripts.TestMap.NormalCatScript;
import Scripts.TestMap.NormalGuyScript;
import Scripts.TestMap.SusCatScript;
import Tilesets.CommonTileset;
import java.util.ArrayList;

public class NewMap extends Map {
    
    public NewMap() {
        super("my_new_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(1, 5).getLocation(); 
    }

     public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Cat cat = new Cat(4, getMapTile(6, 5).getLocation().subtractY(40));
        cat.setInteractScript(new CatScript());
        npcs.add(cat);

        SusCat susCat = new SusCat(5, getMapTile(8,8).getLocation().subtractY(40));
        susCat.setInteractScript(new SusCatScript());
        npcs.add(susCat);

        Taverncat normalCat = new Taverncat(6, getMapTile(2, 7).getLocation().subtractY(40));
        normalCat.setInteractScript(new NormalCatScript());
        npcs.add(normalCat);

        NPC3 npc3 = new NPC3(5, getMapTile(0, 3).getLocation().subtractY(40));
        npc3.setInteractScript(new NormalGuyScript());
        npcs.add(npc3);
       
        return npcs;
    }
    
}
