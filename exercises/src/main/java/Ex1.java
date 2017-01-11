import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Implement the following functions
 */
public class Ex1 {


    /**
     * @return a function that always return b
     */
    public static <A,B> Function<A,B> constFunction(B b) {
        return null;
    }

    /**
     * @param f a function that takes two arguments and returns one
     * @return a function that does exactly what f does but flips the input arguments
     *
     * <p>
     * Example:<p>
     * BiFunction<Int,Int,Int> f = (a,b) -> a-b <p>
     * f.apply(3,2) //the result is 1 <p>
     * flip(f).apply(3,2) //the result is -1 <p>
     *
     */
    public static <A,B,C> BiFunction<B,A,C> flip(BiFunction<A,B,C> f) {
        return null;
    }


    /**
     * @return curry function created from the given f
     */
    public static <A,B,C> Function<A, Function<B,C>> cur(BiFunction<A,B,C> f) {
        return null;
    }




}
