import java.util.Scanner;
public class Practice_Array {

    private static final Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Week 7, Lab 6 - Practice Arrays");

        System.out.println("How many elements of the array do you want?");
        int arraySize = keyboard.nextInt();

        //DECLARE AN ARRAY
        int[] myArray = new int[arraySize];
        int [][] yourArray = new int[3][2]; // 3 rows, 2 columsn: row always comes before columns

        // update your array
        int rowIndex;
        int columnIndex;



        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++){
            System.out.println("At row " + rowIndex + " :");
            for(columnIndex = 0; columnIndex < yourArray[rowIndex].length; columnIndex++){

                System.out.println("At index [" + rowIndex + "] [" + columnIndex +"]: Enter a number: ");
                yourArray[rowIndex][columnIndex] = keyboard.nextInt();

            }// end of the inner loop ----> (column)
        }// end of the outer loop --------> (row)



        //display
        System.out.println("Displaying the result...");
        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++){
            System.out.println("At row " + rowIndex + " :");
            for(columnIndex = 0; columnIndex < yourArray[rowIndex].length; columnIndex++){

                System.out.println("At index [" + rowIndex + "] [" + columnIndex +"]: The value is: " + yourArray[rowIndex][columnIndex]);
                yourArray[rowIndex][columnIndex] = keyboard.nextInt();

            }// end of the inner loop ----> (column)
        }// end of the outer loop --------> (row)

    }// end of the main method


    private static void updateMyArray(int[] myArray){
        //update your array
        int index; //always declare your index outside
        for(index = 0; index < myArray.length; index++){

            System.out.println("At index [" + index + "], Enter a number: ");
            myArray[index] = keyboard.nextInt();
        }// end of the for loop

        //display your array - to display, copy the loop
        for(index = 0; index < myArray.length; index++) {

            System.out.println("At index [" + index + "], The value is: " + myArray[index]);
        }// end of the for loop
    }



}// end of the public class Practice_Array
