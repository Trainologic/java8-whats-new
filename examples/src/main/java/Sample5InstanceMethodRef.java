import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author victorp
 */
public class Sample5InstanceMethodRef {

        public static void main(String... args){

            ExecutorService executorService = Executors.newFixedThreadPool(1);


            Sample5InstanceMethodRef obj = new Sample5InstanceMethodRef();
            executorService.submit(obj::task);
        }


        public void task(){
            Util.println("Method ref is invoked");
        }

}
