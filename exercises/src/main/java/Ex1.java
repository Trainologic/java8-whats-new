import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
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
     */
    public static <A,B,C> BiFunction<B,A,C> flip(BiFunction<A,B,C> f) {
        return null;
    }


    /**
     * Impl transform function
     */
    public static class TransformableStringSet extends HashSet<String>{
        public TransformableStringSet() {
        }

        public TransformableStringSet(Collection<? extends String> c) {
            super(c);
        }

        TransformableStringSet transform(Function<String,String> transformer ){
            TransformableStringSet result = new TransformableStringSet();
            for (String element: this) {
                result.add(transformer.apply(element));
            }
            return result;
        }
    }


    /**
     *
     * @return  the given word with Capital first letter.
     *          if the word is empty returns empty string.
     */
    public static String capitalize(String word){
        if (word.length() <1) return word;

        char[] result = word.toCharArray();
        result[0] = Character.toUpperCase(word.toCharArray()[0]);
        return new String(result);
    }


    /**
     * Hint: use {@link TransformableStringSet}
     * @return the given words after capitalization
     */
    public static Set<String> capitalize(Set<String> words){
        TransformableStringSet result = new TransformableStringSet(words);
        return result.transform(Ex1::capitalize);
    }




    /**
     * @return curry function created from the given f
     */
    public static <A,B,C> Function<A, Function<B,C>> cur(BiFunction<A,B,C> f) {
        return null;
    }




}
