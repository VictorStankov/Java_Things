package arraylists;

import java.util.ArrayList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; ++i)
            products.add(new Product("Product_" + i, random.nextDouble(1000)));

        System.out.println(products + "\n");
        printInPriceRange(products, 200, 500);
        sortByPrice(products);
        sortByName(products);
    }

    public static void printInPriceRange(ArrayList<Product> products, double floor, double ceil) {
        for (Product product : products)
            if (product.getPrice() >= floor && product.getPrice() <= ceil)
                System.out.println(product);
    }

    public static void sortByPrice(ArrayList<Product> products) {
        products.sort(new MyPriceComparator());
        System.out.println("\n" + products);
    }

    public static void sortByName(ArrayList<Product> products) {
        products.sort(new MyNameComparator());  // Sorts in reverse order, just for testing purposes
        System.out.println("\n" + products);
    }
}
