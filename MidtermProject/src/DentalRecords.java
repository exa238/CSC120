import java.util.Scanner;

public class DentalRecords {

    //create a scanner object for input
    private static final Scanner keyboard = new Scanner(System.in);

    //establish the constants for maximum family size and the number of teeth
    public static final int MAX_FAMILY_AMOUNT = 6;
    public static final int MAX_TEETH = 8;


    public static void main(String[] args) {
        //welcome banner
        System.out.println("Welcome to the Floridian Teeth Records");
        System.out.println("--------------------------------------");

        //scanner for user input
        Scanner scanner = new Scanner (System.in);
        //array to store family member names
        String[] family = new String[MAX_FAMILY_AMOUNT];
        // three dimensional array to store upper and lower teeth data
        char[][][] teethData = new char[MAX_FAMILY_AMOUNT][2][MAX_TEETH];
        //get the number of family members
        int familySize = getFamilySize(keyboard);
        //clear the newline character
        scanner.nextLine();


        // loop through the number of family members to collect their names and teeth data
        for(int index = 0; index < familySize; index++){
            //get the family member's name
            family[index] = getName(scanner, index);
            //get the upper teeth data
            teethData[index][0] = getTeeth(scanner, "uppers", family[index]);
            //get the lower teeth data
            teethData[index][1] = getTeeth(scanner, "lowers", family[index]);
        }// end of the for loop


        char menuOfChoices;
        //loop to display menu options until the user wants to exit
        do{
            //get the user's menu choice
            menuOfChoices = getMenuOfChoices(scanner);
            scanner.nextLine();
            switch(menuOfChoices){
                case 'P': // print family teeth
                    printFamilyTeeth(family, teethData);
                    break;
                case 'E': //extract a tooth
                    extractTooth(scanner, family, teethData);
                    break;
                case 'R': //report root canal data
                    reportRootCanal(teethData, familySize);
                    break;
                case 'X': // exit the program
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    break;
                default: //otherwise, handle the invalid menu option
                    System.out.println("Invalid menu option. Try again.");
            }

        } while (menuOfChoices != 'X'); // allow the loop to continue until X is selected


    }// end of the main method

    //method to get the size of the family
    static int getFamilySize(Scanner scanner){

        int familySize = 0;
        //flag for valid input
        boolean validInput = false;

        //loop until a valid family is provided
        while (!validInput) {
            System.out.print("Please enter the number of people in your family: ");
            //check if input is an integer
            if (scanner.hasNextInt()) {
                //get the next integer input
                familySize = scanner.nextInt();
                //clear the newline character
                scanner.nextLine(); // Clear the newline character

                //check if size is within valid range
                if (familySize >= 1 && familySize <= MAX_FAMILY_AMOUNT) {
                    validInput = true; // Valid input received
                } // end of if statement
                else {
                    System.out.println("Invalid number of people. Please try again.");
                }// end of else statement
            } // end of the if statement
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }// end of the else statement
        }// end of the while loop

        return familySize;
    }// end of the getFamilySize method


    // method to get the teeth data for a family member
    static String getName(Scanner scanner, int memberIndex){
        System.out.print("Please enter the name for family member" + (memberIndex + 1) + ": ");
        //flag for valid input
        return scanner.nextLine(); // read full names
    }// end of the getName method


    //method to get the teeth data for a family member
    static char[] getTeeth(Scanner scanner, String layer, String memberName) {
        //array to store teeth data
        char[] teeth = new char[MAX_TEETH];
        //flag for valid input
        boolean validInput;

        //loop until valid teeth data is provided
        do {
            //reset validInput flag from earlier
            validInput = true;
            System.out.print("Please enter the " + layer + " for " + memberName + ": ");
            //reads input and converts to uppercase
            String input = scanner.nextLine().toUpperCase();

            // Check length
            if (input.length() > MAX_TEETH) {
                System.out.println("Too many teeth, try again.");
                //set flag to false for invalid input
                validInput = false;
                //continue to prompt for valid input
                continue;
            }

            // Fill teeth array and check validity
            for (int index = 0; index < MAX_TEETH; index++) {
                if (index < input.length()) {
                    //get the tooth types
                    char toothType = input.charAt(index);

                    //check for valid tooth types
                    if (toothType != 'I' && toothType != 'B' && toothType != 'M') {
                        System.out.println("Invalid teeth types, try again.");
                        //set flag to false for invalid input
                        validInput = false;
                        //break out of the loop if input is invalid
                        break;
                    }// end of the if statement

                    // store valid tooth type in an array
                    teeth[index] = toothType;
                }
                else {
                    teeth[index] = '\u0000'; // Default value if not satisfied
                }// end of the else statement

            }// end of the for loop

        } // end of the do while loop

        // continue until valid input is received
        while (!validInput);

        // return the teeth array
        return teeth;

    }// end of the getTeeth method

    //method to get the user's menu choice
    static char getMenuOfChoices(Scanner scanner) {
        char choice;
        do {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");
            // read and convert choice to uppercase
            choice = scanner.next().toUpperCase().charAt(0);
            //clear newline
            scanner.nextLine();
            //check for a valid choice
            if (choice != 'P' && choice != 'E' && choice != 'R' && choice != 'X') {
                System.out.println("Invalid menu option, try again.");
            }// end of the if statement
        } // end of the do while loop

        //repeat until a valid choice is made
        while (choice != 'P' && choice != 'E' && choice != 'R' && choice != 'X');

        //return the valid choice
        return choice;
    }//end of the getMenuOfChoices method


    //method for printing teeth data for the family
    static void printFamilyTeeth(String[] family, char[][][] teethData){
        // loop through each family member
        for(int index = 0; index < family.length && family[index] != null; index++) {
            // print family membe rname
            System.out.println(family[index]);
            //print upper teeth data
            System.out.print("  Uppers: ");
            for (int upperToothIndex = 0; upperToothIndex < MAX_TEETH; upperToothIndex++) {
                //get upper tooth
                char tooth = teethData[index][0][upperToothIndex];
                // print tooth number and type -- or  '-' if not present
                System.out.print((upperToothIndex + 1) + ":" + (tooth != '\u0000' ? tooth : '-') + "  ");
            }// end of the for loop

            // new line for lower teeth
            System.out.println();
            // print lower teeth data
            System.out.print("  Lowers: ");
            for (int lowerToothIndex = 0; lowerToothIndex < MAX_TEETH; lowerToothIndex++) {
                //get lower tooth
                char tooth = teethData[index][1][lowerToothIndex];
                // print tooth number and type -- or '-' if not present
                System.out.print((lowerToothIndex + 1) + ":" + (tooth != '\u0000' ? tooth : '-') + "  ");

            }// end of the for loop

            System.out.println(); // new line after printing all the teeth
        }// end of the for loop
    }// end of the printFamilyTeeth method

    //method to extract a tooth from a family member
    static void extractTooth(Scanner scanner, String[] family, char[][][] teethData){
        String memberName; // variable to hold the name of a family member
        int memberIndex =-1; // index of the family member
        boolean validInput = false;  // flag for valid input

        //loop until a valid family member is provided
        while (!validInput) {
            System.out.print("Which family member: ");
            memberName = scanner.nextLine(); //  capture their full name
            memberIndex = findFamilyMemberIndex(family, memberName); // find the index of the member

            if (memberIndex != -1) { // Check if a valid family member was found
                validInput = true; // Set the flag to true to exit the loop
            } // end of the if statement
            else {
                System.out.println("Invalid family member, try again.");
            }// end of the else statement
        }// end of the while loop

        char layer = getLayer(scanner); //variable for layer choice
        int toothIndex = -1;
        boolean validToothInput = false;
        //int toothIndex = getToothIndex(scanner, layer);
        while(!validToothInput) {
            toothIndex = getToothIndex(scanner, layer);
            if (toothIndex != -1) {
                char[] teeth = (layer == 'U') ? teethData[memberIndex][0] : teethData[memberIndex][1];

                if (teeth[toothIndex] == 'M') {
                    System.out.println("Missing tooth, try again.");
                } // end of if statement
                else {
                    teeth[toothIndex] = 'M';// mark the tooth as missing
                    validToothInput = true; //exit the loop
                }// end of else statement

            }// end of the if statement
            else{
                System.out.println("Invalid tooth number, try again.");
            }// end of the else statement

        }// end of the while loop

    } // end of the extractTooth method

    static int findFamilyMemberIndex(String[] family, String memberName){
        for(int index = 0; index < family.length; index++){
            if(family[index] != null && family[index].equalsIgnoreCase(memberName)){//REVISE
                return index;
            }// end of the if statement

        }// end of the for loop
        return -1; // not found, but we might revise to make sure that it doesn't take negative numbers, not just -1

    }// end of the findFamilyMemberIndex method

    //method to get the layer (upper or lower) for tooth extraction
    static char getLayer(Scanner scanner){
        char layer = ' '; // variable for layer choice
        while(layer != 'U' && layer != 'L'){
            System.out.print("Which tooth layer (U)pper or (L)ower: ");
            layer = scanner.next().toUpperCase().charAt(0); // convert to upper case
            if(layer != 'U' && layer != 'L'){
                System.out.println("Invalid layer, try again.");

            }// end of the if statement

        }// end of the while loop

        return layer;

    }// end of the getLayer method


    // method to get the tooth number for extraction
    static int getToothIndex(Scanner scanner, char layer) {
        int toothIndex = -1;
        //loop until tooth number is provided
        while (toothIndex < 1 || toothIndex > MAX_TEETH) {
            System.out.print("Which tooth number: ");
            if (scanner.hasNextInt()) {
                toothIndex = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                if (toothIndex < 1 || toothIndex > MAX_TEETH) {
                    System.out.println("Invalid tooth number, try again.");

                }// end of the if statement

            } // end of the if statement
            else {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }// end of the else statement

        }// end of the while loop
        return toothIndex - 1; // return the right tooth number
    }// end of the getToothIndex method

    //method to report root canal data
    static void reportRootCanal(char[][][] teethData, int familySize) {
        int incisorCount = 0, biscupidCount = 0, missingCount = 0;

        // Count the types of teeth
        for (int index = 0; index < familySize; index++) {
            //count upper teeth
            for (char tooth : teethData[index][0]) {
                if (tooth == 'I') incisorCount++;
                else if (tooth == 'B') biscupidCount++;
                else if (tooth == 'M') missingCount++;
            }

            //count lower teeth
            for (char tooth : teethData[index][1]) {
                if (tooth == 'I') incisorCount++;
                else if (tooth == 'B') biscupidCount++;
                else if (tooth == 'M') missingCount++;
            }// end of the for loop

        }// end of the for loop

        // print the counts of each of the teeth
        System.out.println("Incisor Count: " + incisorCount);
        System.out.println("Biscupid Count: " + biscupidCount);
        System.out.println("Missing Count: " + missingCount);

        // Set coefficients for the quadratic equation
        int I = incisorCount;        // coefficient of x^2
        int B = biscupidCount;       // coefficient of x
        int M = missingCount;        // constant term

        // Ensure the quadratic equation is valid
        if (I != 0) {
            // calculate the discriminant
            double discriminant = Math.pow(B, 2) - 4 * I * (-M); // Using -M because of the structure of the equation

            // calculate and print the roots
            if (discriminant > 0) {
                double root1 = (-B + Math.sqrt(discriminant)) / (2 * I);
                double root2 = (-B - Math.sqrt(discriminant)) / (2 * I);
                System.out.printf("One root canal at %.2f\n", root1);
                System.out.printf("Another root canal at %.2f\n", root2);
            } // end of the if statement
            else if (discriminant == 0) {
                double root = -B / (2.0 * I);
                System.out.printf("One double root canal at %.2f\n", root);
            } // end of the else if statement
            else {
                System.out.println("No real roots found for the root canal equation.");
            }
        } // end of the if statement

        else {
            System.out.println("Invalid quadratic equation.");
        }// end of the else statement
    }// end of reportRootCanal method








}// end of the DentalRecords class
