import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * @author victorp
 */
public class Sample6InsMetRefVSAnonClass {
    public static void main(String... args){

        // All predicates return the same results.
        Collection<String> names = Collections.singletonList("John");

        Predicate<String> p1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return names.contains(s);
            }
        };

        Predicate<String> p2 = (s) -> names.contains(s);

        Predicate<String> p3 = names::contains;

        Util.println(p1.test("John"));
        Util.println(p2.test("John"));
        Util.println(p3.test("John"));
    }


}
