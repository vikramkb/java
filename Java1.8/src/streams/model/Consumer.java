package streams.model;

import java.util.List;

public class Consumer {
    private String name;
    private String city;
    private int age;
    private List<Thing> things;

    public Consumer(String name, String city, int age, List<Thing> things) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.things = things;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", things=" + things +
                '}';
    }
}
