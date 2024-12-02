import java.util.Scanner;
//=======================================================================================================================================================================
public class Nitrox_Scuba {

    //establish your constants
    private static final int  FEET_PER_ATMOSPHERE = 33;

    private static final double  MAXIMUM_PARTIAL_PRESSURE = 1.4;

    private static final double CONTINGENCY_PARTIAL_PRESSURE_O2 = 1.6;

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        System.out.println("Week 4 - LAB 3");
        Scanner scnr = new Scanner(System.in);


        //get the user's inputs
        System.out.println("Enter depth: ");
        double diveDepth = scnr.nextDouble();
        System.out.println("Enter percentage O2: ");
        double oxygenPercentage = scnr.nextDouble();


        //compute ambient pressure
        double compute_ambient_pressure = (diveDepth / FEET_PER_ATMOSPHERE) + 1;

        //compute oxygen pressure
        double partialPressure = compute_ambient_pressure * (double)oxygenPercentage / 100;

        char o2Group = (char) ((int) (partialPressure * 10) + (int) 'A');
        boolean exceedMaxO2Pressure;
        boolean exceedMaxContingencyPressure;


        //establish your booleans
        if (partialPressure > MAXIMUM_PARTIAL_PRESSURE){
            exceedMaxO2Pressure = true;
        }

        else {
            exceedMaxO2Pressure = false;
        }

        if (partialPressure > CONTINGENCY_PARTIAL_PRESSURE_O2) {
            exceedMaxContingencyPressure = true;
        }
        else {
            exceedMaxContingencyPressure = false;
        }

        System.out.println("Ambient pressure: " + compute_ambient_pressure);
        System.out.println("O2 Pressure " + partialPressure);
        System.out.println("O2 Group: " + o2Group);
        System.out.println("Exceeds contingency O2 pressure: " + exceedMaxContingencyPressure);
        System.out.println("Exceeds maximum partial pressure: " + exceedMaxO2Pressure);











    }// end of main






}// end of the Nitrox_Scuba class
