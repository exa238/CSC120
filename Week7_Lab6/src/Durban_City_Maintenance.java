import java.util.Scanner;

public class Durban_City_Maintenance {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //use the scanner so that we can read the user's input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Week 7 - Lab 6 - Durban Street Maintenance");

        //ask for the number of houses, which would be an integer (no half houses)
        System.out.println("How many houses are in the street?");
        int numberOfHouses = keyboard.nextInt();


        //make sure to INITIALIZE THE ARRAYS (here)
        int[] houseNumbers = new int[numberOfHouses]; //initialize the houseNumbers array which is going to hold house numbers
        //initialize the array peopleAges which holds different number of ages for each house, multidimensional



        //declare your indexes for your integers
        int index;

        //create an array in peopleAges to hold the ages of that house's residents
        for (index = 0; index < houseNumbers.length; index++){ //update the array
            System.out.print("At index [" + index + "], What is the next house number?");
            houseNumbers[index] = keyboard.nextInt();

        }// end of the for loop


        int[][] peopleAges = new int[numberOfHouses][];

        int rowIndex;
        int columnIndex;

        for(rowIndex = 0; rowIndex < peopleAges.length; rowIndex++) {
            System.out.println("How many people live in: " + houseNumbers[rowIndex]);
            int peopleInHouse = keyboard.nextInt();
            peopleAges[rowIndex] = new int[peopleInHouse];
            for (columnIndex = 0; columnIndex < peopleAges[rowIndex].length; columnIndex++){
                System.out.println("What is the age of the person" + (columnIndex +1));
                peopleAges[rowIndex][columnIndex] = keyboard.nextInt();
            }
        }// end of the for loop


        // counting

        for(rowIndex = 0; rowIndex < peopleAges.length; rowIndex++){
            int totalAge = 0;

            for(columnIndex = 0; columnIndex < peopleAges[rowIndex].length; columnIndex++) {

                totalAge = totalAge + peopleAges[rowIndex][columnIndex];

            }// end of the inner loop ----> (column)

            System.out.println("House" + (houseNumbers[rowIndex]) + "has a total age of" + totalAge);
        }// end of the outer loop --------> (row)


        int totalStreetAge = 0;
        for (rowIndex= 0; rowIndex < peopleAges.length; rowIndex++){
            for(columnIndex = 0; columnIndex < peopleAges[rowIndex].length; columnIndex++){

            }
        }










    }// end of the main method



}// end of the public class Dublin_Street_Maintenance
