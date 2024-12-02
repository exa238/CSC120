public class Person {

    // Instance variables
    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = " ";
        this.age = 0;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void incrementAge() {
        age++;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String toString() {
        return name + " is " + age + " years old";
    }
}
