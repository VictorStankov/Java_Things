package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Key, Product> productHashMap = new HashMap<>();

        while (true) {
            System.out.println("""

                    Q - quit; A - add product; R - remove product; P - print all products
                    C - change price of product; G - print products in price range""");
            switch (scanner.nextLine().toUpperCase().charAt(0)) {
                case 'A':
                    addProduct(productHashMap, scanner);
                    break;
                case 'R':
                    removeProduct(productHashMap, scanner);
                    break;
                case 'C':
                    changePrice(productHashMap, scanner);
                    break;
                case 'P':
                    System.out.println(productHashMap.values());
                    break;
                case 'G':
                    printInRange(productHashMap, scanner);
                    break;
                case 'Q':
                    return;
                default:
                    System.out.println("Unknown character!");
            }
        }
    }

    public static void addProduct(HashMap<Key, Product> productHashMap, Scanner scanner) {
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Key key = new Key(manufacturer, model);
        productHashMap.put(key, new Product(key, price));
    }

    public static void removeProduct(HashMap<Key, Product> productHashMap, Scanner scanner) {
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        Key key = new Key(manufacturer, model);

        if (productHashMap.containsKey(key))
            productHashMap.remove(key);
        else {
            System.out.println("No product found!");
        }
    }

    public static void changePrice(HashMap<Key, Product> productHashMap, Scanner scanner) {
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        Key key = new Key(manufacturer, model);
        if (productHashMap.containsKey(key)) {

            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            productHashMap.put(key, new Product(key, price));
        }
        else
            System.out.println("No product found!");
    }

    public static void printInRange(HashMap<Key, Product> productHashMap, Scanner scanner) {
        System.out.print("Minimum price: ");
        double min = scanner.nextDouble();

        System.out.print("Maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        for (Product product : productHashMap.values()) {
            if (product.getPrice() >= min && product.getPrice() <= max)
                System.out.println(product);
        }
    }
}
