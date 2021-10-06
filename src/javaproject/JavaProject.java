package javaproject;

import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        String mem;

        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();

        LinkedList<Member> members = fh.readFile();
        System.out.println(members.toString());
        int choice = mm.getChoice();

        while (choice != -1) {
            switch (choice) {
                case 1:
                    fh.appendFile(mm.addMembers(members));
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                default:
                    System.out.println("Unknown option!");
            }

            choice = mm.getChoice();
        }

        System.out.println("Goodbye...");
    }
}
