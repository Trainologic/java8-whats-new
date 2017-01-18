package streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class FilterCollection {

    private FilterCollection() {
    }

    public static Set<String> transform7(Set<String> collection) {
        Set<String> newCollection = new HashSet<>();
        for (String element : collection) {
            if (element.length() < 4) {
                newCollection.add(element);
            }
        }
        return newCollection;
    }

    public static Set<String> transform(Set<String> collection) {
        return collection.stream() // Convert collection to Stream
                .filter(value -> value.length() < 4) // Filter elements with length smaller than 4 characters
                .collect(toSet()); // Collect results to a new set
    }

}
