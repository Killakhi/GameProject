package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
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

        MapTileBuilder lightGrass1Tile = new MapTileBuilder(lightGrass1Frame);

        mapTiles.add(lightGrass1Tile);

        // Tile 2: lightGrass2

        Frame lightGrass2Frame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass2Tile = new MapTileBuilder(lightGrass2Frame);

        mapTiles.add(lightGrass2Tile);

        // Tile 3: lightGrass3

        Frame lightGrass3Frame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass3Tile = new MapTileBuilder(lightGrass3Frame);

        mapTiles.add(lightGrass3Tile);

        // Tile 4: lightGrass4

        Frame lightGrass4Frame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightGrass4Tile = new MapTileBuilder(lightGrass4Frame);

        mapTiles.add(lightGrass4Tile);

        // Tile 5: darkGrass1

        Frame darkGrass1Frame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkGrass1Tile = new MapTileBuilder(darkGrass1Frame);

        mapTiles.add(darkGrass1Tile);

        // Tile 6: darkGrass2

        Frame darkGrass2Frame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkGrass2Tile = new MapTileBuilder(darkGrass2Frame);

        mapTiles.add(darkGrass2Tile);

         // Tile 7: darkGrass3

         Frame darkGrass3Frame = new FrameBuilder(getSubImage(0, 6))
         .withScale(tileScale)
         .build();

        MapTileBuilder darkGrass3Tile = new MapTileBuilder(darkGrass3Frame);

        mapTiles.add(darkGrass3Tile);

        // Tile 8: darkGrass4

        Frame darkGrass4Frame = new FrameBuilder(getSubImage(1, 0))
        .withScale(tileScale)
        .build();

       MapTileBuilder darkGrass4Tile = new MapTileBuilder(darkGrass4Frame);

       mapTiles.add(darkGrass4Tile);

       // Tile 9: upsideDownpathway

       Frame upsideDownpathwayFrame = new FrameBuilder(getSubImage(1, 1))
       .withScale(tileScale)
       .build();

      MapTileBuilder upsideDownpathwayTile = new MapTileBuilder(upsideDownpathwayFrame);

      mapTiles.add(upsideDownpathwayTile);

      // Tile 10: rightPathway

      Frame rightPathwayFrame = new FrameBuilder(getSubImage(1, 2))
      .withScale(tileScale)
      .build();

     MapTileBuilder rightPathwayTile = new MapTileBuilder(rightPathwayFrame);

     mapTiles.add(rightPathwayTile);

     // Tile 11: leftPathway

     Frame leftPathwayFrame = new FrameBuilder(getSubImage(1, 3))
     .withScale(tileScale)
     .build();

    MapTileBuilder leftPathwayTile = new MapTileBuilder(leftPathwayFrame);

    mapTiles.add(leftPathwayTile);

    // Tile 12: downPathway

    Frame downPathwayFrame = new FrameBuilder(getSubImage(1, 4))
    .withScale(tileScale)
    .build();

   MapTileBuilder downPathwayTile = new MapTileBuilder(downPathwayFrame);

   mapTiles.add(downPathwayTile);

        // Tile 13: downDarkpathway

        Frame downDarkpathwayFrame = new FrameBuilder(getSubImage(1, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder downDarkpathwayTile = new MapTileBuilder(downDarkpathwayFrame);

        mapTiles.add(downDarkpathwayTile);

        // Tile 14: leftDarkpathway

        Frame leftDarkpathwayFrame = new FrameBuilder(getSubImage(1, 6))
         .withScale(tileScale)
        .build();

        MapTileBuilder leftDarkpathwayTile = new MapTileBuilder(leftDarkpathwayFrame);

        mapTiles.add(leftDarkpathwayTile);

        // Tile 15: rightDarkpathway

        Frame rightDarkpathwayFrame = new FrameBuilder(getSubImage(2, 0))
         .withScale(tileScale)
        .build();

        MapTileBuilder rightDarkpathwayTile = new MapTileBuilder(rightDarkpathwayFrame);

        mapTiles.add(rightDarkpathwayTile);

        // Tile 16: upsidedownDarkpathway

        Frame upsidedownDarkpathwayFrame = new FrameBuilder(getSubImage(2, 1))
         .withScale(tileScale)
        .build();

        MapTileBuilder upsidedownDarkpathwayTile = new MapTileBuilder(upsidedownDarkpathwayFrame);

        mapTiles.add(upsidedownDarkpathwayTile);

        // Tile 17: darkBigleaves

        Frame darkBigleavesFrame = new FrameBuilder(getSubImage(2, 2))
         .withScale(tileScale)
        .build();

        MapTileBuilder darkBigleavesTile = new MapTileBuilder(darkBigleavesFrame);

        mapTiles.add(darkBigleavesTile);

        // Tile 18: lightBigleaves

        Frame lightBigleavesFrame = new FrameBuilder(getSubImage(2, 3))
         .withScale(tileScale)
        .build();

        MapTileBuilder lightBigleavesTile = new MapTileBuilder(lightBigleavesFrame);

        mapTiles.add(lightBigleavesTile);

        // Tile 19: downlightCurvepath

        Frame downlightCurvepathFrame = new FrameBuilder(getSubImage(2, 4))
         .withScale(tileScale)
        .build();

        MapTileBuilder downlightCurvepathTile = new MapTileBuilder(downlightCurvepathFrame);

        mapTiles.add(downlightCurvepathTile);

        // Tile 20: rightlightCurvepath

        Frame rightlightCurvepathFrame = new FrameBuilder(getSubImage(2, 5))
         .withScale(tileScale)
        .build();

        MapTileBuilder rightlightCurvepathTile = new MapTileBuilder(rightlightCurvepathFrame);

        mapTiles.add(rightlightCurvepathTile);

        // Tile 21: leftlightCurvepath

        Frame leftlightCurvepathFrame = new FrameBuilder(getSubImage(2, 6))
         .withScale(tileScale)
        .build();

        MapTileBuilder leftlightCurvepathTile = new MapTileBuilder(leftlightCurvepathFrame);

        mapTiles.add(leftlightCurvepathTile);

        // Tile 22: upsideDownlightcurvepath

        Frame upsideDownlightcurvepathFrame = new FrameBuilder(getSubImage(3, 0))
         .withScale(tileScale)
        .build();

        MapTileBuilder upsideDownlightcurvepathTile = new MapTileBuilder(upsideDownlightcurvepathFrame);

        mapTiles.add(upsideDownlightcurvepathTile);

         // Tile 23: downdarkCurvepath

         Frame downdarkCurvepathFrame = new FrameBuilder(getSubImage(3, 1))
         .withScale(tileScale)
        .build();

        MapTileBuilder downdarkCurvepathTile = new MapTileBuilder(downdarkCurvepathFrame);

        mapTiles.add(downdarkCurvepathTile);

        // Tile 24: rightdarkCurvepath

        Frame rightdarkCurvepathFrame = new FrameBuilder(getSubImage(3, 2))
        .withScale(tileScale)
       .build();

       MapTileBuilder rightdarkCurvepathTile = new MapTileBuilder(rightdarkCurvepathFrame);

       mapTiles.add(rightdarkCurvepathTile);

       // Tile 25: leftdarkCurvepath

       Frame leftdarkCurvepathFrame = new FrameBuilder(getSubImage(3, 3))
       .withScale(tileScale)
      .build();

      MapTileBuilder leftdarkCurvepathTile = new MapTileBuilder(leftdarkCurvepathFrame);

      mapTiles.add(leftdarkCurvepathTile);

      // Tile 26:upsidedowndarkCurvepath

        Frame upsidedowndarkCurvepathFrame = new FrameBuilder(getSubImage(3, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder upsidedowndarkCurvepathTile = new MapTileBuilder(upsidedowndarkCurvepathFrame);

        mapTiles.add(upsidedowndarkCurvepathTile);

        // Tile 27:wood

        Frame woodFrame = new FrameBuilder(getSubImage(3, 5))
        .withScale(tileScale)
        .build();

        MapTileBuilder woodTile = new MapTileBuilder(woodFrame);

        mapTiles.add(woodTile);

        // Tile 28: bannerWithwood

        Frame bannerWithwoodFrame = new FrameBuilder(getSubImage(3, 6))
        .withScale(tileScale)
        .build();

        MapTileBuilder bannerWithwoodTile = new MapTileBuilder(bannerWithwoodFrame);

        mapTiles.add(bannerWithwoodTile);

        // Tile 29: treeWood

        Frame treeWoodFrame = new FrameBuilder(getSubImage(4, 0))
        .withScale(tileScale)
        .build();

        MapTileBuilder treeWoodTile = new MapTileBuilder(treeWoodFrame);

        mapTiles.add(treeWoodTile);

        // Tile 30: balloon

        Frame balloonFrame = new FrameBuilder(getSubImage(4, 1))
        .withScale(tileScale)
        .build();

        MapTileBuilder balloonTile = new MapTileBuilder(balloonFrame);

        mapTiles.add(balloonTile);

        // Tile 31: window

        Frame windowFrame = new FrameBuilder(getSubImage(4, 2))
        .withScale(tileScale)
        .build();

        MapTileBuilder windowTile = new MapTileBuilder(windowFrame);

        mapTiles.add(windowTile);

        // Tile 32: windowPanel

        Frame windowPanelFrame = new FrameBuilder(getSubImage(4, 3))
        .withScale(tileScale)
        .build();

        MapTileBuilder windowPanelTile = new MapTileBuilder(windowPanelFrame);

        mapTiles.add(windowPanelTile);

        // Tile 33: pathway1

        Frame pathway1Frame = new FrameBuilder(getSubImage(4, 4))
        .withScale(tileScale)
        .build();

        MapTileBuilder pathway1Tile = new MapTileBuilder(pathway1Frame);

        mapTiles.add(pathway1Tile);

         // Tile 34: pathway2

         Frame pathway2Frame = new FrameBuilder(getSubImage(4, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder pathway2Tile = new MapTileBuilder(pathway2Frame);
 
         mapTiles.add(pathway2Tile);

         // Tile 35: bottomDoor

         Frame bottomDoorFrame = new FrameBuilder(getSubImage(4, 6))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder bottomDoorTile = new MapTileBuilder(bottomDoorFrame);
 
         mapTiles.add(bottomDoorTile);

         // Tile 36: upperDoor

         Frame upperDoorFrame = new FrameBuilder(getSubImage(5, 0))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder upperDoorTile = new MapTileBuilder(upperDoorFrame);
 
         mapTiles.add(upperDoorTile);

         // Tile 37: rightRoof

         Frame rightRoofFrame = new FrameBuilder(getSubImage(5, 1))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightRoofTile = new MapTileBuilder(rightRoofFrame);
 
         mapTiles.add(rightRoofTile);

         // Tile 38: leftRoof

         Frame leftRoofFrame = new FrameBuilder(getSubImage(5, 2))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftRoofTile = new MapTileBuilder(leftRoofFrame);
 
         mapTiles.add(leftRoofTile);

         // Tile 39: leftmiddleRoof

         Frame leftmiddleRoofFrame = new FrameBuilder(getSubImage(5, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftmiddleRoofTile = new MapTileBuilder(leftmiddleRoofFrame);
 
         mapTiles.add(leftmiddleRoofTile);

         // Tile 40: leftpointRoof

         Frame leftpointRoofFrame = new FrameBuilder(getSubImage(5, 4))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder leftpointRoofTile = new MapTileBuilder(leftpointRoofFrame);
 
         mapTiles.add(leftpointRoofTile);

         // Tile 41: roofTiles1

         Frame roofTiles1Frame = new FrameBuilder(getSubImage(5, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder roofTiles1Tile = new MapTileBuilder(roofTiles1Frame);
 
         mapTiles.add(roofTiles1Tile);

         // Tile 42: roofTiles2

         Frame roofTiles2Frame = new FrameBuilder(getSubImage(5, 6))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder roofTiles2Tile = new MapTileBuilder(roofTiles2Frame);
 
         mapTiles.add(roofTiles2Tile);

         // Tile 43: topRightroof

         Frame topRightroofFrame = new FrameBuilder(getSubImage(6, 0))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topRightroofTile = new MapTileBuilder(topRightroofFrame);
 
         mapTiles.add(topRightroofTile);

         // Tile 44: topRightroof2

         Frame topRightroof2Frame = new FrameBuilder(getSubImage(6, 1))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topRightroof2Tile = new MapTileBuilder(topRightroof2Frame);
 
         mapTiles.add(topRightroof2Tile);

         // Tile 45: rightPointroof

         Frame rightPointroofFrame = new FrameBuilder(getSubImage(6, 2))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightPointroofTile = new MapTileBuilder(rightPointroofFrame);
 
         mapTiles.add(rightPointroofTile);

         // Tile 46: rightmiddleRoof

         Frame rightmiddleRoofFrame = new FrameBuilder(getSubImage(6, 3))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder rightmiddleRoofTile = new MapTileBuilder(rightmiddleRoofFrame);
 
         mapTiles.add(rightmiddleRoofTile);

         // Tile 47: topLeftroof2

         Frame topLeftroof2Frame = new FrameBuilder(getSubImage(6, 4))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topLeftroof2Tile = new MapTileBuilder(topLeftroof2Frame);
 
         mapTiles.add(topLeftroof2Tile);

         // Tile 48: topLeftroof

         Frame topLeftroofFrame = new FrameBuilder(getSubImage(6, 5))
         .withScale(tileScale)
         .build();
 
         MapTileBuilder topLeftroofTile = new MapTileBuilder(topLeftroofFrame);
 
         mapTiles.add(topLeftroofTile);


        return mapTiles;
    }
}
