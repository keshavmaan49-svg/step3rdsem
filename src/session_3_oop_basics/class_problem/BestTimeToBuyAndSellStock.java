import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void test(int[] prices) {
        System.out.printf("prices = %s -> Max Profit: %d%n", Arrays.toString(prices), maxProfit(prices));
    }

    public static void main(String[] args) {
        test(new int[]{7, 1, 5, 3, 6, 4});
        test(new int[]{7, 6, 4, 3, 1});
    }
}
