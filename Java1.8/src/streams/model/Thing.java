package streams.model;

import java.util.List;

public class Thing {
    private String id;
    private String name;
    private boolean isRunning;
    private Type type;
    private List<Event> events;
    private int cost;

    public Thing(String id, String name, boolean isRunning, Type type, List<Event> events, int cost) {
        this.id = id;
        this.name = name;
        this.isRunning = isRunning;
        this.type = type;
        this.events = events;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isRunning=" + isRunning +
                ", type=" + type +
                ", events=" + events +
                ", cost=" + cost +
                '}';
    }
}
