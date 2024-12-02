import java.lang.reflect.Array;
import java.util.ArrayList;


public class ExceptionalIntegers {

    public static void main(String[] args) {
        System.out.println("Week 12 - Lab 10");

        String currentElement = "";
        int nextInteger;
        ArrayList <Integer> commandLineInput = new ArrayList<Integer>();


        for (int index= 0;  index < args.length; index++){
           // System.out.println(commandLineInput.get(index));

            try {
                nextInteger = converter(args[index]);
                commandLineInput.add(nextInteger);

            }// end of the try statement
            catch(NumberFormatException e){

                System.out.println("Catch block says the argument " + currentElement + "is ignored because " + currentElement);

            }// end of catch statement

        }// end of the for loop



        System.out.println("Your array list contents are: " + currentElement);
        for (int index = 0; index < commandLineInput.size(); index++){
            System.out.println("Item " + index + " is " + commandLineInput.get(index));

        }// end of the for loop


    }// end of the main method

    private static int converter (String myInfoList) throws NumberFormatException{
        int converter = Integer.parseInt(myInfoList); // you are just passing the info list through so you can turn it into an integer

        System.out.println("Converter method says the integer is OK - " + converter);

        return converter;

    }// end of the converter method

}// end of the ExceptionalIntegers class
