package src.algorithm.best_time_to_buy_and_sell_stock_ii;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;

        int minPrice = prices[0];
        int tempProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - minPrice;
                minPrice = prices[i];
                tempProfit = 0;
            } else {
                tempProfit = prices[i] - minPrice;
            }
        }

        if (tempProfit > 0) profit += tempProfit;

        return profit;
    }
}
