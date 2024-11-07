package Engine.Navigation;

public class StaticMenuItem<T> implements MenuItem<T> {
    protected String name;
    protected T value;

    public StaticMenuItem(String name, T value) {
        this.name = name;
        this.value = value;
    }
    
    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public T getValue() {
        return value;
    }    
}
