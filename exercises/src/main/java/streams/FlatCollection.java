package streams;

import java.util.*;
import java.util.stream.Collectors;

public class FlatCollection {


    private FlatCollection() {
    }


    public static Set<String> transform7(List<List<String>> collection) {
        Set<String> newCollection = new HashSet<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }


    public static Set<String> flatten(List<List<String>> collection) {
        return collection.stream() // Convert collection to Stream
                .flatMap(Collection::stream) // Replace list with stream
                .collect(Collectors.toSet()); // Collect results to a new set
    }

}
