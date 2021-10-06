package errordemo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorDemo2 {
    public static void main(String[] args)
    {
        int choice;

        Scanner input = new Scanner(System.in);

        int[] numbers = { 10, 11, 12, 13, 14, 15 };
        System.out.print("Please enter the index of the array: ");

        try
        {
            choice = input.nextInt();
            if(choice == 0)
                throw new ArrayIndexOutOfBoundsException();
            System.out.printf("numbers[%d] = %d\n", choice, numbers[choice]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Index is invalid.");
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error: You did not enter an integer.");
        }
        catch(Exception e)
        {
         System.out.println(e.getMessage());
        }
    }
}
