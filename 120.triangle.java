/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j > -1; j--) {
                int base = triangle.get(i).get(j);
                if (j > 0) {
                    int bias = Math.min(dp[j], dp[j - 1]);
                    dp[j] += bias;
                }
                dp[j] += base;
            }
        }
        int res = dp[0];
        for (int x : dp) { if (x < res) { res = x; } }
        return res;
    }
}
// @lc code=end

