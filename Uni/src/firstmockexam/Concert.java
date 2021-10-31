package firstmockexam;

public class Concert extends Event {
    String starName;

    public Concert(String starName, String place, String date, String startHour, int numberOfTickets, double priceOfTicket) {
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.starName = starName;
    }
}
