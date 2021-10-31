package firstmockexam;

public class VolleyBallMatch extends Event {
    String firstTeam, secondTeam;

    public VolleyBallMatch(String firstTeam, String secondTeam, String place, String date, String startHour,
                           int numberOfTickets, double priceOfTicket) {
        super(place, date, startHour, numberOfTickets, priceOfTicket);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }
}
