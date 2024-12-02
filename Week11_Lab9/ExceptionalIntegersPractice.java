
import java.util.ArrayList;

public class ExceptionalIntegersPractice {

    public static void main(String[] args) {
        System.out.println("Week 12 - Lab 10");

        ArrayList <String> myInfoList = new ArrayList<String>();

        myInfoList.add("Emily A");
        myInfoList.add("Computer Science");
        myInfoList.add("4.0"); // you can only store the same data type, so despite it being a int, you are going to make it a string

        double currentGPA = Double.parseDouble(myInfoList.get(2));

        System.out.println(myInfoList);

        for (int index = 0; index < myInfoList.size(); index++){
            System.out.println(myInfoList.get(index));
        }// end of the for loop

    }// end of the main method

}// end of the ExceptionalIntegersPractice class
