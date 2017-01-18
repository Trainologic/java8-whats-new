/**
 * @author victorp
 */
public class Sample1LamdbaSyntax {


    public static void main(String... args){


        Runnable task1 = new Runnable(){
            @Override
            public void run() {
                Util.println("Java 7");
            }
        };


        Runnable task2 = () -> { Util.println("Java 8  with brackets"); };


        Runnable task3 = () -> Util.println("Java 8 NO brackets");


        task1.run();
        task2.run();
        task3.run();
    }
}
