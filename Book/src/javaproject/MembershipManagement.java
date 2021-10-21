package javaproject;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);

    public int getIntInput()
    {
        while (true) {
            try {
                int choice = reader.nextInt();
                reader.nextLine();
                return choice;
            } catch (InputMismatchException e)
            {
                reader.nextLine();
                System.out.print("ERROR: INVALID INPUT. Please try again:");
            }
        }
    }

    public void printClubOptions()
    {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoice()
    {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.print("\nPlease select an option (or enter -1 to quit): ");
        return getIntInput();
    }

    public String addMembers(LinkedList<Member> m)
    {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.print("Enter name: ");
        name = reader.nextLine();

        printClubOptions();
        System.out.print("Enter club ID: ");
        club = getIntInput();

        while (club < 1 || club > 4)
        {
            System.out.print("Try again: ");
            club = getIntInput();
        }

        if(m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;

        if (club != 4)
        {
            cal = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };

            fees = cal.calculateFees(club);

            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();

            System.out.println("\nSTATUS: Single Club Member added\n");
        }
        else
        {
            cal = (n) ->{
                if (n == 4)
                    return 1200;
                else
                    return -1;
            };

            fees = cal.calculateFees(club);

            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        }

        return mem;
    }

    public void removeMember(LinkedList<Member> m)
    {
        int memberID;

        System.out.print("Enter member ID: ");
        memberID = reader.nextInt();

        for (int i = 0; i < m.size(); i++)
        {
            if (m.get(i).getMemberID() == memberID)
            {
                m.remove(i);
                System.out.println("Member successfully removed.");
                return;
            }
        }

        System.out.println("Member not fount!");
    }

    public void printMemberInfo(LinkedList<Member> m)
    {
        int memberID;

        System.out.print("Enter member ID: ");
        memberID = reader.nextInt();

        for (int i = 0; i < m.size(); i++)
        {
            if (m.get(i).getMemberID() == memberID)
            {
                String[] memberInfo = m.get(i).toString().split(", ");
                System.out.println("Member Type = " + memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member Name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);
                if (memberInfo[0].equals("S"))
                    System.out.println("Club ID = " + memberInfo[4] + "\n");
                else if (memberInfo[0].equals("M"))
                    System.out.println("Membership Points = " + memberInfo[4] + "\n");
                return;
            }
        }
    }
}
