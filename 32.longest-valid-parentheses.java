/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        int res = 0;
        int[] dp = new int[l];
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ')' && i > 0) {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - 1 - dp[i-1] > -1 && s.charAt(i - 1 - dp[i-1]) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        dp[i] = i - 2 - dp[i-1] > -1 ? dp[i] + dp[i - 2 - dp[i-1]] : dp[i];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

