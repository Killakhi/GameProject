package Screens.Stats;
import Engine.*;
import Engine.Battle.FriendlyStats;
import Engine.Navigation.Drawable;
import Screens.PlayLevelScreen;
import SpriteFont.SpriteFont;
import java.awt.*;

// This class is for the win level screen
public class HealthStatsPanel implements Drawable {
    protected SpriteFont healthScreenMessage;
    protected SpriteFont currentHpMessage;
    protected SpriteFont attackStatMessage;
    protected SpriteFont magicStatMessage;
    protected SpriteFont speedStatMessage;
    protected KeyLocker keyLocker = PlayLevelScreen.keyLocker;
    // protected int currentpauseMenuItemHovered = 0;
    // protected int pauseMenuItemSelected = -1;
    protected int keyPressTimer;
    protected int pointerLocationX, pointerLocationY;
    public FriendlyStats stats;

    public HealthStatsPanel(FriendlyStats stats) {
        this.stats = stats;
    }
 
    @Override
    public void draw(GraphicsHandler graphicsHandler, int x, int y) {
        healthScreenMessage = new SpriteFont(stats.partyMemberName, x + 45, y + 50, "Courier Bold Italic", 45, Color.white);
        healthScreenMessage.setOutlineColor(Color.black);
        healthScreenMessage.setOutlineThickness(3);
        currentHpMessage = new SpriteFont("HP: " + stats.currentHp + " / " + stats.hpStat, x + 45, y + 120, "Arial", 25, Color.white);
        currentHpMessage.setOutlineColor(Color.black);
        currentHpMessage.setOutlineThickness(3);
        attackStatMessage = new SpriteFont("Attack: " + stats.attackStat, x + 45, y + 150, "Arial", 25, Color.white);
        attackStatMessage.setOutlineColor(Color.black);
        attackStatMessage.setOutlineThickness(3);
        magicStatMessage = new SpriteFont("Magic: " + stats.currentMagic + " / " + stats.magicStat, x + 45, y + 180, "Arial", 25, Color.white);
        magicStatMessage.setOutlineColor(Color.black);
        magicStatMessage.setOutlineThickness(3);
        speedStatMessage = new SpriteFont("Speed: " + stats.speedStat, x + 45, y + 210, "Arial", 25, Color.white);
        speedStatMessage.setOutlineColor(Color.black);
        speedStatMessage.setOutlineThickness(3);

        healthScreenMessage.draw(graphicsHandler);
        currentHpMessage.draw(graphicsHandler);
        attackStatMessage.draw(graphicsHandler);
        // graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(0, 0, 0), Color.white, 2);
        magicStatMessage.draw(graphicsHandler);
        speedStatMessage.draw(graphicsHandler);
    }

    
}

