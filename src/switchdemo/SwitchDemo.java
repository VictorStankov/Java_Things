package switchdemo;

import java.util.Locale;
import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your grade: ");
        String userGrade = input.nextLine().toUpperCase();
        switch (userGrade)
        {
            case "A+":
            case "A":
                System.out.println("Distinction");
            case "B":
                System.out.println("B Grade");
                break;
            case "C":
                System.out.println("C Grade");
            default:
                System.out.println("Fail");
                break;
        }
    }
}
