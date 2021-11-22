package hashmaps;

import java.util.Objects;

public class Key {
    private String brand;
    private String model;

    public Key(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return brand.equals(key.brand) && model.equals(key.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public String toString() {
        return "Key{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
