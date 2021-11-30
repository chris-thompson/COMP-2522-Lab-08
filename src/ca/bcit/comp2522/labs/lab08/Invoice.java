package ca.bcit.comp2522.labs.lab08;

/**
 * Represents a simple invoice.
 *
 * @author BCIT
 * @version 2021
 */
public class Invoice implements Payable {
    private final String partNumber;
    private final String partDescription;
    private int quantity;
    private double pricePerItem;

    /**
     * Constructs an object of type Invoice.
     * @param partNumber a String
     * @param partDescription a String
     * @param quantity an integer that is greater than or equal to zero
     * @param pricePerItem a double that is greater than or equal to zero
     * @throws IllegalArgumentException if quantity < 0
     * @throws IllegalArgumentException if prince < 0.00
     */
    public Invoice(final String partNumber,
                   final String partDescription,
                   final int quantity,
                   final double pricePerItem) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        if (pricePerItem < 0.0) {
            throw new IllegalArgumentException(
                    "Price per item must be >= 0");
        }
        this.quantity = quantity;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.pricePerItem = pricePerItem;
    }

    /**
     * Returns the part number.
     * @return part number as a String
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Returns the part description.
     * @return part description as a String
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * Sets the quantity. The quantity must be greater than zero,
     * or an IllegalArgumentException will be thrown.
     * @param quantity an int >= 0
     * @throws IllegalArgumentException if quantity < 0
     */
    public void setQuantity(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        this.quantity = quantity;
    }

    /**
     * Returns the quantity.
     * @return quantity as an int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the price per item.
     * @param pricePerItem a positive double.
     * @throws IllegalArgumentException if pricePerItem < 0
     */
    public void setPricePerItem(final double pricePerItem) {
        if (pricePerItem < 0.0) {
            throw new IllegalArgumentException("Price per item must be >= 0");
        }
        this.pricePerItem = pricePerItem;
    }

    /**
     * Returns price per item.
     * @return pricePerItem as a double
     */
    public double getPricePerItem() {
        return pricePerItem;
    }

    /**
     * Returns a String representation of this Invoice.
     * @return toString as a string
     */
    @Override
    public String toString() {
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem());
    }

    /**
     * Returns the payment amount.
     * @return total payment amount as a double
     */
    @Override
    public double getPaymentAmount() {
        return getQuantity() * getPricePerItem();
    }
}
