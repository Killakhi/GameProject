package Engine.Navigation;

public interface MenuItem<T> {
    public String getDisplayName();
    public T getValue();
}
