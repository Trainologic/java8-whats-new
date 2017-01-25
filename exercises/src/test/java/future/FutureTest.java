package future;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author victorp
 */
public class FutureTest {


    @Test
    public void twoFutures() throws InterruptedException, ExecutionException, TimeoutException {
        Integer result1 = 1;
        String result2 = "2";


        Future<Pair<Integer,String>> f = JavaWorkUtil.doItInTheFuture(result1, result2);

        Util.println("future tasks are started, we can now wait for its results");
        Pair<Integer,String> result = f.get(1000, TimeUnit.MILLISECONDS);

        Util.println("future tasks are finished, results: " + result.toString());


        Assert.assertEquals(result1,result.getKey());
        Assert.assertEquals(result2, result.getValue());

    }



    @Test
    public void multiFutures() throws InterruptedException, ExecutionException, TimeoutException {
        String result1 = "1";
        String result2 = "2";
        String result3 = "3";


        Future<List<String>> f = JavaWorkUtil.doItInTheFuture(result1, result2, result3);

        Util.println("future tasks are started, we can now wait for its results");
        List<String> results = f.get(1000, TimeUnit.MILLISECONDS);

        Util.println("future tasks are finished, results: " + results.toString());


        Assert.assertTrue(results.contains(result1));
        Assert.assertTrue(results.contains(result2));
        Assert.assertTrue(results.contains(result3));


    }


}