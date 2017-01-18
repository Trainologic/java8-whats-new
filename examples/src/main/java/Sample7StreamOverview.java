import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author victorp
 */
public class Sample7StreamOverview {


    public static void main(String... args) {


        // The list is the pipeline data source.
        Collection<String> names = Arrays.asList("Vera", "Chuck", "Dave", "Dave");

        // Create the stream.
        Stream<String> stream = names.stream();

        /**
         * Basics
         */

//
//        // Returns an array containing the elements of this stream.
//        // This is a terminal operation.
//        Util.println(Arrays.toString(stream.toArray()));
//        // [Vera, Chuck, Dave]
//
//        // The filter argument is of type Predicate<String>
//        stream = names.stream().filter(p -> !p.startsWith("D"));
//        Util.println(Arrays.toString(stream.toArray()));
//        // [Vera, Chuck]


        /**
         * Chaining
         */

//        // Stream operations can be chained (piping)
//        stream = names.stream().skip(1).limit(2);
//        Util.println(Arrays.toString(stream.toArray()));
//        // [Chuck, Dave]


        /**
         * Transforming
         */
        //Transform one stream to another
//        Stream<Integer> hashCodes = names.stream().map(name -> name.hashCode());
//        Util.println(hashCodes.toArray());


        /**
         * Reduce + Optional
         */
//        //Calculate the sum of all hash codes
//        Optional<Integer> hashCodesSum = names.stream()
//                        .map(String::hashCode)
//                        .reduce((x, y) -> x + y);
//        Util.println(hashCodesSum.get());
//
//
        /**
         * IntStream
         */
//        //Calculate the sum of all hash codes with IntStream
//        IntStream intStream = names.stream().mapToInt(String::hashCode);
//        Util.println(intStream.sum());
//


        /**
         * collect
         */
//        // We first map the String elements to lower case.
//        // Then we return a new collection with the lower case names.
//        // We will have a deeper look on collect() soon.
//        List<String> namesLowerCase = names.stream()
//                .map(s -> s.toLowerCase())
//                .collect(Collectors.toList());
//        Util.println(namesLowerCase);
//        // [vera, chuck, dave, dave]


        /**
         * Exercises:
         *
         */

        // Ex2
        // FilterCollectionTest
        //KidsTest
        //OldestPersonTest
        //ToUpperCaseTest
        //SumTest


        /**
         * flatMap = map + flatten
         */
//        // Print all letters occurred in the given names
        Stream<String> allLetters = names.stream()
                .flatMap(name -> Arrays.asList(name.split("")).stream());

        Set<String> allDistinctLetters = allLetters.collect(Collectors.toSet());
        Util.println(allDistinctLetters);


        /**
         * flatMapToInt
         */

//        // Calculates the average length of the values in the names list.
//        // flatMapToInt returns an IntStream after applying the function.
        OptionalDouble avg = names.stream()
                .flatMapToInt(s -> IntStream.of(s.length()))
                .average();



        /**
         * Exercises:
         *
         */

        //FlatCollectionTest



    }


}
