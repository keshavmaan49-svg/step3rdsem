public class MovieTicket {
    private String ticketId;
    String movieName;
    protected double basePrice;
    public String theatreName;

    public MovieTicket(String ticketId, String movieName, double basePrice, String theatreName) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.basePrice = basePrice;
        this.theatreName = theatreName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void displayDetails() {
        System.out.printf("Ticket [%s] | Movie: %s | Theatre: %s | Price: $%.2f%n",
                ticketId, movieName, theatreName, basePrice);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("TICK-101", "Interstellar", 12.50, "PVR Cinemas");
        ticket.displayDetails();
    }
}
