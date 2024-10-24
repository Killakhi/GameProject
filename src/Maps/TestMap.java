package Maps;

import EnhancedMapTiles.Coin;
import EnhancedMapTiles.PushableRock;
import Level.*;
import NPCs.*;
import Scripts.SimpleTextScript;
import Scripts.TestMap.*;
import Tilesets.CommonTileset;
import java.util.ArrayList;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(8, 10).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        PushableRock pushableRock = new PushableRock(getMapTile(2, 7).getLocation());
        enhancedMapTiles.add(pushableRock);

        Coin coin1 = new Coin(getMapTile(4, 7).getLocation());
        enhancedMapTiles.add(coin1);

        Coin coin2 = new Coin(getMapTile(7, 9).getLocation());
        enhancedMapTiles.add(coin2);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

       // Walrus walrus = new Walrus(1, getMapTile(4, 19).getLocation().subtractY(40));
        //walrus.setInteractScript(new WalrusScript());
        //npcs.add(walrus);

       // Dinosaur dinosaur = new Dinosaur(2, getMapTile(5, 4).getLocation());
        //dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        //dinosaur.setInteractScript(new DinoScript());
        //npcs.add(dinosaur);
        
        //Bug bug = new Bug(3, getMapTile(7, 12).getLocation().subtractX(20));
        //bug.setInteractScript(new BugScript());
        //npcs.add(bug);

        Goku goku = new Goku(4, getMapTile(3, 1).getLocation().subtractY(40));
        goku.setInteractScript(new GokuScript());
        npcs.add(goku);
        this.enemies.add(goku);

        Bat bat = new Bat(1, getMapTile(11, 15).getLocation().subtractY(40));
        bat.setInteractScript(new BatScript());
        npcs.add(bat);

        Sword sword = new Sword(1, getMapTile(14, 13).getLocation().subtractY(40));
        sword.setInteractScript(new SwordScript());
        npcs.add(sword);

        Wand wand = new Wand(1, getMapTile(6, 19).getLocation().subtractY(40));
        wand.setInteractScript(new WandScript());
        npcs.add(wand);

        Townsfolk townsfolk = new Townsfolk(4, getMapTile(6, 13).getLocation().subtractY(40));
        townsfolk.setInteractScript(new TownsfolkScript());
        npcs.add(townsfolk);

        TownGuy1 townguy1 = new TownGuy1(4, getMapTile(6, 15).getLocation().subtractY(40));
        townguy1.setInteractScript(new TownGuy1Script());
        npcs.add(townguy1);

        Innkeeper innkeeper = new Innkeeper(4, getMapTile(8, 17).getLocation().subtractY(40));
        innkeeper.setInteractScript(new InnkeeperScript());
        npcs.add(innkeeper);



        

        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(15, 16).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 15).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(9, 5).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(7, 18).setInteractScript(new SimpleTextScript("Bat's house"));

        getMapTile(13, 9).setInteractScript(new SimpleTextScript("Sword's house"));
        
        getMapTile(10, 10).setInteractScript(new SimpleTextScript("Wand's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
    }
}

