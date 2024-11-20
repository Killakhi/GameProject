package Screens;

import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;
import Engine.Navigation.StaticMenuItem;
import Engine.Navigation.MenuItem;
import Engine.Navigation.ScrollableMenu;
import Engine.Navigation.ScrollableMenuScreen;
import Engine.Navigation.StaticMenuItem;
import Game.ScreenCoordinator;

import java.util.ArrayList;
import java.util.function.Consumer;

public class PauseMenu extends ScrollableMenuScreen<Consumer<PauseMenu>> {
    public ScreenCoordinator screenCoordinator;
    public PlayLevelScreen playLevelScreen;

    public PauseMenu(ScreenCoordinator screenCoordinator, PlayLevelScreen playLevelScreen) {
        this.screenCoordinator = screenCoordinator;
        this.playLevelScreen = playLevelScreen;    
        this.playLevelScreen = playLevelScreen;    
    }


    @Override
    protected ScrollableMenu<Consumer<PauseMenu>> createScrollableMenu() {
        ArrayList<MenuItem<Consumer<PauseMenu>>> options = new ArrayList<>();

        options.add(new StaticMenuItem<Consumer<PauseMenu>>("Resume", pauseMenu -> {
            pauseMenu.playLevelScreen.paused = false;
        }));

        return new ScrollableMenu<>(options);
    }


    @Override
    public void select() {
        this.menu.getSelectedItem().accept(this);
    }

    
}

