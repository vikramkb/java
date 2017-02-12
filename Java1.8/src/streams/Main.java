package streams;

import streams.model.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        getConsumersFilterByAge();
        getConsumersAnonymousClass();

        collectFilteredConsumersInMapAnonymousClass();
        collectFilteredConsumersInMap();

        consumerThingsSorted();
        allUniqueCities();
        anyConsumersLivingInCity();
        sortByConsumerName();

        collectRunningThingsEvents();
        collectConsumersHavingDeviceTypeHome();
    }

    private static void collectConsumersHavingDeviceTypeHome() {
        Factory.getConsumers()
                .stream()
                .filter(consumer -> {
                    Boolean thingAvailable = consumer.getThings()
                            .stream()
                            .anyMatch(thing -> thing.isRunning() && thing.getType() == Type.HOME);
                    return thingAvailable;
                })
                .forEach(System.out::println);
    }

    private static void collectRunningThingsEvents() {
        List<Event> events = Factory.getConsumers()
                .stream()
                .flatMap(consumer -> consumer.getThings().stream())
                .filter(Thing::isRunning)
                .flatMap(thing -> thing.getEvents().stream())
                .collect(Collectors.toList());
        events.stream()
                .forEach(System.out::println);
    }

    private static void sortByConsumerName() {
        Factory.getConsumers()
                .stream()
                .map(Consumer::getName)
                .sorted()
                .reduce((prev, next) -> prev + " " + next) // reducing all the names as single string
                .ifPresent(System.out::println); //printing final concatinated string
    }

    private static void anyConsumersLivingInCity() {
        boolean isAnyConsumerInBerlin = Factory.getConsumers()
                .stream()
                .anyMatch(consumer -> consumer.getCity().equals("Hyd"));

        System.out.println("Consumers living in Hyd = " + (isAnyConsumerInBerlin ? "true" : "false"));
    }

    private static void consumerThingsSorted() {
        Factory.getConsumers()
                .stream()
                .filter(consumer -> consumer.getName().equals("laxman"))
                .flatMap(consumer -> consumer.getThings().stream())
                .sorted(Comparator.comparing(Thing::getName))
                .forEach(System.out::println);
    }

    private static void getConsumersFilterByAge() {
        List<Consumer> filterConsumers = Factory.getConsumers()
                .stream()
                .filter(consumer -> consumer.getAge() > 20)
                .collect(Collectors.toList());

        filterConsumers
        .forEach(System.out::println);
    }

    /**
     * predicate is nothing but anonymous class
     */
    private static void getConsumersAnonymousClass() {
        Factory.getConsumers()
                .stream()
                .filter(new Predicate<Consumer> () {
                    @Override
                    public boolean test(Consumer consumer) {
                        return consumer.getAge() > 20;
                    }
                })
                .forEach(System.out::println);
    }

    private static void collectFilteredConsumersInMapAnonymousClass() {
        Map<String, List<Thing>> consumerDevicesByAge =
                Factory.getConsumers()
                        .stream()
                        .filter(consumer -> consumer.getAge() > 20)
                        .collect(Collectors.toMap(new Function<Consumer, String>() {
                            @Override
                            public String apply(Consumer consumer) {
                                return consumer.getName();
                            }
                        }, new Function<Consumer, List<Thing>>() {
                            @Override
                            public List<Thing> apply(Consumer consumer) {
                                return consumer.getThings();
                            }
                        }));

        consumerDevicesByAge.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    private static void collectFilteredConsumersInMap() {
        Map<String, List<Thing>> consumerDevicesByAge =
                Factory.getConsumers()
                        .stream()
                        .filter(consumer -> consumer.getAge() > 20)
                        .collect(Collectors.toMap(consumer -> consumer.getName(), consumer -> consumer.getThings()));

        consumerDevicesByAge.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    private static void allUniqueCities() {
        List<String> cities = Factory.getConsumers()
                .stream()
                .map(Consumer::getCity)
                .distinct()
                .collect(Collectors.toList());

        cities
        .stream()
        .forEach(System.out::println);
    }

}
