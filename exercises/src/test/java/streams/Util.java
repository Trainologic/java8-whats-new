package streams;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author victorp
 */
public class Util {

    public static <T> Set<T> asSet(T... a) {
        return Arrays.asList(a).stream().collect(Collectors.toSet());
    }
}
