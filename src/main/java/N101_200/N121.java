package N101_200;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(prices[i], low);
            profit = Math.max(prices[i] - low, profit);
        }
        return profit;
    }
}
