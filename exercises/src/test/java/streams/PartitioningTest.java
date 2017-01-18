package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

/*
Partition adults and kids
 */
public class PartitioningTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, Set<Person>> result = Partitioning.partitionAdults(collection);
        Assert.assertTrue(result.get(true).equals(Util.asSet(eva, viktor)));
        Assert.assertTrue(result.get(false).equals(Util.asSet(sara)));
    }

}
