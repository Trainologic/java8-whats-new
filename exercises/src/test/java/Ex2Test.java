import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author victorp
 */
public class Ex2Test {

    @Test
    public void filterPrefixesTest(){
        List<String> msgs = Arrays.asList("Hello", "World", "Java", "Down");
        List<String> prefixes = Arrays.asList("H", "Ja");

        Set<String> expected = new HashSet<>(Arrays.asList( "World", "Down"));

        Assert.assertEquals(expected,Ex2.filterPrefixes(prefixes, msgs));

    }
}
