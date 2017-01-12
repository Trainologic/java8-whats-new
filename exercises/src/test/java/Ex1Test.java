import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author victorp
 */

public class Ex1Test {

    @Test
    public void constFunctionTest() {
        Assert.assertEquals("const", Ex1.constFunction("const").apply("different"));
    }

    @Test
    public void flipFunctionTest() {
        BiFunction<String,String,String> f = (a,b) -> a+b;
        Assert.assertEquals("abcdef", f.apply("abc","def"));
        Assert.assertEquals("defabc", Ex1.flip(f).apply("abc", "def"));
    }


    @Test
    public void transformableTest() {
        Ex1.TransformableStringSet words = new  Ex1.TransformableStringSet(Arrays.asList("hello","java8"));
        Set<String> expected = new HashSet<>(Arrays.asList("HELLO","JAVA8"));

        Assert.assertEquals(expected,words.transform(String::toUpperCase));


    }

    @Test
    public void capitalizeTest() {

        Set<String> words = new HashSet<>(Arrays.asList("hello","java8"));
        Set<String> expected = new HashSet<>(Arrays.asList("Hello","Java8"));

        Assert.assertEquals(expected,Ex1.capitalize(words));
    }


        @Test
    public void cur(){
        BiFunction<String,String,String> f = (a,b) -> a+b;
        Function<String,String> f1 = Ex1.cur(f).apply("abc");
        Assert.assertEquals("abcdef", f1.apply("def"));

    }

}
