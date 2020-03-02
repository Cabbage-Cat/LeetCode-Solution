/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[2][n+1];
        // for (int i = 0; i <= m; i++) { dp[i][0] = i; }
        for (int i = 0; i <= n; i++) { dp[0][i] = i; }

        for (int i = 1; i <= m; i++) {
            dp[i%2][0] = dp[(i-1)%2][0] + 1;
            for (int j = 1; j <= n; j++) {
                int distance1 = Math.min(dp[(i-1)%2][j], dp[i%2][j-1]) + 1;
                int distance2 = dp[(i-1)%2][j-1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) { distance2++; }
                dp[i%2][j] = Math.min(distance1, distance2);
            }
        }
        return dp[m%2][n];
    }
}
// @lc code=end

