package Engine.Navigation;

/*
 * represents a list that can also have items be selected rather than just highlighted.
 */
public interface Selectable<T> extends Navigable<T> {
    public void select();
}
