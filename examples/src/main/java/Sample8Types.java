import checker.Person;
import org.checkerframework.checker.regex.qual.Regex;

/**
 * @author victorp
 */
public class Sample8Types {

    public static void main(String... args) {


        /**
         * Nullable access
         * correct: if (person.name != null)
         */

//        Person person = new Person("moshe",30);
//
//        Util.println(person.age);
//        Util.println(person.name);


        /**
         * Regex
         * correct: /^[a-z0-9_-]{3,16}$/
         */
//
//        @Regex
//        String regex = "{/^[a-z0-9_-]{3,16}$/";
//


        /**
         * Upper bound
         * correct: i < names.length
         */
//        String[] names = {"moshe","jacob"};
//
//        for (int i = 0; i < 2; i++){
//            Util.println(names[i]);
//        }

    }

}
