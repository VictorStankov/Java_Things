package hashmaps;

public class Product {
    private Key key;
    private double price;

    public Product(Key key, double price) {
        this.key = key;
        this.price = price;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "manufacturer=" + key.getBrand() +
                ", model=" + key.getModel() +
                ", price=" + price +
                '}';
    }
}
