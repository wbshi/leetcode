package src.algorithm.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] > minPrice && (prices[i] - minPrice) > profit) {
                profit = prices[i] - minPrice;
            }

        }
        return profit;
    }
}
