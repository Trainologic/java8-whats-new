/**
 * @author victorp
 */
public class Sample3LambdaScope {

    public void runIt(){
        Runnable r1 = () -> Util.println(this);


        Runnable r2 = new Runnable() {
            public void run() {
                Util.println(this);
            }
        };
    }


    public String toString() {
        return "Hasamba!";
    }



    public static void main(String[] args) {
            new Sample3LambdaScope().runIt();
            new Sample3LambdaScope().runIt();
    }
}


