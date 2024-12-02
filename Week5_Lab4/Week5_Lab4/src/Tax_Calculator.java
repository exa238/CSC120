import java.util.Scanner;

public class Tax_Calculator {





    private static final Scanner keyboard = new Scanner(System.in);


    //declare your constants
    private static final double STINKING_RICH = 500000;

    private static final double QUITE_RICH = 200000;

    private static final double MIAMI_POOR = 100000;

    private static final double AVERAGE = 50000;

    private static final double REALISTIC = 20000;

    private static final double HIGH_RATE = 0.25;

    private static final double MEDIUM_RATE = 0.10;

    private static final double LOW_RATE = 0.03;



    public static void main(String[] args) {

        double amount, income, deductions;
        double taxableIncome, taxOwed;
        char taxGroup;

        //address your inputs
        income = 0.0;
        deductions = 0.0;
        //----- 1.1 Repeatedly until 0.0 is entered
        do {
            System.out.println("Enter next amount: ");
            amount  = keyboard.nextDouble();
            if (amount > 0.0){
                income += amount;
            }
            else{
                deductions -= amount;
            }
        }
        while(income != 0.0);

        taxableIncome = computeTaxableIncome(income, deductions);
        char letterGroup;
        letterGroup = chooseTaxGroup(taxableIncome);
        double taxAmount;
        taxAmount = ComputeTax(taxableIncome, letterGroup);
        displayTaxInformation(income, deductions, taxableIncome, letterGroup, taxAmount);



        System.out.println("Week 5 - Lab 4");

    }// end of the main method

    private static double computeTaxableIncome (double income, double deductions){
        double taxable;
        if (income >= deductions){
            taxable = income - deductions;
        }

        else{
            taxable = 0.0;
        }
        return taxable;
    }// end of the computeTaxableIncome method

    private static char chooseTaxGroup (double income){
        char Tax_group;


        if(income >= STINKING_RICH){
            Tax_group = ('S');
        }
        else if(income >= QUITE_RICH){
            Tax_group = ('Q');
        }
        else if(income >= MIAMI_POOR){
            Tax_group = ('M');
        }
        else if(income >= AVERAGE){
            Tax_group = ('A');
        }
        else if (income >= REALISTIC) {
            Tax_group = ('R');
        }
        else{
            Tax_group = ('P');
        }
        return Tax_group;
    }// end of chooseTaxGroup method


    private static double ComputeTax(double taxable, char group){
        double tax;
        double taxAmount;

        if (group == 'S' || group == 'Q'){
            tax = HIGH_RATE;
            taxAmount = tax * taxable;
        }
        else if (group == 'M'){
            tax = MEDIUM_RATE;
            taxAmount = tax * taxable;
        }
        else if (group == 'A' || group == 'R'){
            tax = LOW_RATE;
            taxAmount = tax * taxable;
        }
        else if (group == 'P'){
            tax = 0.0;
            taxAmount = tax * taxable;
        }
        else{
            taxAmount = 0.0;
            System.out.println("Error!");

        }

        return taxAmount;
    }// end of the ComputeTax method

    private static void displayTaxInformation(double income, double deductions, double taxableIncome, char group, double taxOwed){
        System.out.println("Income: " + income);
        System.out.println("Deductions: " + deductions);
        System.out.println("Taxable Income: " + taxableIncome);
        System.out.println("Group: " + group);
        System.out.println("Tax Owed: " + taxOwed);


    }//end of the displayTaxInformation method

} // end of the Tax_Calculator class
