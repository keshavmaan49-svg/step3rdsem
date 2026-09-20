import java.util.Arrays;
public class ReferenceOnlyLoanReceipt {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }
        public boolean isDraftable() {
            if (matchesPlayed >= 10) {
                return true;
            }
            return matchesPlayed >= 5 && battingAverage >= 50 && !injured;
        }
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
        public String getName() {
            return name;
        }
    }
    static String draftAndRank(Player[] players) {
        int count = 0;
        for (Player player : players) {
            if (player.isDraftable()) {
                count++;
            }
        }
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player player : players) {
            if (player.isDraftable()) {
                draftable[index] = player;
                index++;
            }
        }
        Arrays.sort(draftable);
        String result = "";
        for (int i = 0; i < draftable.length; i++) {
            result += (i + 1) + ". " + draftable[i].getName();
            if (i < draftable.length - 1) {
                result += " | ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}