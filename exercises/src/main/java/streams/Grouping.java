package streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Grouping {

    private Grouping() {
    }

    public static Map<String, Set<Person>> groupByNationality7(List<Person> people) {
        Map<String, Set<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new HashSet<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;
    }

    public static Map<String, Set<Person>> groupByNationality(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .collect(groupingBy(Person::getNationality, Collectors.toSet())); // Group people by nationality
    }

}
