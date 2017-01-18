package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/*
Get names of all kids (under age of 18)
 */
public class KidsTest {

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsFromNorway() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        Assert.assertTrue(Kids.getKidNames(collection).contains("Sara"));
        Assert.assertTrue(Kids.getKidNames(collection).contains("Anna"));
        Assert.assertFalse(Kids.getKidNames(collection).contains("Viktor"));
        Assert.assertFalse(Kids.getKidNames(collection).contains("Eva"));

    }

}
