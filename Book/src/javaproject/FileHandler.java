package javaproject;

import java.io.*;
import java.util.LinkedList;
import java.util.Locale;

public class FileHandler {

    public LinkedList<Member> readFile()
    {
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member mem;

        try (BufferedReader input  = new BufferedReader(new FileReader("members.csv")))
        {
            while ((lineRead = input.readLine()) != null)
            {
                splitLine = lineRead.split(", ");

                switch (splitLine[0].toUpperCase())
                {
                    case "S":
                        m.add(new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2],
                                Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4])));
                        break;
                    case "M":
                        m.add(new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2],
                            Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4])));
                        break;
                    default:
                        System.out.println("Error: Unrecognised format!");
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return m;
    }

    public void appendFile(String mem)
    {
        try (BufferedWriter output = new BufferedWriter(new FileWriter("members.csv", true)))
        {
            output.write(mem);
            output.newLine();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(LinkedList<Member> m)
    {
        try (BufferedWriter output = new BufferedWriter(new FileWriter("members.temp", false)))
        {
            for (Member mem : m)
            {
                output.write(mem.toString());
                output.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            File f = new File("members.csv");
            File tf = new File("members.temp");

            f.delete();
            tf.renameTo(f);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
