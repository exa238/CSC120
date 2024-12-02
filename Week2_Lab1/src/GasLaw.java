import java.util.Scanner;
//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    /*----The gas constant in Joules/mole/K */

    private static double GasConstant = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values like volume, moles and temperature
        double volume, moles, temperature;
        double pressure;

//---- Create an imput to enter the volume, moles, and temperature
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//---- calculate the pressure
        pressure = moles * GasConstant * temperature / volume;

//----output the pressure
        System.out.println("Pressure is " + pressure);
    }
//-------------------------------------------------------------------------------------------------
}

//-----------------------------------------------------------------------------
//=============================================================================