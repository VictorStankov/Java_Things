package multithreadserver;

public class Customer {
    private int customerID;
    private String customerName;
    private double amount;

    public Customer(int customerID, String customerName, double amount) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.amount = amount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.customerID + "*" + this.customerName + "*" + this.amount;
    }
}
