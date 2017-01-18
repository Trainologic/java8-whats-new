/**
 * @author victorp
 */
public class Sample3LambdaScope {

    Runnable r1 = () -> Util.println(this);


    Runnable r2 = new Runnable() {
        public void run() {
            System.out.println(this);
        }
    };




    public String toString() {
        return "Hasamba!";
    }



    public static void main(String[] args) {
            new Sample3LambdaScope().r1.run();
            new Sample3LambdaScope().r2.run();
    }
}


