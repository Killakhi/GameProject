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

        PushableRock pushableRock = new PushableRock(getMapTile(2, 0).getLocation());
        enhancedMapTiles.add(pushableRock);

        Coin coin1 = new Coin(getMapTile(9, 15).getLocation());
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

        NPC1 man = new NPC1(3, getMapTile(11, 16).getLocation().subtractY(40));
        man.setInteractScript(new QuestSeekerScript());
        npcs.add(man);
 
 
        NPC2 man2 = new NPC2(11, getMapTile(13, 7).getLocation().subtractY(40));
        man2.setInteractScript(new MysteryQuestScript());
        npcs.add(man2);
 

        Goku goku = new Goku(4, getMapTile(7, 2).getLocation().subtractY(40));
        goku.setInteractScript(new GokuScript());
        npcs.add(goku);
        this.enemies.add(goku);

        Bat bat = new Bat(5, getMapTile(11, 15).getLocation().subtractY(40));
        bat.setInteractScript(new BatScript());
        npcs.add(bat);

        Sword sword = new Sword(6, getMapTile(14, 13).getLocation().subtractY(40));
        sword.setInteractScript(new SwordScript());
        npcs.add(sword);

        Wand wand = new Wand(7, getMapTile(6, 19).getLocation().subtractY(40));
        wand.setInteractScript(new WandScript());
        npcs.add(wand);
        

 
        Maya maya = new Maya(2, getMapTile(9, 10).getLocation().subtractY(40));
        npcs.add(maya);
        this.maya.add(maya);

        Damion damion = new Damion(3, getMapTile(7, 10).getLocation().subtractY(40));
        npcs.add(damion);
        this.damion.add(damion);
        

        Townsfolk townsfolk = new Townsfolk(8, getMapTile(6, 10).getLocation().subtractY(40));
        townsfolk.setInteractScript(new TownsfolkScript());
        npcs.add(townsfolk);

        TownGuy1 townguy1 = new TownGuy1(9, getMapTile(3, 19).getLocation().subtractY(40));
        townguy1.setInteractScript(new TownGuy1Script());
        npcs.add(townguy1);

        Innkeeper innkeeper = new Innkeeper(10, getMapTile(8, 17).getLocation().subtractY(40));
        innkeeper.setInteractScript(new InnkeeperScript());
        npcs.add(innkeeper);

        TownGuy2 townguy2 = new TownGuy2(11, getMapTile(7, 1).getLocation().subtractY(40));
        townguy2.setInteractScript(new TownGuy2Script());
        npcs.add(townguy2);

        Moth moth = new Moth(12, getMapTile(9, 4).getLocation().subtractY(40));
        moth.setInteractScript(new MothScript());
        npcs.add(moth);
        this.enemies.add(moth);

        Imp imp = new Imp(13, getMapTile(14, 10).getLocation().subtractY(40));
        imp.setInteractScript(new ImpScript());
        npcs.add(imp);
        this.enemies.add(imp);

        Cultist cultist = new Cultist(14, getMapTile(14, 15).getLocation().subtractY(40));
        cultist.setInteractScript(new CultistScript());
        npcs.add(cultist);
        this.enemies.add(cultist);

        Door door = new Door(15, getMapTile(2, 17).getLocation().subtractY(40));
        door.setInteractScript(new DoorScript());
        npcs.add(door);

        BossCultist bossCultist = new BossCultist(16, getMapTile(1, 2).getLocation().subtractY(40));
        bossCultist.setInteractScript(new BossCultistScript());
        npcs.add(bossCultist);




        

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

