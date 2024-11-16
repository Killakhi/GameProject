package Engine.Navigation;

/*
 * represents a list that can be navigated up and down.
 */
public interface Navigable<T> {
    public void navigateUp();
    public void navigateDown();

    public T getSelected();
}
