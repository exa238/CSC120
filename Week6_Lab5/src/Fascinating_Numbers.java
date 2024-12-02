import java.util.Scanner;

public class Fascinating_Numbers {

    private static final Scanner keyboard = new Scanner(System.in);



    public static final int MAXIMUM_INPUT = 10;

    public static final int STOP_INPUT = 0;


    public static void main(String[] args) {

        System.out.println("Week 6 - Lab 5");

        int [] numbersInput = new int [MAXIMUM_INPUT];


        int index = 0;
        int [] inputNumbers = new int[MAXIMUM_INPUT];
        int count = numbersEntered(inputNumbers);

        for (index = 0; index < count; index++ );
            if (isPrime(inputNumbers[index]) && testFibonacciNumber(inputNumbers[index])){
            System.out.println(inputNumbers[index] + "is Fibonacci and is prime");
        }
        else if (isPrime(inputNumbers[index]) && !testFibonacciNumber(inputNumbers[index])){
            System.out.println(inputNumbers[index] + "is Fibonacci and is not prime" );
        } else if (isPrime(inputNumbers[index]) &&  testFibonacciNumber(inputNumbers[index])){
            System.out.println("is not Fibonacci and is prime");
        } else{
            System.out.println(inputNumbers[index] + "is not Fibonacci and is not prime");
        }



    }// end of main method


    private static boolean isPrime(int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {
                return(false);
            }
            divisor++;
        }
        return(true);
    } // end of isPrime method

    private static boolean testFibonacciNumber (int number){
        int previous = 1;
        int current = 0;
        int next;

        while (current < number);
        next = current + previous;
        previous = current;
        current = next;
            if (current == number) {
                return true;
            }
            else{
                return false;
            }
    }// end of the testFibonacciNumber method

    private static int numbersEntered(int[] numbersInput) {
        int index = 0;
        System.out.println("Please enters numbers (0 to stop): ");
        do {
            numbersInput[index] = keyboard.nextInt();
            index++;
        } while ((numbersInput[index - 1] != STOP_INPUT) && (index < numbersInput.length));





        return index - 1;
    }// end of the findNumberInput method


}// end of the public class Fascinating_Numbers


