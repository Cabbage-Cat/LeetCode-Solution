/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) { return 0; }
        int[][] dp = new int[prices.length][3];
        int res = 0;
        for (int k = 1; k < 3; k++) {
            for (int i = 1; i < prices.length; i++) {
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][k]);
                for (int x = 0; x < i; x++) { dp[i][k] = Math.max(prices[i] + dp[x][k - 1] - prices[x], dp[i][k]); }
            }
        }
        res = dp[prices.length - 1][2];
        return res;
    }
}
// @lc code=end

