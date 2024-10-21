import java.util.Scanner;
public class IThinkThereforeIAm {

    private static final Scanner keyboard = new Scanner(System.in);
    public static String allQualities = "The qualities are: ";

    public static void main(String[] args) {
        System.out.println("Week 10 - Lab 8");

        System.out.println("Please enter sentences, . to end.");
        String sentence = keyboard.nextLine();


        while(!sentence.equals(".")) {
            if(sentence.startsWith("I am")){
                String quality = sentence.substring(5);
                allQualities = allQualities + quality + ",";

            }// end of if statement

            sentence = keyboard.nextLine();

        }// end of while loop

        System.out.println(allQualities);













    }// end of the main method
}// end of the IThinkThereforeIAm class
