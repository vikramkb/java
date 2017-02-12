package methodreference;

@FunctionalInterface
public interface Consumer<OBJECT> {
    void apply(OBJECT object);
}
