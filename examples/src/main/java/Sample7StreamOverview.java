import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author victorp
 */
public class Sample7StreamOverview {


    public static void main(String... args) throws Throwable {


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

        //  map .
//        Stream<Integer> hashCodes = names
//                .stream()
//                .map(String::hashCode);
//
//        Util.println(hashCodes.toArray());

//        // mapToInt argument is of type ToIntFunction<String>.
//        // This is an int-producing specialization for Function.
//        IntStream hashCodes = names.stream().mapToInt(String::hashCode);
//        Util.println(hashCodes.toArray());


        /**
         * Sum
         */

//        int total = names.stream().mapToInt(String::hashCode).sum();
////
////        // Optional (new in Java8)
//        Optional<Integer> reduce = names.stream()
//                        .map(String::hashCode)
//                        .reduce((x, y) -> x + y);
//
//
//        assert (total == reduce.orElseGet( ()-> {throw new IllegalStateException();}));


        /**
         * collector
         */

//        Stream<Integer> hashCodesForSet = names
//                .stream()
//                .map(String::hashCode);
//
//        Util.println(hashCodesForSet.collect(Collectors.toSet()));


        /**
         * Exercise
         * Ex2
         *
         *
         * ToUpperCase
         *
         */


        /**
         * flatMap == map + flatten
         *
         * print all unique letters
         */


//        List<String> uniqueLetters = names.stream()
//                .map(name -> name.split(""))
//                .flatMap(letters -> Arrays.stream(letters))
//                .distinct()
//                .collect(Collectors.toList());
//        Util.println(uniqueLetters);




        /**
         * Optional
         */


        //creation
//        Optional emptyOptional = Optional.empty();
//        Optional<String> nonEmptyOptional = Optional.of( "msg" );
//        Optional nullableOptional = Optional.ofNullable( null );
//
//
//        Util.println(nonEmptyOptional.orElse("else"));
//        Util.println(emptyOptional.orElse("else"));
//        Util.println(nullableOptional.orElse("else"));
//
//
//        emptyOptional.orElseThrow( IllegalStateException::new );
//
//        Util.println(nonEmptyOptional.filter(m -> m.startsWith("m")));
//


        /**
         * Custom collector
         */
//        Util.println(
//                names.stream()
//                        .collect(new GroupByCollector<>(name->name.length())));
//
//

    }



}
