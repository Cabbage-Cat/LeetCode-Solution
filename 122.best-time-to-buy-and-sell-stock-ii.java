/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int slow = 0, fast = 1;
        for (; fast < prices.length; fast++) {
            if (prices[fast] > prices[fast - 1]) { continue; }
            else {
                profit += prices[fast - 1] - prices[slow];
                slow = fast;
            }
        }
        if (fast - 1 > slow && prices[fast - 1] - prices[slow] > 0) { profit += prices[fast - 1] - prices[slow]; }
        return profit;
    }

}
// @lc code=end

