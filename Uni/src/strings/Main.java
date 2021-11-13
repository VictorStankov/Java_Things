package strings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"John", "Michael", "Frank", "Joshua"};
        processInvite(names, "Concert", "NDK", "15.11.2021", "15:00", "Victor");

        String email;
        System.out.print("\nEnter an email Address: ");
        email = input.nextLine();

        System.out.printf("%s\n", verifyEmail(email) ? "Email is Valid" : "Email is Invalid");
    }

    public static void processInvite(String[] names, String event, String address,
                                     String date, String time, String sender) {
        String template = "recipient; event; address; date; time; sender";
        template = template.replace("event", event).replace("address", address).replace("date", date).
                replace("time", time).replace("sender", sender);
        for (String name : names) {
            System.out.println(template.replace("recipient", name));
        }
    }

    public static boolean verifyEmail(String email) {
        return email.matches(".*@abv.bg") || email.matches(".*@gmail.com");
    }
}
