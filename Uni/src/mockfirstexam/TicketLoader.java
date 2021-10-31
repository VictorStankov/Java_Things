package mockfirstexam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TicketLoader implements Importable {
    private int numberOfConcerts = 0, numberOfMatches = 0;

    @Override
    public Event[] importDataFromFile() throws IOException {
        Event[] eventsArray = new Event[getNumberOfEvents()];
        BufferedReader reader = new BufferedReader(new FileReader("src/firstmockexam/dailytickets.txt"));
        String line;
        String[] lineArray;
        int i = 0;

        while ((line = reader.readLine()) != null) {
            line = line.replace("*", "@");
            lineArray = line.split("@");

            try {
                switch (lineArray[0]) {
                    case "1":
                        eventsArray[i++] = new Concert(lineArray[1], lineArray[2], lineArray[3], lineArray[4],
                                Integer.parseInt(lineArray[5]), Double.parseDouble(lineArray[6]));
                        numberOfConcerts++;
                        break;
                    case "2":
                        eventsArray[i++] = new VolleyBallMatch(lineArray[1], lineArray[2], lineArray[3], lineArray[4],
                                lineArray[5], Integer.parseInt(lineArray[6]), Double.parseDouble(lineArray[7]));
                        numberOfMatches++;
                        break;
                    default:
                        throw new UnrecognisedRowException("" + i);
                }
            }
            catch (UnrecognisedRowException e){
                System.out.println(e.getMessage());
            }
        }
        return eventsArray;
    }

    private int getNumberOfEvents() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/firstmockexam/dailytickets.txt"));
        int rows = 0;

        while (reader.readLine() != null)
            rows++;

        reader.close();
        return rows;
    }

    public int getNumberOfConcerts() {
        return numberOfConcerts;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }
}
