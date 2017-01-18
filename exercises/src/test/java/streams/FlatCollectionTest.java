package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/*
Flatten multidimensional collection
 */
public class FlatCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        Set<String> expected = Util.asSet("Viktor", "Farcic", "John", "Doe", "Third");
        Assert.assertTrue(FlatCollection.flatten(collection).equals(expected));
    }

}
