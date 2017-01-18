package streams;

public class Person {

    private String name;
    private int age;
    private String nationality;

    public Person(final String nameValue, final int ageValue) {
        name = nameValue;
        age = ageValue;
    }

    public Person(final String nameValue, final int ageValue, final String nationalityValue) {
        name = nameValue;
        age = ageValue;
        nationality = nationalityValue;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return !(nationality != null ? !nationality.equals(person.nationality) : person.nationality != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        return result;
    }
}