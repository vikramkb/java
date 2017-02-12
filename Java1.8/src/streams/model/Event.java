package streams.model;

/**
 * Created by vikramkb on 2/5/17.
 */
public class Event {
    private String name;
    private boolean isActive;

    public Event(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
