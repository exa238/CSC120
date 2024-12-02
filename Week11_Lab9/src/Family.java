import java.util.Scanner;
public class Family {

    public static final int MAX_PEOPLE = 10;
    private Person[] people;
    private int numPeople;

    private static final Scanner keyboard = new Scanner(System.in);

    private int peopleInFamily;

    public Family(){
        people = new Person[MAX_PEOPLE];
        numPeople = 0;
    }

    public boolean addPerson(String name, int age){
        if(numPeople < MAX_PEOPLE){
            people[numPeople] = new Person(name, age);
            numPeople++;
            return true;
        }
        else{
            return false;
        }
    }

    public int getNumberOfPeople(){
        return people.length;
    }

    public void birthday(String name){
        int index;
        for (index = 0; index < numPeople; index++){
            if(people[index].getName().equals(name)){
                people[index].incrementAge();
            }
        }
    }

    public int getTotalAge(){
        int index;
        int totalAge = 0;
        for(index = 0; index < numPeople; index++){
            totalAge = totalAge + people[index].getAge();
        }
        return totalAge;
    }

    public void display(){
        int index;
        for (index = 0; index < numPeople; index++){
            System.out.println(people[index]);
        }
    }


}
