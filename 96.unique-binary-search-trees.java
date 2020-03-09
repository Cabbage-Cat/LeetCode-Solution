/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n == 0) { return 0; }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int length = 1; length <= n; length++) {
            int tmpRes = 0;
            for (int root = 1; root <= length; root++) {
                int leftSize = dp[root - 1];
                int rightSize = dp[length - root];
                tmpRes += leftSize * rightSize;
            }
            dp[length] = tmpRes;
        }
        return dp[n];
    }
}
// @lc code=end

