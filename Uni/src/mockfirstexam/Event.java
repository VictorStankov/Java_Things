package mockfirstexam;

public class Event {
    String place, date, startHour;
    int numberOfTickets;
    double priceOfTicket;

    public Event(String place, String date, String startHour, int numberOfTickets, double priceOfTicket) {
        this.place = place;
        this.date = date;
        this.startHour = startHour;
        this.numberOfTickets = numberOfTickets;
        this.priceOfTicket = priceOfTicket;
    }

    boolean sellTicket(int num) throws NoMoreTicketException {
        if (this.numberOfTickets >= num){
            this.numberOfTickets -= num;
            System.out.printf("%d tickets sold!\n", num);
            return true;
        }
        else
            throw new NoMoreTicketException("Not enough tickets available!");
    }
}
