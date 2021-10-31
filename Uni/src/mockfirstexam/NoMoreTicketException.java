package mockfirstexam;

public class NoMoreTicketException extends Exception {
    private String message;

    public NoMoreTicketException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
