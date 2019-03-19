package N101_200;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profile = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i] < prices[i + 1])
                profile += prices[i + 1] - prices[i];
        return profile;
    }
}
