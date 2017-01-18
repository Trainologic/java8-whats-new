package streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Partitioning {

    private Partitioning() {
    }

    public static Map<Boolean, Set<Person>> partitionAdults7(List<Person> people) {
        Map<Boolean, Set<Person>> map = new HashMap<>();
        map.put(true, new HashSet<>());
        map.put(false, new HashSet<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }

    public static Map<Boolean, Set<Person>> partitionAdults(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .collect(partitioningBy(p -> p.getAge() >= 18, Collectors.toSet())); // Partition stream of people into adults (age => 18) and kids
    }

}
