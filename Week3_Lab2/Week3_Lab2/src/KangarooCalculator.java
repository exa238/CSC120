import java.util.Scanner;

//=======================================================================================================================================================================
public class
KangarooCalculator {
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // you need to convert 10 meter into kilometers
    private static final double WIDTH_OF_ROAD = 0.01;

    //*----The roadkill probability constant - which is 1.47
    private static final double Roadkill_Probability_Constant = 1.47;

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        //get the user's inputs
        double sideLength = getSideLength();
        double roadLength = getRoadLength();
        int numberOfKangaroos = getNumberOfKangaroos();


        //compute how many kangaroos are present per square kilometer
        double kangarooDensity = calculateKangarooDensity(sideLength, numberOfKangaroos);
        //determine the total surface area of roads within the square unit of land
        double roadSurfaceArea = calculateRoadSurfaceArea(roadLength);
        //estimate the number of kangaroo kills based on kangaroo density and surface area
        double expectedKills = calculateExpectedKills(kangarooDensity, roadSurfaceArea);
        //convert the estimated number of kills to integer values
        int numberOfKills = (int) expectedKills;
        //convert the number of integers into an integer value and multiply by 5 and round to the nearest whole number
        int numberofInjuries = (int) Math.round((expectedKills - numberOfKills) * 5);

        //display the results
        displayResults(numberOfKills, numberofInjuries);
        }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static double getSideLength() {
        Scanner scanner = new Scanner(System.in);
        //prompt the user to enter the side length
        System.out.print("Enter side of square in km: ");
        //read and return the side length
        return scanner.nextDouble();
    }

    private static double getRoadLength() {
        Scanner scanner = new Scanner(System.in);
        //prompt the user to enter the total road length
        System.out.print("Enter roads length in km: ");
        //read and return the road length
        return scanner.nextDouble();
    }

    private static int getNumberOfKangaroos() {
        Scanner scanner = new Scanner(System.in);
        //prompt the user to enter the number of kangaroos
        System.out.print("Enter number of 'roos: ");
        //read and return the number of kangaroos
        return scanner.nextInt();
    }

    private static double calculateKangarooDensity(double sideLength, int numberofKangaroos) {
        //calculate the area of the square parcel
        double squareArea = sideLength * sideLength;
        //compute and return the kangaroo density
        return numberofKangaroos / squareArea;
    }

    private static double calculateRoadSurfaceArea(double roadLength) {
        //calculate and return the total road surface area
        return roadLength * WIDTH_OF_ROAD;
    }

    private static double calculateExpectedKills(double density, double surfaceArea) {
        //calculate and return the expected number of kills
        return density * surfaceArea * Roadkill_Probability_Constant;
    }

    private static void displayResults(int kills, int injuries) {
        //print the number of kills
        System.out.println("Expected number of kills is: " + kills);
        //print the number of injuries
        System.out.println("Expected number of injuries: " + injuries);
    }


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//====================================================================================================================================================================