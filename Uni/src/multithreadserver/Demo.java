package multithreadserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Demo {
    private static final LinkedList<String> listOfBranches;
    private static final LinkedList<Customer> listOfCustomers = new LinkedList<>();

    static {
        listOfBranches = new LinkedList<>();
        listOfBranches.add("Branch1");
        listOfBranches.add("Branch2");
        listOfCustomers.add(new Customer(1, "John Johnson", 162.50));
        listOfCustomers.add(new Customer(2, "Michael Scott", 659.42));
    }
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1211)){
            while (true) {
                Socket socket = server.accept();
                CustomerInfoServer app = new CustomerInfoServer(listOfBranches, listOfCustomers, socket);
                app.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
