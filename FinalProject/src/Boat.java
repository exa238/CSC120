public class Boat {
    public enum BoatType {SAILING, POWER}

    private BoatType type;

    private String name;

    private int year;

    private String makeModel;

    private double length;

    private double purchasePrice;

    private double expenses;


    public Boat(BoatType type, String name, int year, String makeModel, double length, double purchasePrice){
        System.out.println("Creating boat: " + type + ", " + name + ", " + year + ", " + makeModel + ", " + length + ", " + purchasePrice);

        this.type = type;

        this.name = name;

        this.year = year;

        this.makeModel = makeModel;

        this.length = length;

        this.purchasePrice = purchasePrice;

        this.expenses = 0.0;

    }// end of Boat


    public String getName(){
        return name;
    }// end of getName

    public double getPurchasePrice(){
        return purchasePrice;
    }// end of getPurchasePrice


    public boolean canSpend(double amount){
        return (expenses + amount) <= purchasePrice;
    }// end of canSpend

    public void spend(double amount){
        this.expenses += amount;
    }// end of spend

    public double getRemainingBudget(){
        return purchasePrice - expenses;
    }// end of getRemainingBudget

    public double getExpenses(){
        return expenses;
    }// end of getExpenses

    @Override
    public String toString(){
        return String.format("%-8s %-20s %4d %-10s %4.1f' : Paid $ %.2f : Spent $ %.2f",
                type, name, year, makeModel, length, purchasePrice, expenses);
    }

}// end of the Boat class
