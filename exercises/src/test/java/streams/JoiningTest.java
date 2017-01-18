package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/*
Return people names separated by comma
 */
public class JoiningTest {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        Assert.assertTrue(Joining.namesToString(collection).equals("Names: Sara, Viktor, Eva."));
    }

}
