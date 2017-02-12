package streams.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {
    public static List<Event> getEvents() {
        List allEvents = new ArrayList<Event>();
        allEvents.addAll(getSwitchEvents());
        allEvents.addAll(getFanEvents());
        return allEvents;
    }

    public static List<Event> getSwitchEvents() {
        return Arrays.asList(new Event("LightSwitchOn", true), new Event("LightSwitchOff", false));
    }

    public static List<Event> getFanEvents() {
        return Arrays.asList(new Event("FanSwitchOn", false), new Event("FanSwitchOff", true));
    }

    public static List<Thing> getThings() {
        return Arrays.asList(getFan(), getSwitch());
    }

    public static Thing getFan() {
        return new Thing("F1", "fan", false, Type.HOME, getFanEvents(), 500);
    }

    public static Thing getSwitch() {
        return new Thing("S1", "switch", true, Type.HOME, getSwitchEvents(), 100);
    }

    public static List<Consumer> getConsumers() {
        return Arrays.asList(new Consumer("ram", "Hyd", 54, Arrays.asList(getFan())), new Consumer("laxman", "Blore", 30, getThings()), new Consumer("vignesh", "Hyd", 18, getThings()), new Consumer("vishant", "Blore", 10, Arrays.asList(getSwitch())));
    }
}
