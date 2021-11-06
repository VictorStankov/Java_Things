package filehandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDemo {
    public static void main(String[] args) {

        try {
            String name;
            double price;

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/filehandling/products.txt"));
            Scanner input = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.print("Name of Product: ");
                name = input.nextLine();

                System.out.print("Price of Product: ");
                price = input.nextDouble();
                input.nextLine();

                writer.write(new Product(name, price).toText());
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            String name, line;
            String[] contents;
            double price;
            ArrayList<Product> inputList = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader("src/filehandling/products.txt"));
            while ((line = reader.readLine()) != null) {
                contents = line.split(";");
                name = contents[0];
                price = Double.parseDouble(contents[1]);
                inputList.add(new Product(name, price));
            }

            for (Product product : inputList) {
                System.out.println(product.toString());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
