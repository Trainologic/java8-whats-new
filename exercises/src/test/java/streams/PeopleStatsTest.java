package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/*
Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
 */
public class PeopleStatsTest {

    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    List<Person> collection = asList(sara, eva, viktor);

    @Test
    public void getStatsShouldReturnAverageAge() {
        Assert.assertTrue(PeopleStats.getStats(collection).getAverage() == ((double)(4 + 40 + 42) / 3));
    }

    @Test
    public void getStatsShouldReturnNumberOfPeople() {
        Assert.assertTrue(PeopleStats.getStats(collection).getCount() == 3);
    }

    @Test
    public void getStatsShouldReturnMaximumAge() {
        Assert.assertTrue(PeopleStats.getStats(collection).getMax() == 42);

    }

    @Test
    public void getStatsShouldReturnMinimumAge() {
        Assert.assertTrue(PeopleStats.getStats(collection).getMin() == 4);
    }

    @Test
    public void getStatsShouldReturnSumOfAllAges() {
        Assert.assertTrue(PeopleStats.getStats(collection).getSum() == 40 + 42 + 4);

    }

}
