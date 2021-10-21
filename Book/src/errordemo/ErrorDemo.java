package errordemo;

import java.util.Scanner;

public class ErrorDemo {
    public static void main(String[] args)
    {
        int num, deno;

        Scanner input = new Scanner(System.in);

        try
        {
            System.out.print("Please enter the numerator: ");
            num = input.nextInt();

            System.out.print("Please enter the denominator: ");
            deno = input.nextInt();

            System.out.printf("The result is %d\n", num/deno);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("---- End of Error Handling Example ----");
        }
    }
}
