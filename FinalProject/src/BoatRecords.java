import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The BoatRecords class manages a fleet of boats allowing the user to add,
 * remove, and view boats as well as manage boat-related expenses. It interacts
 * with a list of boats and provides a menu for the user.
 */

public class BoatRecords {

    //establish your constants for maximum purchase price and maximum length in feet
    public static final double MAX_PURCHASE_PRICE = 1000000;
    public static final double MAX_LENGTH_IN_FEET = 100;

    //ArrayList to store the fleet of boats and Scanner for user input
    private static ArrayList<Boat> boatList = new ArrayList<>(); //array list
    private static final Scanner keyboard = new Scanner(System.in); //scanner object

    /**
     * Main method to start the fleet management system. It loads boat data from
     * a csv file, displays a menu to the user, and processes user input to manage
     * boats and expenses.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        //welcome banner
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        try{
            // load boat data from the specified CSV file into the boatList
            loadBoatData("FleetData.csv", boatList);
        } catch (IOException e) {
            // handle any errors that occur during file reading
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


    /**
     * Displays a menu of options to the user and returns the user's choice.
     *
     * @param keyboard A Scanner object used to capture user input.
     * @return The character representing the user's choice from the menu.
     */


    private static char getMenuOfChoices(Scanner keyboard) {
        // prompt the user for their menu choice
        System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it: ");
        String input = keyboard.nextLine(); // read user input
        return input.toUpperCase().charAt(0); // return the first input character as capital
    }// end of the getMenuofChoices method


    /**
     * Prints the current inventory of boats, including each boat's details and
     * total paid and spent amounts.
     */

    public static void printInventory() {
        // display a report of the current boat fleet
        System.out.println("Fleet report:");
        double totalPaid = 0;
        double totalSpent = 0;

        // loop through the boatList to print each boat's details
        for (Boat boat : boatList) {
            System.out.println(boat);
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }

        // total values of all boats' purchase prices and expenses
        System.out.printf("Total: Paid $%.2f | Spent $%.2f\n", totalPaid, totalSpent);
    }//end of printInventory method


    /**
     * Prompts the user to enter a new boat's data in csv format, validates the input,
     * and adds the boat to the fleet if the input is correct.
     */


    private static void addBoat() {
        System.out.print("Please enter the new boat CSV data: ");
        String input = keyboard.nextLine();  // Get the full CSV input

        // split the input string by commas to separate values
        String[] userInputArray = input.split(",");

        if (userInputArray.length == 6) {  // ensure the input has the correct number of fields
            try {
                // create the Boat object using the parsed CSV data
                Boat boat = new Boat(
                        Boat.BoatType.valueOf(userInputArray[0].toUpperCase()),  // boat type (SAILING/POWER)
                        userInputArray[1],  // Boat name
                        Integer.parseInt(userInputArray[2]), //year
                        userInputArray[3],  // Make/Model
                        Double.parseDouble(userInputArray[4]),  // length
                        Double.parseDouble(userInputArray[5])   // purchase price
                );

                boatList.add(boat);  // add the boat to the list
                System.out.println("Boat added successfully.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format in the input.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Invalid boat type in the input.");
            }
        } else {
            System.out.println("Error: Invalid input format. Please provide all 6 fields.");
        }
    }// end of the addBoat method


    /**
     * Removes a boat from the fleet based on the boat's name. If the boat is found,
     * it is removed. Otherwise an error message is displayed.
     */

    private static void removeBoat() {
        System.out.print("Which boat do you want to remove? ");
        String boatName = keyboard.nextLine();// read boat name

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
            //let the user know that the boat has been removed
            System.out.println("Boat removed.");
        }else {
            // let the user know if the specified boat was not found
            System.out.println("Cannot find boat " + boatName);
        }

    }// end of the removeBoat method


    /**
     * Prompts the user to request permission to spend money on a specific boat.
     * If the expense is within the remaining budget, the expense is authorized.
     * Otherwise a message is displayed indicating the remaining budget.
     */

    public static void requestPermission() {
        System.out.println("Which boat do you want to spend on?");
        String boatName = keyboard.nextLine().trim(); // read and trim the boat name

        Boat selectedBoat = null;

        // look through the boatList to find the specific boat
        for (Boat boat : boatList) {
            if (boat.getName().equalsIgnoreCase(boatName)) {
                selectedBoat = boat;
                break;
            }
        }

        if (selectedBoat == null) {
            System.out.println("Cannot find boat " + boatName);
            return;
        }

        System.out.println("How much do you want to spend?");
        double amount = keyboard.nextDouble();
        keyboard.nextLine();  // Consume the newline

        // check if the boat can accept the expense based on the budget
        if (selectedBoat.canSpend(amount)) {
            selectedBoat.spend(amount);
            // Round the expenses to 2 decimal places
            System.out.println("Expense authorized, $" + String.format("%.2f", selectedBoat.getExpenses()) + " spent.");
        } else {
            // Round the remaining budget to 2 decimal places
            System.out.println("Expense not permitted, only $" + String.format("%.2f", selectedBoat.getRemainingBudget()) + " left to spend.");
        }
    }// end of the requestPermission method




    /**
     * Loads boat data from a csv file into the boat list. Each line in the file represents
     * a boat's attributes and is used to create a new Boat object.
     *
     * @param csvBoatFile The path to the csv file containing boat data.
     * @param boatList The list to store the loaded boats.
     * @throws IOException If there is an error reading the file.
     */


    public static void loadBoatData(String csvBoatFile, ArrayList<Boat> boatList) throws IOException {
        // method to load boat data from a csv file into the boatList
        try (BufferedReader reader = new BufferedReader(new FileReader(csvBoatFile))) {
            String currentLine = reader.readLine();  // Skip header if there is one

            while (currentLine != null) {

                String[] userInputArray = currentLine.split(",");

                try {
                    // create a Boat object from the parsed data and add it to the boatList
                    Boat boat = new Boat(
                            Boat.BoatType.valueOf(userInputArray[0].toUpperCase()), // boat type
                            userInputArray[1], // boat name
                            Integer.parseInt(userInputArray[2]),// year
                            userInputArray[3],//make or model
                            Double.parseDouble(userInputArray[4]), // length
                            Double.parseDouble(userInputArray[5])// purchase price
                    );
                    boatList.add(boat); // add the boat to the list
                } catch (NumberFormatException e) {
                    System.out.println("Number error in line: " + currentLine);
                } catch (IllegalArgumentException e) {
                    System.out.println("Boat type error in line: " + currentLine);
                }
                currentLine = reader.readLine();
            }// end of the while loop
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }// end of the loadBoatData method





}// end of BoatRecord class
