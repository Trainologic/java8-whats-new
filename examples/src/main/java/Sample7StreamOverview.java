import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
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
//        // mapToInt argument is of type ToIntFunction<String>.
//        // This is an int-producing specialization for Function.
//        IntStream hashCodes = names.stream().mapToInt(String::hashCode);
//        Util.println(hashCodes.toArray());


        /**
         * Sum
         */

//        int total = names.stream().mapToInt(String::hashCode).sum();
//
//        // Optional (new in Java8)
//        Optional<Integer> reduce = names.stream()
//                        .map(String::hashCode)
//                        .reduce((x, y) -> x + y);
//
//        assert (total == reduce.get());

    }


}
