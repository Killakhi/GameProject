package Screens.Stats;

import Engine.GraphicsHandler;
import Engine.Battle.PartyStats;
import java.awt.Color;

public class HealthStatsWindow {
    public static HealthStatsWindow INSTANCE = new HealthStatsWindow();

    public HealthStatsPanel player, maya, damion;

    public HealthStatsWindow() {
        player = new HealthStatsPanel(PartyStats.PLAYER);
        maya = new HealthStatsPanel(PartyStats.MAYA);
        damion = new HealthStatsPanel(PartyStats.DAMION);
    }

    public void draw(GraphicsHandler graphicsHandler) {
            graphicsHandler.drawFilledRectangle(0, 0, 5000, 5000, Color.GRAY);
        player.draw(graphicsHandler, 0, 50);
        maya.draw(graphicsHandler, 240, 50);
        damion.draw(graphicsHandler, 480, 50);
    }
    
}
