package Screens.Pause;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;
import Engine.Navigation.StaticMenuItem;
import Game.ScreenCoordinator;
import GameObject.Money;
import Inventory.Inventory;
import Inventory.Shop;
import Screens.PlayLevelScreen;
import Screens.Stats.HealthStatsWindow;

import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PauseMenu extends ScrollableMenuScreen<Consumer<PauseMenu>> {
    public ScreenCoordinator screenCoordinator;
    public PlayLevelScreen playLevelScreen;
    public PauseState pauseState = PauseState.PAUSE_MAIN;

    public static enum PauseState {
        PAUSE_MAIN,
        PAUSE_INVENTORY,
        PAUSE_SHOP,
        PAUSE_STATS,
    }

    public PauseMenu(ScreenCoordinator screenCoordinator, PlayLevelScreen playLevelScreen) {
        this.screenCoordinator = screenCoordinator;
        this.playLevelScreen = playLevelScreen;  
    }

    @Override
    protected ScrollableMenu<Consumer<PauseMenu>> createScrollableMenu() {
        ArrayList<MenuItem<Consumer<PauseMenu>>> options = new ArrayList<>();

        options.add(new StaticMenuItem<Consumer<PauseMenu>>("Resume", pauseMenu -> {
            pauseMenu.playLevelScreen.paused = false;
        }));

        options.add(new StaticMenuItem<Consumer<PauseMenu>>("Inventory", pauseMenu -> {
            pauseMenu.pauseState = PauseState.PAUSE_INVENTORY;
        }));

        options.add(new StaticMenuItem<Consumer<PauseMenu>>("Shop", pauseMenu -> {
            pauseMenu.pauseState = PauseState.PAUSE_SHOP;
        }));

        options.add(new StaticMenuItem<Consumer<PauseMenu>>("Stats", pauseMenu -> {
            pauseMenu.pauseState = PauseState.PAUSE_STATS;
        }));

        return new ScrollableMenu<>(options);
    }

    @Override
    public void select() {
        this.menu.getSelectedItem().accept(this);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.ESC) && !keyLocker.isKeyLocked(Key.ESC)) {
            keyLocker.lockKey(Key.ESC);

            if (pauseState == PauseState.PAUSE_MAIN) {
                playLevelScreen.paused = false;
            } else {
                this.pauseState = PauseState.PAUSE_MAIN;
            }
        }

        switch (pauseState) {
            case PAUSE_MAIN:
                super.update();
                break;
            case PAUSE_INVENTORY:
                Inventory.INSTANCE.update();
                break;
            case PAUSE_SHOP:
                Shop.INSTANCE.update();
                break;
            case PAUSE_STATS:
                break;
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        Font font = Font.decode(Font.SANS_SERIF).deriveFont(25.0f);

        switch (pauseState) {
            case PAUSE_MAIN:
                super.draw(graphicsHandler);
                break;
            case PAUSE_INVENTORY:
                Inventory.INSTANCE.draw(graphicsHandler);
                break;
            case PAUSE_SHOP:
                graphicsHandler.drawStringWithOutline("Money: $" + Money.INSTANCE.getMoney(), 70, 250, font, Color.WHITE, Color.BLACK, 2.0f);
                Shop.INSTANCE.draw(graphicsHandler);
                break;
            case PAUSE_STATS:
                HealthStatsWindow.INSTANCE.draw(graphicsHandler);
                break;
        }

        if (pauseState != PauseState.PAUSE_MAIN) {
            graphicsHandler.drawStringWithOutline("Press ESC to go back", 100, 450, font, Color.WHITE, Color.BLACK, 2.0f);
        }
    }
}

