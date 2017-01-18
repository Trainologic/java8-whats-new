package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static streams.ToUpperCase.toUpperCase;

/*
Convert elements of a collection to upper case.
 */
public class ToUpperCaseTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        Set<String> expected = Util.asSet("MY", "NAME", "IS", "JOHN", "DOE");
        Assert.assertTrue(toUpperCase(collection).equals(expected));
    }

}
