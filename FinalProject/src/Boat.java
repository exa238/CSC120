import java.io.Serializable;

public class Boat implements Serializable {
    /**
     * Represents a Boat with various attributes such as type, name, year, make/model, length,
     * purchase price, and expenses.
     */
    public enum BoatType {SAILING, POWER}

    // Variables to hold the boat's properties
    private BoatType type;
    private String name;
    private int year;
    private String makeModel;
    private double length;
    private double purchasePrice;
    private double expenses;

    /**
     * Constructs a new Boat object with specified values.
     *
     * @param type          The type of the boat (SAILING or POWER).
     * @param name          The name of the boat.
     * @param year          The year the boat was made.
     * @param makeModel     The make or model of the boat.
     * @param length        The length of the boat in feet.
     * @param purchasePrice The purchase price of the boat.
     */
    public Boat(BoatType type, String name, int year, String makeModel, double length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.year = year;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = 0.0;
    }

    // Getters
    public BoatType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public double getLength() {
        return length;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getExpenses() {
        return expenses;
    }

    // Core functionality
    /**
     * Checks if the boat can spend a specified amount without exceeding the purchase price.
     *
     * @param amount The amount to check.
     * @return {@code true} if the boat can spend the amount, {@code false} otherwise.
     */
    public boolean canSpend(double amount) {
        return (expenses + amount) <= purchasePrice;
    }

    /**
     * Adds the specified amount to the boat's expenses.
     *
     * @param amount The amount to spend.
     * @throws IllegalArgumentException if the amount exceeds the remaining budget.
     */
    public void spend(double amount) {
        if (!canSpend(amount)) {
            throw new IllegalArgumentException("Exceeds available budget. Cannot spend this amount.");
        }
        this.expenses += amount;
    }

    /**
     * Gets the remaining budget for the boat.
     *
     * @return The remaining budget (purchase price minus expenses).
     */
    public double getRemainingBudget() {
        return purchasePrice - expenses;
    }

    // Utility methods
    /**
     * Returns a string representation of the boat, including its details.
     *
     * @return A formatted string with the boat's details.
     */
    @Override
    public String toString() {
        return String.format(
                "%-8s %-20s %4d %-10s %4.1f' : Paid $ %.2f : Spent $ %.2f : Remaining $ %.2f",
                type, name, year, makeModel, length, purchasePrice, expenses, getRemainingBudget()
        );
    }
}
