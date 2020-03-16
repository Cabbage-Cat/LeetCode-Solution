/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) { return 0; };
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength + 1][tLength + 1];
        for (int i = 0; i <= sLength; i++) { dp[i][tLength] = 1; }
        for (int i = sLength - 1; i > -1; i--) {
            for (int j = tLength - 1; j > -1; j--) {
                boolean firstMatch = s.charAt(i) == t.charAt(j);
                dp[i][j] = dp[i+1][j];
                if (firstMatch) { dp[i][j] += dp[i+1][j+1]; }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

