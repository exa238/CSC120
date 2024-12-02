public class Boat {

    // enum to define the two possible types of boats
    public enum BoatType {SAILING, POWER}

    // variables to hold the boat's properties
    private BoatType type;

    private String name;

    private int year;

    private String makeModel;

    private double length;

    private double purchasePrice;

    private double expenses;

    // constructor to initialize a new Boat object with specified values
    public Boat(BoatType type, String name, int year, String makeModel, double length, double purchasePrice) {
        this.type = type;

        this.name = name;

        this.year = year;

        this.makeModel = makeModel;

        this.length = length;

        this.purchasePrice = purchasePrice;

        this.expenses = 0.0;
    }

    // getter for the boat's name
    public String getName() {
        return name;
    }

    // getter for the boat's purchase price
    public double getPurchasePrice() {
        return purchasePrice;
    }

    // check if the boat can accept more expenses based on the budget
    public boolean canSpend(double amount) {
        return (expenses + amount) <= purchasePrice;
    }

    // add the expenses to the boat
    public void spend(double amount) {
        this.expenses += amount;
    }

    // get the remaining budget
    public double getRemainingBudget() {
        return purchasePrice - expenses;
    }

    // get the total expenses for the boat
    public double getExpenses() {
        return expenses;
    }

    // override toString method to return a formatted string of the boat details
    @Override
    public String toString() {
        return String.format("%-8s %-20s %4d %-10s %4.1f' : Paid $ %.2f : Spent $ %.2f",
                type, name, year, makeModel, length, purchasePrice, expenses);
    }
}// end of the Boat class
