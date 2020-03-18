/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int slow = 0, fast = 0;
        int profit = 0;
        for (; fast < prices.length; fast++) {
            if (prices[fast] < prices[slow]) { slow = fast; }
            else {
                int nowProfit = prices[fast] - prices[slow];
                if (nowProfit > profit) { profit = nowProfit; }
            }
        }
        return profit;
    }
}
// @lc code=end

