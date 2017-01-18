package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

/*
Group people by nationality
 */
public class GroupingTest {

    @Test
    public void partitionByNationality() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, Set<Person>> result = Grouping.groupByNationality(collection);
        Assert.assertTrue(result.get("Norwegian").equals(Util.asSet(eva,sara)));
        Assert.assertTrue(result.get("Serbian").equals(Util.asSet(viktor)));
    }

}
