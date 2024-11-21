package Screens.Pause;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.Keyboard;
import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;
import Engine.Navigation.StaticMenuItem;
import Game.ScreenCoordinator;
import Inventory.Inventory;
import Inventory.Shop;
import Screens.PlayLevelScreen;
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

        return new ScrollableMenu<>(options);
    }

    @Override
    public void select() {
        this.menu.getSelectedItem().accept(this);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.ESC)) {
            this.pauseState = PauseState.PAUSE_MAIN;
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
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        switch (pauseState) {
            case PAUSE_MAIN:
                super.draw(graphicsHandler);
                break;
            case PAUSE_INVENTORY:
                Inventory.INSTANCE.draw(graphicsHandler);
                break;
            case PAUSE_SHOP:
                Shop.INSTANCE.draw(graphicsHandler);
                break;
        }

        if (pauseState != PauseState.PAUSE_MAIN) {
            Font font = Font.decode(Font.SANS_SERIF).deriveFont(25.0f);

            graphicsHandler.drawString("Press ESC to go back", 70, 250, font, Color.GRAY);
        }
    }
}

