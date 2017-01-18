import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author victorp
 */
public class Sample4StaticMethodRef {
    public static void main(String... args){

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(Sample4StaticMethodRef::task);
    }


    public static void task(){
        Util.println("Method ref is invoked");
    }

}
