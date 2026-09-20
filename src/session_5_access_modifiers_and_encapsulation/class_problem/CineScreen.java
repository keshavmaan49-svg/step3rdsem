public class CineScreen {
    private String screenName;
    private int totalSeats;
    private int bookedSeats;

    public CineScreen(String screenName, int totalSeats) {
        this.screenName = screenName;
        if (totalSeats <= 0) {
            System.out.println("Invalid total seats. Setting default to 50.");
            this.totalSeats = 50;
        } else {
            this.totalSeats = totalSeats;
        }
        this.bookedSeats = 0;
    }

    public boolean bookSeats(int count) {
        if (count <= 0) {
            System.out.println("Invalid seat count request.");
            return false;
        }
        if (bookedSeats + count > totalSeats) {
            System.out.printf("Cannot book %d seats. Only %d seats available.%n",
                    count, (totalSeats - bookedSeats));
            return false;
        }
        bookedSeats += count;
        System.out.printf("Successfully booked %d seats on %s. Remaining: %d%n",
                count, screenName, (totalSeats - bookedSeats));
        return true;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public static void main(String[] args) {
        CineScreen screen = new CineScreen("Screen 1 - IMAX", 100);
        screen.bookSeats(40);
        screen.bookSeats(70); // Should fail
        screen.bookSeats(30); // Should succeed
    }
}
