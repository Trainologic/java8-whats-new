package checker;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author victorp
 */


public class Person {

    @Nullable
    public final  String name;

    public final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
