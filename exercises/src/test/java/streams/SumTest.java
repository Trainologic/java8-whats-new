package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/*
Sum all elements of a collection
 */
public class SumTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Assert.assertTrue(Sum.calculate(numbers) == (1 + 2 + 3 + 4 + 5));
    }

}
