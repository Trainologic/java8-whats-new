package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static streams.Util.asSet;

/*
Filter collection so that only elements with less then 4 characters are returned.
 */
public class FilterCollectionTest {

    @Test
    public void transformShouldFilterCollection() {
        Set<String> collection = asSet("My", "name", "is", "John", "Doe");
        Set<String> expected = asSet("My", "is", "Doe");
        Assert.assertTrue(FilterCollection.transform(collection).equals(expected));
    }

}
