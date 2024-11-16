package Engine.Navigation;

import Engine.GraphicsHandler;

/*
 * Something that can be drawn, like a list.
 */
public interface Drawable {
    public void draw(GraphicsHandler graphicsHandler, int x, int y);
}
