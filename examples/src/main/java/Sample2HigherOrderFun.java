import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author victorp
 */
public class Sample2HigherOrderFun {

    public static void main(String... args){

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Runnable task = () -> Util.println("Java 8 task");

        executorService.submit(task);

        executorService.submit(() -> Util.println("Lambda task"));
    }
}
