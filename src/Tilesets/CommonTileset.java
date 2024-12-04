package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;
import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("Tilesheet.png"), 32, 32, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // Tile 1: lightGrass1
        Frame lightGrass1Frame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass1Tile = new MapTileBuilder(lightGrass1Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightGrass1Tile);

        // Tile 2: lightGrass2

        Frame lightGrass2Frame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass2Tile = new MapTileBuilder(lightGrass2Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightGrass2Tile);

        // Tile 3: lightGrass3

        Frame lightGrass3Frame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass3Tile = new MapTileBuilder(lightGrass3Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightGrass3Tile);

        // Tile 4: lightGrass4

        Frame lightGrass4Frame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass4Tile = new MapTileBuilder(lightGrass4Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightGrass4Tile);

        // Tile 5: darkGrass1

        Frame darkGrass1Frame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkGrass1Tile = new MapTileBuilder(darkGrass1Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkGrass1Tile);

        // Tile 6: darkGrass2

        Frame darkGrass2Frame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkGrass2Tile = new MapTileBuilder(darkGrass2Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkGrass2Tile);

         // Tile 7: darkGrass3

         Frame darkGrass3Frame = new FrameBuilder(getSubImage(0, 6))
         .withScale(tileScale)
         .build();

        MapTileBuilder darkGrass3Tile = new MapTileBuilder(darkGrass3Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkGrass3Tile);

        // Tile 8: darkGrass4

        Frame darkGrass4Frame = new FrameBuilder(getSubImage(0, 7))
        .withScale(tileScale)
        .build();

       MapTileBuilder darkGrass4Tile = new MapTileBuilder(darkGrass4Frame)
       .withTopLayer(darkGrass4Frame)
       .withTileType(TileType.PASSABLE);
       mapTiles.add(darkGrass4Tile);

       // Tile 9: lightupsideDownpathway

       Frame lightupsideDownpathwayFrame = new FrameBuilder(getSubImage(0, 8))
       .withScale(tileScale)
       .build();

      MapTileBuilder lightupsideDownpathwayTile = new MapTileBuilder(lightupsideDownpathwayFrame)
      .withTileType(TileType.PASSABLE);
      mapTiles.add(lightupsideDownpathwayTile);

      // Tile 10: lightrightPathway

      Frame lightrightPathwayFrame = new FrameBuilder(getSubImage(0, 9))
      .withScale(tileScale)
      .build();

     MapTileBuilder lightrightPathwayTile = new MapTileBuilder(lightrightPathwayFrame)
     .withTileType(TileType.PASSABLE);
     mapTiles.add(lightrightPathwayTile);

     // Tile 11: lightleftPathway

     Frame lightleftPathwayFrame = new FrameBuilder(getSubImage(0, 10))
     .withScale(tileScale)
     .build();

    MapTileBuilder lightleftPathwayTile = new MapTileBuilder(lightleftPathwayFrame)
    .withTileType(TileType.PASSABLE);
    mapTiles.add(lightleftPathwayTile);

    // Tile 12: lightdownPathway

    Frame lightdownPathwayFrame = new FrameBuilder(getSubImage(1, 0))
    .withScale(tileScale)
    .build();

   MapTileBuilder lightdownPathwayTile = new MapTileBuilder(lightdownPathwayFrame)
   .withTileType(TileType.PASSABLE);
   mapTiles.add(lightdownPathwayTile);

        // Tile 13: downDarkpathway

        Frame downDarkpathwayFrame = new FrameBuilder(getSubImage(1, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder downDarkpathwayTile = new MapTileBuilder(downDarkpathwayFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(downDarkpathwayTile);

        // Tile 14: rightDarkpathway

        Frame rightDarkpathwayFrame = new FrameBuilder(getSubImage(1, 2))
         .withScale(tileScale)
        .build();

        MapTileBuilder rightDarkpathwayTile = new MapTileBuilder(rightDarkpathwayFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(rightDarkpathwayTile);

        // Tile 15: leftDarkpathway

        Frame leftDarkpathwayFrame = new FrameBuilder(getSubImage(1, 3))
         .withScale(tileScale)
        .build();

        MapTileBuilder leftDarkpathwayTile = new MapTileBuilder(leftDarkpathwayFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(leftDarkpathwayTile);

        // Tile 16: upsidedownDarkpathway

        Frame upsidedownDarkpathwayFrame = new FrameBuilder(getSubImage(1, 4))
         .withScale(tileScale)
        .build();

        MapTileBuilder upsidedownDarkpathwayTile = new MapTileBuilder(upsidedownDarkpathwayFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(upsidedownDarkpathwayTile);

        // Tile 17: darkBigleaves

        Frame darkBigleavesFrame = new FrameBuilder(getSubImage(1, 5))
         .withScale(tileScale)
        .build();

        MapTileBuilder darkBigleavesTile = new MapTileBuilder(darkBigleavesFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkBigleavesTile);

        // Tile 18: lightBigleaves

        Frame lightBigleavesFrame = new FrameBuilder(getSubImage(1, 6))
         .withScale(tileScale)
        .build();

        MapTileBuilder lightBigleavesTile = new MapTileBuilder(lightBigleavesFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightBigleavesTile);

        // Tile 19: bottomleftlightCornerpath

        Frame bottomleftlightCornerpathFrame = new FrameBuilder(getSubImage(1, 7))
         .withScale(tileScale)
        .build();

        MapTileBuilder bottomleftlightCornerpathTile = new MapTileBuilder(bottomleftlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomleftlightCornerpathTile);

        // Tile 20: topleftlightCornerpath

        Frame topleftlightCornerpathFrame = new FrameBuilder(getSubImage(1, 8))
         .withScale(tileScale)
        .build();

        MapTileBuilder topleftlightCornerpathTile = new MapTileBuilder(topleftlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(topleftlightCornerpathTile);

        // Tile 21: lightopRightcornerpath

        Frame lightopRightcornerpathFrame = new FrameBuilder(getSubImage(1, 9))
         .withScale(tileScale)
        .build();

        MapTileBuilder lightopRightcornerpathTile = new MapTileBuilder(lightopRightcornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(lightopRightcornerpathTile);

        // Tile 22: smalltopleftlightCornerpath

        Frame smalltopleftlightCornerpathFrame = new FrameBuilder(getSubImage(1, 10))
         .withScale(tileScale)
        .build();

        MapTileBuilder smalltopleftlightCornerpathTile = new MapTileBuilder(smalltopleftlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smalltopleftlightCornerpathTile);

        // Tile 23: smalltoprightlightCornerpath

        Frame smalltoprightlightCornerpathFrame = new FrameBuilder(getSubImage(2, 0))
         .withScale(tileScale)
        .build();

        MapTileBuilder smalltoprightlightCornerpathTile = new MapTileBuilder(smalltoprightlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smalltoprightlightCornerpathTile);

         // Tile 24: bottomrightlightCornerpath

         Frame bottomrightlightCornerpathFrame = new FrameBuilder(getSubImage(2, 1))
         .withScale(tileScale)
        .build();

        MapTileBuilder bottomrightlightCornerpathTile = new MapTileBuilder(bottomrightlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomrightlightCornerpathTile);

        // Tile 25: smallbottomrightlightCornerpath

        Frame smallbottomrightlightCornerpathFrame = new FrameBuilder(getSubImage(2, 2))
        .withScale(tileScale)
       .build();

       MapTileBuilder smallbottomrightlightCornerpathTile = new MapTileBuilder(smallbottomrightlightCornerpathFrame)
       .withTileType(TileType.PASSABLE);
       mapTiles.add(smallbottomrightlightCornerpathTile);

       // Tile 26: bottomleftdarkCornerpath

       Frame bottomleftdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 3))
       .withScale(tileScale)
      .build();

      MapTileBuilder bottomleftdarkCornerpathTile = new MapTileBuilder(bottomleftdarkCornerpathFrame)
      .withTileType(TileType.PASSABLE);
      mapTiles.add(bottomleftdarkCornerpathTile);

      // Tile 27: topleftdarkCornerpath

        Frame topleftdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder topleftdarkCornerpathTile = new MapTileBuilder(topleftdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(topleftdarkCornerpathTile);

        // Tile 28: toprighttdarkCornerpath

        Frame toprighttdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder toprighttdarkCornerpathTile = new MapTileBuilder(toprighttdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(toprighttdarkCornerpathTile);

        // Tile 29: smalltopleftdarkCornerpath

        Frame smalltopleftdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 6))
        .withScale(tileScale)
        .build();

        MapTileBuilder smalltopleftdarkCornerpathTile = new MapTileBuilder(smalltopleftdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smalltopleftdarkCornerpathTile);

        // Tile 30: smalltoprightdarkCornerpath

        Frame smalltoprightdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 7))
        .withScale(tileScale)
        .build();

        MapTileBuilder smalltoprightdarkCornerpathTile = new MapTileBuilder(smalltoprightdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smalltoprightdarkCornerpathTile);

        // Tile 31: bottomrightdarkCornerpath

        Frame bottomrightdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 8))
        .withScale(tileScale)
        .build();

        MapTileBuilder bottomrightdarkCornerpathTile = new MapTileBuilder(bottomrightdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomrightdarkCornerpathTile);

        // Tile 32: smallbottomrightdarkCornerpath

        Frame smallbottomrightdarkCornerpathFrame = new FrameBuilder(getSubImage(2, 9))
        .withScale(tileScale)
        .build();

        MapTileBuilder smallbottomrightdarkCornerpathTile = new MapTileBuilder(smallbottomrightdarkCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smallbottomrightdarkCornerpathTile);

        // Tile 33: bottomleftdarkandlightCornerpath

        Frame bottomleftdarkandlightCornerpathFrame = new FrameBuilder(getSubImage(2, 10))
        .withScale(tileScale)
        .build();

        MapTileBuilder bottomleftdarkandlightCornerpathTile = new MapTileBuilder(bottomleftdarkandlightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomleftdarkandlightCornerpathTile);

        // Tile 34: topdarkleftCornerpath

        Frame topdarkleftCornerpathFrame = new FrameBuilder(getSubImage(3, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder topdarkleftCornerpathTile = new MapTileBuilder(topdarkleftCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(topdarkleftCornerpathTile);

        // Tile 35: topdarkrightCornerpath

        Frame topdarkrightCornerpathFrame = new FrameBuilder(getSubImage(3, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder topdarkrightCornerpathTile = new MapTileBuilder(topdarkrightCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(topdarkrightCornerpathTile);

        // Tile 36: smalltopdarkleftCornerpath

        Frame smalltopdarkleftCornerpathFrame = new FrameBuilder(getSubImage(3, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder smalltopdarkleftCornerpathTile = new MapTileBuilder(smalltopdarkleftCornerpathFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(smalltopdarkleftCornerpathTile);

         // Tile 37: smalltopdarkrightCornerpath

         Frame smalltopdarkrightCornerpathFrame = new FrameBuilder(getSubImage(3, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder smalltopdarkrightCornerpathTile = new MapTileBuilder(smalltopdarkrightCornerpathFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(smalltopdarkrightCornerpathTile);

         // Tile 38: bottomdarkrightCornerpath

         Frame bottomdarkrightCornerpathFrame = new FrameBuilder(getSubImage(3, 4))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomdarkrightCornerpathTile = new MapTileBuilder(bottomdarkrightCornerpathFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomdarkrightCornerpathTile);

         // Tile 39: bottomdarksmallrightCornerpath

         Frame bottomdarksmallrightCornerpathFrame = new FrameBuilder(getSubImage(3, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomdarksmallrightCornerpathTile = new MapTileBuilder(bottomdarksmallrightCornerpathFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomdarksmallrightCornerpathTile);

         // Tile 40: Wood

         Frame WoodFrame = new FrameBuilder(getSubImage(3, 6))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder WoodTile = new MapTileBuilder(WoodFrame)
         .withTopLayer(WoodFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(WoodTile);

         // Tile 41: Woodwithbanners

         Frame WoodwithbannersFrame = new FrameBuilder(getSubImage(3, 7))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder WoodwithbannersTile = new MapTileBuilder(WoodwithbannersFrame)
         .withTopLayer(WoodwithbannersFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(WoodwithbannersTile);

         // Tile 42: treeWood

         Frame treeWoodFrame = new FrameBuilder(getSubImage(3, 8))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder treeWoodTile = new MapTileBuilder(treeWoodFrame)
         .withTopLayer(treeWoodFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(treeWoodTile);

         // Tile 43: MiddleofTree

         Frame regularGrassFrame = new FrameBuilder(getSubImage(3, 9))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder regularGrassTile = new MapTileBuilder(regularGrassFrame)
         .withTopLayer(regularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(regularGrassTile);

         // Tile 44: leftroundofTree

         Frame leftroundregularGrassFrame = new FrameBuilder(getSubImage(3, 10))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftroundregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(leftroundregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(leftroundregularGrassTile);

         // Tile 45: rightrightroundoftree

         Frame rightroundregularGrassFrame = new FrameBuilder(getSubImage(4, 0))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightroundregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(rightroundregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(rightroundregularGrassTile);

         // Tile 46: toprightcornerregularGrass

         Frame toprightcornerregularGrassFrame = new FrameBuilder(getSubImage(4, 1))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder toprightcornerregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(toprightcornerregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(toprightcornerregularGrassTile);

         // Tile 47: topleftcornerregularGrass

         Frame topleftcornerregularGrassFrame = new FrameBuilder(getSubImage(4, 2))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topleftcornerregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(topleftcornerregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(topleftcornerregularGrassTile);

         // Tile 48: bottomrightcornerregularGrass

         Frame bottomrightcornerregularGrassFrame = new FrameBuilder(getSubImage(4, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomrightcornerregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(bottomrightcornerregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomrightcornerregularGrassTile);

         // Tile 49: bottomleftcornerregularGrass

         Frame bottomleftcornerregularGrassFrame = new FrameBuilder(getSubImage(4, 4))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomleftcornerregularGrassTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(bottomleftcornerregularGrassFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomleftcornerregularGrassTile);

         // Tile 50: bottomregularGrass1

         Frame bottomregularGrass1Frame = new FrameBuilder(getSubImage(4, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomregularGrass1Tile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(bottomregularGrass1Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomregularGrass1Tile);

         // Tile 51: bottomregularGrass2

         Frame bottomregularGrass2Frame = new FrameBuilder(getSubImage(4, 6))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomregularGrass2Tile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(bottomregularGrass2Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(bottomregularGrass2Tile);

         // Tile 52: Treewood2

         Frame Treewood2Frame = new FrameBuilder(getSubImage(4, 7))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder Treewood2Tile = new MapTileBuilder(Treewood2Frame)
         .withTopLayer(Treewood2Frame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(Treewood2Tile);

         // Tile 53: balloons

         Frame balloonsFrame = new FrameBuilder(getSubImage(4, 8))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder balloonsTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(balloonsFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(balloonsTile);

         // Tile 54: window

         Frame windowFrame = new FrameBuilder(getSubImage(4, 9))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder windowTile = new MapTileBuilder(windowFrame)
         .withTopLayer(windowFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(windowTile);

         // Tile 55: windowPanel

         Frame windowPanelFrame = new FrameBuilder(getSubImage(4, 10))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder windowPanelTile = new MapTileBuilder(windowPanelFrame)
         .withTopLayer(windowPanelFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(windowPanelTile);

         // Tile 56: sand1

         Frame sand1Frame = new FrameBuilder(getSubImage(5, 0))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder sand1Tile = new MapTileBuilder(sand1Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(sand1Tile);

         // Tile 57: sand2

         Frame sand2Frame = new FrameBuilder(getSubImage(5, 1))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder sand2Tile = new MapTileBuilder(sand2Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(sand2Tile);

         // Tile 58: door

         Frame doorFrame = new FrameBuilder(getSubImage(5, 2))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(doorTile);

         // Tile 59: rightroofEdge

         Frame rightroofEdgeFrame = new FrameBuilder(getSubImage(5, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightroofEdgeTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(rightroofEdgeFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(rightroofEdgeTile);

         // Tile 60: leftroofEdge

         Frame leftroofEdgeFrame = new FrameBuilder(getSubImage(5, 4))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftroofEdgeTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(leftroofEdgeFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(leftroofEdgeTile);

         // Tile 61: leftroofAndhouse

         Frame leftroofAndhouseFrame = new FrameBuilder(getSubImage(5, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftroofAndhouseTile = new MapTileBuilder(leftroofAndhouseFrame)
         .withTopLayer(leftroofAndhouseFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(leftroofAndhouseTile);

         // Tile 62: topLeftroof

         Frame topLeftroofFrame = new FrameBuilder(getSubImage(5, 6))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topLeftroofTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(topLeftroofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(topLeftroofTile);

         // Tile 63: leftRoof

         Frame leftRoofFrame = new FrameBuilder(getSubImage(5, 7))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftRoofTile = new MapTileBuilder(leftRoofFrame)
         .withTopLayer(leftRoofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(leftRoofTile);

         // Tile 64: rightRoof

         Frame rightRoofFrame = new FrameBuilder(getSubImage(5, 8))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightRoofTile = new MapTileBuilder(rightRoofFrame)
         .withTopLayer(rightRoofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(rightRoofTile);

         // Tile 65: rightRoof2

         Frame rightRoof2Frame = new FrameBuilder(getSubImage(5, 9))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightRoof2Tile = new MapTileBuilder(rightRoof2Frame)
         .withTopLayer(rightRoof2Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(rightRoof2Tile);

         // Tile 66: tophouseAndrightroof

         Frame tophouseAndrightroofFrame = new FrameBuilder(getSubImage(5, 10))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder tophouseAndrightroofTile = new MapTileBuilder(tophouseAndrightroofFrame)
         .withTopLayer(tophouseAndrightroofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(tophouseAndrightroofTile);

         // Tile 67: topRightroof

         Frame topRightroofFrame = new FrameBuilder(getSubImage(6, 0))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topRightroofTile = new MapTileBuilder(lightGrass3Frame)
         .withTopLayer(topRightroofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(topRightroofTile);

         // Tile 68: rightroofAndhouse

         Frame rightroofAndhouseFrame = new FrameBuilder(getSubImage(6, 1))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightroofAndhouseTile = new MapTileBuilder(rightroofAndhouseFrame)
         .withTopLayer(rightroofAndhouseFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(rightroofAndhouseTile);

         // Tile 69: tophouseAndleftroof

         Frame tophouseAndleftroofFrame = new FrameBuilder(getSubImage(6, 2))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder tophouseAndleftroofTile = new MapTileBuilder(tophouseAndleftroofFrame)
         .withTopLayer(tophouseAndleftroofFrame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(tophouseAndleftroofTile);

         // Tile 70: leftRoof2

         Frame leftRoof2Frame = new FrameBuilder(getSubImage(6, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftRoof2Tile = new MapTileBuilder(leftRoof2Frame)
         .withTopLayer(leftRoof2Frame)
         .withTileType(TileType.PASSABLE);
         mapTiles.add(leftRoof2Tile);

     /*    // Tile 71: rightroofandhouse

        Frame rightroofandhouseFrame = new FrameBuilder(getSubImage(6, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder rightroofandhouseTile = new MapTileBuilder(rightroofandhouseFrame)
        .withTopLayer(rightroofandhouseFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(rightroofandhouseTile);

        // Tile 72: tophouseandleftroof

        Frame tophouseandleftroofFrame = new FrameBuilder(getSubImage(6, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder tophouseandleftroofTile = new MapTileBuilder(tophouseandleftroofFrame)
        .withTopLayer(tophouseandleftroofFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(tophouseandleftroofTile);
*/
        // Tile 71: woodPlanks

        Frame woodPlanksFrame = new FrameBuilder(getSubImage(6, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder woodPlanksTile = new MapTileBuilder(woodPlanksFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(woodPlanksTile);

        


        // Tile 72: DarkwoodPlanks 

        Frame darkWoodPlanksFrame = new FrameBuilder(getSubImage(6, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder darkWoodPlanksTile = new MapTileBuilder(darkWoodPlanksFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkWoodPlanksTile);

        // Tile 73: Bricks

        Frame bricksFrame = new FrameBuilder(getSubImage(6, 6))
        .withScale(tileScale)
        .build();

        MapTileBuilder bricksTile = new MapTileBuilder(bricksFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bricksTile);

        // Tile 74: Topofbed

        Frame topOfBedFrame = new FrameBuilder(getSubImage(6, 7))
        .withScale(tileScale)
        .build();

        MapTileBuilder topOfBedTile = new MapTileBuilder(woodPlanksFrame)
        .withTopLayer(topOfBedFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(topOfBedTile);

        // Tile 75: BottomofBEd

        Frame bottomOfBedFrame = new FrameBuilder(getSubImage(6, 8))
        .withScale(tileScale)
        .build();

        MapTileBuilder bottomOfBedTile = new MapTileBuilder(woodPlanksFrame)
        .withTopLayer(bottomOfBedFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(bottomOfBedTile);

        // Tile 76: InsideWall

        Frame insideOfWallFrame = new FrameBuilder(getSubImage(6, 9))
        .withScale(tileScale)
        .build();

        MapTileBuilder insideOfWallTile = new MapTileBuilder(insideOfWallFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(insideOfWallTile);

        // Tile 77: BlackFrame

        Frame blackFrame = new FrameBuilder(getSubImage(6, 10))
        .withScale(tileScale)
        .build();

        MapTileBuilder blackTile = new MapTileBuilder(blackFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(blackTile);

        // Tile 78: grayRoof1

        Frame grayRoof1Frame = new FrameBuilder(getSubImage(7, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder grayRoof1Tile = new MapTileBuilder(grayRoof1Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grayRoof1Tile);

        // Tile 79: grayRoof2

        Frame grayRoof2Frame = new FrameBuilder(getSubImage(7, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder grayRoof2Tile = new MapTileBuilder(grayRoof2Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grayRoof2Tile);

        // Tile 80: grayRoof3

        Frame grayRoof3Frame = new FrameBuilder(getSubImage(7, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder grayRoof3Tile = new MapTileBuilder(grayRoof3Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grayRoof3Tile);

        // Tile 81: grayRoof4

        Frame grayRoof4Frame = new FrameBuilder(getSubImage(7, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder grayRoof4Tile = new MapTileBuilder(grayRoof4Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grayRoof4Tile);

        // Tile 82: grayRoof5

        Frame grayRoof5Frame = new FrameBuilder(getSubImage(7, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder grayRoof5Tile = new MapTileBuilder(grayRoof5Frame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grayRoof5Tile);

        // Tile 83: woodStool 

        Frame woodStoolFrame = new FrameBuilder(getSubImage(7, 6))
        .withScale(tileScale)
        .build();

        MapTileBuilder woodStoolTile = new MapTileBuilder(woodStoolFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(woodStoolTile);

        // Tile 84: bigBarDesk1

        Frame bigBarDesk1Frame = new FrameBuilder(getSubImage(7, 7))
        .withScale(tileScale)
        .build();

        MapTileBuilder bigBarDesk1Tile = new MapTileBuilder(bigBarDesk1Frame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(bigBarDesk1Tile);

        // Tile 85: bigBarDesk2

        Frame bigBarDesk2Frame = new FrameBuilder(getSubImage(7, 8))
        .withScale(tileScale)
        .build();

        MapTileBuilder bigBarDesk2Tile = new MapTileBuilder(bigBarDesk2Frame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(bigBarDesk2Tile);

        // Tile 86: bigBarDesk3

        Frame bigBarDesk3Frame = new FrameBuilder(getSubImage(7, 9))
        .withScale(tileScale)
        .build();

        MapTileBuilder bigBarDesk3Tile = new MapTileBuilder(bigBarDesk3Frame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(bigBarDesk3Tile);

        // Tile 87: bigBarDesk4 

        Frame bigBarDesk4Frame = new FrameBuilder(getSubImage(7, 10))
        .withScale(tileScale)
        .build();

        MapTileBuilder bigBarDesk4Tile = new MapTileBuilder(bigBarDesk4Frame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(bigBarDesk4Tile);

        // Tile 88: grassCornerLeft

        Frame grassCornerLeftFrame = new FrameBuilder(getSubImage(8, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder grassCornerLeftTile = new MapTileBuilder(grassCornerLeftFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(grassCornerLeftTile);

        // Tile 89: darkGrassCornerLeft

        Frame darkGrassCornerLeftFrame = new FrameBuilder(getSubImage(8, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder darkGrassCornerLeftTile = new MapTileBuilder(darkGrassCornerLeftFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(darkGrassCornerLeftTile);

        // Tile 90: NormalandDarkGrassCorner

        Frame NormalandDarkGrassCornerFrame = new FrameBuilder(getSubImage(8, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder NormalandDarkGrassCornerTile = new MapTileBuilder(NormalandDarkGrassCornerFrame)
        .withTileType(TileType.PASSABLE);
        mapTiles.add(NormalandDarkGrassCornerTile);

        // Tile 91: MiddleofDesk

        Frame middleOfDeskFrame = new FrameBuilder(getSubImage(8, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder middleOfDeskTile = new MapTileBuilder(middleOfDeskFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(middleOfDeskTile);

        // Tile 92: RightCornerOfDesk

        Frame rightCornerOfDeskFrame = new FrameBuilder(getSubImage(8, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder rightCornerOfDeskTile = new MapTileBuilder(woodPlanksFrame)
        .withTopLayer(rightCornerOfDeskFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(rightCornerOfDeskTile);

        // Tile 93: LeftCornerOfDesk

        Frame leftCornerOfDeskFrame = new FrameBuilder(getSubImage(8, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder leftCornerOfDeskTile = new MapTileBuilder(woodPlanksFrame)
        .withTopLayer(leftCornerOfDeskFrame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(leftCornerOfDeskTile);


        // Tile 94: LeftBottomOfDesk

        Frame leftBottomOfDeskFrame= new FrameBuilder(getSubImage(8, 6))
         .withScale(tileScale)
         .build();
 
        MapTileBuilder leftBottomOfDeskTile = new MapTileBuilder(woodPlanksFrame)
         .withTopLayer(leftBottomOfDeskFrame)
         .withTileType(TileType.NOT_PASSABLE);
         mapTiles.add(leftBottomOfDeskTile);


       // Tile 95: rightBottomOfDeskFrame
        
       Frame rightBottomOfDeskFrame= new FrameBuilder(getSubImage(8, 7))
       .withScale(tileScale)
       .build();

      MapTileBuilder rightBottomOfDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(rightBottomOfDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(rightBottomOfDeskTile);

       // Tile 96: middleBottomDesk

       Frame middleBottomDeskFrame = new FrameBuilder(getSubImage(8, 8))
       .withScale(tileScale)
       .build();

      MapTileBuilder middleBottomDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(middleBottomDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(middleBottomDeskTile);


       // Tile 97: LeftUpperCornerOfDesk

       Frame leftUpperCornerOfDeskFrame = new FrameBuilder(getSubImage(8, 9))
       .withScale(tileScale)
       .build();

      MapTileBuilder leftUpperCornerOfDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(leftUpperCornerOfDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(leftUpperCornerOfDeskTile);

       // Tile 98: RightUpperCornerOfDesk

       Frame RightUpperCornerOfDeskFrame = new FrameBuilder(getSubImage(8, 10))
       .withScale(tileScale)
       .build();

      MapTileBuilder RightUpperCornerOfDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(RightUpperCornerOfDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(RightUpperCornerOfDeskTile);

       // Tile 99: MiddleOfTopDesk

       Frame MiddleOfTopDeskFrame = new FrameBuilder(getSubImage(9, 0))
       .withScale(tileScale)
       .build();

      MapTileBuilder MiddleOfTopDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(MiddleOfTopDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(MiddleOfTopDeskTile);

       // Tile 100: SmallDesk

       Frame SmallDeskFrame = new FrameBuilder(getSubImage(9, 1))
       .withScale(tileScale)
       .build();

      MapTileBuilder SmallDeskTile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(SmallDeskFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(SmallDeskTile);


       // Tile 101: SmallCupboard

       Frame smallCupboardFrame = new FrameBuilder(getSubImage(9, 2))
       .withScale(tileScale)
       .build();

      MapTileBuilder smallCupboardTile = new MapTileBuilder(smallCupboardFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(smallCupboardTile);

       // Tile 102: Bigcupboard1 

       Frame bigCupboard1Frame = new FrameBuilder(getSubImage(9, 3))
       .withScale(tileScale)
       .build();

      MapTileBuilder bigCupboard1Tile = new MapTileBuilder(bigCupboard1Frame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(bigCupboard1Tile);


       // Tile 103: Bigcupboard2

       Frame bigCupboard2Frame = new FrameBuilder(getSubImage(9, 4))
       .withScale(tileScale)
       .build();

      MapTileBuilder bigCupboard2Tile = new MapTileBuilder(woodPlanksFrame)
       .withTopLayer(bigCupboard2Frame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(bigCupboard2Tile);


       // Tile 104: Inside Window 

       Frame insideWindowFrame = new FrameBuilder(getSubImage(9, 5))
       .withScale(tileScale)
       .build();

      MapTileBuilder insideWindowTile = new MapTileBuilder(insideOfWallFrame)
       .withTopLayer(insideWindowFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(insideWindowTile);

       // Tile 105: SmallWindow

       Frame smallWindowFrame = new FrameBuilder(getSubImage(9, 6))
       .withScale(tileScale)
       .build();

      MapTileBuilder smallWindowTile = new MapTileBuilder(WoodFrame)
       .withTopLayer(smallWindowFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(smallWindowTile);

       // Tile 106: RockWall
       
       Frame rockWallFrame = new FrameBuilder(getSubImage(9, 7))
       .withScale(tileScale)
       .build();

       MapTileBuilder rockwallTile = new MapTileBuilder(rockWallFrame)
       .withTileType(TileType.NOT_PASSABLE);
       mapTiles.add(rockwallTile);

       // Tile 107: RockPath
       Frame rockPathFrame = new FrameBuilder(getSubImage(9, 8))
       .withScale(tileScale)
       .build();

       MapTileBuilder rockPathTile = new MapTileBuilder(rockPathFrame)
       .withTileType(TileType.PASSABLE);
       mapTiles.add(rockPathTile);











/* 
        // Tile 73: leftroof2

        Frame leftroof2Frame = new FrameBuilder(getSubImage(8, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder leftroof2Tile = new MapTileBuilder(leftroof2Frame)
        .withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(leftroof2Tile);
*/
                return mapTiles;
        }
}
