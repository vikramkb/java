package lamdas.sort;

@FunctionalInterface
public interface SortCriteria<Current, Next> {
    int compare(Current current, Next next);
}