public class TrafficSignalStreak {
    static void findLongestStreak(String signalLog) {
        char current = signalLog.charAt(0);
        char longestColor = current;
        int currentCount = 1;
        int longestCount = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == current) {
                currentCount++;
            } else {
                current = signalLog.charAt(i);
                currentCount = 1;
            }
            if (currentCount > longestCount) {
                longestCount = currentCount;
                longestColor = current;
            }
        }
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestCount + " times");
    }
    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";
        findLongestStreak(signalLog);
    }
}