package streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ToUpperCase {

    private ToUpperCase() {
    }

    public static Set<String> toUpperCase7(List<String> collection) {
        Set<String> newCollection = new HashSet<>();
        for (String element : collection) {
            newCollection.add(element.toUpperCase());
        }
        return newCollection;
    }

    public static Set<String> toUpperCase(List<String> collection) {
        return collection.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(Collectors.toSet()); // Collect results to a new list
    }

}
