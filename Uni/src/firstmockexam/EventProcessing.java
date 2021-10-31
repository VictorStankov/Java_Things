package firstmockexam;

import java.io.IOException;

public class EventProcessing {
    public static Concert[] concerts;
    public static VolleyBallMatch[] matches;

    public static void main(String[] args) {

        try {
            processTickets();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Concert c = concerts[0];
        try {
            c.sellTicket(5001);
        }
        catch (NoMoreTicketException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processTickets() throws IOException{
        TicketLoader loader = new TicketLoader();

        Event[] events = loader.importDataFromFile();
        concerts = new Concert[loader.getNumberOfConcerts()];
        matches = new VolleyBallMatch[loader.getNumberOfMatches()];
        int concertIterator = 0, matchIterator = 0;

        for (Event event : events) {
            if (event instanceof Concert)
                concerts[concertIterator++] = (Concert) event;
            else
                matches[matchIterator++] = (VolleyBallMatch) event;
        }
    }
}
