package Engine.Navigation;

import java.util.ArrayList;

import Engine.GraphicsHandler;
import java.awt.Color;
import java.awt.Font;

public class ScrollableMenu<T> implements Drawable, Navigable<MenuItem<T>> {
    public ArrayList<MenuItem<T>> items;
    public int selected = -1;

    public ScrollableMenu(ArrayList<MenuItem<T>> items) {
        this.items = items;
    }

    protected void drawItem(GraphicsHandler graphicsHandler, int x, int y, int row, boolean selected, int index) {
        if (index < 0 || index >= items.size()) {
            return;
        }

        String itemName = items.get(index).getDisplayName();
        Font font = Font.decode(Font.SANS_SERIF).deriveFont(25.0f);

        if (!selected) {
            graphicsHandler.drawString(itemName, x + 20, y + 25 + 30 * row, font, Color.GRAY);
        } else {
            graphicsHandler.drawStringWithOutline(itemName, x + 20, y + 25 + 30 * row, font, Color.WHITE, Color.GRAY, 2.0f);
        }
    }

    @Override
    public void navigateUp() {
        this.selected--;

        if (this.selected < 0 && !this.items.isEmpty()) {
            this.selected = 0;
        }
    }

    @Override
    public void navigateDown() {
        this.selected++;

        if (this.selected >= this.items.size()) {
            this.selected = this.items.size() - 1;
        }
    }

    @Override
    public MenuItem<T> getSelected() {
        try {
            return this.items.get(this.selected);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void draw(GraphicsHandler graphicsHandler, int x, int y) {
        graphicsHandler.drawFilledRectangleWithBorder(x, y, 300, 110, Color.BLACK, Color.WHITE, 2);

        if (items.isEmpty()) {
            selected = -1;
        } else if (selected < 0) {
            // implies it's not empty
            selected = 0;
        } else if (selected >= items.size()) {
            selected = items.size() - 1;
        }

        if (selected >= 0) {
            int index = selected;

            // three cases
            if (index == 0) {
                // this is the first item
                this.drawItem(graphicsHandler, x, y, 0, true, index);
                this.drawItem(graphicsHandler, x, y, 1, false, index + 1);
                this.drawItem(graphicsHandler, x, y, 2, false, index + 2);
            } else if (index == items.size() - 1) {
                // this is the last item
                this.drawItem(graphicsHandler, x, y, 0, false, index - 2);
                this.drawItem(graphicsHandler, x, y, 1, false, index - 1);
                this.drawItem(graphicsHandler, x, y, 2, true, index);
            } else {
                // this is somewhere in the middle
                this.drawItem(graphicsHandler, x, y, 0, false, index - 1);
                this.drawItem(graphicsHandler, x, y, 1, true, index);
                this.drawItem(graphicsHandler, x, y, 2, false, index + 1);
            }
        }
    }

    public T getSelectedItem() {
        MenuItem<T> menuItem = this.getSelected();

        return menuItem != null ? menuItem.getValue() : null;
    }
}
