package multithreadserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerInfoServer extends Thread {
    LinkedList<String> listOfBranches;
    LinkedList<Customer> listOfCustomers;
    Socket socket;

    public CustomerInfoServer(LinkedList<String> listOfBranches, LinkedList<Customer> listOfCustomers, Socket socket) {
        this.listOfBranches = listOfBranches;
        this.listOfCustomers = listOfCustomers;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintStream writer = new PrintStream(socket.getOutputStream(), true);
             Scanner reader = new Scanner(socket.getInputStream())) {
            writer.print("Name of Branch: ");
            String selectedBranch = reader.nextLine();

            if (listOfBranches.contains(selectedBranch)) {
                writer.print("OK\nCustomer ID: ");
                int id = reader.nextInt();

                for (Customer customer: listOfCustomers) {
                    if (customer.getCustomerID() == id) {
                        writer.println(customer);
                        return;
                    }
                }
                writer.println("No such Customer!");
            }
            else {
                writer.println("Invalid Code!");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
