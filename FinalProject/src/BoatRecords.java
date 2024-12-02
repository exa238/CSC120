import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoatRecords {

    //establish your constants for maximum purchase price and maximum length in feet
    public static final double MAX_PURCHASE_PRICE = 1000000;
    public static final double MAX_LENGTH_IN_FEET = 100;

    //these two are for the fleet data storage
    private static ArrayList<Boat> boatList = new ArrayList<>(); //array list
    private static final Scanner keyboard = new Scanner(System.in); //scanner object


    public static void main(String[] args) {

        //welcome banner
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        try{
            loadBoatData("FleetData.csv", boatList);
        } catch (IOException e) {
            System.out.println("Error loading boat data: " + e.getMessage());
        }


        char menuOfChoices;
        //loop to display menu options until the user wants to exit
        do{
            menuOfChoices = getMenuOfChoices(keyboard);
            keyboard.nextLine(); //clear the buffer
            switch(menuOfChoices){
                case 'P': // print the inventory
                    printInventory();
                    break;
                case 'A': //add a boat
                    addBoat();
                    break;
                case 'R': //remove boat
                    removeBoat();
                    break;
                case 'E': //request permission to spend money on boat
                    requestPermission();
                    break;
                case 'X': // exit the program
                    System.out.println("Exiting the Fleet Management System");
                    break;
                default: //otherwise, handle the invalid menu option
                    System.out.println("Invalid menu option. Try again.");
            }//end of switch

        } while (menuOfChoices != 'X'); // allow the loop to continue until X is selected

    }// end of main method



    private static char getMenuOfChoices(Scanner keyboard) {
        System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it: ");
        String input = keyboard.nextLine();
        return input.toUpperCase().charAt(0);
    }// end of the getMenuofChoices method

    private static void printInventory() {
        System.out.println("\nFleet report:");
        double totalPaid = 0;
        double totalSpent = 0;
        for(Boat boat : boatList) {
            System.out.println(boat);
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }// end of the for loop
        System.out.printf("Total: Paid $%.2f | Spent $%.2f\n", totalPaid, totalSpent);
    }// end of the printInventory method

    private static void addBoat() {
        System.out.print("Enter boat type (SAILING/POWER): ");
        String typeInput = keyboard.nextLine().toUpperCase();

        System.out.print("Enter boat name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter year: ");
        int year = keyboard.nextInt();

        keyboard.nextLine(); // clear buffer
        System.out.print("Enter make/model: ");

        String makeModel = keyboard.nextLine();
        System.out.print("Enter length in feet: ");

        double length = keyboard.nextDouble();
        System.out.print("Enter purchase price: ");

        double purchasePrice = keyboard.nextDouble();

        Boat.BoatType type = Boat.BoatType.valueOf(typeInput);
        boatList.add(new Boat(type, name, year, makeModel, length, purchasePrice));
        System.out.println("Boat added successfully.");
    }// end of the addBoat method

    private static void removeBoat() {
        System.out.print("Which boat do you want to remove? ");
        String boatName = keyboard.nextLine();

        boolean removed_boat = false;

        // loop through the boatList and look for a match
        for (int index = 0; index < boatList.size(); index++) {
            if (boatList.get(index).getName().equalsIgnoreCase(boatName)) {
                boatList.remove(index);
                removed_boat = true;
                break;
            }
        }// end of the for loop

        if(removed_boat) {
            System.out.println("Boat removed.");
        }else {
            System.out.println("Cannot find boat " + boatName);
        }

    }// end of the removeBoat method


    private static void requestPermission() {
        System.out.print("Which boat do you want to spend on? ");
        String boatName = keyboard.nextLine();
        for(Boat boat : boatList) {
            if (boat.getName().equalsIgnoreCase(boatName)) {
                System.out.print("How much do you want to spend?");
                double amount = keyboard.nextDouble();
                if (boat.canSpend(amount)) {
                    boat.spend(amount);
                    System.out.printf("Expense authorized, $%.2f spent.\n", amount);
                }else {
                    System.out.printf("Expense not permitted, only $%.2f left to spend.\n", boat.getRemainingBudget());
                }
                return;
            }
        }// end of the for loop

        System.out.println("Cannot find boat" + boatName);

    }// end of the requestPermission method

    public static void loadBoatData(String csvBoatFile, ArrayList<Boat> boatList) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvBoatFile))) {
            String currentLine = reader.readLine();  // Skip header if there is one

            while (currentLine != null) {
                System.out.println("Processing line: " + currentLine);  // Debugging line

                String[] userInputArray = currentLine.split(",");
                try {
                    Boat boat = new Boat(
                            Boat.BoatType.valueOf(userInputArray[0].toUpperCase()),
                            userInputArray[1],
                            Integer.parseInt(userInputArray[2]),
                            userInputArray[3],
                            Double.parseDouble(userInputArray[4]),
                            Double.parseDouble(userInputArray[5])
                    );
                    boatList.add(boat);
                } catch (NumberFormatException e) {
                    System.out.println("Number error in line: " + currentLine);
                } catch (IllegalArgumentException e) {
                    System.out.println("Boat type error in line: " + currentLine);
                }
                currentLine = reader.readLine();
            }
        }
    }



}// end of BoatRecord class
