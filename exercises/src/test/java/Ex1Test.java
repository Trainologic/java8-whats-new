import org.junit.Assert;
import org.junit.Test;

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
    public void cur(){
        BiFunction<String,String,String> f = (a,b) -> a+b;
        Function<String,String> f1 = Ex1.cur(f).apply("abc");
        Assert.assertEquals("abcdef", f1.apply("def"));

    }

}
