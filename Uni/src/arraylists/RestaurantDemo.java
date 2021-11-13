package arraylists;

import java.util.*;

public class RestaurantDemo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int n;
        Stack<Integer> dirtyPlates = new Stack<>(), cleanPlates = new Stack<>();

        for (int i = 0; i < 10; ++i)
            dirtyPlates.add(random.nextInt(10, 50));

        System.out.println("""
                Q - Quit; P - Print plate stack;
                W - Wash Plates; S - Serve Plates;
                -----------------------------------""");

        while (true) {
            System.out.print("Enter a Letter: ");
            switch (input.nextLine().toUpperCase().charAt(0)) {
                case 'P':
                    System.out.println("Dirty Plates: " + dirtyPlates);
                    System.out.println("Clean Plates: " + cleanPlates);
                    break;

                case 'W':
                    System.out.print("How many plates: ");
                    n = input.nextInt();
                    input.nextLine();
                    washPlates(dirtyPlates, cleanPlates, n);
                    break;

                case 'S':
                    System.out.print("How many plates: ");
                    n = input.nextInt();
                    input.nextLine();
                    servePlates(dirtyPlates, cleanPlates, n);
                    break;

                case 'Q':
                    return;

                default:
                    System.out.println("Unrecognised operation!");
            }
        }
    }

    public static void washPlates(Stack<Integer> dirtyPlates, Stack<Integer> cleanPlates, int n) {
        try {
            for (int i = 0; i < n; ++i)
                cleanPlates.add(dirtyPlates.pop());
            System.out.println(n + " successfully cleaned!");
        }
        catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void servePlates(Stack<Integer> dirtyPlates, Stack<Integer> cleanPlates, int n) {
        if (cleanPlates.size() < n)
            washPlates(dirtyPlates, cleanPlates, n - cleanPlates.size());

        try {
            for (int i = 0; i < n; ++i)
                cleanPlates.pop();
            System.out.println(n + " successfully served!");
        }
        catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

    }
}
