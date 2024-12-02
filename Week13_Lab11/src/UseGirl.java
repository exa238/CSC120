import java.util.Scanner;

public class UseGirl {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String name;

        double carat = -1;

        double value = -1;

        System.out.println("Enter the name of the girl: ");

        name = keyboard.next();

        Girl myGirl = new Girl(name);

        System.out.println(myGirl);

        do{
            System.out.println("Enter carats and value: ");
            carat = keyboard.nextDouble();
            value = keyboard.nextDouble();

            Diamond myDiamond = new Diamond(carat, value);

            if (myGirl.setDiamond(myDiamond)){
                System.out.println("Woohoo, the girl took the diamond");
            }else{
                System.out.println("Aaargh, the diamond was rejected");
            }
            System.out.println(myGirl);
        } while(carat != 0.0 && value != 0.0);


    }// end of main method
}// end of UseGirl class
